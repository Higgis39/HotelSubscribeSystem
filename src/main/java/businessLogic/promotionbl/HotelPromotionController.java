package businessLogic.promotionbl;

import java.sql.SQLException;
import java.util.List;

import businessLogicService.promotionBLService.HotelPromotionBLService;
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
public class HotelPromotionController implements HotelPromotionBLService{

	HotelPromotionData hpd = new HotelPromotionData();
	
	@Override
	public boolean hotelPromotionCreate(HotelPromotionVO hpv) {
		HotelPromotionPO hpp = new HotelPromotionPO();
		hpp.setHotelname(hpv.getHotelName());
		hpp.setName(hpv.getName());
		hpp.setIsbirthday(hpv.getisIsbirthday());
		hpp.setNumberofroom(hpv.getNumberofroom());
		hpp.setIspartner(hpv.getisIspartner());
		hpp.setBegintime(hpv.getBegintime());
		hpp.setEndtime(hpv.getEndtime());
		hpd.insert(hpp);
		return true;
	}

	@Override
	public boolean hotelPromotionUpdate(HotelPromotionVO hpv) {
		HotelPromotionPO hpp = new HotelPromotionPO();
		hpp.setHotelname(hpv.getHotelName());
		hpp.setName(hpv.getName());
		hpp.setIsbirthday(hpv.getisIsbirthday());
		hpp.setNumberofroom(hpv.getNumberofroom());
		hpp.setIspartner(hpv.getisIspartner());
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
		String hotelname = hpv.getHotelName();
		List<HotelPromotionPO> hotelPromotion = hpd.findByHotelname(hotelname);
		return hotelPromotion;
	}

	@Override
	public void hotelPromotionexecute(HotelPromotionVO hpv) {
		// TODO Auto-generated method stub
		
	}
	

}