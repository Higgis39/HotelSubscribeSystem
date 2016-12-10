package businessLogic.orderbl;

import businessLogic.orderbl.stub.HotelInfoForOrder;
import businessLogic.orderbl.stub.HotelInfoForOrder_stub;
import businessLogicService.orderBLService.CommentOrderService;
import vo.OrderVO;

public class CommentOrderCotroller implements CommentOrderService{
	/**
	 * 客户评价订单
	 * @return 成功返回true，否则返回false
	 */
	@Override
	public boolean addComment(OrderVO vo,int point) {
		HotelInfoForOrder service = new HotelInfoForOrder_stub();
		return new Order(vo).Comment()&&service.updatePoint(vo.getHotelId(),point);
		
	}

	
}
