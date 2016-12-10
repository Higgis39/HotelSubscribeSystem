package businessLogicService.orderBLService;

import java.sql.SQLException;
import java.util.List;

import vo.OrderVO;

public interface WebsiteViewOrderService {
	
	public List<OrderVO> ViewException(String Date)throws SQLException;
	
	public boolean RecoverCredit(OrderVO vo);
}
