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
	
	WebPromotionDataService wpd = new WebPromotionData();
	
	@Override
	public boolean webPromotionCreate(WebPromotionVO wpv) {
		try {
			ArrayList<WebPromotionPO> promotion = new ArrayList<>();
			promotion = wpd.find();
			
			ArrayList<String> name = new ArrayList<>();
			ArrayList<String> bussinessarea = new ArrayList<>();
			ArrayList<Integer> VIPgrade = new ArrayList<>();
			
			for(int i=0; i<promotion.size(); i++){
				name.add(promotion.get(i).getName());
				bussinessarea.add(promotion.get(i).getSpecificbusinessarea());
				VIPgrade.add(promotion.get(i).getVIPgrade());
			}
			
			WebPromotionPO wpp = new WebPromotionPO();
			wpp.setName(wpv.getName());
			wpp.setBegintime(wpv.getBegintime());
			wpp.setEndtime(wpv.getEndtime());
			wpp.setVIPgrade(wpv.getVIPgrade());
			wpp.setSpecificbusinessarea(wpv.getSpecificbusinessarea());
			wpp.setDiscount(wpv.getDiscount());
			
			for(int i=0; i<name.size(); i++){
				if(wpv.getName().equals(name.get(i)) && wpv.getSpecificbusinessarea().equals(bussinessarea.get(i))
						&& wpv.getVIPgrade()==VIPgrade.get(i)){
					wpd.update(wpp);
					return true;
				}
			}
			wpd.insert(wpp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void webPromotionDelete(WebPromotionVO wpv) {
		String name = wpv.getName();
		wpd.delete(name);
	}

	@Override
	public ArrayList<WebPromotionVO> webPromotionFind() throws SQLException {
		ArrayList<WebPromotionPO> webPromotion = wpd.find();
		ArrayList<WebPromotionVO> list = new ArrayList<WebPromotionVO>();
		for(int i=0;i<webPromotion.size();i++){
			WebPromotionPO po = webPromotion.get(i);
			WebPromotionVO vo = new WebPromotionVO(po.getName(),po.getBegintime(),po.getEndtime(),po.getSpecificbusinessarea(),po.getVIPgrade(),po.getDiscount());
			list.add(vo);
		}
		return list;
	}

}
