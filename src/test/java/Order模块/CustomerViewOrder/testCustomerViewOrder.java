package Order模块.CustomerViewOrder;
import static org.junit.Assert.*;
import org.junit.Test;
import Order模块.CustomerViewOrder.*;
import java.util.ArrayList;

public class testCustomerViewOrder {
    @Test
	public void testfindSpecificOrder(String userID){
    	MockCustomerViewOrder cvo=new MockCustomerViewOrder();
    	ArrayList<OrderPO> order=cvo.findSpecificOrder("0000");
    	for(int i=0;i<order.size();i++)
    	    assertEquals(order.get(0).getUserID(),"0000");
	}
}
