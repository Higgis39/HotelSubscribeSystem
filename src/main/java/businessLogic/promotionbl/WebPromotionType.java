package businessLogic.promotionbl;
/**
 * WebPromotionType是策略接口，不同策略不同实现该接口
 * @author hly
 */
public interface WebPromotionType {

	public double calculateDiscount(String hotelId);
}
