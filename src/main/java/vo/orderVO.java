package vo;

public class OrderVO {
	private String orderId;
	private String hotelId;
	private String userId;
	private int status;
	private String entryTime;
	private String lastTime;
	private String orderInfo;
	private double price;
	
	public OrderVO(String orderId, String hotelId, String userId, int status,
			String entryTime, String lastTime,String orderInfo,double price) {
		super();
		this.orderId = orderId;
		this.hotelId = hotelId;
		this.userId = userId;
		this.status = status;
		this.entryTime = entryTime;
		this.lastTime = lastTime;
		this.orderInfo = orderInfo;
		this.price = price;
	}
	
	public String getorderId() {
		return orderId;
	}

	public String getHotelId() {
		return hotelId;
	}
	
	public String getUserId() {
		return userId;
	}

	public int getStatus() {
		return status;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public String getLastTime() {
		return lastTime;
	}
	
	public String getOrderInfo() {
		return orderInfo;
	}

	public double getPrice() {
		return price;
	}
}
