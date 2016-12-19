package businessLogic.promotionbl;

import java.sql.SQLException;
import java.util.ArrayList;

import businessLogic.orderbl.PromotionInfoForOrder;
import vo.OrderVO;


/**
 * 为订单选择折扣最多的促销策略
 * @author Thpffcj
 *
 */
public class PromotionToolForOrder implements PromotionInfoForOrder{
	
	/**
	 * 选择折扣最多的酒店促销策略
	 */
	public double getApproriateHotelPromotion(OrderVO vo) {
		
		String userID = vo.getUserId();
		String hotelID = vo.getHotelId();
		String entryTime= vo.getEntryTime();
		
		//计算生日促销策略折扣
		BirthdayPromotion bp = new BirthdayPromotion();
		double a = bp.calculateDiscount(userID, hotelID, entryTime);
		System.out.println(a);
		
		//计算三件以上策略折扣
		ThreemorePromotion tp = new ThreemorePromotion();
		double b = tp.calculateDiscount(userID, hotelID, entryTime);
		
		//计算合作伙伴策略折扣
		PartnerPromotion pp = new PartnerPromotion();
		double c = pp.calculateDiscount(userID, hotelID, entryTime);
		
		//计算特定时间促销策略折扣
		HotelSpecificTimePromotion hstp = new HotelSpecificTimePromotion();
		double d = hstp.calculateDiscount(userID, hotelID, entryTime);
		
		ArrayList<Double> discount = new ArrayList<>();
		discount.add(a);
		discount.add(b);
		discount.add(c);
		discount.add(d);
		
		//选出折扣最多的促销策略
		for(int i=0; i<discount.size(); i++){
			for(int j=i; j<discount.size(); j++){
				if(discount.get(j)<discount.get(i)){
					double temp = discount.get(i);
					discount.set(i, discount.get(j));
					discount.set(j, temp);
				}
			}
		}
		double minDiscount = discount.get(0);
		
		return minDiscount;
	}

	/**
	 * 选择折扣最多的酒店促销策略
	 */
	public double getAppropriateWebPromotion(OrderVO vo) {
		
		String hotelID = vo.getHotelId();
		System.out.println(hotelID);
		
		//网站特定时间促销策略
		WebSpecificTimePromotion wstp = new WebSpecificTimePromotion();
		double a = wstp.calculateDiscount(hotelID);
		
		//特定商圈专属折扣
		BusinessDistrictPromotion bdp = new BusinessDistrictPromotion();
		double b = bdp.calculateDiscount(hotelID);
		
		ArrayList<Double> discount = new ArrayList<>();
		discount.add(a);
		discount.add(b);
		
		//选出折扣最多的促销策略
		for(int i=0; i<discount.size(); i++){
			for(int j=i; j<discount.size(); j++){
				if(discount.get(j)<discount.get(i)){
					double temp = discount.get(i);
					discount.set(i, discount.get(j));
					discount.set(j, temp);
				}
			}
		}
		double minDiscount = discount.get(0);
		
		return minDiscount;
	}
}

////从数据库找出该折扣的对应第一个策略
//		WebPromotionData wpd = new WebPromotionData();
//		
//		ArrayList<WebPromotionPO> webPromotions = new ArrayList<>();
//		try {
//			webPromotions = wpd.findByDiscount(minDiscount);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		WebPromotionPO executeWebPromotion = webPromotions.get(0);
//		
//		//将策略信息传递给HotelPromotionVO
//		WebPromotionVO viewWebPromotion = new WebPromotionVO(executeWebPromotion.getName(), 
//				executeWebPromotion.getBegintime(), executeWebPromotion.getEndtime(), 
//				executeWebPromotion.getSpecificbusinessarea(), executeWebPromotion.getDiscount());
//		}
