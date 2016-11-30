package businessLogic.orderbl;

import businessLogicService.orderBLService.CreateOrderService;
import vo.OrderVO;

public class CreateOrderController implements CreateOrderService{
	public boolean CheckEnoughCredit(String ID) {
		return new CreditManager().checkCredit(ID);
	}

//	public boolean addOrderInfo(orderVO vo) {
//		return false;
//	}

	public int CheckRoom(String hotelID,int roomType){
		return 0;
	}
	 
	public double getTotal(OrderVO vo) {
		return new OrderInfo(vo).getTotal();
	}

	public boolean addNewOrder(OrderVO vo) {
		return new OrderInfo(vo).addNewOrder();
	}
	
}
