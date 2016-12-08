package vo;

public class HotelPromotionVO {

	private String hotelname;
	private String name;
	private boolean isbirthday;
	private int numberofroom;
	private boolean ispartner;
	private String begintime;
	private String endtime;
	private double discount;
	
	public HotelPromotionVO(String hotelname, String name, boolean isbirthday, int numberofroom, boolean ispartner,
			String begintime, String endtime, double discount) {
		super();
		this.hotelname = hotelname;
		this.name = name;
		this.isbirthday = isbirthday;
		this.numberofroom = numberofroom;
		this.ispartner = ispartner;
		this.begintime = begintime;
		this.endtime = endtime;
		this.discount = discount;
	}

	public String getHotelname() {
		return hotelname;
	}


	public String getName() {
		return name;
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
