package businessLogic.orderbl.stub;

import java.util.List;

import po.OrderPO;
import po.PromotionPO;
import vo.OrderVO;
import vo.PromotionVO;

public interface PromotionInfoForOrder {

	public PromotionVO getAppropriatePromotion(OrderVO vo);
}
