package businessLogicService;

import java.sql.SQLException;
import java.util.List;

import po.HotelPromotionPO;
import vo.HotelPromotionVO;

/**
 * PromotionHotelPromotionBLService接口是界面层和业务逻辑层之间的接口。
 * 接口包括策略界面添加，修改，删除促销策略的功能接口，以及策略界面.
 * @author hly
 * @version 1.0
 */
public interface PromotionHotelPromotionBLService {

	public boolean hotelPromotionCreate(HotelPromotionVO hpv);
	
	public boolean hotelPromotionUpdate(HotelPromotionVO hpv);
	
	public void hotelPromotionDelete(HotelPromotionVO hpv);
	
	public List<HotelPromotionPO> hotelPromotionFind(HotelPromotionVO hpv) throws SQLException;
	
	public void hotelPromotionexecute(HotelPromotionVO hpv);
	
}
