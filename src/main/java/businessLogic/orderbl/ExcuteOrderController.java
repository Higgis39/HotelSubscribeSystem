package businessLogic.orderbl;

import java.sql.SQLException;
import java.util.List;

import businessLogicService.orderBLService.ExcuteOrderService;
import dataService.OrderDataService;
import vo.OrderVO;

public class ExcuteOrderController implements ExcuteOrderService{

	@Override
	public boolean CheckIn(OrderVO vo) {
		return new Order(vo).CheckIn();
	}

	@Override
	public List<OrderVO> FindOrderByHotelID(String ID) throws SQLException {
		return new Order().getOrderByHotelID(ID);
	}

}
