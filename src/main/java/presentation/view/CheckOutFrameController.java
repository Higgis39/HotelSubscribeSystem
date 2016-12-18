package presentation.view;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import businessLogic.hotelbl.UpdateController;
import businessLogicService.hotelBLService.UpdateService;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.controller.FrameController;
import vo.HotelNameVO;


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
	private ComboBox<String> roomtype;
	@FXML
	private Label id;
	@FXML
	private TextField enterid;
	@FXML
	private TextField enterroomnum;
	@FXML
	private TextField entercheckouttime;
	
	private CheckOutFrame checkoutframe;
	
	FrameController viewcontrol = new FrameController();
	
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
	private void confirmAction() throws SQLException{
		UpdateService service = new UpdateController();
		int num = Integer.valueOf(enterroomnum.getText());
		String room = roomtype.getSelectionModel().getSelectedItem();
		if(checkbox.isSelected()){
			String id = enterid.getText();
			String outtime = entercheckouttime.getText();
			service.CheckOut(HotelNameVO.getHotelname(),id,room,num,outtime);
		}else{
			service.CheckOut(HotelNameVO.getHotelname(),room,num);
		}
		checkoutframe.getPrimaryStage().close();
		viewcontrol.openSuccessSaveFrame();
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
		roomtype.getItems().addAll("单人间","标准间","家庭套房");
	}

	public void setCheckOutFrame(CheckOutFrame checkoutframe) {
		this.checkoutframe = checkoutframe;
	}

}
