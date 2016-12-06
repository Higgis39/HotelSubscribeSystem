package businessLogic.orderbl;

import java.util.List;

import businessLogicService.orderBLService.CustomerViewOrderService;
import vo.OrderVO;

public class CustomerViewOrderController implements CustomerViewOrderService{
	public List<OrderVO> FindSpecificOrderlist(String userID) {
		return new Order().getOrderByUserID(userID);
	}

	public OrderVO ShowOrderMessage(OrderVO vo) {
		return new Order(vo).gerOrderByOrderID();
	}
}
