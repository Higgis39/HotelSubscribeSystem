package vo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RoomVO {
	private StringProperty roomtype;
	private IntegerProperty peoplenum;
	private IntegerProperty roomnum;
	private IntegerProperty roomprice;
	
	public RoomVO(){
		this(null,0,0,0);
	}

	public RoomVO(String roomtype,int peoplenum,int roomnum,int roomprice) {
		this.roomtype = new SimpleStringProperty(roomtype);
		this.peoplenum = new SimpleIntegerProperty(peoplenum);
		this.roomnum = new SimpleIntegerProperty(roomnum);
		this.roomprice = new SimpleIntegerProperty(roomprice);
	}
	
	public String getroomtype(){
		return roomtype.get();
	}
	
	public StringProperty roomtypeProperty(){
		return roomtype;
	}
	
	public int getpeoplenum(){
		return peoplenum.get();
	}
	
	public IntegerProperty peoplenumProperty(){
		return peoplenum;
	}
	
	public int getroomnum(){
		return roomnum.get();
	}
	
	public IntegerProperty roomnumProperty(){
		return roomnum;
	}
	
	public int getroomprice(){
		return roomprice.get();
	}
	
	public IntegerProperty roompriceProperty(){
		return roomprice;
	}
}
