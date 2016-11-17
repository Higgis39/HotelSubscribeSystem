package OrderBLtest;
import static org.junit.Assert.*;
import org.junit.Test;
import OrderBL.MockCancelOrder;
import OrderBL.OrderPO;

public class testCancelOrder {
	MockCancelOrder eo=new MockCancelOrder();
	OrderPO po = new OrderPO("0000","2016.11.11","2016.11.12","IKEA",256.00);
	@Test
    public void testCancel(String OrderID){
    	eo.Cancel(po.getOrderID());
    	assertEquals("ÒÑ³·Ïú",po.getState());
    }
}
