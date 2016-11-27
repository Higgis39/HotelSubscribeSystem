package businessLogicService;

public interface UserAddHotelBLService {
	public String AddHotel(boolean IsManager,String hotelname,String phonenumber,String address,String businessarea,String introduction,String facilities,int star,String password1,String password2);
	
	public boolean AddHotelWorker(boolean IsManager,String workername,String hotelid);

}
