package User.ManageMessage;

import java.util.ArrayList;

import businessLogic.userbl.CreditChange;
import businessLogic.userbl.PersonalMessage;


public class MockUserPO extends UserPO{
	ArrayList<MockUserPO> userPO = new ArrayList<MockUserPO>();
	String id;
	String name;
	String password;
	String user_type;
	int creditvalue;
	String phonenumber;
	CreditChange creditchange;
	boolean IsVIP;
	int VIPPoint;
	int VIPGrade;
	String birthday;
	String company;
	
	public MockUserPO(String id, String name, String password,String usertype, int creditvalue, String phonenumber,CreditChange crechan) {
		
	}

	public PersonalMessage getMessage(){
		return new PersonalMessage(name,phonenumber,creditvalue);
	}
	
	public CreditChange getCreditChange(){
		return creditchange;
	}
	
	public PersonalMessage ChangeMessage(String newname,String newphonenumber){
		return new PersonalMessage(newname,newphonenumber,creditvalue);
	}
	
	public int RechargeCredit(int creditRecharge){
		creditvalue = creditvalue+creditRecharge;
		return creditvalue;
	}
	
	public boolean RegisterVIP(int VIPtype,String companyORbirthday){
		if(VIPtype==0){
			IsVIP = true;
			company = companyORbirthday;
			birthday = null;
			VIPPoint = 0;
			VIPGrade = 1;
		}else{
			IsVIP = true;
			company = null;
			birthday = companyORbirthday;
			VIPPoint = 0;
			VIPGrade = 1;
		}
		return true;
	}
	

	public PersonalMessage ViewClient(boolean IsManager,String id){
		if(IsManager==false){
			return null;
		}
		for(int i=0;i<userPO.size();i++){
			if(userPO.get(i).id.equals(id)){
				return new PersonalMessage(userPO.get(i).name,userPO.get(i).phonenumber,userPO.get(i).creditvalue);
			}
		}
		return null;
	}
	

	public PersonalMessage ChangeClient(boolean IsManager,String id,String name,String phonenumber){
		if(IsManager==false){
			return null;
		}
		for(int i=0;i<userPO.size();i++){
			if(userPO.get(i).id.equals(id)){
				userPO.get(i).name = name;
				userPO.get(i).phonenumber = phonenumber;
				userPO.get(i).creditvalue = creditvalue;
				return new PersonalMessage(userPO.get(i).name,userPO.get(i).phonenumber,userPO.get(i).creditvalue);
			}
		}
		return null;
	}
}