package businessLogic.hotelbl;

import java.util.ArrayList;

import po.HotelPO;

public class SearchController {
	
	Hotel hotel = new Hotel();
	
	/**
	 * 搜索酒店(Controller)
	 * @param Address String
	 * @param BusinessArea String
	 * @param Star int
	 * @param Grade double
	 * @return 返回符合搜索条件的酒店列表
	 */
	
	public ArrayList<HotelPO> Search(String Address, String BusinessArea, int Star, double Grade){
		return hotel.Search(Address, BusinessArea, Star, Grade);
	}
}
