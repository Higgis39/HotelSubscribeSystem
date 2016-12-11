package businessLogic.orderbl;

import businessLogic.orderbl.stub.HotelInfoForOrder_stub;
import businessLogicService.orderBLService.CreateOrderService;
import vo.OrderVO;

public class CreateOrderController implements CreateOrderService{
	/**
	 * 检查客户的信用值是否达到下订单的最低标准
	 * @return 达到标准返回true，否则返回false
	 */
	public boolean CheckEnoughCredit(String ID) {
		return CreditManager.getInstance().checkCredit(ID);
	}

	/**
	 * 查询某种房间类型的数量
	 * @param hotelID
	 * @param roomType
	 * @return 返回该房间类型的数量
	 */
	public int CheckRoom(String hotelName,String roomType){
		return new HotelInfoForOrder_stub().CheckEnoughRoom(hotelName, roomType);
	}
	
	public int CheckMax(String hotelName,String roomType){
		return new HotelInfoForOrder_stub().CheckEnoughRoom(hotelName, roomType);
	}
	 
	/**
	 * 计算订单总价
	 * @return 返回订单总价
	 */
	public double getTotal(OrderVO vo) {
		return new Order(vo).getTotal();
	}

	/**
	 * 客户确认下单
	 * @return 订单生成成功并添加进数据库中返回true，否则返回false
	 */
	public boolean addNewOrder(OrderVO vo) {
		return new Order(vo).addNewOrder();
	}
	
}
