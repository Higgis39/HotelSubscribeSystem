package Mock.MockWeb;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import Mock.MockHotel.MockHotelPromotionList;
import Mock.MockHotel.MockPromotion;

public class WebPromotionTest {
	
	ArrayList<String> webpromotion = new ArrayList<String>();

	@SuppressWarnings("deprecation")
	@Test
	public void testWebCreate() {
		MockWebPromotionList mock1 = new MockWebPromotionList();
		MockWebPromotionList mock2 = new MockWebPromotionList();
		MockPromotion mock3 = new MockPromotion();
		MockPromotion mock4 = new MockPromotion();
		assertEquals(true,mock1.addPromotion(true, "双十一活动折扣", 0.5));
		assertEquals(false,mock2.addPromotion(false, "VIP会员特定商圈专属折扣", 1));
		assertEquals(0.72,mock3.businessDistrict(true, "仙林中心", 4));
		assertEquals(0.4,mock4.businessDistrict(true, "新街口", 10));
	}
}
