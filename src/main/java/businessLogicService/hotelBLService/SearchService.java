package businessLogicService.hotelBLService;

import java.sql.SQLException;
import java.util.ArrayList;

import po.HotelPO;
import vo.HotelVO;

public interface SearchService {
	public ArrayList<HotelVO> Search(String Address, String BusinessArea, String RoomType, double minPrice, double maxPrice, String checkinTime, String checkoutTime, int Star, double minGrade, double maxGrade,boolean hasfixed)throws SQLException;
}
