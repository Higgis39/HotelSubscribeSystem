package maintain;

import static org.junit.Assert.*;

import org.junit.Test;

import maintain.HotelPO;
import maintain.MockHotel;

public class testupdate {

	@Test
	public void testupdate() {
		MockHotel Hotel1 = new MockHotel("如家");
		MockHotel Hotel2 = new MockHotel("格林豪泰");

//      下面显示的是要修改的酒店本来的信息
//		HotelPO hotel1 = new HotelPO("如家", "151XXXX7532", "南京", "栖霞区", "", "Wifi仅在房间内有效", "8.8", 4.0);
//		HotelPO hotel2 = new HotelPO("格林豪泰", "152XXXX5098", "南京", "栖霞区", "", "Wifi全覆盖", "8.6", 3.8);
		
		assertEquals(true, Hotel1.UpdateHotelMessage("如家", "151XXXX5535"));
		assertEquals(true, Hotel2.UpdateHotelMessage("格林豪泰", "152XXXX5095"));
	}

}
