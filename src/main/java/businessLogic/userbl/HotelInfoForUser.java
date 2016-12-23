package businessLogic.userbl;

import java.sql.SQLException;

public interface HotelInfoForUser {

	public boolean addHotel(String id,String password,String hotelname,String phonenumber,String city,String address,String businessarea,String introduction,String facilities,int star);
	
	public boolean addHotelWorker(String workername,String hotelname,int age,String sex,String begindate);
	
	public boolean ChangeHotelWorkerMessage(String hotelid,String name,int age,String sex,String begindate)throws SQLException;
}
