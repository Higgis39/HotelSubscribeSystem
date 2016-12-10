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
	
	public void setName(String name){
		this.name = new SimpleStringProperty(name);
	}
	
	public String getid(){
		return id.get();
	}
	
	public StringProperty getidProperty(){
		return id;
	}
	
	public void setid(String id){
		this.id = new SimpleStringProperty(id);
	}
	
	public String getpassword(){
		return password.get();
	}
	
	public StringProperty getpasswordProperty(){
		return password;
	}
	
	public void setpassword(String password){
		this.password = new SimpleStringProperty(password);
	}
	
	public String getusertype(){
		return usertype.get();
	}
	
	public StringProperty getusertypeProperty(){
		return usertype;
	}
	
	public void setusertype(String usertype){
		this.usertype = new SimpleStringProperty(usertype);
	}
	
	public String getphonenumber(){
		return phonenumber.get();
	}
	
	public StringProperty getphonenumberProperty(){
		return phonenumber;
	}
	
	public void setphonenumber(String phonenumber){
		this.phonenumber = new SimpleStringProperty(phonenumber);
	}
	
	public int getcreditvalue(){
		return creditvalue.get();
	}
	
	public IntegerProperty getcreditvalueProperty(){
		return creditvalue;
	}
	
	public void setcreditvalue(int creditvalue){
		this.creditvalue = new SimpleIntegerProperty(creditvalue);
	}
	
	public String getVIPtype(){
		return VIPtype.get();
	}
	
	public StringProperty getVIPtypeProperty(){
		return VIPtype;
	}
	
	public void setVIPtype(String VIPtype){
		this.VIPtype = new SimpleStringProperty(VIPtype);
	}
	
	public int getVIPgrade(){
		return VIPgrade.get();
	}
	
	public IntegerProperty getVIPgradeProperty(){
		return VIPgrade;
	}
	
	public void setVIPgrade(int VIPgrade){
		this.VIPgrade = new SimpleIntegerProperty(VIPgrade);
	}
	
	public String getbirthday(){
		return birthday.get();
	}
	
	public StringProperty getbirthdayProperty(){
		return birthday;
	}
	
	public void setbirthday(String birthday){
		this.birthday = new SimpleStringProperty(birthday);
	}
	
	public String getcompany(){
		return company.get();
	}
	
	public StringProperty getcompanyProperty(){
		return company;
	}
	
	public void setcompany(String company){
		this.company = new SimpleStringProperty(company);
	}
}
