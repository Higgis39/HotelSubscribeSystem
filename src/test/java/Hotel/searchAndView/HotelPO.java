package Hotel.searchAndView;

public class HotelPO {
	String address;
	String businessArea;
	String introduction;
	String Service;
	double Grade;
	String ClientEvaluate;
	String HotelName;
	
	public HotelPO(){
		
	}
	public HotelPO(String name,String addr,String busi,String intr,String serv,String clie,double Star){
		address=addr;
		businessArea=busi;
		introduction=intr;
		Service=serv;
		ClientEvaluate=clie;
		Grade=Star;
		HotelName=name;
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
	
	public String getHotelMessage(){
		return HotelName+"\n"+address+"\n"+businessArea+"\n"+introduction+"\n"+Service+"\n"+ClientEvaluate+"\n"+Grade;
	}
}
