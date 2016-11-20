package Order.CreateOrder;
import static org.junit.Assert.*;
import org.junit.Test;

import Order.CommentOrder.MockPromotionPO;
import Order.CreateOrder.*;

public class testCreateOrder {
	MockCreateOrder co=new MockCreateOrder();
	OrderPO po = new OrderPO("0000","2016.11.11","2016.11.12","IKEA",256.00);
	MockUserPO Upo=new MockUserPO();
	
	@Test
	public void testCheckCredit(){
		MockCreditManager mcm=new MockCreditManager();
		assertEquals(true,mcm.haveEnoughCredit(Upo.getUserID()));
	}
	@Test
    public void testaddOrderInfo(){
    	co.addOrderInfo(po);
    	assertEquals(co.NewOrder.getOrderID(),0000);
    	assertEquals(co.NewOrder.getBeginDate(),"2016.11.11");
    	assertEquals(co.NewOrder.getCheckOutTime(),"2016.11.12");
    	assertEquals(co.NewOrder.getHotel(),"IKEA");
    }
	@Test
    public void testfindBestPromotion(){
    	co.findBestPromotion(po);
    	assertEquals(new MockPromotionPO(),co.NewOrder.getPromotion());
    }
	@Test
    public void testgetTotal(){
    	co.getTotal(po);
    	assertEquals(100.00,co.NewOrder.getPrice());
    }
}
