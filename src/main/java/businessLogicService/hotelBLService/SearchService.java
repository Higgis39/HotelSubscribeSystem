package businessLogicService.hotelBLService;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

import po.HotelPO;

public interface SearchService {
	public ArrayList<HotelPO> Search(String Address, String BusinessArea, String RoomType, double minPrice, double maxPrice, String checkinTime, String checkoutTime, int Star, double minGrade, double maxGrade);
}
