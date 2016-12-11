package businessLogic.hotelbl;

import java.sql.SQLException;
import java.util.ArrayList;

import businessLogicService.hotelBLService.AddRoomService;
import vo.RoomVO;

public class AddRoomController implements AddRoomService{
	Hotel hotel = new Hotel();
	
	/**
	 * 得到酒店的空闲客房
	 * @param HotelName
	 * @return
	 */
	public ArrayList<RoomVO> getRoom(String HotelName){
		return hotel.getRoom(HotelName);
	}
	
	/**
	 * 录入可用客房
	 * @param roomID String
	 * @param hotelname String
	 * @return roomList ArrayList<String>
	 */
	public boolean UpdateRoom(String hotelName,String roomtype,int peoplenum,int roomnum,int price)throws SQLException{
		return hotel.UpdateRoom(hotelName, roomtype, peoplenum, roomnum, price);
	}
}
