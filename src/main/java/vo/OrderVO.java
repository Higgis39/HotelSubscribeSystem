package vo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import po.OrderPO;

public class OrderVO {
	private final StringProperty orderId;
	
	private final StringProperty hotelId;
	
	private final StringProperty userId;
	
	private final StringProperty status;
	
	private final StringProperty entryTime;
	
	private final StringProperty lastTime;
	
	private final StringProperty orderInfo;
	
	private final IntegerProperty price;
	
	private final StringProperty comment;
	
	
	public OrderVO(String orderId, String hotelId, String userId, String status,
			String entryTime, String lastTime,String orderInfo,int price,String comment) {
		super();
		this.orderId = new SimpleStringProperty(orderId);
		this.hotelId = new SimpleStringProperty(hotelId);
		this.userId = new SimpleStringProperty(userId);
		this.status = new SimpleStringProperty(status);
		this.entryTime = new SimpleStringProperty(entryTime);
		this.lastTime = new SimpleStringProperty(lastTime);
		this.orderInfo = new SimpleStringProperty(orderInfo);
		this.price = new SimpleIntegerProperty(price);
		this.comment = new SimpleStringProperty(comment);
	}
	
	public OrderVO(OrderPO po){
//		this.orderId = po.getId();
//		this.hotelId = po.getHotelId();
//		this.userId = po.getUserId();
//		this.status = po.getStatus();
//		this.entryTime = po.getEntryTime();
//		this.lastTime = po.getLastTime();
//		this.orderInfo = po.getOrderInfo();
//		this.price = po.getPrice();
//		this.comment = po.getComment();
		this(po.getId(),po.getHotelId(),po.getUserId(),po.getStatus(),po.getEntryTime(),po.getLastTime(),po.getOrderInfo(),po.getPrice(),po.getComment());
	}
	
	public String getorderId() {
		return orderId.get();
	}
	
	public StringProperty getorderIdProperty() {
		return orderId;
	}

	public String getHotelId() {
		return hotelId.get();
	}
	
	public StringProperty getHotelIdProperty(){
		return hotelId;
	}
	
	public String getUserId() {
		return userId.get();
	}
	
	public StringProperty getUserIdProperty(){
		return userId;
	}

	public String getStatus() {
		return status.get();
	}
	
	public StringProperty getStatusProperty() {
		return status;
	}

	public String getEntryTime() {
		return entryTime.get();
	}
	
	public StringProperty getEntryTimeProperty(){
		return entryTime;
	}

	public String getLastTime() {
		return lastTime.get();
	}
	
	public StringProperty getLastTimeProperty(){
		return lastTime;
	}
	
	public String getOrderInfo() {
		return orderInfo.get();
	}
	
	public StringProperty getOrderInfoProperty(){
		return orderInfo;
	}

	public int getPrice() {
		return price.get();
	}
	
	public IntegerProperty getPriceProperty(){
		return price;
	}

	public String getComment(){
		return comment.get();
	}
	
	public StringProperty getCommentProperty(){
		return comment;
	}
}
