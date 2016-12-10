package vo;
import po.OrderPO;
           /**
            * id			订单编号
            * hotelId		酒店编号
            * userId		用户编号
            * status		订单状态(已执行；未执行；已撤销；异常；已评价)
            * entryTime	        用户入住时间/用户预计入住时间
            * lastTime		用户退房时间/用户预计退房时间
            * price		        订单价值
            * comment       订单评价
            */
public class OrderVO {
<<<<<<< HEAD
	private StringProperty orderId;
	
	private StringProperty hotelId;
	
	private StringProperty userId;
	
	private StringProperty status;
	
	private StringProperty entryTime;
	
	private StringProperty lastTime;
	
	private IntegerProperty price;
	
	private StringProperty comment;
	
	
	public OrderVO(String orderId, String hotelId, String userId, String status,
			String entryTime, String lastTime,int price,String comment) {
		super();
		this.orderId = new SimpleStringProperty(orderId);
		this.hotelId = new SimpleStringProperty(hotelId);
		this.userId = new SimpleStringProperty(userId);
		this.status = new SimpleStringProperty(status);
		this.entryTime = new SimpleStringProperty(entryTime);
		this.lastTime = new SimpleStringProperty(lastTime);
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
		this(po.getId(),po.getHotelId(),po.getUserId(),po.getStatus(),po.getEntryTime(),po.getLastTime(),po.getPrice(),po.getComment());
=======
	private String orderId;
	
	private String hotelId;
	
	private String userId;
	
	private String status;
	
	private String entryTime;
	
	private String lastTime;
	
	private int price;
	
	private String comment;
	
	private String RoomType;
	
	private int RoomNum;
	
	
	public OrderVO(String orderId, String hotelId, String userId, String status,
			String entryTime, String lastTime,int price,String comment,String RoomType,int RoomNum) {
		super();
		this.orderId = orderId;
		this.hotelId = hotelId;
		this.userId = userId;
		this.status = status;
		this.entryTime = entryTime;
		this.lastTime = lastTime;
		this.price = price;
		this.comment = comment;
		this.RoomType = RoomType;
		this.RoomNum = RoomNum;
	}
	
	public OrderVO(OrderPO po){
		this.orderId = po.getId();
		this.hotelId = po.getHotelId();
		this.userId = po.getUserId();
		this.status = po.getStatus();
		this.entryTime = po.getEntryTime();
		this.lastTime = po.getLastTime();
		this.price = po.getPrice();
		this.comment = po.getComment();
		this.RoomType = po.getRoomType();
		this.RoomNum = po.getRoomNum();
>>>>>>> origin/master
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

	public int getPrice() {
		return price;
	}

	public String getComment(){
		return comment;
	}

	public String getRoomType() {
		return RoomType;
	}

	public void setRoomType(String roomType) {
		RoomType = roomType;
	}

	public int getRoomNum() {
		return RoomNum;
	}

	public void setRoomNum(int roomNum) {
		RoomNum = roomNum;
	}
}
