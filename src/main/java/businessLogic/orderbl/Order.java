package businessLogic.orderbl;

import vo.OrderVO;
import vo.HotelPromotionVO;
import vo.WebPromotionVO;

import java.sql.SQLException;
import java.util.*;

import businessLogic.orderbl.stub.HotelInfoForOrder;
import businessLogic.orderbl.stub.HotelInfoForOrder_stub;
import businessLogic.orderbl.stub.PromotionInfoForOrder;
import businessLogic.orderbl.stub.PromotionInfoForOrder_stub;
import data.OrderData;
import dataService.OrderDataService;
import po.OrderPO;
import po.UserPO;

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
	 */
	public int getTotal(){
		PromotionInfoForOrder promotionService=new PromotionInfoForOrder_stub();
		HotelInfoForOrder hotelService=new HotelInfoForOrder_stub();
		return 0;
	}
	
	/**
	 * 添加新的订单
	 * @param OrderDataService service
	 * @return 添加成功返回true，否则false
	 */
	public boolean addNewOrder(){
		OrderPO po=new OrderPO(vo.getorderId(),vo.getHotelId(),vo.getUserId(),vo.getStatus(),
				vo.getEntryTime(),vo.getLastTime(),vo.getPrice(),vo.getComment(),vo.getRoomType(),vo.getRoomNum());
		service.insert(po);
		return true;
	}
	
	/**
	 * 记录入住信息
	 * @return
	 */
	public boolean CheckIn(){
		OrderPO po=service.findByOrderID(vo.getorderId());
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
		po.setStatus("已撤销");
		manager.subCredit(po);
		service.update(po);
		return true;
	}
	
	/**
	 * 恢复异常订单
	 * @return
	 */
	public boolean Recover(){
		OrderPO po=service.findByOrderID(vo.getorderId());
		po.setStatus("已执行");
		po.setEntryTime(vo.getEntryTime());
		po.setLastTime(vo.getLastTime());
		manager.recoverCredit(po);
		service.update(po);
		return true;
	}
	
	/**
	 * 评价订单
	 * @return
	 */
	public boolean Comment(){
		OrderPO po = service.findByOrderID(vo.getorderId());
		po.setComment(vo.getComment());
		service.update(po);
		return true;
	}
	
	/**
	 * 根据订单号查询订单
	 * @return
	 */
	public OrderVO gerOrderByOrderID(){
		OrderPO po=service.findByOrderID(this.vo.getorderId());
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
		List<OrderPO> orderListPO=service.findByDate(Date);
		return this.turnPOtoVO(orderListPO);
	}
	
	/**
	 * 将一个订单列表中某种状态的订单筛选出来
	 * @param list
	 * @param Status
	 * @return
	 */
	public List<OrderVO> filterOrderByStatus(List<OrderVO> list,String Status){
		for(int i=0;i<list.size();i++){
			OrderVO vo=list.get(i);
			if(!vo.getStatus().equals(Status))
				list.remove(i);
		}
		return list;
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