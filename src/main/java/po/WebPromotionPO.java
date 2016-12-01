package po;

public class WebPromotionPO {

	String name;
	String introduction;
	String begintime;
	String endtime;
	String specificbusinessarea;
	
	public WebPromotionPO(String name, String introduction, String begintime, String endtime,
			String specificbusinessarea) {
		super();
		this.name = name;
		this.introduction = introduction;
		this.begintime = begintime;
		this.endtime = endtime;
		this.specificbusinessarea = specificbusinessarea;
	}
	
	public WebPromotionPO(){
		
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

	public String getSpecificbusinessarea() {
		return specificbusinessarea;
	}

	public void setSpecificbusinessarea(String specificbusinessarea) {
		this.specificbusinessarea = specificbusinessarea;
	}
	
	
}
