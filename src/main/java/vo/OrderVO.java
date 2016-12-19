package vo;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import po.OrderPO;


/**
 * 
 * @author Administrator
 *
 *界面与逻辑之间传输的订单信息
 */
public class OrderVO {
	private StringProperty orderId;
	
	private StringProperty hotelId;
	
	private StringProperty userId;
	
	private StringProperty status;
	
	private StringProperty entryTime;
	
	private StringProperty lastTime;
	
	private DoubleProperty price;
	
	private StringProperty comment;
	
	private StringProperty roomtype;
	
	private IntegerProperty roomnum;
	
	
	public OrderVO(String orderId, String hotelId, String userId, String status,String entryTime, String lastTime,double price,String comment,String roomtype,int roomnum) {
		super();
		this.orderId = new SimpleStringProperty(orderId);
		this.hotelId = new SimpleStringProperty(hotelId);
		this.userId = new SimpleStringProperty(userId);
		this.status = new SimpleStringProperty(status);
		this.entryTime = new SimpleStringProperty(entryTime);
		this.lastTime = new SimpleStringProperty(lastTime);
		this.price = new SimpleDoubleProperty(price);
		this.comment = new SimpleStringProperty(comment);
		this.roomtype = new SimpleStringProperty(roomtype);
		this.roomnum = new SimpleIntegerProperty(roomnum);
	}
	
	public OrderVO(OrderPO po){
		this(po.getId(),po.getHotelId(),po.getUserId(),po.getStatus(),po.getEntryTime(),po.getLastTime(),po.getPrice(),po.getComment(),po.getRoomType(),po.getRoomNum());
	}
	
	public String getorderId() {
		return orderId.get();
	}
	
	public StringProperty getorderIdProperty(){
		return orderId;
	}
	
	public void setorderid(String orderId){
		this.orderId = new SimpleStringProperty(orderId);
	}

	public String getHotelId() {
		return hotelId.get();
	}
	
	public StringProperty getHotelIdProperty(){
		return hotelId;
	}
	
	public void sethotelid(String hotelId){
		this.hotelId = new SimpleStringProperty(hotelId);
	}
	
	public String getUserId() {
		return userId.get();
	}
	
	public StringProperty getUserIdProperty(){
		return userId;
	}
	
	public void setuserid(String UserId){
		this.userId = new SimpleStringProperty(UserId);
	}

	public String getStatus() {
		return status.get();
	}
	
	public StringProperty getStatusProperty(){
		return status;
	}
	
	public void setStatus(String status){
		this.status = new SimpleStringProperty(status);
	}

	public String getEntryTime() {
		return entryTime.get();
	}
	
	public StringProperty getEntryTimeProperty(){
		return entryTime;
	}
	
	public void setEntryTime(String entryTime){
		this.entryTime = new SimpleStringProperty(entryTime);
	}

	public String getLastTime() {
		return lastTime.get();
	}
	
	public StringProperty getLastTimeProperty(){
		return lastTime;
	}
	
	public void setlastTime(String lastTime){
		this.lastTime = new SimpleStringProperty(lastTime);
	}

	public double getPrice() {
		return price.get();
	}
	
	public DoubleProperty getPriceProperty(){
		return price;
	}
	
	public void setprice(double price){
		this.price = new SimpleDoubleProperty(price);
	}

	public String getComment(){
		return comment.get();
	}
	
	public StringProperty getcommentProperty(){
		return comment;
	}
	
	public void setcomment(String comment){
		this.comment = new SimpleStringProperty(comment);
	}

	public String getRoomType() {
		return roomtype.get();
	}
	
	public StringProperty getRoomTypeProperty(){
		return roomtype;
	}

	public void setRoomType(String roomType) {
		this.roomtype = new SimpleStringProperty(roomType);
	}

	public int getRoomNum() {
		return roomnum.get();
	}
	
	public IntegerProperty getRoomNumProperty(){
		return roomnum;
	}

	public void setRoomNum(int roomNum) {
		this.roomnum = new SimpleIntegerProperty(roomNum);
	}
}
