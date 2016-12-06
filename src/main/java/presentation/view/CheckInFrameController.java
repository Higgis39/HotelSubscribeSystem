package presentation.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * 
 * @author 费慧通
 *
 *CheckInFrame的监听
 */
public class CheckInFrameController {
	@FXML
	private CheckBox checkbox;
	@FXML
	private Label id;
	@FXML
	private TextField enterid;
	@FXML
	private TextField enterroomid;
	@FXML
	private TextField entercheckintime;
	@FXML
	private TextField entercheckouthour;
	@FXML
	private TextField entercheckoutminute;
	@FXML
	private DatePicker entercheckoutdate;
	
	private CheckInFrame checkinframe;
	
	@FXML
	/**
	 * 选择框的监听
	 */
	private void checkboxAction(){
		if(checkbox.isSelected()){
			id.setDisable(false);
			enterid.setDisable(false);
		}else{
			id.setDisable(true);
			enterid.setDisable(true);
		}
	}
	
	@FXML
	/**
	 * 获取当前时间的监听
	 */
	private void getnowAction(){
		Date now = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String time = format.format(now);
		entercheckintime.setText(time);
	}
	
	@FXML
	/**
	 * 确定按钮的监听
	 */
	private void confirmAction(){
		
	}
	
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		checkinframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		
	}

	public void setCheckInFrame(CheckInFrame checkinframe) {
		this.checkinframe = checkinframe;
	}

}