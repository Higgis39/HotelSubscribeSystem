package businessLogic.userbl;

import java.sql.SQLException;

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
	
	/**
	 * 修改酒店工作人员信息
	 * @param hotelid
	 * @param name
	 * @param age
	 * @param sex
	 * @param begindate
	 * @return
	 * @throws SQLException 
	 */
	public boolean ChangeHotelWorkerMessage(String hotelid,String name,int age,String sex,String begindate) throws SQLException{
		return user.ChangeHotelWorkerMessage(hotelid, name, age, sex, begindate);
	}
}
