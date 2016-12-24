package businessLogic.userbl;

import java.sql.SQLException;
import java.util.ArrayList;

import businessLogic.hotelbl.HotelToolForUser;
import data.UserData;
import dataService.UserDataService;
import po.UserPO;
import vo.HotelVO;
import vo.UserVO;
import vo.WorkerVO;

/**
 * 
 * @author 费慧通
 *
 *具体实现User模块的逻辑操作
 */
public class User{
	UserDataService userdataservice = new UserData();
	CreditGrade creditvaluechange = new CreditGrade();
	HotelInfoForUser hotelinfoforuser = new HotelToolForUser();
	
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
	 * @param uservo UserVO
	 * @return 创建成功则返回分配的id
	 * @throws SQLException 
	 */
	public String RegisterClient(UserVO uservo) throws SQLException{
		String newid = Integer.toString(Integer.valueOf(userdataservice.distributeid())+1);
		userdataservice.insert(new UserPO(uservo.getname(),newid,uservo.getpassword(),"普通客户",0,null,0,null,null,null,null));
		return newid;
	}
	
	/**
	 * 查看个人信息
	 * @param id String
	 * @return 返回用户的基本信息
	 */
	public UserVO GetMessage(String id){
		UserPO userpo = userdataservice.find(id);
		return new UserVO(userpo.getname(),userpo.getid(),userpo.getpassword(),userpo.getusertype(),userpo.getphonenumber(),userpo.getcreditvalue(),userpo.getVIPtype(),userpo.getVIPgrade(),userpo.getbirthday(),userpo.getcompany());
	}
	
	/**
	 * 修改个人信息
	 * @param id
	 * @param name
	 * @param phonenumber
	 * @return
	 */
	public boolean ChangeMessage(String id,String name,String phonenumber){
		UserPO userpo = userdataservice.find(id);
		userpo.setName(name);
		userpo.setPhonenumber(phonenumber);
		userdataservice.update(userpo);
		return true;
	}
	
	/**
	 * 修改生日/企业
	 * @param id
	 * @param birorcom
	 * @return
	 */
	public boolean ChangeBirOrCom(String id,String birorcom){
		UserPO userpo = userdataservice.find(id);
		if(userpo.getbirthday()==null){
			userpo.setCompany(birorcom);
		}else{
			userpo.setBirthday(birorcom);
		}
		userdataservice.update(userpo);
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
		}else if(creditRecharge<0){
			return false;
		}else{
			UserPO userpo = userdataservice.find(clientid);
			if(userpo==null){
				return false;
			}
			//更改信用值
			int creditvalue = userpo.getcreditvalue();
			creditvalue = creditvalue+creditRecharge;
			//更新会员等级
			int VIPgrade = creditvaluechange.setVIPgradeByCredit(creditvalue,userpo.getVIPtype());
			//更新信用变化
			ArrayList<String> creditchange = userpo.getcreditchange();
			String change = "客户充值"+Integer.toString(creditRecharge);
			creditchange.add(change);
			userpo.setCreditvalue(creditvalue);
			userpo.setVIPgrade(VIPgrade);
			userpo.setCreditchange(creditchange);
			userdataservice.update(userpo);
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
		if(userpo.getVIPtype()!=null){
			return false;
		}
		userpo.setVIPtype(VIPtype);
		if(VIPtype.equals("普通会员")){
			userpo.setBirthday(CompanyOrBirthday);
		}else{
			userpo.setCompany(CompanyOrBirthday);
		}
		userdataservice.update(userpo);
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
		return new UserVO(userpo.getname(),userpo.getid(),userpo.getpassword(),userpo.getusertype(),userpo.getphonenumber(),userpo.getcreditvalue(),userpo.getVIPtype(),userpo.getVIPgrade(),userpo.getbirthday(),userpo.getcompany());
		
	}
	
	/**
	 * 管理人员修改其它用户信息
	 * @param IsManager
	 * @param id
	 * @param newname
	 * @param newphonenumber
	 * @param creditvalue
	 * @param birthday
	 * @param company
	 * @return
	 */
	public boolean ChangeClientMessaage(String id,String newname,String newphonenumber,int creditvalue,String birthday,String company){
		UserPO userpo = userdataservice.find(id);
		userpo.setName(newname);
		userpo.setPhonenumber(newphonenumber);
		userpo.setCreditvalue(creditvalue);
		userpo.setBirthday(birthday);
		userpo.setCompany(company);
		userdataservice.update(userpo);
		return true;
	}
	
	/**
	 * 添加网站营销人员
	 * @param uservo
	 * @return
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	public String AddMarketer(UserVO uservo) throws NumberFormatException, SQLException{
		String newid = Integer.toString(Integer.valueOf(userdataservice.distributeid())+1);
		userdataservice.insert(new UserPO(uservo.getname(),newid,uservo.getpassword(),"网站营销人员",0,null,0,null,null,null,null));
		return newid;
	}
	
	/**
	 * 添加酒店
	 * @param hotelvo
	 * @return
	 * @throws SQLException
	 */
	public String AddHotel(HotelVO hotelvo) throws SQLException{
		String newid = Integer.toString(Integer.valueOf(userdataservice.distributeid())+1);
		userdataservice.insert(new UserPO(hotelvo.getName(),newid,hotelvo.getPassword(),"酒店工作人员",0,null,0,null,null,null,null));
		//添加HotelPO
		hotelinfoforuser.addHotel(newid, hotelvo.getPassword(),hotelvo.getName(), hotelvo.getPhonenumber(),hotelvo.getCity(), hotelvo.getAddress(), hotelvo.getBusinessArea(), hotelvo.getIntroduction(), hotelvo.getFacilities(), hotelvo.getStar());
		return newid;
		
	}
	
	/**
	 * 管理人员添加酒店工作人员
	 * @param workervo
	 * @return
	 */
	public boolean AddHotelWorker(WorkerVO workervo){
		//添加WorkerPO
		hotelinfoforuser.addHotelWorker(workervo.getName(), workervo.getHotelname(), workervo.getAge(),workervo.getSex(),workervo.getBeginTime());
		return true;
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
		hotelinfoforuser.ChangeHotelWorkerMessage(hotelid, name, age, sex, begindate);
		return true;
	}
}
