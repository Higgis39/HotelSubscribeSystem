package User.Manager;

import java.util.ArrayList;

import User.ManageMessage.CreditChange;
import User.ManageMessage.PersonalMessage;
import User.ManageMessage.UserPO;

public class MockUserPO extends UserPO{
	ArrayList<MockUserPO> userPO = new ArrayList<MockUserPO>();
	String id;
	String name;
	String password;
	int user_type;
	int creditvalue;
	String phonenumber;
	CreditChange creditchange;
	boolean IsVIP;
	int VIPPoint;
	int VIPGrade;
	String birthday;
	String company;
	
	public MockUserPO(String id,String name,String password,int user_type,int creditvalue,String phonenumber,CreditChange creditchange){
		this.id = id;
		this.name = name;
		this.password = password;
		this.user_type = user_type;
		this.creditvalue = creditvalue;
		this.phonenumber = phonenumber;
		this.creditchange = creditchange;
		userPO.add(this);
	}
	
	//�鿴������Ϣ
	public PersonalMessage getMessage(){
		return new PersonalMessage(name,phonenumber,creditvalue);
	}
	
	//�鿴�������ñ仯
	public CreditChange getCreditChange(){
		return creditchange;
	}
	
	//�޸ĸ�����Ϣ
	public PersonalMessage ChangeMessage(String newname,String newphonenumber){
		return new PersonalMessage(newname,newphonenumber,creditvalue);
	}
	
	//��ֵ����ֵ
	public int RechargeCredit(int creditRecharge){
		creditvalue = creditvalue+creditRecharge;
		return creditvalue;
	}
	
	//ע����?
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
	
	//������Ա�鿴�û���Ϣ
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
	
	//������Ա�޸��û���Ϣ
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
