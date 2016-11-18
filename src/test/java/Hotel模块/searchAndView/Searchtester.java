package searchAndView;

import static org.junit.Assert.*;

import org.junit.Test;

public class Searchtester{

	//测试搜索酒店
	@Test
	public void testsearch() {
		MockHotel Hotel1 = new MockHotel("南京", "栖霞区");
		MockHotel Hotel2 = new MockHotel("南京", "Wifi全覆盖");
		
		HotelPO hotel1 = new HotelPO("如家", "南京", "栖霞区", "", "Wifi仅在房间内有效", "8.8", 4.0);
		HotelPO hotel2 = new HotelPO("汉庭", "南京", "玄武区", "", "Wifi全覆盖", "9.0", 4.2);
		HotelPO hotel3 = new HotelPO("七天", "上海", "普陀区", "", "Wifi全覆盖", "9.1", 4.1);
		HotelPO hotel4 = new HotelPO("格林豪泰", "南京", "栖霞区", "", "Wifi全覆盖", "8.6", 3.8);
		
		assertEquals(true, Hotel1.Search(hotel1.getAddress(), hotel1.getArea()));
		assertEquals(false, Hotel1.Search(hotel2.getAddress(), hotel2.getArea()));
		assertEquals(false, Hotel1.Search(hotel3.getAddress(), hotel3.getArea()));
		assertEquals(true, Hotel1.Search(hotel4.getAddress(), hotel4.getArea()));
		assertEquals(false, Hotel2.Search(hotel1.getAddress(), hotel1.getService()));
		assertEquals(true, Hotel2.Search(hotel2.getAddress(), hotel2.getService()));
		assertEquals(false, Hotel2.Search(hotel3.getAddress(), hotel3.getService()));
		assertEquals(true, Hotel2.Search(hotel4.getAddress(), hotel4.getService()));
		
	}
	
	//测试浏览酒店
	@Test
	public void testview() {
		MockHotel Hotel1 = new MockHotel("南京", "栖霞区");
		
		HotelPO hotel1 = new HotelPO("如家", "南京", "栖霞区", "", "Wifi仅在房间内有效", "8.8", 4.0);
		HotelPO hotel2 = new HotelPO("格林豪泰", "南京", "栖霞区", "", "Wifi全覆盖", "8.6", 3.8);
		
		assertEquals(hotel1.getHotelMessage(), Hotel1.View("如家"));
		assertEquals("No Hotel",Hotel1.View("汉庭"));
		assertEquals(hotel2.getHotelMessage(),Hotel1.View("格林豪泰"));
	}
}
