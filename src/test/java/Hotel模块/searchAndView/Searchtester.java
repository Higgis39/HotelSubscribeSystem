package Hotel模块.searchAndView;

import static org.junit.Assert.*;

import org.junit.Test;

public class Searchtester{

	//���������Ƶ�
	@Test
	public void testsearch() {
		MockHotel Hotel1 = new MockHotel("�Ͼ�", "��ϼ��");
		MockHotel Hotel2 = new MockHotel("�Ͼ�", "Wifiȫ����");
		
		HotelPO hotel1 = new HotelPO("���", "�Ͼ�", "��ϼ��", "", "Wifi���ڷ�������Ч", "8.8", 4.0);
		HotelPO hotel2 = new HotelPO("��ͥ", "�Ͼ�", "������", "", "Wifiȫ����", "9.0", 4.2);
		HotelPO hotel3 = new HotelPO("����", "�Ϻ�", "������", "", "Wifiȫ����", "9.1", 4.1);
		HotelPO hotel4 = new HotelPO("���ֺ�̩", "�Ͼ�", "��ϼ��", "", "Wifiȫ����", "8.6", 3.8);
		
		assertEquals(true, Hotel1.Search(hotel1.getAddress(), hotel1.getArea()));
		assertEquals(false, Hotel1.Search(hotel2.getAddress(), hotel2.getArea()));
		assertEquals(false, Hotel1.Search(hotel3.getAddress(), hotel3.getArea()));
		assertEquals(true, Hotel1.Search(hotel4.getAddress(), hotel4.getArea()));
		assertEquals(false, Hotel2.Search(hotel1.getAddress(), hotel1.getService()));
		assertEquals(true, Hotel2.Search(hotel2.getAddress(), hotel2.getService()));
		assertEquals(false, Hotel2.Search(hotel3.getAddress(), hotel3.getService()));
		assertEquals(true, Hotel2.Search(hotel4.getAddress(), hotel4.getService()));
		
	}
	
	//��������Ƶ�
	@Test
	public void testview() {
		MockHotel Hotel1 = new MockHotel("�Ͼ�", "��ϼ��");
		
		HotelPO hotel1 = new HotelPO("���", "�Ͼ�", "��ϼ��", "", "Wifi���ڷ�������Ч", "8.8", 4.0);
		HotelPO hotel2 = new HotelPO("���ֺ�̩", "�Ͼ�", "��ϼ��", "", "Wifiȫ����", "8.6", 3.8);
		
		assertEquals(hotel1.getHotelMessage(), Hotel1.View("���"));
		assertEquals("No Hotel",Hotel1.View("��ͥ"));
		assertEquals(hotel2.getHotelMessage(),Hotel1.View("���ֺ�̩"));
	}
}
