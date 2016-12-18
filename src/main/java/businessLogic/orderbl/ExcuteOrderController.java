package businessLogic.orderbl;

import java.sql.SQLException;
import java.util.List;

import businessLogicService.orderBLService.ExcuteOrderService;
import vo.OrderVO;

public class ExcuteOrderController implements ExcuteOrderService{

	@Override
	public boolean CheckIn(OrderVO vo) throws SQLException {
		return new Order(vo).CheckIn();
	}

	@Override
	public List<OrderVO> FindOrderByHotelID(String ID) throws SQLException {
		return new Order().getOrderByHotelID(ID);
	}

}
