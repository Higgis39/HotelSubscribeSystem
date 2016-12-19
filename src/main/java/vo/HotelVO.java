package vo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 
 *界面与逻辑之间传输的酒店信息
 */
public class HotelVO {
	private StringProperty hotelid;
	private StringProperty password;
	private StringProperty hotelname;
	private StringProperty phonenumber;
	private StringProperty address;
	private StringProperty businessarea;
	private StringProperty introduction;
	private StringProperty facilities;
	private IntegerProperty star;
	private DoubleProperty grade;
	
	//构造函数
	public HotelVO(String hotelid,String password,String hotelname,String phonenumber,String address,String businessarea,String introduction,String facilities,int star,double grade){
		this.hotelid = new SimpleStringProperty(hotelid);
		this.password = new SimpleStringProperty(password);
		this.hotelname = new SimpleStringProperty(hotelname);
		this.phonenumber = new SimpleStringProperty(phonenumber);
		this.address = new SimpleStringProperty(address);
		this.businessarea= new SimpleStringProperty(businessarea);
		this.introduction = new SimpleStringProperty(introduction);
		this.facilities = new SimpleStringProperty(facilities);
		this.star = new SimpleIntegerProperty(star);
		this.grade = new SimpleDoubleProperty(grade);
	}
	
	
	//得到酒店账号
	public String getId(){
		return hotelid.get();
	}
	
	public StringProperty getIdProperty(){
		return hotelid;
	}
	
	//得到酒店账号密码
	public String getPassword(){
		return password.get();
	}
	
	public StringProperty getPasswordProperty(){
		return password;
	}
	
	//得到酒店名称
	public String getName(){
		return hotelname.get();
	}
	
	public StringProperty getNameProperty(){
		return hotelname;
	}
	
	//得到酒店联系方式
	public String getPhonenumber(){
		return phonenumber.get();
	}
	
	public StringProperty getPhonenumberProperty(){
		return phonenumber;
	}
	
	//得到酒店地址
	public String getAddress(){
		return address.get();
	}
	
	public StringProperty getAddressProperty(){
		return address;
	}
	
	//得到酒店所处商圈
	public String getBusinessArea(){
		return businessarea.get();
	}
	
	public StringProperty getBusinessAreaProperty(){
		return businessarea;
	}

	//得到酒店简介
	public String getIntroduction(){
		return introduction.get();
	}
	
	public StringProperty getIntroductionProperty(){
		return introduction;
	}
	
	//得到酒店设施服务
	public String getFacilities(){
		return facilities.get();
	}
	
	public StringProperty getFacilitiesProperty(){
		return facilities;
	}
	
	//得到酒店星级
	public int getStar(){
		return star.get();
	}
	
	public IntegerProperty getStarProperty(){
		return star;
	}
	
	//得到酒店评分
	public double getGrade(){
		return grade.get();
	}
	
	public DoubleProperty getGradeProperty(){
		return grade;
	}
}
