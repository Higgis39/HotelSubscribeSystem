package Promotion.MockHotelPromotion;

import static org.junit.Assert.*;

import org.junit.Test;



public class HotelPromotionTest {

	@Test
	public void testHotelCreate() {
		MockHotelPromotionList mock = new MockHotelPromotionList();
		assertEquals(true,mock.addPromotion(true, "�����ػ��ۿ�", 0.5));
		assertEquals(false,mock.addPromotion(false, "���估����Ԥ���ػ�", 0.8));
	}
	
	@Test
	public void testHotelUpdate() {
		PromotionMessage p1= new PromotionMessage("������ҵ�ͻ��ۿ�", 0.5);
		PromotionMessage p2 = new PromotionMessage("˫11��ۿ�", 0.8);
		MockPromotion mock1 = new MockPromotion("�����ػ��ۿ�", 0.5);
		MockPromotion mock2 = new MockPromotion("���估����Ԥ���ػ�", 0.8);
		assertEquals(p1,mock1.updatePromotion(true, "������ҵ�ͻ��ۿ�", 0.5));
		assertEquals(p2,mock2.updatePromotion(true, "˫11��ۿ�", 0.8));
		assertEquals(false,mock2.updatePromotion(false, "˫11��ۿ�", 0.8));
	}
	
	@Test
	public void testHotelDelete() {
		PromotionMessage p2 = new PromotionMessage("���估����Ԥ���ػ�", 0.8);
		MockPromotion mock1 = new MockPromotion("�����ػ��ۿ�", 0.5);
		MockPromotion mock2 = new MockPromotion("���估����Ԥ���ػ�", 0.8);
		assertEquals(null,mock1.deletePromotion(true));
		assertEquals(p2,mock2.deletePromotion(false));
	}
	
	@Test
	public void testExecute() {
		MockPromotion mock1 = new MockPromotion();
		MockPromotion mock2 = new MockPromotion();
		assertEquals(true,mock1.executePromotion(true, "�����ػ��ۿ�"));
		assertEquals(false,mock2.executePromotion(true, "˫11��ۿ�"));
	}

}
