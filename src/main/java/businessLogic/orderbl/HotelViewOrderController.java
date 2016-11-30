package businessLogic.orderbl;

import java.util.*;

import businessLogicService.orderBLService.HotelViewOrderService;
import data.OrderData;
import dataService.OrderDataService;
import po.OrderPO;
import vo.OrderVO;

public class HotelViewOrderController implements HotelViewOrderService{

	@Override
	public List<OrderVO> FindSpecificOrders(String OrderID) {
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		OrderDataService service = new OrderData();
		return null;
	}

	@Override
	public boolean ShowOrderMessage() {
		// TODO Auto-generated method stub
		return false;
	}

}
