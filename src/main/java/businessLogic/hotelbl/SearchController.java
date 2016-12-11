package businessLogic.hotelbl;

import java.sql.SQLException;
import java.util.ArrayList;

import businessLogicService.hotelBLService.SearchService;
import po.HotelPO;
import vo.HotelVO;

public class SearchController implements SearchService{
	
	Hotel hotel = new Hotel();
	
	/**
	 * 搜索酒店(Controller)
	 * @param Address String
	 * @param BusinessArea String
	 * @param RoomType String
	 * @param minPrice double
	 * @param maxPrice double
	 * @param checkinTime String
	 * @param checkoutTime String
	 * @param Star String
	 * @param minGrade double
	 * @param maxGrade double
	 * @return 返回符合搜索条件的酒店列表
	 */
	
	public ArrayList<HotelVO> Search(String Address, String BusinessArea, String RoomType, double minPrice, double maxPrice, String checkinTime, String checkoutTime, int Star, double minGrade, double maxGrade,boolean hasfixed)throws SQLException{
		return hotel.Search(Address, BusinessArea, RoomType, minPrice, maxPrice, checkinTime, checkoutTime, Star, minGrade, maxGrade,hasfixed);
	}
}
