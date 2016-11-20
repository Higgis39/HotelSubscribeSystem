package Order.HotelViewOrder;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import Order.HotelViewOrder.*;

public class testHotelViewOrder {
	public void testfindSpecificOrder(String HotelID){
		MockHotelViewOrder cvo=new MockHotelViewOrder();
    	ArrayList<OrderPO> order=cvo.findSpecificOrder("IKEA");
    	for(int i=0;i<order.size();i++)
    	    assertEquals(order.get(0).getHotel(),"IKEA");
	}

}
