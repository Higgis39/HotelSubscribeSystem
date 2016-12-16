package dataService;

import java.sql.SQLException;
import java.util.*;

import po.OrderPO;

public interface OrderDataService {
	public boolean insert(OrderPO po);
	
	public List<OrderPO> findByClient(String ID) throws SQLException;
	
	public boolean update(OrderPO po);
	
	public String distributeid() throws SQLException;
	
	public OrderPO findByOrderID(String ID);
	
	public List<OrderPO> findByDate(String Date) throws SQLException;
	
	public List<OrderPO> findByHotelID(String ID) throws SQLException;
	
	public List<OrderPO> findByStatus(String Status) throws SQLException;
} 
