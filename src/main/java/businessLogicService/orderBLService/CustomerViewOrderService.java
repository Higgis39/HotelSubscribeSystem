package businessLogicService.orderBLService;

import java.sql.SQLException;
import java.util.List;

import vo.OrderVO;

public interface CustomerViewOrderService {
    public List<OrderVO> FindSpecificOrderlist(String userID)throws SQLException;
	
	public OrderVO ShowOrderMessage(OrderVO vo);
}
