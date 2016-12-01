package businessLogic.promotionbl;

public class PromotionMessage {
	public String promotionname;
	public String introduction;
	public double discount;
	
	public PromotionMessage() {
		// TODO Auto-generated constructor stub
	}
	
	public PromotionMessage(String promotionname, String introduction, double discount) {
		this.promotionname = promotionname;
		this.introduction = introduction;
		this.discount = discount;
	}
}
