package Hotel.addRoom;

import java.util.ArrayList;

public class MockHotel extends Hotel{
	String Hotelname;
	ArrayList<Integer> Room =new ArrayList<Integer>();
	
	public MockHotel(String p1){
		Hotelname=p1;
	}
	
	public void addRoom(int roomID){
		Room.add(roomID);
	}
}
