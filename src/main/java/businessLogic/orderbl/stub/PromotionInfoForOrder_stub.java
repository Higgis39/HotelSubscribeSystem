package businessLogic.orderbl.stub;

import java.util.List;

import po.OrderPO;
import vo.HotelPromotionVO;
import vo.OrderVO;
import vo.WebPromotionVO;

public class PromotionInfoForOrder_stub implements PromotionInfoForOrder{

	@Override
	public double getAppropriateWebPromotion(String OrderID, String UserID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getApproriateHotelPromotion(String OrderID, String UserID, String HotelID) {
		// TODO Auto-generated method stub
		return 0;
	}
  
}
