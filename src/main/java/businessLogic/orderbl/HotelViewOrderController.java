package businessLogic.orderbl;

import java.sql.SQLException;
import java.util.*;

import businessLogicService.orderBLService.HotelViewOrderService;
import data.OrderData;
import dataService.OrderDataService;
import po.OrderPO;
import vo.OrderVO;

public class HotelViewOrderController implements HotelViewOrderService{

	@Override
	public OrderVO ShowOrderMessage(OrderVO vo) {
		return new Order(vo).gerOrderByOrderID();
	}

	@Override
	public List<OrderVO> getAllHotelOrders(String HotelID) throws SQLException {
		return new Order().getOrderByHotelID(HotelID);
	}

	@Override
	public List<OrderVO> GetSpecificOrders(String HotelID, String Status) throws SQLException {
		return new Order().filterOrderByStatus(new Order().getOrderByHotelID(HotelID), Status);
	}

}
