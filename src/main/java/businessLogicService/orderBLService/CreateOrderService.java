package businessLogicService.orderBLService;

import vo.OrderVO;

public interface CreateOrderService {
    public boolean CheckEnoughCredit(String ID);

	public double getTotal(OrderVO vo);
	
	public boolean addNewOrder(OrderVO vo);
	
	public int CheckRoom(String hotelName,String roomType);
	
	public int CheckMax(String hotelName,String roomType);
}
