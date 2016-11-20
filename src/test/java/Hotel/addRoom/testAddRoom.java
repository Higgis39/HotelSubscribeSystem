package Hotel.addRoom;

import static org.junit.Assert.*;

import org.junit.Test;

public class testAddRoom {

	@Test
	public void test() {
		
		MockHotel hotel=new MockHotel("���?");
		RoomPO room1 = new RoomPO(2301, 2, 198, "˫�˼�");
		RoomPO room2 = new RoomPO(2302, 2, 258, "˫�˼�");
		RoomPO room3 = new RoomPO(2303, 2, 298, "�󴲷�");
		RoomPO room4 = new RoomPO(2304, 1, 128, "���˼�");
		
		room1.addRoom();
		room3.addRoom();
		
		hotel.addRoom(room1.getRoomID());
		hotel.addRoom(room3.getRoomID());
		
		assertEquals(true,hotel.Room.contains(room1.getRoomID()));
		assertEquals(false,hotel.Room.contains(room2.getRoomID()));
		assertEquals(true,hotel.Room.contains(room3.getRoomID()));
		assertEquals(false,hotel.Room.contains(room4.getRoomID()));
		
	}

}
