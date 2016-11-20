package businessLogic.userbl;

import java.util.ArrayList;

import dataService.HotelDataService;
import dataService.UserDataService;
import po.HotelPO;
import po.UserPO;

public class User{
	/**
	 * 登录
	 * @param id String
	 * @param password String
	 * @param usertype String
	 * @return 成功返回true,失败返回false
	 */
	public boolean Login(String id,String password,String usertype){
		UserPO userpo = UserDataService.find(id);
		if(usertype.equals(userpo.getusertype())&&password.equals(userpo.getpassword())){
			return true;
		}
		return false;
	}
	
	/**
	 * 注册用户
	 * @param name String
	 * @param password1 String
	 * @param password2 String
	 * @return 创建成功则返回分配的id
	 */
	public String RegisterClient(String name,String password1,String password2){
		if(password1.equals(password2)){
			return "The two passwords is different.";
		}else{
			String newid = UserDataService.distributeid();
			UserDataService.insert(new UserPO(name,newid,password1,"普通客户",0,null,0,null,null,null,null));
			return "Register successfully! Your id is "+newid;
		}
	}
	
	/**
	 * 查看个人信息
	 * @param id String
	 * @return 返回用户的基本信息
	 */
	public PersonalMessage GetMessage(String id){
		UserPO userpo = UserDataService.find(id);
		return new PersonalMessage(userpo.getname(),userpo.getphonenumber(),userpo.getcreditvalue());
	}
	
	/**
	 * 修改个人信息
	 * @param id String
	 * @param newname String
	 * @param newphonenumber String
	 * @return 成功返回true,失败返回false
	 */
	public boolean ChangeMessage(String id,String newname,String newphonenumber){
		UserPO userpo = UserDataService.find(id);
		UserDataService.update(new UserPO(newname,userpo.getid(),userpo.getpassword(),userpo.getusertype(),userpo.getcreditvalue(),
				userpo.getVIPtype(),userpo.getVIPgrade(),newphonenumber,userpo.getbirthday(),userpo.getcompany(),userpo.getcreditchange()));
		return true;
	}
	
	/**
	 * 查看信用变化
	 * @param id String
	 * @return 返回个人信用变化
	 */
	public CreditChange GetCreditChange(String id){
		UserPO userpo = UserDataService.find(id);
		return userpo.getcreditchange();
	}
	
	/**
	 * 充值信用值
	 * @param clientid String
	 * @param creditRecharge int
	 * @return 成功返回true,失败返回false
	 */
	public boolean RechargeCredit(String usertype,String clientid,int creditRecharge){
		if(!usertype.equals("网站营销人员")){
			return false;
		}else{
			UserPO userpo = UserDataService.find(clientid);
			//更改信用值
			int creditvalue = userpo.getcreditvalue();
			creditvalue = creditvalue+creditRecharge;
			//更新信用变化
			CreditChange creditchange = userpo.getcreditchange();
			String change = "客户充值"+Integer.toString(creditRecharge);
			creditchange.addcreditchange(change);
			
			UserDataService.update(new UserPO(userpo.getname(),userpo.getid(),userpo.getpassword(),userpo.getusertype(),creditvalue,
				   userpo.getVIPtype(),userpo.getVIPgrade(),userpo.getphonenumber(),userpo.getbirthday(),userpo.getcompany(),creditchange));
			return true;
		}
	}
	
	/**
	 * 注册会员
	 * @param id String
	 * @param VIPtype String
	 * @param CompanyOrBirthday String
	 * @return 成功返回true,失败返回false
	 */
	public boolean RegisterVIP(String id,String VIPtype,String CompanyOrBirthday){
		UserPO userpo = UserDataService.find(id);
		if(VIPtype.equals("普通会员")){
			UserDataService.update(new UserPO(userpo.getname(),userpo.getid(),userpo.getpassword(),userpo.getusertype(),userpo.getcreditvalue(),
					   VIPtype,1,userpo.getphonenumber(),CompanyOrBirthday,null,userpo.getcreditchange()));
		}else{
			UserDataService.update(new UserPO(userpo.getname(),userpo.getid(),userpo.getpassword(),userpo.getusertype(),userpo.getcreditvalue(),
					   VIPtype,1,userpo.getphonenumber(),null,CompanyOrBirthday,userpo.getcreditchange()));
		}
		return true;
	}
	
	/**
	 * 管理人员查看其它用户信息
	 * @param IsManager boolean
	 * @param id String
	 * @return 返回其它用户信息
	 */
	public PersonalMessage ViewClientMessage(boolean IsManager,String id){
		if(IsManager==false){
			return null;
		}else{
			UserPO userpo = UserDataService.find(id);
			return new PersonalMessage(userpo.getname(),userpo.getphonenumber(),userpo.getcreditvalue());
		}
	}
	
	/**
	 * 管理人员修改其它用户信息
	 * @param IsManager boolean
	 * @param id String
	 * @param newname String
	 * @param newphonenumber String
	 * @return 成功返回true,失败返回false
	 */
	public boolean ChangeClientMessaage(boolean IsManager,String id,String newname,String newphonenumber){
		if(IsManager==false){
			return false;
		}else{
			UserPO userpo = UserDataService.find(id);
			UserDataService.update(new UserPO(newname,userpo.getid(),userpo.getpassword(),userpo.getusertype(),userpo.getcreditvalue(),
				   userpo.getVIPtype(),userpo.getVIPgrade(),newphonenumber,userpo.getbirthday(),userpo.getcompany(),userpo.getcreditchange()));
			return true;
		}
	}
	
	/**
	 * 管理人员添加酒店
	 * @param IsManager boolean
	 * @param hotelname String
	 * @param phonenumber String
	 * @param address String
	 * @param businessarea String
	 * @param star int
	 * @return 成功返回一个分配到的账号
	 */
	public String AddHotel(boolean IsManager,String hotelname,String phonenumber,String address,String businessarea,String introduction,String facilities,int star,String password1,String password2){
		if(IsManager==false){
			return null;
		}else if(!password1.equals(password2)){
			return "The two passwords is different.";
		}else{
			String newid = HotelDataService.distributeid();
			ArrayList<String> worker = new ArrayList<String>();
			HotelDataService.insert(new HotelPO(newid,password1,hotelname,phonenumber,address,businessarea,introduction,facilities,star,0.0,worker));
			return "Register successfully! The id of hotel is "+newid;
		}
	}
	
	/**
	 * 管理人员添加酒店工作人员
	 * @param IsManager boolean
	 * @param workername String
	 * @param hotelid String
	 * @return 成功返回true,失败返回false
	 */
	public boolean AddHotelWorker(boolean IsManager,String workername,String hotelid){
		if(IsManager==false){
			return false;
		}else{
			HotelPO hotelpo = HotelDataService.find(hotelid);
			ArrayList<String> worker = hotelpo.getWorker();
			worker.add(workername);
			HotelDataService.update(new HotelPO(hotelpo.getid(),hotelpo.getpassword(),hotelpo.getName(),hotelpo.getphonenumber(),
					hotelpo.getAddress(),hotelpo.getbusinessArea(),hotelpo.getIntroduction(),hotelpo.getFacilities(),hotelpo.getStar(),hotelpo.getGrade(),worker));
			return true;
		}
	}
}