package businessLogicService.orderBLService;

import vo.OrderVO;

public interface CreateOrderService {
    public boolean CheckEnoughCredit(String ID);
	
//	public boolean addOrderInfo(orderVO vo);

	public double getTotal(OrderVO vo);
	
	public boolean addNewOrder(OrderVO vo);
}
