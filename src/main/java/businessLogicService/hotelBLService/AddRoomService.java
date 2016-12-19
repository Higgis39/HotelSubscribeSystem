package businessLogicService.hotelBLService;

import java.sql.SQLException;
import java.util.ArrayList;

import vo.RoomVO;
/*
 * 
 * @author 梁先伟
 * 
 */
public interface AddRoomService {
	public ArrayList<RoomVO> getRoom(String HotelName)throws SQLException;
	
	public boolean UpdateRoom(String hotelName,String roomtype,int peoplenum,int roomnum,int price)throws SQLException;
}
