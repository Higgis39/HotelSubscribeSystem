package businessLogicService.orderBLService;

import java.sql.SQLException;
import java.util.List;

import po.OrderPO;
import vo.OrderVO;

public interface HotelViewOrderService {
	public List<OrderVO> getAllHotelOrders(String HotelID)throws SQLException;
	
    public List<OrderVO> GetSpecificOrders(String HotelID,String Status)throws SQLException;
	
	public OrderVO ShowOrderMessage(String OrderID);
}
