package po;

import java.util.Date;

public class WorkerPO {
	
	private String hotelName;
	private String name;
	private int age;
	private String sex;
	private Date beginTime;
	
	public WorkerPO() {
		// TODO Auto-generated constructor stub
	}

	public WorkerPO(String hotelName, String name, int age, String sex, Date beginTime) {
		super();
		this.hotelName = hotelName;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.beginTime = beginTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	
}