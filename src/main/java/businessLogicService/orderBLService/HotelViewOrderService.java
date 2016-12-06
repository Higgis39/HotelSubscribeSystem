package businessLogicService.orderBLService;

import java.util.List;

import po.OrderPO;
import vo.OrderVO;

public interface HotelViewOrderService {
    public List<OrderVO> FindSpecificOrders(String OrderID);
	
	public OrderVO ShowOrderMessage(OrderVO vo);
}
