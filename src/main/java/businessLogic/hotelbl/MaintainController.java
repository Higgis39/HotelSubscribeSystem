package businessLogic.hotelbl;

import businessLogicService.hotelBLService.MaintainService;
/*
 * 
 * @author 梁先伟
 * 
 */
public class MaintainController implements MaintainService{
	
	Hotel hotel = new Hotel();
	
	/**
	 * 维护酒店信息
	 * @param hotelName String
	 * @param phoneNumber String
	 * @param Introduction String
	 * @param Facilities String
	 * @param Star Integer
	 * @param Grade double
	 * @param Worker ArrayList<String>
	 * @return 返回修改后的酒店详细信息
	 */
	
	public boolean Maintain(String hotelName,String businessarea,String address, String phoneNumber, String Introduction, String Facilities, int Star){
		return hotel.UpdateHotelMessage(hotelName,businessarea,address, phoneNumber, Introduction, Facilities, Star);
	}
}
