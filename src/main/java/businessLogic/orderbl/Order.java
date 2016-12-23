package businessLogic.orderbl;

import vo.OrderVO;

import java.sql.SQLException;
import java.util.*;

import businessLogic.hotelbl.HotelToolForOrder;
import businessLogic.orderbl.HotelInfoForOrder;
import businessLogic.orderbl.PromotionInfoForOrder;
import businessLogic.promotionbl.PromotionToolForOrder;
import data.OrderData;
import dataService.OrderDataService;
import po.OrderPO;

public class Order{
	OrderVO vo;
	OrderDataService service=new OrderData();
	CreditManager manager=CreditManager.getInstance();
	public Order(){
		super();
	}
	
	public Order(OrderVO vo){
		this.vo=vo;
	}
	
	/**
	 * 获取订单总价
	 * @param OrderDataService service
	 * @return 订单总价值
	 * @throws SQLException 
	 */
	public int getTotal() throws SQLException{
		PromotionInfoForOrder promotionService=new PromotionToolForOrder();
		HotelInfoForOrder hotelService=new HotelToolForOrder();
		double HotelDiscount=promotionService.getApproriateHotelPromotion(vo);
		double WebDiscount=promotionService.getAppropriateWebPromotion(vo);
		int roomPrice;
		roomPrice = hotelService.getHotelRoomPrice(vo.getHotelId(), vo.getRoomType());
	    int totalPrice=(int) (roomPrice*vo.getRoomNum()*HotelDiscount*WebDiscount);
		return totalPrice;
	}
	
	/**
	 * 添加新的订单
	 * @param OrderDataService service
	 * @return 添加成功返回true，否则false
	 * @throws SQLException 
	 */
	public String addNewOrder() throws SQLException{
		OrderPO po=new OrderPO(vo);
		String OrderID = service.distributeid();
		int id = Integer.valueOf(OrderID);
		id++;
		OrderID = String.valueOf(id);
		po.setId(OrderID);
		service.insert(po);
		return OrderID;
	}
	/**
	 * 记录入住信息
	 * @return
	 * @throws SQLException 
	 */
	public boolean CheckIn() throws SQLException{
		OrderPO po=service.findByOrderID(vo.getorderId());
		if(!po.getStatus().equals("未执行"))
			return false;
		po.setStatus("已执行");
		po.setEntryTime(vo.getEntryTime());
		po.setLastTime(vo.getLastTime());
		manager.addCredit(po);
		service.update(po);
		return true;
	}
	/**
	 * 撤销订单
	 * @return
	 */
	public boolean Cancel(){
		OrderPO po=service.findByOrderID(vo.getorderId());
	    if(!po.getStatus().equals("未执行"))
		    return false;
	
	    po.setStatus("已撤销");
	    manager.subCredit(po);
	    service.update(po);
	    return true;
	}
	
	/**
	 * 恢复异常订单
	 * @return
	 */
	public boolean Recover(String recoverPercent){
		OrderPO po=service.findByOrderID(vo.getorderId());
		if(!po.getStatus().equals("异常"))
			return false;
		po.setStatus("已执行");
		po.setEntryTime(vo.getEntryTime());
		po.setLastTime(vo.getLastTime());
		if(recoverPercent.equals("全部")){
			manager.recoverCredit(po,1);
		}else{
			manager.recoverCredit(po,0.5);
		}
		
		service.update(po);
		return true;
	}
	
	/**
	 * 评价订单
	 * @return
	 */
	public boolean Comment(int grade){
		HotelInfoForOrder hotelService=new HotelToolForOrder();
		OrderPO po = service.findByOrderID(vo.getorderId());
		if(!po.getStatus().equals("已退房"))
			return false;
		po.setComment(vo.getComment());
		po.setStatus("已评价");
		service.update(po);
		hotelService.updateGrade(po.getHotelId(), grade);
		return true;
	}
	
	/**
	 * 根据订单号查询订单
	 * @return
	 */
	public OrderVO gerOrderByOrderID(String OrderID){
		OrderPO po=service.findByOrderID(OrderID);
		OrderVO order=new OrderVO(po);
		return order;
	}
	
	/**
	 * 获得酒店的所有订单
	 * @param ID
	 * @return 酒店的所有订单
	 * @throws SQLException 
	 */
	public List<OrderVO> getOrderByHotelID(String hotelID) throws SQLException{
		List<OrderPO> orderListPO=service.findByHotelID(hotelID);
		System.out.println(orderListPO);
		return this.turnPOtoVO(orderListPO);
	}
	
	/**
	 * 获得用户的所有订单
	 * @param UserID
	 * @return
	 * @throws SQLException 
	 */
	public List<OrderVO> getOrderByUserID(String UserID) throws SQLException{
		List<OrderPO> orderListPO=service.findByClient(UserID);
		return this.turnPOtoVO(orderListPO);
	}
	
	/**
	 * 获得某一天的所有订单
	 * @param Date
	 * @return
	 * @throws SQLException 
	 */
	public List<OrderVO> getOrderByDate(String Date) throws SQLException{
		List<OrderPO> orderListPO=service.findByDate(Date+" 18:00");
		return this.turnPOtoVO(orderListPO);
	}
	
	/**
	 * 将一个订单列表中某种状态的订单筛选出来
	 * @param list
	 * @param Status
	 * @return
	 */
	public List<OrderVO> filterOrderByStatus(List<OrderVO> list,String Status){
		List<OrderVO> result = new ArrayList<OrderVO>();
		for(int i=0;i<list.size();i++){
			OrderVO vo=list.get(i);
			if(vo.getStatus().equals(Status)){
				result.add(vo);
			}	
		}
		return result;
	}
	
	/**
	 * 将一个OrderPO的List转为OrderVO的list
	 * @param poList
	 * @return
	 */
	private List<OrderVO> turnPOtoVO(List<OrderPO> poList){
		List<OrderVO> voList=new ArrayList<OrderVO>();
		for(OrderPO po:poList){
			OrderVO vo= new OrderVO(po);
			voList.add(vo);
		} 
		return voList;
	}
}