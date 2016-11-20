package Hotel.maintain;

import static org.junit.Assert.*;

import org.junit.Test;

import Hotel.maintain.HotelPO;
import Hotel.maintain.MockHotel;

public class testupdate {

	@Test
	public void testupdate() {
		MockHotel Hotel1 = new MockHotel("���?");
		MockHotel Hotel2 = new MockHotel("���ֺ�̩");

//      ������ʾ����Ҫ�޸ĵľƵ걾������Ϣ
//		HotelPO hotel1 = new HotelPO("���?", "151XXXX7532", "�Ͼ�", "��ϼ��", "", "Wifi���ڷ�������Ч", "8.8", 4.0);
//		HotelPO hotel2 = new HotelPO("���ֺ�̩", "152XXXX5098", "�Ͼ�", "��ϼ��", "", "Wifiȫ����", "8.6", 3.8);
		
		assertEquals(true, Hotel1.UpdateHotelMessage("���?", "151XXXX5535"));
		assertEquals(true, Hotel2.UpdateHotelMessage("���ֺ�̩", "152XXXX5095"));
	}

}
