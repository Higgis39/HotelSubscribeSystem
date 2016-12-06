package po;

public class OrderPO {
    private String orderId;
	private String hotelId;
	private String userId;
	private int status;
	private String entryTime;
	private String lastTime;
	private String orderInfo;
	private double price;
	
	public OrderPO(String orderId, String hotelId, String userId, int status,
			String entryTime, String lastTime,String orderInfo,double price) {
		this.orderId = orderId;
		this.hotelId = hotelId;
		this.userId = userId;
		this.status = status;
		this.entryTime = entryTime;
		this.lastTime = lastTime;
		this.orderInfo = orderInfo;
		this.price = price;
	}
	
	public OrderPO(){
		
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

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderPO [orderId=" + orderId + ", hotelId=" + hotelId + ", userId=" + userId + ", status=" + status
				+ ", entryTime=" + entryTime + ", lastTime=" + lastTime + ", orderInfo=" + orderInfo + ", price="
				+ price + "]";
	}

	
}
