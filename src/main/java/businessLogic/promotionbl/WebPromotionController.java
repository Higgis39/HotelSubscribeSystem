package businessLogic.promotionbl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import businessLogicService.promotionBLService.WebPromotionBLService;
import data.WebPromotionData;
import po.WebPromotionPO;
import vo.WebPromotionVO;
/**
 * 
 * @author Thpffcj
 *
 */
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
	public List<WebPromotionVO> webPromotionFind() throws SQLException {
		List<WebPromotionPO> webPromotion = wpd.find();
		List<WebPromotionVO> list = new ArrayList<WebPromotionVO>();
		for(int i=0;i<webPromotion.size();i++){
			WebPromotionPO po = webPromotion.get(i);
			WebPromotionVO vo = new WebPromotionVO(po.getName(),po.getBegintime(),po.getEndtime(),po.getSpecificbusinessarea(),po.getVIPgrade(),po.getDiscount());
			list.add(vo);
		}
		return list;
	}

	@Override
	public void webPromotionexecute(WebPromotionVO wpv) {
		
	}
}
