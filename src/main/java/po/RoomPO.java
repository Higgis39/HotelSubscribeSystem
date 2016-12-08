package po;

public class RoomPO {
	String hotelName;
	int roomID;
	String roomType;
	double roomPrice;
	int peopleNumber;
	boolean IsEmpty;
	
	public RoomPO(){
		
	}
	
	public RoomPO(String HotelName, int RoomID,int PeopleNumber,double RoomPrice,String RoomType){
		hotelName=HotelName;
		roomID=RoomID;
		roomType=RoomType;
		roomPrice=RoomPrice;
		peopleNumber=PeopleNumber;
		IsEmpty=false;
	}
	
	public String getHotelName(){
		return hotelName;
		
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

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	public void setIsEmpty(boolean isEmpty) {
		IsEmpty = isEmpty;
	}
	
	
}
