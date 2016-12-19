package businessLogic.hotelbl;

import java.sql.SQLException;
import java.util.ArrayList;

import businessLogicService.hotelBLService.SearchService;
import vo.HotelVO;

public class SearchController implements SearchService{
	
	Hotel hotel = new Hotel();
	
	/**
	 * 搜索酒店
	 * @param userID
	 * @param hotelName
	 * @param city String
	 * @param businessArea String
	 * @param roomType String
	 * @param price String
	 * @param checkinTime String
	 * @param checkoutTime String
	 * @param star String
	 * @param grade String
	 * @param hasfixed boolean
	 * @return 返回符合搜索条件的酒店列表
	 * @throws SQLException 
	 */
	
	public ArrayList<HotelVO> Search(String userID,String hotelName, String city, String businessArea, String roomType, String price, String checkinTime, String checkoutTime, int star, String grade,boolean hasfixed) throws SQLException{
		return hotel.Search(userID,hotelName, city, businessArea, roomType, price, checkinTime, checkoutTime, star, grade,hasfixed);
	}
}
