package Promotion模块.MockWebPromotion;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;



public class WebPromotionTest {
	
	ArrayList<String> webpromotion = new ArrayList<String>();

	@SuppressWarnings("deprecation")
	@Test
	public void testWebCreate() {
		MockWebPromotionList mock1 = new MockWebPromotionList();
		MockWebPromotionList mock2 = new MockWebPromotionList();
		MockPromotion mock3 = new MockPromotion();
		MockPromotion mock4 = new MockPromotion();
		assertEquals(true,mock1.addPromotion(true, "˫ʮһ��ۿ�", 0.5));
		assertEquals(false,mock2.addPromotion(false, "VIP��Ա�ض���Ȧר���ۿ�", 1));
		assertEquals(0.72,mock3.businessDistrict(true, "��������", 4));
		assertEquals(0.4,mock4.businessDistrict(true, "�½ֿ�", 10));
	}
}
