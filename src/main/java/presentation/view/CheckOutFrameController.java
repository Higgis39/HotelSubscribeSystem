package presentation.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * 
 * @author 费慧通
 *
 *CheckOutFrame的监听
 */
public class CheckOutFrameController {
	@FXML
	private CheckBox checkbox;
	@FXML
	private Label id;
	@FXML
	private TextField enterid;
	@FXML
	private TextField enterroomid;
	@FXML
	private TextField entercheckouttime;
	
	private CheckOutFrame checkoutframe;
	
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
		entercheckouttime.setText(time);
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
		checkoutframe.getPrimaryStage().close();
	}
	
	@FXML
	private void initialize(){
		
	}

	public void setCheckOutFrame(CheckOutFrame checkoutframe) {
		this.checkoutframe = checkoutframe;
	}

}
