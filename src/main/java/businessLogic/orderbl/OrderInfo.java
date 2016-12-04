package businessLogic.orderbl;

import po.OrderPO;
//import po.PromotionPO;
import vo.OrderVO;

public class OrderInfo {
	OrderPO po;
	public OrderInfo(OrderVO vo){
		super();
		po=new OrderPO(vo.getorderId(),vo.getHotelId(),vo.getUserId(),vo.getStatus(),
				vo.getEntryTime(),vo.getLastTime(),vo.getOrderInfo(),vo.getPrice());
	}

	public double getTotal(){
		return 0.0;
	}
	
//	private PromotionPO findBestPromotion(){
//		return new PromotionPO();
//	}
	
	public boolean addNewOrder(){
		return false;
	}
}
