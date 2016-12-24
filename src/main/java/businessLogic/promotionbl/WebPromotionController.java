package businessLogic.promotionbl;

import java.sql.SQLException;
import java.util.ArrayList;

import businessLogicService.promotionBLService.WebPromotionBLService;
import data.WebPromotionData;
import dataService.WebPromotionDataService;
import po.WebPromotionPO;
import vo.WebPromotionVO;
/**
 * 
 * @author Thpffcj
 *
 */
public class WebPromotionController implements WebPromotionBLService {
	Promotion promotion = new Promotion();
	
	public boolean webPromotionCreate(WebPromotionVO wpv) {
		return promotion.webPromotionCreate(wpv);
	}

	public void webPromotionDelete(WebPromotionVO wpv) {
		promotion.webPromotionDelete(wpv);
	}

	public ArrayList<WebPromotionVO> webPromotionFind() throws SQLException {
		return promotion.webPromotionFind();
	}

}
