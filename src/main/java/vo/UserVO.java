package vo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserVO {
	private StringProperty name;
	private StringProperty id;
	private StringProperty password;
	private StringProperty usertype;
	private StringProperty phonenumber;
	private IntegerProperty creditvalue;
	private StringProperty VIPtype;
	private IntegerProperty VIPgrade;
	private StringProperty birthday;
	private StringProperty company;
	
	public UserVO(String name,String id,String password,String usertype,String phonenumber,int creditvalue,String VIPtype,int VIPgrade,String birthday,String company){
		this.name = new SimpleStringProperty(name);
		this.id = new SimpleStringProperty(id);
		this.password = new SimpleStringProperty(password);
		this.usertype = new SimpleStringProperty(usertype);
		this.phonenumber = new SimpleStringProperty(phonenumber);
		this.creditvalue = new SimpleIntegerProperty(creditvalue);
		this.VIPtype = new SimpleStringProperty(VIPtype);
		this.VIPgrade = new SimpleIntegerProperty(VIPgrade);
		this.birthday = new SimpleStringProperty(birthday);
		this.company = new SimpleStringProperty(company);
	}
	
	public String getname(){
		return name.get();
	}
	
	public StringProperty getnameProperty(){
		return name;
	}
	
	public String getid(){
		return id.get();
	}
	
	public StringProperty getidProperty(){
		return id;
	}
	
	public String getpassword(){
		return password.get();
	}
	
	public StringProperty getpasswordProperty(){
		return password;
	}
	
	public String getusertype(){
		return usertype.get();
	}
	
	public StringProperty getusertypeProperty(){
		return usertype;
	}
	
	public String getphonenumber(){
		return phonenumber.get();
	}
	
	public StringProperty getphonenumberProperty(){
		return phonenumber;
	}
	
	public int getcreditvalue(){
		return creditvalue.get();
	}
	
	public IntegerProperty getcreditvalueProperty(){
		return creditvalue;
	}
	
	public String getVIPtype(){
		return VIPtype.get();
	}
	
	public StringProperty getVIPtypeProperty(){
		return VIPtype;
	}
	
	public int getVIPgrade(){
		return VIPgrade.get();
	}
	
	public IntegerProperty getVIPgradeProperty(){
		return VIPgrade;
	}
	
	public String getbirthday(){
		return birthday.get();
	}
	
	public StringProperty getbirthdayProperty(){
		return birthday;
	}
	
	public String getcompany(){
		return company.get();
	}
	
	public StringProperty getcompanyProperty(){
		return company;
	}
}
