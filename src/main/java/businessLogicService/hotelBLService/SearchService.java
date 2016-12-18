package businessLogicService.hotelBLService;

import java.sql.SQLException;
import java.util.ArrayList;
import vo.HotelVO;

public interface SearchService {
	public ArrayList<HotelVO> Search(String hotelName,String Address, String BusinessArea, String RoomType, String price, String checkinTime, String checkoutTime, int Star, String grade,boolean hasfixed) throws SQLException;
}
