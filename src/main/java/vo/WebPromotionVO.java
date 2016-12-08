package vo;

public class WebPromotionVO {

	private String name;
	private String begintime;
	private String endtime;
	private String specificbusinessarea;
	private double discount;
	
	public WebPromotionVO(String name, String begintime, String endtime,
			String specificbusinessarea, double discount) {
		super();
		this.name = name;
		this.begintime = begintime;
		this.endtime = endtime;
		this.specificbusinessarea = specificbusinessarea;
		this.discount = discount;
	}

	public String getName() {
		return name;
	}

	public String getBegintime() {
		return begintime;
	}

	public String getEndtime() {
		return endtime;
	}

	public String getSpecificbusinessarea() {
		return specificbusinessarea;
	}

	public double getDiscount() {
		return discount;
	}
	
	
}
