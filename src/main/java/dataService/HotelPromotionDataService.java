package dataService;

import java.sql.SQLException;
import java.util.List;

import po.HotelPromotionPO;

public interface HotelPromotionDataService {

	public boolean insert(HotelPromotionPO hp);
	public boolean update(HotelPromotionPO hp);
	public void delete(String name);
	public HotelPromotionPO findByHotelNameAndName(String hotelName, String name);
	public List<HotelPromotionPO> findByHotelname(String hotelname) throws SQLException;
	
}
