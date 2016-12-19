package businessLogic.orderbl;

import java.sql.SQLException;
import java.util.List;

import businessLogicService.orderBLService.CustomerViewOrderService;
import vo.OrderVO;

public class CustomerViewOrderController implements CustomerViewOrderService{
	public List<OrderVO> FindSpecificOrderlist(String userID) throws SQLException {
		return new Order().getOrderByUserID(userID);
	}

	public OrderVO ShowOrderMessage(String OrderID) {
		return new Order().gerOrderByOrderID(OrderID);
	}

	public List<OrderVO> getAllUserOrders(String userID) throws SQLException {
		return new Order().getOrderByUserID(userID);
	}

	public List<OrderVO> getSpecificOrders(String userID, String Status) throws SQLException {
		return new Order().filterOrderByStatus(new Order().getOrderByUserID(userID), Status);
	}
}
