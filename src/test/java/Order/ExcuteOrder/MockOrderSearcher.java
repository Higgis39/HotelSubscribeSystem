package Order.ExcuteOrder;
import java.util.ArrayList;

import Order.CancelOrder.OrderPO;

public class MockOrderSearcher {

	public OrderPO findByID(String OrderID){
		return null;
	}
	
	public ArrayList<OrderPO> findByUser(String userID){
		return null;
	}
	
	public ArrayList<OrderPO> findByState(String userID,String state){
		return null;
	}
	
	public ArrayList<OrderPO> findByHotel(String HotelID){
		return null;
	}
}
