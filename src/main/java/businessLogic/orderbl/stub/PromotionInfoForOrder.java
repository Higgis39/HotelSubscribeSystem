package businessLogic.orderbl.stub;

import vo.HotelPromotionVO;
import vo.OrderVO;
import vo.WebPromotionVO;

public interface PromotionInfoForOrder {
    /**
     * 获得最低折扣的网站营销策略
     * @param vo
     * @return
     */
	public double getAppropriateWebPromotion(OrderVO vo);
	/**
	 * 获得最低折扣的酒店营销策略
	 * @param vo
	 * @return
	 */
	public double getApproriateHotelPromotion(OrderVO vo);
}
