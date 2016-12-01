package po;

/**
 * promotionPO的职责是保存持久对象，用来在业务逻辑层与数据层之间传递数据
 * @author hly
 * @version 1.0
 * @see
 */
public class HotelPromotionPO {

	String name;
	String introduction;
	boolean isbirthday;
	int numberofroom;
	boolean ispartner;
	String begintime;
	String endtime;
	
	public HotelPromotionPO(String name, String introduction, boolean isbirthday, int numberofroom, boolean ispartner,
			String begintime, String endtime) {
		super();
		this.name = name;
		this.introduction = introduction;
		this.isbirthday = isbirthday;
		this.numberofroom = numberofroom;
		this.ispartner = ispartner;
		this.begintime = begintime;
		this.endtime = endtime;
	}

	public HotelPromotionPO(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public boolean isIsbirthday() {
		return isbirthday;
	}

	public void setIsbirthday(boolean isbirthday) {
		this.isbirthday = isbirthday;
	}

	public int getNumberofroom() {
		return numberofroom;
	}

	public void setNumberofroom(int numberofroom) {
		this.numberofroom = numberofroom;
	}

	public boolean isIspartner() {
		return ispartner;
	}

	public void setIspartner(boolean ispartner) {
		this.ispartner = ispartner;
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
}
