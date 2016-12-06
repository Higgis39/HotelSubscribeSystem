package po;

public class OrderPO {
	/**
	 * id			订单编号
	 * hotelId		酒店编号
	 * userId		用户编号
	 * status		订单状态（0：未执行订单；1：已执行订单；2：异常订单）
	 * entryTime	用户入住时间
	 * lastTime		订单最晚执行时间
	 * orderInfo	订单详情
	 * price		订单价值
	 */
		
		private String id;
		
		private String hotelId;
		
		private String userId;
		
		private String status;
		
		private String entryTime;
		
		private String lastTime;
		
		private String orderInfo;
		
		private int price;
		
		private String comment;
		
		public OrderPO(){
			super();
		}

		public OrderPO(String id, String hotelId, String userId, String status,
				String entryTime, String lastTime,String orderInfo,int price,String comment) {
			super();
			this.id = id;
			this.hotelId = hotelId;
			this.userId = userId;
			this.status = status;
			this.entryTime = entryTime;
			this.lastTime = lastTime;
			this.orderInfo = orderInfo;
			this.price = price;
			this.comment = comment;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getHotelId() {
			return hotelId;
		}

		public void setHotelId(String hotelId) {
			this.hotelId = hotelId;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getEntryTime() {
			return entryTime;
		}

		public void setEntryTime(String entryTime) {
			this.entryTime = entryTime;
		}

		public String getLastTime() {
			return lastTime;
		}

		public void setLastTime(String lastTime) {
			this.lastTime = lastTime;
		}
		
		public String getOrderInfo() {
			return orderInfo;
		}

		public void setOrderInfo(String orderInfo) {
			this.orderInfo = orderInfo;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getComment(){
			return comment;
		}
		
		public void setComment(String Comment){
			this.comment=Comment;
		}
}
