package businessLogicService;

import businessLogic.promotionbl.PromotionMessage;
import vo.HotelVO;
import vo.UserVO;

/**
 * promotionblService接口是界面层和业务逻辑层之间的接口。
 * 接口包括策略界面添加，修改，删除促销策略的功能接口，以及策略界面.
 * @author hly
 * @version 1.0
 */
public interface PromotionHotelpromotionBLService {

	public PromotionMessage hotelCreate(String name, String introduction, double d);
	public PromotionMessage hotelUpdate(String name, String introduction, double d);
	public void hotelDelete();
	public void hotelexecute();
}
