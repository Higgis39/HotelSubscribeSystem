package vo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserVO {
	private final StringProperty name;
	private final StringProperty id;
	private final StringProperty usertype;
	private final StringProperty phonenumber;
	private final IntegerProperty creditvalue;
	private final StringProperty VIPtype;
	private final IntegerProperty VIPgrade;
	private final StringProperty birthday;
	private final StringProperty company;

	public UserVO(){
		this(null,null,null,null,0,null,0,null,null);
	}
	
	public UserVO(String name,String id,String usertype,String phonenumber,int creditvalue,String VIPtype,int VIPgrade,String birthday,String company){
		this.name = new SimpleStringProperty(name);
		this.id = new SimpleStringProperty(id);
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
