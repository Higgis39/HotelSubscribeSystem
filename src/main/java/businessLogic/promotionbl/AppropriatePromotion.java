package businessLogic.promotionbl;

import java.sql.SQLException;
import java.util.ArrayList;

import businessLogic.orderbl.stub.PromotionInfoForOrder;
import data.HotelPromotionData;
import data.WebPromotionData;
import po.HotelPromotionPO;
import po.WebPromotionPO;
import vo.HotelPromotionVO;
import vo.OrderVO;
import vo.WebPromotionVO;

/**
 * 为订单选择折扣最多的促销策略
 * @author Thpffcj
 *
 */
public class AppropriatePromotion implements PromotionInfoForOrder{
	
	/**
	 * 选择折扣最多的酒店促销策略
	 */
	public HotelPromotionVO getApproriateHotelPromotion(OrderVO vo) {
		
		String hotelID = vo.getHotelId();
		String userID = vo.getUserId();
		String entryTime= vo.getEntryTime();
		
		//计算生日促销策略折扣
		BirthdayPromotion bp = new BirthdayPromotion();
		double a = bp.calculateDiscount(hotelID, userID, entryTime);
		
		//计算三件以上策略折扣
		ThreemorePromotion tp = new ThreemorePromotion();
		double b = tp.calculateDiscount(hotelID, userID, entryTime);
		
		
		//计算合作伙伴策略折扣
		PartnerPromotion pp = new PartnerPromotion();
		double c = pp.calculateDiscount(hotelID, userID, entryTime);
		
		//计算特定时间促销策略折扣
		HotelSpecificTimePromotion hstp = new HotelSpecificTimePromotion();
		double d = hstp.calculateDiscount(hotelID, userID, entryTime);
		
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
		
		//从数据库找出该折扣的对应第一个策略
		HotelPromotionData hpd = new HotelPromotionData();
		
		ArrayList<HotelPromotionPO> hotelPromotions = new ArrayList<>();
		try {
			hotelPromotions = hpd.findByDiscount(minDiscount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HotelPromotionPO executeHotelPromotion = hotelPromotions.get(0);
		
		//将策略信息传递给HotelPromotionVO
		HotelPromotionVO viewHotelPromotion = new HotelPromotionVO
				(executeHotelPromotion.getHotelname(), executeHotelPromotion.getName(), 
						executeHotelPromotion.isIsbirthday(), executeHotelPromotion.getNumberofroom(), 
						executeHotelPromotion.isIspartner(), executeHotelPromotion.getBegintime(), 
						executeHotelPromotion.getEndtime(), executeHotelPromotion.getDiscount());
		
		return viewHotelPromotion;
	}

	/**
	 * 选择折扣最多的酒店促销策略
	 */
	public WebPromotionVO getAppropriateWebPromotion(OrderVO vo) {
		
		//网站特定时间促销策略
		WebSpecificTimePromotion wstp = new WebSpecificTimePromotion();
		double a = wstp.calculateDiscount();
		
		//特定商圈专属折扣
		BusinessDistrictPromotion bdp = new BusinessDistrictPromotion();
		double b = bdp.calculateDiscount();
		
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
		
		//从数据库找出该折扣的对应第一个策略
		WebPromotionData wpd = new WebPromotionData();
		
		ArrayList<WebPromotionPO> webPromotions = new ArrayList<>();
		try {
			webPromotions = wpd.findByDiscount(minDiscount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		WebPromotionPO executeWebPromotion = webPromotions.get(0);
		
		//将策略信息传递给HotelPromotionVO
		WebPromotionVO viewWebPromotion = new WebPromotionVO(executeWebPromotion.getName(), 
				executeWebPromotion.getBegintime(), executeWebPromotion.getEndtime(), 
				executeWebPromotion.getSpecificbusinessarea(), executeWebPromotion.getDiscount());
		
		return viewWebPromotion;
	}
}
