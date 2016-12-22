package businessLogic.orderbl;

import java.sql.SQLException;
import java.util.*;

import businessLogicService.orderBLService.WebsiteViewOrderService;
import vo.OrderVO;

public class WebsiteViewOrderController implements WebsiteViewOrderService{

	@Override
	public List<OrderVO> ViewException(String Date) throws SQLException {
		Order order=new Order();
		List<OrderVO> list = order.getOrderByDate(Date);
		list = order.filterOrderByStatus(list, "异常");
		return list;
	}

	@Override
	public boolean RecoverCredit(OrderVO vo,String RecoverPercent) {
		return new Order(vo).Recover(RecoverPercent);
	}

}
