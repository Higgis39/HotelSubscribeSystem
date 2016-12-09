package businessLogic.orderbl;

import java.sql.SQLException;
import java.util.List;

import businessLogicService.orderBLService.CustomerViewOrderService;
import vo.OrderVO;

public class CustomerViewOrderController implements CustomerViewOrderService{
	public List<OrderVO> FindSpecificOrderlist(String userID) throws SQLException {
		return new Order().getOrderByUserID(userID);
	}

	public OrderVO ShowOrderMessage(OrderVO vo) {
		return new Order(vo).gerOrderByOrderID();
	}
}
