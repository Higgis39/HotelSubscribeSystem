package businessLogic.userbl;

import businessLogicService.UserAddHotelBLService;

public class AddHotelController implements UserAddHotelBLService{
	User user = new User();
	
	/**
	 * 管理人员添加酒店（controller）
	 * @param IsManager boolean
	 * @param hotelname String
	 * @param address String
	 * @param phonenumber String
	 * @return 成功返回一个分配到的账号
	 */
	public String AddHotel(boolean IsManager,String hotelname,String phonenumber,String address,String businessarea,String introduction,String facilities,int star,String password1,String password2){
		return user.AddHotel(IsManager,hotelname,phonenumber,address,businessarea,introduction,facilities,star,password1,password2);
	}
	
	/**
	 * 管理人员添加酒店工作人员(controller)
	 * @param IsManager boolean
	 * @param workername String
	 * @param hotelname String
	 * @return 成功返回true,失败返回false
	 */
	public boolean AddHotelWorker(boolean IsManager,String workername,String hotelname){
		return user.AddHotelWorker(IsManager,workername,hotelname);
	}
}
