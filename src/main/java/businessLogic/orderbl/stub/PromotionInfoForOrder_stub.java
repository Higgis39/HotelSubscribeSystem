package businessLogic.orderbl.stub;

import java.util.List;

import po.OrderPO;
import po.PromotionPO;
import vo.HotelPromotionVO;
import vo.OrderVO;
import vo.PromotionVO;
import vo.WebPromotionVO;

public class PromotionInfoForOrder_stub implements PromotionInfoForOrder{


	@Override
	public WebPromotionVO getAppropriateWebPromotion(OrderVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelPromotionVO getApproriateHotelPromotion(OrderVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
  
}
