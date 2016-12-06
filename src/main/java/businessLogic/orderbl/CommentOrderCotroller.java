package businessLogic.orderbl;

import java.util.List;

import businessLogicService.orderBLService.CommentOrderService;
import vo.OrderVO;

public class CommentOrderCotroller implements CommentOrderService{
	/**
	 * 客户评价订单
	 * @return 成功返回true，否则返回false
	 */
	@Override
	public boolean addComment(OrderVO vo) {
		return new Order(vo).Comment();
	}

	
}
