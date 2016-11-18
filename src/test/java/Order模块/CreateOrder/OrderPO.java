package Order模块.CreateOrder;

import Order模块.CommentOrder.MockPromotionPO;

public class OrderPO {
	int RoomNum;
	String beginDate;
	String endDate;
	String CheckInTime;
	String CheckOutTime;
	String state;
	String hotel;
	double price;
	String comment;
	String OrderID;
	String UserID;
		
	public OrderPO(String id, String beginDate, String endDate,String hotel,double price){
		this.UserID = id;
		this.beginDate = beginDate;
		this.endDate = endDate;;
		this.CheckOutTime = "";
		this.hotel = hotel;
		this.price = price;
	}

	public String getUserID() {
		return UserID;
	}
	
	public int getRoomNum(){
		return RoomNum;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getCheckInTime() {
		return CheckInTime;
	}
		
	public String getCheckOutTime() {
		return CheckOutTime;
	}

	public String getState() {
		return state;
	}

	public String getHotel() {
		return hotel;
	}

	public double getPrice() {
		return price;
	}

	public String getComment() {
		return comment;
	}
		
	public void update(String checkOutTime){
		CheckOutTime=checkOutTime;
	}
	
	public String getOrderID(){
		return OrderID;
	}
	
	public MockPromotionPO getPromotion(){
		return new MockPromotionPO();
	}
}

