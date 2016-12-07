package businessLogic.userbl;

import java.sql.SQLException;
import java.time.LocalDate;

import businessLogicService.userBLService.AddHotelBLService;

/**
 * 
 * @author 费慧通
 *
 */
public class AddHotelController implements AddHotelBLService{
	User user = new User();
	
	/**
	 * 管理人员添加酒店（controller）
	 * @param IsManager boolean
	 * @param hotelname String
	 * @param address String
	 * @param phonenumber String
	 * @return 成功返回一个分配到的账号
	 * @throws SQLException 
	 */
	public String AddHotel(boolean IsManager,String hotelname,String phonenumber,String address,String businessarea,String introduction,String facilities,int star,String password1,String password2)throws SQLException{
		return user.AddHotel(IsManager, hotelname, phonenumber, address, businessarea, introduction, facilities, star, password1, password2);
	}
	
	/**
	 * 管理人员添加酒店工作人员(controller)
	 * @param IsManager boolean
	 * @param workername String
	 * @param hotelname String
	 * @return 成功返回true,失败返回false
	 */
	public boolean AddHotelWorker(boolean IsManager,String workername,String hotelname,int age,String sex,LocalDate begindate){
		return user.AddHotelWorker(IsManager,workername,hotelname,age,sex,begindate);
	}
}
