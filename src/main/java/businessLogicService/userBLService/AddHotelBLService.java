package businessLogicService.userBLService;

import java.sql.SQLException;

import vo.HotelVO;
import vo.WorkerVO;

/**
 * 
 * @author 费慧通
 *
 */
public interface AddHotelBLService {
	public String AddHotel(HotelVO hotelvo)throws SQLException;
	
	public boolean AddHotelWorker(WorkerVO workervo);
	
	public boolean ChangeHotelWorkerMessage(String hotelid,String name,int age,String sex,String begindate)throws SQLException;
}
