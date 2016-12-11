package businessLogicService.hotelBLService;

import java.sql.SQLException;
import java.util.ArrayList;

import vo.RoomVO;

public interface AddRoomService {
	public ArrayList<RoomVO> getRoom(String HotelName);
	
	public boolean UpdateRoom(String hotelName,String roomtype,int peoplenum,int roomnum,int price)throws SQLException;
}
