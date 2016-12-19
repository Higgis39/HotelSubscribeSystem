package businessLogicService.hotelBLService;

import java.sql.SQLException;
/*
 * 
 * @author 梁先伟
 * 
 */
public interface UpdateService {
	public boolean CheckOut(String hotelname,String orderID,String room,int num, String checkoutTime)throws SQLException;
	
	public boolean CheckIn(String HotelName,String roomType,int num)throws SQLException;
	
	public boolean CheckOut(String HotelName,String roomType,int num)throws SQLException;
}
