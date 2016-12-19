package dataService;

import java.sql.SQLException;
import java.util.ArrayList;

import po.RoomPO;

public interface RoomDataService {
	
	public void insert(RoomPO r);
	
	public void update(RoomPO r);
	
	public ArrayList<RoomPO> findByHotelName(String HotelName) throws SQLException;
	
	public RoomPO findByIDAndHotelname(String roomID,String hotelName) throws SQLException;
}
