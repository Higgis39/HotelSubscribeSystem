package businessLogicService.orderBLService;

import java.sql.SQLException;

import vo.OrderVO;

public interface CreateOrderService {
    public boolean CheckEnoughCredit(String ID);

	public double getTotal(OrderVO vo) throws SQLException;
	
	public boolean addNewOrder(OrderVO vo);
	
	public int CheckRoom(String hotelName,String roomType) throws SQLException;
	
	public int CheckMax(String hotelName,String roomType) throws SQLException;
}
