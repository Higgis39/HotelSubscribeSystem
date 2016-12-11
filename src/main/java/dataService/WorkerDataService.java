package dataService;

import java.sql.SQLException;
import java.util.List;

import po.WorkerPO;

public interface WorkerDataService {

	public void insert(WorkerPO po);
	
	public List<WorkerPO> findByHotelName(String hotelName) throws SQLException;
}
