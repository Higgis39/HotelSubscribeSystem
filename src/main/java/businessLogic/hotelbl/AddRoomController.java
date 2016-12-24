package businessLogic.hotelbl;

import java.sql.SQLException;
import java.util.ArrayList;

import businessLogicService.hotelBLService.AddRoomService;
import vo.RoomVO;
/*
 * 
 * @author 梁先伟
 * 
 */
public class AddRoomController implements AddRoomService{
	Hotel hotel = new Hotel();
	
	/**
	 * 得到酒店的空闲客房
	 * @param HotelName
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<RoomVO> getRoom(String HotelName) throws SQLException{
		return hotel.getRoom(HotelName);
	}
	
	/**
	 * 判断酒店是否还有房间
	 * @param HotelName
	 * @return
	 * @throws SQLException
	 */
	public boolean HasRoom(String HotelName) throws SQLException{
		return hotel.HasRoom(HotelName);
	}
	
	/**
	 * 录入可用客房
	 * @param hotelname String
	 * @param roomtype String
	 * @param peoplenum Integer
	 * @param roomnum Integer
	 * @param price Integer
	 * @return 
	 */
	public boolean UpdateRoom(String hotelName,String roomtype,int peoplenum,int roomnum,int price)throws SQLException{
		return hotel.UpdateRoom(hotelName, roomtype, peoplenum, roomnum, price);
	}
}
