package dataService;

import java.sql.SQLException;
import java.util.List;

import po.HotelPromotionPO;

public interface HotelPromotionDataService {

	public boolean insert(HotelPromotionPO hp);
	public boolean update(HotelPromotionPO hp);
	public void delete(String name);
	public List<HotelPromotionPO> find(String name) throws SQLException;
}
