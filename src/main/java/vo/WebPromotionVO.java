package vo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class WebPromotionVO {

	private final StringProperty name;
	private final StringProperty begintime;
	private final StringProperty endtime;
	private final StringProperty specificbusinessarea;
	private final IntegerProperty VIPgrade;
	private final DoubleProperty discount;
	
	public WebPromotionVO(String name, String begintime, String endtime,
			String specificbusinessarea, int VIPgrade, double discount) {
		super();
		this.name = new SimpleStringProperty(name);
		this.begintime = new SimpleStringProperty(begintime);
		this.endtime = new SimpleStringProperty(endtime);
		this.specificbusinessarea = new SimpleStringProperty(specificbusinessarea);
		this.VIPgrade = new SimpleIntegerProperty(VIPgrade);
		this.discount = new SimpleDoubleProperty(discount);
	}

	public String getName() {
		return name.get();
	}
	
	public StringProperty getNameProperty(){
		return name;
	}

	public String getBegintime() {
		return begintime.get();
	}
	
	public StringProperty getBegintimeProperty(){
		return begintime;
	}

	public String getEndtime() {
		return endtime.get();
	}
	
	public StringProperty getEndtimeProperty(){
		return endtime;
	}

	public String getSpecificbusinessarea() {
		return specificbusinessarea.get();
	}
	
	public StringProperty getSpecificbusinessareaProperty(){
		return specificbusinessarea;
	}

	public int getVIPgrade(){
		return VIPgrade.get();
	}
	
	public IntegerProperty getVIPgradeProperty(){
		return VIPgrade;
	}
	
	public double getDiscount() {
		return discount.get();
	}
	
	public DoubleProperty getDiscountProperty(){
		return discount;
	}
}
