package businessLogicService.hotelBLService;

import java.sql.SQLException;

public interface UpdateService {
	public boolean CheckOut(String orderID, String checkoutTime);
	
	public boolean CheckIn(String HotelName,String roomType,int num)throws SQLException;
	
	public boolean CheckOut(String HotelName,String roomType,int num)throws SQLException;
}
