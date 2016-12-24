package businessLogicService.hotelBLService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.HotelVO;
import vo.WorkerVO;
/*
 * 
 * @author 梁先伟
 * 
 */
public interface ViewService {
	public HotelVO View(String hotelName);

	public HotelVO ViewByid(String id);

	public List<WorkerVO> findworker(String hotelid) throws SQLException;
	
	public ArrayList<String> getcity() throws SQLException;
	
	public ArrayList<String> getbusinessareaBycity(String city) throws SQLException;
}
