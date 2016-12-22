package businessLogic.orderbl;

import businessLogicService.orderBLService.CommentOrderService;
import vo.OrderVO;

public class CommentOrderController implements CommentOrderService{
	/**
	 * 客户评价订单
	 * @return 成功返回true，否则返回false
	 */
	public boolean addComment(OrderVO vo,int grade) {
		return new Order(vo).Comment(grade);
		
	}

	
}
