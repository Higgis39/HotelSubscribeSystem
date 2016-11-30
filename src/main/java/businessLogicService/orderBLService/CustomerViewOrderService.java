package businessLogicService.orderBLService;

import java.util.List;

import po.OrderPO;

public interface CustomerViewOrderService {
    public List<OrderPO> FindSpecificOrderlist(String State);
	
	public OrderPO ShowOrderMessage(String OrderID);
}
