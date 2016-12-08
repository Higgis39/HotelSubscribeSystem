package businessLogic.hotelbl;

import businessLogicService.hotelBLService.ViewService;
import vo.HotelVO;

public class ViewController implements ViewService{
	
	Hotel hotel = new Hotel();
	
	/**
	 * 浏览酒店(Controller)
	 * @param hotelName String
	 * @return 返回酒店的详细信息
	 */
	public HotelVO View(String hotelName){
		return hotel.View(hotelName);
	}
}
