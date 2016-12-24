package businessLogic.promotionbl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import businessLogicService.promotionBLService.HotelPromotionBLService;
import businessLogicService.promotionBLService.WebPromotionBLService;
import data.HotelPromotionData;
import data.WebPromotionData;
import dataService.HotelPromotionDataService;
import dataService.WebPromotionDataService;
import po.HotelPromotionPO;
import po.WebPromotionPO;
import vo.HotelPromotionVO;
import vo.WebPromotionVO;

public class Promotion implements HotelPromotionBLService, WebPromotionBLService{

	HotelPromotionDataService hpd = new HotelPromotionData();
	WebPromotionDataService wpd = new WebPromotionData();
	
	@Override
	public boolean hotelPromotionCreate(HotelPromotionVO hpv) {
		try {
			ArrayList<HotelPromotionPO> promotion = new ArrayList<>();
			promotion = hpd.findByHotelname(hpv.getHotelName());
			
			ArrayList<String> name = new ArrayList<>();
			for(int i=0; i<promotion.size(); i++){
				name.add(promotion.get(i).getName());
			}
			
			HotelPromotionPO hpp = new HotelPromotionPO();
			hpp.setHotelname(hpv.getHotelName());
			hpp.setName(hpv.getName());
			hpp.setIsbirthday(hpv.getisIsbirthday());
			hpp.setNumberofroom(hpv.getNumberofroom());
			hpp.setIspartner(hpv.getisIspartner());
			hpp.setBegintime(hpv.getBegintime());
			hpp.setEndtime(hpv.getEndtime());
			hpp.setDiscount(hpv.getDiscount());
			
			for(int i=0; i<name.size(); i++){
				if(hpv.getName().equals(name.get(i))){
					hpd.update(hpp);
					return true;
				}
			}
			hpd.insert(hpp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void hotelPromotionDelete(HotelPromotionVO hpv) {
		String name = hpv.getName();
		hpd.delete(name);
	}

	@Override
	public List<HotelPromotionVO> hotelPromotionFind(String hotelname) throws SQLException {
		List<HotelPromotionPO> hotelPromotion = hpd.findByHotelname(hotelname);
		List<HotelPromotionVO> list = new ArrayList<HotelPromotionVO>();
		for(int i=0;i<hotelPromotion.size();i++){
			HotelPromotionPO po = hotelPromotion.get(i);
			HotelPromotionVO vo = new HotelPromotionVO(po.getHotelname(),po.getName(),po.isIsbirthday(),po.getNumberofroom(),po.isIspartner(),po.getBegintime(),po.getEndtime(),po.getDiscount());
			list.add(vo);
		}
		return list;
	}
	
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
