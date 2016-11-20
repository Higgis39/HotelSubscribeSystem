package Order.WebsiteViewOrder;
import static org.junit.Assert.*;
import org.junit.Test;
import Order.WebsiteViewOrder.*;

public class testWebsiteViewOrder {
	MockWebsiteViewOrder wo=new MockWebsiteViewOrder();
	OrderPO po = new OrderPO("0000","2016.11.11","2016.11.12","IKEA",256.00);
	@Test
	public void testRecover(String orderID){
		wo.Recover(po.getOrderID());
		assertEquals("��ִ��",po.getState());
	}
}
