package businessLogic.orderbl;

import businessLogicService.orderBLService.CancelOrderService;
import vo.OrderVO;

public class CancelOrderController implements CancelOrderService {
	/**
	 * 用户撤销订单
	 * @return 撤销成功返回true，否则返回false
	 */
	public boolean Cancel(OrderVO vo) {
		return new Order(vo).Cancel();
	}
}
