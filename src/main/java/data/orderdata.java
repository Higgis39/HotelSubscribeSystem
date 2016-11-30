package data;

import java.util.List;

import dataService.OrderDataService;
import po.OrderPO;

public class OrderData implements OrderDataService{

	@Override
	public boolean insert(OrderPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OrderPO> findByStatus(String ID, String Status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(OrderPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderPO findByOrderID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderPO findByDate(String Date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderPO> findByHotelID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
