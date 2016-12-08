package businessLogic.hotelbl;

import java.util.ArrayList;

import businessLogicService.hotelBLService.AddRoomService;

public class AddRoomController implements AddRoomService{
	Hotel hotel = new Hotel();
	
	/**
	 * 录入可用客房
	 * @param roomID String
	 * @param hotelname String
	 * @return roomList ArrayList<String>
	 */
	public boolean AddRoom(String roomID,String hotelName){
		return hotel.UpdateRoom(roomID, hotelName);
	}
}
