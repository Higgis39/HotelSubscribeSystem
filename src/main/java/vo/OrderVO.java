package vo;
import po.OrderPO;
public class OrderVO {
	private String orderId;
	
	private String hotelId;
	
	private String userId;
	
	private String status;
	
	private String entryTime;
	
	private String lastTime;
	
	private String orderInfo;
	
	private int price;
	
	private String comment;
	
	
	public OrderVO(String orderId, String hotelId, String userId, String status,
			String entryTime, String lastTime,String orderInfo,int price,String comment) {
		super();
		this.orderId = orderId;
		this.hotelId = hotelId;
		this.userId = userId;
		this.status = status;
		this.entryTime = entryTime;
		this.lastTime = lastTime;
		this.orderInfo = orderInfo;
		this.price = price;
		this.comment = comment;
	}
	
	public OrderVO(OrderPO po){
		this.orderId = po.getId();
		this.hotelId = po.getHotelId();
		this.userId = po.getUserId();
		this.status = po.getStatus();
		this.entryTime = po.getEntryTime();
		this.lastTime = po.getLastTime();
		this.orderInfo = po.getOrderInfo();
		this.price = po.getPrice();
		this.comment = po.getComment();
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

	public String getStatus() {
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

	public int getPrice() {
		return price;
	}

	public String getComment(){
		return comment;
	}
}
