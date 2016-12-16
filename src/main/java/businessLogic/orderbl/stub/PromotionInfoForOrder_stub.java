package businessLogic.orderbl.stub;

import java.util.List;

import po.OrderPO;
import vo.HotelPromotionVO;
import vo.OrderVO;
import vo.WebPromotionVO;

public class PromotionInfoForOrder_stub implements PromotionInfoForOrder{

	@Override
	public double getAppropriateWebPromotion(OrderVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getApproriateHotelPromotion(OrderVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
  
}
