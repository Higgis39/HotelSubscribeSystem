package vo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * 
 * @author Administrator
 *
 *界面与逻辑层之间传输的酒店工作人员信息
 */
public class WorkerVO {
	private StringProperty hotelname;
	private StringProperty name;
	private IntegerProperty age;
	private StringProperty sex;
	private StringProperty beginTime;

	public WorkerVO(String hotelname,String name, int age, String sex,String beginTime) {
		super();
		this.hotelname = new SimpleStringProperty(hotelname);
		this.name = new SimpleStringProperty(name);
		this.age = new SimpleIntegerProperty(age);
		this.sex = new SimpleStringProperty(sex);
		this.beginTime = new SimpleStringProperty(beginTime);
	}
	
	public String getHotelname(){
		return hotelname.get();
	}
	
	public StringProperty getHotelNameProperty(){
		return hotelname;
	}
	
	public void setHotelname(String hotelname){
		this.hotelname = new SimpleStringProperty(hotelname);
	}

	public String getName() {
		return name.get();
	}
	
	public StringProperty getNameProperty(){
		return name;
	}

	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}

	public int getAge() {
		return age.get();
	}
	
	public IntegerProperty getAgeProperty(){
		return age;
	}

	public void setAge(int age) {
		this.age = new SimpleIntegerProperty(age);
	}

	public String getSex() {
		return sex.get();
	}

	public StringProperty getSexProperty(){
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = new SimpleStringProperty(sex);
	}

	public String getBeginTime() {
		return beginTime.get();
	}
	
	public StringProperty getBeginTimeProperty(){
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = new SimpleStringProperty(beginTime);
	}
}
