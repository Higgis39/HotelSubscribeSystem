package businessLogic.orderbl;

import java.sql.SQLException;

import businessLogic.hotelbl.HotelToolForOrder;
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
	 * @throws SQLException 
	 */
	public int CheckRoom(String hotelName,String roomType) throws SQLException{
		return new HotelToolForOrder().CheckEnoughRoom(hotelName, roomType);
	}
	
	public int CheckMax(String hotelName,String roomType) throws SQLException{
		return new HotelToolForOrder().CheckMaxInRoom(hotelName, roomType);
	}
	 
	/**
	 * 计算订单总价
	 * @return 返回订单总价
	 * @throws SQLException 
	 */
	public double getTotal(OrderVO vo) throws SQLException {
		return new Order(vo).getTotal();
	}

	/**
	 * 客户确认下单
	 * @return 订单生成成功并添加进数据库中返回true，否则返回false
	 * @throws SQLException 
	 */
	public String addNewOrder(OrderVO vo) throws SQLException {
		return new Order(vo).addNewOrder();
	}
	
}
