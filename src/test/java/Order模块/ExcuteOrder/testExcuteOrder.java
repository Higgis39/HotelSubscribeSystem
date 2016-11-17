package OrderBLtest;

import static org.junit.Assert.*;
import org.junit.Test;
import OrderBL.*;

public class testExcuteOrder {
	MockExcuteOrder eo=new MockExcuteOrder();
	OrderPO po = new OrderPO("0000","2016.11.11","2016.11.12","IKEA",256.00);
	@Test
	public void testExcute(){
		eo.Excute(po.getOrderID());
		assertEquals("ÒÑÖ´ÐÐ",po.getState());
	}
	
	@Test
	public void testCheckIn(){
		eo.CheckIn(318);
		assertEquals(318,po.getRoomNum());
	}
}
