package businessLogic.userbl;

public interface HotelInfoForUser {

	public boolean addHotel(String id,String password,String hotelname,String phonenumber,String city,String address,String businessarea,String introduction,String facilities,int star);
	
	public boolean addHotelWorker(String workername,String hotelname,int age,String sex,String begindate);
}
