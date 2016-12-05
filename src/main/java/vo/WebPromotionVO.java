package vo;

public class WebPromotionVO {

	private String name;
	private String introduction;
	private String begintime;
	private String endtime;
	private String specificbusinessarea;
	private double discount;
	
	public WebPromotionVO(String name, String introduction, String begintime, String endtime,
			String specificbusinessarea) {
		super();
		this.name = name;
		this.introduction = introduction;
		this.begintime = begintime;
		this.endtime = endtime;
		this.specificbusinessarea = specificbusinessarea;
	}

	public String getName() {
		return name;
	}

	public String getIntroduction() {
		return introduction;
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
