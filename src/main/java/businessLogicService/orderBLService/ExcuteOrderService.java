package businessLogicService.orderBLService;

import java.sql.SQLException;
import java.util.*;

import vo.OrderVO;


public interface ExcuteOrderService {
    public List<OrderVO> FindOrderByHotelID(String ID)throws SQLException;
	
	public boolean CheckIn(OrderVO vo);
}
