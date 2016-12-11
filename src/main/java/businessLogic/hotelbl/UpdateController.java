package businessLogic.hotelbl;

import java.sql.SQLException;

import businessLogicService.hotelBLService.UpdateService;

public class UpdateController implements UpdateService{
	
	Hotel hotel = new Hotel();
	
	/**
	 * 更新退房信息
	 * @param orderID String
	 * @param checkoutTime String
	 * @param checkoutDate String
	 * @return UpdateState boolean
	 */
	
	public boolean CheckOut(String orderID, String checkoutTime){
		return hotel.CheckOut(orderID, checkoutTime);
	}
	
	/**
	 * 登记入住信息(线下)
	 * @param HotelName String
	 * @param roomType String
	 * @param num
	 * @return
	 * @throws SQLException 
	 */
	public boolean CheckIn(String HotelName,String roomType,int num) throws SQLException{
		return hotel.CheckIn(HotelName,roomType,num);
	}
	
	/**
	 * 更新退房信息(线下)
	 * @param HotelName String
	 * @param roomType String
	 * @param num
	 * @return
	 * @throws SQLException 
	 */
	public boolean CheckOut(String HotelName,String roomType,int num) throws SQLException{
		return hotel.CheckOut(HotelName,roomType,num);
	}
}
