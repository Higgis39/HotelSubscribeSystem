package businessLogicService.userBLService;

import java.sql.SQLException;
import java.time.LocalDate;

/**
 * 
 * @author 费慧通
 *
 */
public interface AddHotelBLService {
	public String AddHotel(boolean IsManager,String hotelname,String phonenumber,String address,String businessarea,String introduction,String facilities,int star,String password1,String password2)throws SQLException;
	
	public boolean AddHotelWorker(boolean IsManager,String workername,String hotelname,int age,String sex,LocalDate begindate);

}
