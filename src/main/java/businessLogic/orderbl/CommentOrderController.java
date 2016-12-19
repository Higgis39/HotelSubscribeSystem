package businessLogic.orderbl;

import businessLogic.hotelbl.HotelToolForOrder;
import businessLogic.orderbl.HotelInfoForOrder;
import businessLogicService.orderBLService.CommentOrderService;
import vo.OrderVO;

public class CommentOrderController implements CommentOrderService{
	/**
	 * 客户评价订单
	 * @return 成功返回true，否则返回false
	 */
	public boolean addComment(OrderVO vo,int point) {
		HotelInfoForOrder service = new HotelToolForOrder();
		return new Order(vo).Comment()&&service.updatePoint(vo.getHotelId(),point);
		
	}

	
}
