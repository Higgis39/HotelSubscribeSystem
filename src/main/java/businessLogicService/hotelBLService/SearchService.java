package businessLogicService.hotelBLService;

import java.sql.SQLException;
import java.util.ArrayList;

import po.HotelPO;

public interface SearchService {
	public ArrayList<HotelPO> Search(String Address, String BusinessArea, String RoomType, double minPrice, double maxPrice, String checkinTime, String checkoutTime, int Star, double minGrade, double maxGrade)throws SQLException;
}
