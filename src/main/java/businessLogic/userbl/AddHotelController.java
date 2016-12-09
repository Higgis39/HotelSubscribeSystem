package businessLogic.userbl;

import java.sql.SQLException;
import java.time.LocalDate;

import businessLogicService.userBLService.AddHotelBLService;
import vo.HotelVO;
import vo.WorkerVO;

/**
 * 
 * @author 费慧通
 *
 */
public class AddHotelController implements AddHotelBLService{
	User user = new User();
	
	/**
	 * 添加酒店
	 * @param hotelvo
	 * @return
	 * @throws SQLException
	 */
	public String AddHotel(HotelVO hotelvo) throws SQLException{
		return user.AddHotel(hotelvo);
	}
	
	/**
	 * 管理人员添加酒店工作人员
	 * @param workervo
	 * @return
	 */
	public boolean AddHotelWorker(WorkerVO workervo){
		return user.AddHotelWorker(workervo);
	}
}
