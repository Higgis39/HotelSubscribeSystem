package businessLogicService.orderBLService;

import java.util.List;

import vo.OrderVO;

public interface WebsiteViewOrderService {
	
	public List<OrderVO> ViewException(String Date);
	
	public boolean RecoverCredit(String OrderID);
}
