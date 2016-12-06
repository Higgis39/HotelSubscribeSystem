package businessLogic.userbl;

import java.sql.SQLException;
import java.util.ArrayList;

import data.HotelData;
import data.UserData;
import dataService.HotelDataService;
import dataService.UserDataService;
import po.HotelPO;
import po.UserPO;
import vo.UserVO;

/**
 * 
 * @author 费慧通
 *
 */
public class User{
	UserDataService userdataservice = new UserData();
	HotelDataService hoteldataservice = new HotelData();
	
	/**
	 * 登录
	 * @param id String
	 * @param password String
	 * @param usertype String
	 * @return 成功返回true,失败返回false
	 */
	public boolean Login(String id,String password,String usertype){
		UserPO userpo = userdataservice.find(id);
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
	 * @throws SQLException 
	 */
	public String RegisterClient(String name,String password1,String password2) throws SQLException{
		if(!password1.equals(password2)){
			return "The two passwords is different.";
		}else{
			String newid = Integer.toString(Integer.valueOf(userdataservice.distributeid())+1);
			userdataservice.insert(new UserPO(name,newid,password1,"普通客户",0,null,0,null,null,null,null));
			return "Register successfully! Your id is "+newid;
		}
	}
	
	/**
	 * 查看个人信息
	 * @param id String
	 * @return 返回用户的基本信息
	 */
	public PersonalMessage GetMessage(String id){
		UserPO userpo = userdataservice.find(id);
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
		UserPO userpo = userdataservice.find(id);
		userdataservice.update(new UserPO(newname,userpo.getid(),userpo.getpassword(),userpo.getusertype(),userpo.getcreditvalue(),
				userpo.getVIPtype(),userpo.getVIPgrade(),newphonenumber,userpo.getbirthday(),userpo.getcompany(),userpo.getcreditchange()));
		return true;
	}
	
	/**
	 * 查看信用变化
	 * @param id String
	 * @return 返回个人信用变化
	 */
	public ArrayList<String> GetCreditChange(String id){
		UserPO userpo = userdataservice.find(id);
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
			UserPO userpo = userdataservice.find(clientid);
			//更改信用值
			int creditvalue = userpo.getcreditvalue();
			creditvalue = creditvalue+creditRecharge;
			//更新信用变化
			ArrayList<String> creditchange = userpo.getcreditchange();
			String change = "客户充值"+Integer.toString(creditRecharge);
			creditchange.add(change);
			
			userdataservice.update(new UserPO(userpo.getname(),userpo.getid(),userpo.getpassword(),userpo.getusertype(),creditvalue,
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
		UserPO userpo = userdataservice.find(id);
		if(VIPtype.equals("普通会员")){
			userdataservice.update(new UserPO(userpo.getname(),userpo.getid(),userpo.getpassword(),userpo.getusertype(),userpo.getcreditvalue(),
					   VIPtype,1,userpo.getphonenumber(),CompanyOrBirthday,null,userpo.getcreditchange()));
		}else{
			userdataservice.update(new UserPO(userpo.getname(),userpo.getid(),userpo.getpassword(),userpo.getusertype(),userpo.getcreditvalue(),
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
	public UserVO ViewClientMessage(String id){
		UserPO userpo = userdataservice.find(id);
		return new UserVO(userpo.getname(),userpo.getid(),userpo.getusertype(),userpo.getphonenumber(),userpo.getcreditvalue(),userpo.getVIPtype(),userpo.getVIPgrade(),userpo.getbirthday(),userpo.getcompany());
//		return new UserVO("zhang","1200","wangzhan","1325678",142,"huiyuan",2,"2014-14-12",null);
		
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
			UserPO userpo = userdataservice.find(id);
			userdataservice.update(new UserPO(newname,userpo.getid(),userpo.getpassword(),userpo.getusertype(),userpo.getcreditvalue(),
				   userpo.getVIPtype(),userpo.getVIPgrade(),newphonenumber,userpo.getbirthday(),userpo.getcompany(),userpo.getcreditchange()));
			return true;
		}
	}
	
	public String AddMarketer(boolean IsManager,String name,String password1,String password2) throws NumberFormatException, SQLException{
		if(!password1.equals(password2)){
			return "The two passwords are different.";
		}else{
			String newid = Integer.toString(Integer.valueOf(userdataservice.distributeid())+1);
			userdataservice.insert(new UserPO(name,newid,password1,"网站营销人员",0,null,0,null,null,null,null));
			return newid;
		}
	}
	
	/**
	 * 管理人员添加酒店
	 * @param IsManager boolean
	 * @param hotelname String
	 * @param phonenumber String
	 * @param address String
	 * @param businessarea String
	 * @param introduction String
	 * @param facilities String
	 * @param password1 String
	 * @param password2 String
	 * @param star int
	 * @return 成功返回一个分配到的账号
	 * @throws SQLException 
	 */
	public String AddHotel(boolean IsManager,String hotelname,String phonenumber,String address,String businessarea,String introduction,String facilities,int star,String password1,String password2) throws SQLException{
		if(IsManager==false){
			return null;
		}else if(!password1.equals(password2)){
			return "The two passwords are different.";
		}else{
			String newid = hoteldataservice.distributeid();
			ArrayList<String> worker = new ArrayList<String>();
			hoteldataservice.insert(new HotelPO(newid,password1,hotelname,phonenumber,address,businessarea,introduction,facilities,star,0.0,worker));
			return newid;
		}
	}
	
	/**
	 * 管理人员添加酒店工作人员
	 * @param IsManager boolean
	 * @param workername String
	 * @param hotelid String
	 * @return 成功返回true,失败返回false
	 */
	public boolean AddHotelWorker(boolean IsManager,String workername,String hotelname){
		if(IsManager==false){
			return false;
		}else{
			HotelPO hotelpo = hoteldataservice.findByName(hotelname);
			ArrayList<String> worker = hotelpo.getWorker();
			worker.add(workername);
			hoteldataservice.update(new HotelPO(hotelpo.getId(),hotelpo.getPassword(),hotelpo.getName(),hotelpo.getPhonenumber(),
					hotelpo.getAddress(),hotelpo.getBusinessArea(),hotelpo.getIntroduction(),hotelpo.getFacilities(),hotelpo.getStar(),hotelpo.getGrade(),worker));
			return true;
		}
	}
}
