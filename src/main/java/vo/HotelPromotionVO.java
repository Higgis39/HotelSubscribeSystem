package vo;

public class HotelPromotionVO {

	private String name;
	private String introduction;
	private boolean isbirthday;
	private int numberofroom;
	private boolean ispartner;
	private String begintime;
	private String endtime;
	private double discount;
	
	public HotelPromotionVO(String name, String introduction, boolean isbirthday, int numberofroom, boolean ispartner,
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

	public String getName() {
		return name;
	}

	public String getIntroduction() {
		return introduction;
	}

	public boolean isIsbirthday() {
		return isbirthday;
	}

	public int getNumberofroom() {
		return numberofroom;
	}

	public boolean isIspartner() {
		return ispartner;
	}

	public String getBegintime() {
		return begintime;
	}

	public String getEndtime() {
		return endtime;
	}	
	
	public double getDiscount() {
		return discount;
	}
}
