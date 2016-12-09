package businessLogic.promotionbl;

import java.sql.SQLException;
import java.util.List;

import businessLogicService.promotionBLService.WebPromotionBLService;
import data.WebPromotionData;
import po.WebPromotionPO;
import vo.WebPromotionVO;

public class WebPromotionController implements WebPromotionBLService {

	WebPromotionData wpd = new WebPromotionData();
	
	@Override
	public boolean webPromotionCreate(WebPromotionVO wpv) {
		WebPromotionPO wpp = new WebPromotionPO();
		wpp.setName(wpv.getName());
		wpp.setBegintime(wpv.getBegintime());
		wpp.setEndtime(wpv.getEndtime());
		wpp.setSpecificbusinessarea(wpv.getSpecificbusinessarea());
		wpd.insert(wpp);
		return true;
	}

	@Override
	public boolean webPromotionUpdate(WebPromotionVO wpv) {
		WebPromotionPO wpp = new WebPromotionPO();
		wpp.setBegintime(wpv.getBegintime());
		wpp.setEndtime(wpv.getEndtime());
		wpp.setSpecificbusinessarea(wpv.getSpecificbusinessarea());
		wpd.update(wpp);
		return true;
	}

	@Override
	public void webPromotionDelete(WebPromotionVO wpv) {
		String name = wpv.getName();
		wpd.delete(name);
	}

	@Override
	public List<WebPromotionPO> webPromotionFind(WebPromotionVO wpv) throws SQLException {
		String name = wpv.getName();
		List<WebPromotionPO> webPromotion = wpd.find(name);
		return webPromotion;
	}

	@Override
	public void webPromotionexecute(WebPromotionVO wpv) {
		
	}
}
