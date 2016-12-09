package businessLogicService.orderBLService;

import java.sql.SQLException;
import java.util.List;

import po.OrderPO;
import vo.OrderVO;

public interface HotelViewOrderService {
    public List<OrderVO> FindSpecificOrders(String OrderID)throws SQLException;
	
	public OrderVO ShowOrderMessage(OrderVO vo);
}
