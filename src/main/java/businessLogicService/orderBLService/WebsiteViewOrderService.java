package businessLogicService.orderBLService;

import java.util.List;

import po.OrderPO;

public interface WebsiteViewOrderService {
    public boolean addDate(String Date);
	
	public List<OrderPO> ViewException();
	
	public boolean RecoverCredit();
}
