package businessLogicService.orderBLService;

import java.sql.SQLException;
import java.util.List;

import vo.OrderVO;

public interface CustomerViewOrderService {
    public List<OrderVO> getAllUserOrders(String userID)throws SQLException;
    
    public List<OrderVO> getSpecificOrders(String userID,String Status)throws SQLException;
	
	public OrderVO ShowOrderMessage(String OrderID);
}
