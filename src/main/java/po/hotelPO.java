package po;

import java.util.ArrayList;

public class HotelPO {
	String hotelid;
	String password;
	String hotelname;
	String phonenumber;
	String address;
	String businessarea;
	String introduction;
	String facilities;
	int star;
	double grade;
	ArrayList<String> worker = new ArrayList<String>();
	
	//构造函数
	public HotelPO(String hotelid,String password,String hotelname,String phonenumber,String address,String businessarea,String introduction,String facilities,int star,double grade,ArrayList<String> worker){
		this.hotelid = hotelid;
		this.password = password;
		this.hotelname = hotelname;
		this.phonenumber = phonenumber;
		this.address = address;
		this.businessarea= businessarea;
		this.introduction = introduction;
		this.facilities = facilities;
		this.star = star;
		this.grade = grade;
		this.worker = worker;
	}
	
	//得到酒店账号
	public String getid(){
		return hotelid;
	}
	
	//得到酒店账号密码
	public String getpassword(){
		return password;
	}
	
	//得到酒店名称
	public String getName(){
		return hotelname;
	}
	
	//得到酒店联系方式
	public String getphonenumber(){
		return phonenumber;
	}
	
	//得到酒店地址
	public String getAddress(){
		return address;
	}
	
	//得到酒店所处商圈
	public String getbusinessArea(){
		return businessarea;
	}
	
	//得到酒店简介
	public String getIntroduction(){
		return introduction;
	}
	
	//得到酒店设施服务
	public String getFacilities(){
		return facilities;
	}
	
	//得到酒店星级
	public int getStar(){
		return star;
	}
	
	//得到酒店评分
	public double getGrade(){
		return grade;
	}
	
	//得到酒店工作人员
	public ArrayList<String> getWorker(){
		return worker;
	}
}
