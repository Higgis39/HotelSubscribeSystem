package update;

import java.util.ArrayList;

public class MockHotel extends Hotel{
	String Hotelname;
	ArrayList<String> Order =new ArrayList<String>();
	
	public MockHotel(String p1){
		Hotelname=p1;
	}
	
	public void addorder(int orderID,String state){
		Order.add(orderID+" "+state);
	}
	
	public void update(OrderPO order,String checkOutTime){
		order.CheckOutTime=checkOutTime;
		order.state="finished";
		Order.add(order.getId()+" "+order.CheckOutTime+" "+order.state);
	}
}
