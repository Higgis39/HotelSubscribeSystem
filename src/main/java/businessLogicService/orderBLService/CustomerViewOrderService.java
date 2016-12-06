package businessLogicService.orderBLService;

import java.util.List;

import vo.OrderVO;

public interface CustomerViewOrderService {
    public List<OrderVO> FindSpecificOrderlist(String userID);
	
	public OrderVO ShowOrderMessage(OrderVO vo);
}
