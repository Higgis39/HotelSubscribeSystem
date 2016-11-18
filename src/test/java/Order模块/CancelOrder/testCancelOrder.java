package Order模块.CancelOrder;
import static org.junit.Assert.*;
import org.junit.Test;
import Order模块.CancelOrder.MockCancelOrder;
import Order模块.CancelOrder.OrderPO;

public class testCancelOrder {
	MockCancelOrder eo=new MockCancelOrder();
	OrderPO po = new OrderPO("0000","2016.11.11","2016.11.12","IKEA",256.00);
	@Test
    public void testCancel(String OrderID){
    	eo.Cancel(po.getOrderID());
    	assertEquals("�ѳ���",po.getState());
    }
}
