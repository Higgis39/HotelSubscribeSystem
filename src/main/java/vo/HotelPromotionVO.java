package vo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HotelPromotionVO {
	private final StringProperty hotelname;
	private final StringProperty name;
	private final StringProperty isbirthday;
	private final IntegerProperty numberofroom;
	private final StringProperty ispartner;
	private final StringProperty begintime;
	private final StringProperty endtime;
	private final DoubleProperty discount;
	
	public HotelPromotionVO(String hotelname,String name, boolean isbirthday, int numberofroom, boolean ispartner,
			String begintime, String endtime,double discount) {
		super();
		this.hotelname = new SimpleStringProperty(hotelname);
		this.name = new SimpleStringProperty(name);
		if(isbirthday==true){
			this.isbirthday = new SimpleStringProperty("有");
		}else{
			this.isbirthday = new SimpleStringProperty("无");
		}
		this.numberofroom = new SimpleIntegerProperty(numberofroom);
		if(ispartner==true){
			this.ispartner = new SimpleStringProperty("有");
		}else{
			this.ispartner = new SimpleStringProperty("无");
		}
		this.begintime = new SimpleStringProperty(begintime);
		this.endtime = new SimpleStringProperty(endtime);
		this.discount = new SimpleDoubleProperty(discount);
	}
	
	public String getHotelName() {
		return hotelname.get();
	}
	
	public StringProperty getHotelNameProperty(){
		return hotelname;
	}

	public String getName() {
		return name.get();
	}
	
	public StringProperty getNameProperty(){
		return name;
	}

	public boolean getisIsbirthday() {
		if(isbirthday.get().equals("有")){
			return true;
		}else{
			return false;
		}
	}
		
	public StringProperty getisbirthdayProperty(){
		return isbirthday;
	}

	public int getNumberofroom() {
		return numberofroom.get();
	}
	
	public IntegerProperty getNumberofroomProperty(){
		return numberofroom;
	}

	public boolean getisIspartner() {
		if(ispartner.get().equals("有")){
			return true;
		}else{
			return false;
		}
	}
	
	public StringProperty getisIspartnerProperty() {
		return ispartner;
	}

	public String getBegintime() {
		return begintime.get();
	}
	
	public StringProperty getBegintimeProperty(){
		return begintime;
	}
	
	public String getEndtime(){
		return endtime.get();
	}

	public StringProperty getEndtimeProperty() {
		return endtime;
	}	
	
	public double getDiscount() {
		return discount.get();
	}
	
	public DoubleProperty getDiscountProperty(){
		return discount;
	}
}
