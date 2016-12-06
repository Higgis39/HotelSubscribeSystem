package dataService;

import java.util.*;

import po.OrderPO;

public interface OrderDataService {
	public boolean insert(OrderPO po);
	
	public List<OrderPO> findByStatus(String ID,String Status);
	
	public boolean update(OrderPO po);
	
	public OrderPO findByOrderID(String ID);
	
	public OrderPO findByDate(String Date);
	
	public List<OrderPO> findByHotelID(String ID);
}
