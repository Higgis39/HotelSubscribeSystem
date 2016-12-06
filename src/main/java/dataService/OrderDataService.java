package dataService;

import java.util.*;

import po.OrderPO;

public interface OrderDataService {
	public boolean insert(OrderPO po);
	
	public List<OrderPO> findByClient(String ID);
	
	public boolean update(OrderPO po);
	
	public OrderPO findByOrderID(String ID);
	
	public List<OrderPO> findByDate(String Date);
	
	public List<OrderPO> findByHotelID(String ID);
	
	public List<OrderPO> findByStatus(String Status);
} 
