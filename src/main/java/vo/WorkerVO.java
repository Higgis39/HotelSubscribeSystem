package vo;

import java.util.Date;

public class WorkerVO {

	private String name;
	private int age;
	private String sex;
	private Date beginTime;
	
	public WorkerVO() {
		// TODO Auto-generated constructor stub
	}

	public WorkerVO(String name, int age, String sex, Date beginTime) {
		super();
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
}
