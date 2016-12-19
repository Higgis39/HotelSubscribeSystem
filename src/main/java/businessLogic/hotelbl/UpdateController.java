package businessLogic.hotelbl;

import java.sql.SQLException;

import businessLogicService.hotelBLService.UpdateService;
/*
 * 
 * @author 梁先伟
 * 
 */
public class UpdateController implements UpdateService{
	
	Hotel hotel = new Hotel();
	
	/**
	 * 更新退房信息
	 * @param orderID String
	 * @param checkoutTime String
	 * @param checkoutDate String
	 * @return UpdateState boolean
	 * @throws SQLException 
	 */
	
	public boolean CheckOut(String hotelname,String orderID,String room,int num, String checkoutTime) throws SQLException{
		return hotel.CheckOut(hotelname,orderID,room,num, checkoutTime);
	}
	
	/**
	 * 登记入住信息(线下)
	 * @param HotelName String
	 * @param roomType String
	 * @param num Integer
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
	 * @param num Integer
	 * @return
	 * @throws SQLException 
	 */
	public boolean CheckOut(String HotelName,String roomType,int num) throws SQLException{
		return hotel.CheckOut(HotelName,roomType,num);
	}
}
