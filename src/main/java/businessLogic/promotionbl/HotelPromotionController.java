package businessLogic.promotionbl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import businessLogicService.promotionBLService.HotelPromotionBLService;
import data.HotelPromotionData;
import dataService.HotelPromotionDataService;
import po.HotelPromotionPO;
import po.WebPromotionPO;
import vo.HotelPromotionVO;

/**
 * HotelPromotionController
 * 
 * @author Thpffcj
 *
 */
public class HotelPromotionController implements HotelPromotionBLService{

	Promotion promption = new Promotion();
	
	/**
	 * 新增或修改酒店促销策略
	 */
	public boolean hotelPromotionCreate(HotelPromotionVO hpv) {
		return promption.hotelPromotionCreate(hpv);
	}

	/**
	 * 删除酒店促销策略
	 */
	public void hotelPromotionDelete(HotelPromotionVO hpv) {
		promption.hotelPromotionDelete(hpv);
	}

	/**
	 * 通过酒店名搜索酒店促销策略
	 */
	public List<HotelPromotionVO> hotelPromotionFind(String hotelname) throws SQLException {
		return promption.hotelPromotionFind(hotelname);
	}

}