package businessLogic.promotionbl;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import businessLogicService.PromotionWebPromotionBLService;
import data.WebPromotionData;
import po.WebPromotionPO;
import vo.WebPromotionVO;

public class WebPromotionController implements PromotionWebPromotionBLService {

	WebPromotionData wpd = new WebPromotionData();
	
	@Override
	public boolean webPromotionCreate(WebPromotionVO wpv) {
		WebPromotionPO wpp = new WebPromotionPO();
		wpp.setName(wpv.getName());
		wpp.setIntroduction(wpv.getIntroduction());
		wpp.setBegintime(wpv.getBegintime());
		wpp.setEndtime(wpv.getEndtime());
		wpp.setSpecificbusinessarea(wpv.getSpecificbusinessarea());
		wpd.insert(wpp);
		return true;
	}

	@Override
	public boolean webPromotionUpdate(WebPromotionVO wpv) {
		WebPromotionPO wpp = new WebPromotionPO();
		wpp.setName(wpv.getName());
		wpp.setIntroduction(wpv.getIntroduction());
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
		// TODO Auto-generated method stub
		
	}
}