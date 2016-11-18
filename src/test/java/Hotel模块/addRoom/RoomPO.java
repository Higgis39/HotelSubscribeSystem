package addRoom;

public class RoomPO {
	int roomID;
	String roomType;
	double roomPrice;
	int peopleNumber;
	boolean IsEmpty;
	
	public RoomPO(int RoomID,int PeopleNumber,double RoomPrice,String RoomType){
		roomID=RoomID;
		roomType=RoomType;
		roomPrice=RoomPrice;
		peopleNumber=PeopleNumber;
		IsEmpty=false;
	}
	
	public int getRoomID(){
		return roomID;
	}
	
	public String getRoomType(){
		return roomType;
	}
	
	public double getRoomPrice(){
		return roomPrice;
	}
	
	public int getPeopleNumber(){
		return peopleNumber;
	}
	
	public boolean getIsEmpty(){
		return IsEmpty;
	}
	
	public void addRoom(){
		IsEmpty=true;
	}
}
