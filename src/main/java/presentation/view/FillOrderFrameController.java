package presentation.view;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * 
 * @author 费慧通
 *
 *FillOrderFrame的监听
 */
public class FillOrderFrameController {
	@FXML
	private Label hotelname;
	@FXML
	private Label price;
	@FXML
	private ComboBox<String> enterroomtype;
	@FXML
	private ComboBox<String> enterhaschild;
	@FXML
	private DatePicker enterindate;
	@FXML
	private DatePicker enteroutdate;
	@FXML
	private TextField enterroomnum;
	@FXML
	private TextField enterpeoplenum;
	@FXML
	private Label indateword;
	@FXML
	private Label outdateword;
	@FXML
	private Label roomtypeword;
	@FXML
	private Label haschildword;
	
	private FillOrderFrame fillorderframe;
	
	@FXML
	/**
	 * 入住日期的监听
	 */
	private void enterindateAction(){
		if(enterindate.getValue().isBefore(LocalDate.now())){
			enterindate.setValue(LocalDate.now());
			enteroutdate.setValue(LocalDate.now().plusDays(1));
			indateword.setText("入住日期不能晚于当前日期");
		}else{
			enteroutdate.setValue(enterindate.getValue().plusDays(1));
			indateword.setText(null);
		}
	}
	
	@FXML
	/**
	 * 退房日期的监听
	 */
	private void enteroutdateAction(){
		LocalDate indate = enterindate.getValue();
		if(enteroutdate.getValue().isEqual(indate)&&enteroutdate.getValue().isBefore(indate)){
			enteroutdate.setValue(indate.plusDays(1));
			outdateword.setText("退房日期不能晚于入住日期");
		}else{
			outdateword.setText(null);
		}
	}
	
	@FXML
	/**
	 * 房间数量右侧+号按钮的监听
	 */
	private void roomnumplusAction(){
		int num = Integer.valueOf(enterroomnum.getText());
		num++;
		enterroomnum.setText(Integer.toString(num));
	}
	
	@FXML
	/**
	 * 房间数量右侧-号按钮的监听
	 */
	private void roomnumminusAction(){
		int num = Integer.valueOf(enterroomnum.getText());
		if(num>1){
			num--;
		}
		enterroomnum.setText(Integer.toString(num));
	}
	
	@FXML
	/**
	 * 入住人数右侧+号按钮的监听
	 */
	private void peoplenumplusAction(){
		int num = Integer.valueOf(enterpeoplenum.getText());
		num++;
		enterpeoplenum.setText(Integer.toString(num));
	}
	
	@FXML
	/**
	 * 入住人数右侧-号按钮的监听
	 */
	private void peoplenumminusAction(){
		int num = Integer.valueOf(enterpeoplenum.getText());
		if(num>1){
			num--;
		}
		enterpeoplenum.setText(Integer.toString(num));
	}
	
	@FXML
	/**
	 * 下单按钮的监听
	 */
	private void confirmAction(){
		String roomtype = enterroomtype.getSelectionModel().getSelectedItem();
		LocalDate indate = enterindate.getValue();
		LocalDate outdate = enteroutdate.getValue();
		int roomnum = Integer.valueOf(enterroomnum.getText());
		int peoplenum = Integer.valueOf(enterpeoplenum.getText());
		String haschild = enterhaschild.getSelectionModel().getSelectedItem();
		if(roomtype==null){
			roomtypeword.setText("您必须选择房间类型");
		}else{
			roomtypeword.setText(null);
		}
		if(haschild==null){
			haschildword.setText("您必须填写有无儿童");
		}else{
			haschildword.setText(null);
		}
	}
	
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		fillorderframe.getPrimaryStage().close();
		//返回之前的界面
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		enterroomtype.getItems().addAll("单人间","双人间","三人间");
		enterindate.setValue(LocalDate.now());
		enteroutdate.setValue(LocalDate.now().plusDays(1));
		enterhaschild.getItems().addAll("有","没有");
	}

	public void setFillOrderFrame(FillOrderFrame fillorderframe) {
		this.fillorderframe = fillorderframe;
	}
}
