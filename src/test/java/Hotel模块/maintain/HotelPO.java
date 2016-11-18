package Hotel模块.maintain;

public class HotelPO {
	String address;
	String businessArea;
	String introduction;
	String Service;
	double Grade;
	String ClientEvaluate;
	String HotelName;
	String HotelPhone;
	
	public HotelPO(){
		
	}
	public HotelPO(String name,String phone,String addr,String busi,String intr,String serv,String clie,double Star){
		address=addr;
		businessArea=busi;
		introduction=intr;
		Service=serv;
		ClientEvaluate=clie;
		Grade=Star;
		HotelName=name;
		HotelPhone=phone;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getArea(){
		return businessArea;
	}
	
	public String getIntroduction(){
		return introduction;
	}
	
	public String getService(){
		return Service;
	}
	
	public double getGrade(){
		return Grade;
	}
	
	public String getEvaluate(){
		return ClientEvaluate;
	}
	
	public String getName(){
		return HotelName;
	}
	
	public String getPhone(){
		return HotelPhone;
	}
	
	public void UpdateMessage(String new_name,String new_phone){
		HotelName=new_name;
		HotelPhone=new_phone;
	}
	
	public String getHotelMessage(){
		return HotelName+"\n"+HotelPhone+"\n"+address+"\n"+businessArea+"\n"+introduction+"\n"+Service+"\n"+ClientEvaluate+"\n"+Grade;
	}
}
