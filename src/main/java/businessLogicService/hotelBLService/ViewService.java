package businessLogicService.hotelBLService;

import java.sql.SQLException;
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
}
