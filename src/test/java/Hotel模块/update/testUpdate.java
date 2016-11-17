package update;

import static org.junit.Assert.*;

import org.junit.Test;

import update.MockHotel;

public class testUpdate {

	@Test
	public void test() {
		MockHotel hotel=new MockHotel("如家");
		OrderPO order1 = new OrderPO(98701, "11.12", "11.12", "12:00", "Unfinished", "如家", 128, "");
		OrderPO order2 = new OrderPO(98702, "11.12", "11.12", "12:00", "Unfinished", "如家", 158, "");
		OrderPO order3 = new OrderPO(98703, "11.12", "11.12", "16:00", "Unfinished", "如家", 128, "");
		OrderPO order4 = new OrderPO(98704, "11.12", "11.12", "16:00", "Unfinished", "如家", 158, "");
		OrderPO order5 = new OrderPO(98705, "11.12", "11.12", "18:00", "Unfinished", "如家", 128, "");
		
		hotel.update(order1, "00:00");
		hotel.update(order4, "12:00");
		
		assertEquals(true,hotel.Order.contains(order1.getId()+" "+order1.getCheckOutTime()+" "+order1.getState()));
		assertEquals(false,hotel.Order.contains(order2.getId()+" "+order2.getCheckOutTime()+" "+order2.getState()));
		assertEquals(false,hotel.Order.contains(order3.getId()+" "+order3.getCheckOutTime()+" "+order3.getState()));
		assertEquals(true,hotel.Order.contains(order4.getId()+" "+order4.getCheckOutTime()+" "+order4.getState()));
		assertEquals(false,hotel.Order.contains(order5.getId()+" "+order5.getCheckOutTime()+" "+order5.getState()));
		assertEquals("finished",order1.getState());
		assertEquals("Unfinished",order3.getState());
		assertEquals("00:00",order1.getCheckOutTime());
		assertEquals("12:00",order4.getCheckOutTime());
		assertEquals("",order5.getCheckOutTime());
	}

}
