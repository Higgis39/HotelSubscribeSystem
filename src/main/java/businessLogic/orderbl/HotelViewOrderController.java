package businessLogic.orderbl;

import java.util.*;

import businessLogicService.orderBLService.HotelViewOrderService;
import data.OrderData;
import dataService.OrderDataService;
import po.OrderPO;
import vo.OrderVO;

public class HotelViewOrderController implements HotelViewOrderService{

	@Override
	public List<OrderVO> FindSpecificOrders(String HotelID) {
		return new Order().getOrderByHotelID(HotelID);
	}

	@Override
	public OrderVO ShowOrderMessage(OrderVO vo) {
		return new Order(vo).gerOrderByOrderID();
	}

}
