package businessLogic.promotionbl;

import java.sql.SQLException;
import java.util.List;

import businessLogicService.PromotionHotelPromotionBLService;
import data.HotelPromotionData;
import dataService.HotelPromotionDataService;
import po.HotelPromotionPO;
import vo.HotelPromotionVO;

/**
 * HotelPromotionController
 * 
 * @author Thpffcj
 *
 */
public class HotelPromotionController implements PromotionHotelPromotionBLService{

	HotelPromotionData hpd = new HotelPromotionData();
	
	@Override
	public boolean hotelPromotionCreate(HotelPromotionVO hpv) {
		HotelPromotionPO hpp = new HotelPromotionPO();
		hpp.setName(hpv.getName());
		hpp.setIntroduction(hpv.getIntroduction());
		hpp.setIsbirthday(hpv.isIsbirthday());
		hpp.setNumberofroom(hpv.getNumberofroom());
		hpp.setIspartner(hpv.isIspartner());
		hpp.setBegintime(hpv.getBegintime());
		hpp.setEndtime(hpv.getEndtime());
		hpd.insert(hpp);
		return true;
	}

	@Override
	public boolean hotelPromotionUpdate(HotelPromotionVO hpv) {
		HotelPromotionPO hpp = new HotelPromotionPO();
		hpp.setName(hpv.getName());
		hpp.setIntroduction(hpv.getIntroduction());
		hpp.setIsbirthday(hpv.isIsbirthday());
		hpp.setNumberofroom(hpv.getNumberofroom());
		hpp.setIspartner(hpv.isIspartner());
		hpp.setBegintime(hpv.getBegintime());
		hpp.setEndtime(hpv.getEndtime());
		hpd.update(hpp);
		return true;
	}

	@Override
	public void hotelPromotionDelete(HotelPromotionVO hpv) {
		String name = hpv.getName();
		hpd.delete(name);
	}

	@Override
	public List<HotelPromotionPO> hotelPromotionFind(HotelPromotionVO hpv) throws SQLException {
		String name = hpv.getName();
		List<HotelPromotionPO> hotelPromotion = hpd.find(name);
		return hotelPromotion;
	}

	@Override
	public void hotelPromotionexecute(HotelPromotionVO hpv) {
		// TODO Auto-generated method stub
		
	}
	

}