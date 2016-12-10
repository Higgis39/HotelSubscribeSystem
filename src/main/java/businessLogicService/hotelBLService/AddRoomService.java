package businessLogicService.hotelBLService;

import java.sql.SQLException;

public interface AddRoomService {
	public boolean AddRoom(String roomID,String hotelName)throws SQLException;
}
