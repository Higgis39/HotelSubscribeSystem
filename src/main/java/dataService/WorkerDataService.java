package dataService;

import java.sql.SQLException;
import java.util.List;

import po.WorkerPO;

public interface WorkerDataService {

	public List<WorkerPO> findByHotelName(String hotelName) throws SQLException;
}
