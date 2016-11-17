package Mock.MockHotel;

import static org.junit.Assert.*;

import org.junit.Test;

import po.PromotionMessage;

public class HotelPromotionTest {

	@Test
	public void testHotelCreate() {
		MockHotelPromotionList mock = new MockHotelPromotionList();
		assertEquals(true,mock.addPromotion(true, "生日特惠折扣", 0.5));
		assertEquals(false,mock.addPromotion(false, "三间及以上预订特惠", 0.8));
	}
	
	@Test
	public void testHotelUpdate() {
		PromotionMessage p1= new PromotionMessage("合作企业客户折扣", 0.5);
		PromotionMessage p2 = new PromotionMessage("双11活动折扣", 0.8);
		MockPromotion mock1 = new MockPromotion("生日特惠折扣", 0.5);
		MockPromotion mock2 = new MockPromotion("三间及以上预订特惠", 0.8);
		assertEquals(p1,mock1.updatePromotion(true, "合作企业客户折扣", 0.5));
		assertEquals(p2,mock2.updatePromotion(true, "双11活动折扣", 0.8));
		assertEquals(false,mock2.updatePromotion(false, "双11活动折扣", 0.8));
	}
	
	@Test
	public void testHotelDelete() {
		PromotionMessage p2 = new PromotionMessage("三间及以上预订特惠", 0.8);
		MockPromotion mock1 = new MockPromotion("生日特惠折扣", 0.5);
		MockPromotion mock2 = new MockPromotion("三间及以上预订特惠", 0.8);
		assertEquals(null,mock1.deletePromotion(true));
		assertEquals(p2,mock2.deletePromotion(false));
	}
	
	@Test
	public void testExecute() {
		MockPromotion mock1 = new MockPromotion();
		MockPromotion mock2 = new MockPromotion();
		assertEquals(true,mock1.executePromotion(true, "生日特惠折扣"));
		assertEquals(false,mock2.executePromotion(true, "双11活动折扣"));
	}

}
