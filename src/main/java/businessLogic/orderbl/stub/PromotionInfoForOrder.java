package businessLogic.orderbl.stub;

import java.util.List;

import po.OrderPO;
import vo.HotelPromotionVO;
import vo.OrderVO;
import vo.WebPromotionVO;

public interface PromotionInfoForOrder {

	public WebPromotionVO getAppropriateWebPromotion(OrderVO vo);
	
	public HotelPromotionVO getApproriateHotelPromotion(OrderVO vo);
}
