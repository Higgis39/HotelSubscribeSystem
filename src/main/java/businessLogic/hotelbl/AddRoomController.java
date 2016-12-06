package businessLogic.hotelbl;

import java.util.ArrayList;

public class AddRoomController {
	
	Hotel hotel = new Hotel();
	
	/**
	 * 录入可用客房
	 * @param roomNumber int
	 * @param hotelname String
	 * @return roomList ArrayList<Integer>
	 */
	public ArrayList<Integer> AddRoom(int roomNumber,String hotelName){
		return hotel.UpdateRoom(roomNumber, hotelName);
	}
}
