package Hotel.update;

public class OrderPO {
	int id;
	String beginDate;
	String endDate;
	String CheckInTime;
	String CheckOutTime;
	String state;
	String hotel;
	double price;
	String comment;
	
	public OrderPO(int id, String beginDate, String endDate,String CheckInTime, String state,String hotel,double price,String comment){
		this.id = id;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.CheckInTime = CheckInTime;
		this.CheckOutTime = "";
		this.state = state;
		this.hotel = hotel;
		this.price = price;
		this.comment = comment;
	}

	public int getId() {
		return id;
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
}