package businessLogicService.hotelBLService;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.TableStringConverter;

import vo.HotelVO;

public interface SearchService {
	public ArrayList<HotelVO> Search(String userID, String hotelName,String city, String businessArea, String roomType, String price, String checkinTime, String checkoutTime, int star, String grade,boolean hasfixed) throws SQLException;
}
