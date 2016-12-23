package presentation.view;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import businessLogic.hotelbl.UpdateController;
import businessLogic.orderbl.CustomerViewOrderController;
import businessLogic.orderbl.ExcuteOrderController;
import businessLogicService.hotelBLService.UpdateService;
import businessLogicService.orderBLService.CustomerViewOrderService;
import businessLogicService.orderBLService.ExcuteOrderService;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.controller.FrameController;
import vo.FrameToFrameVO;
import vo.OrderVO;


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
	private ComboBox<String> roomtype;
	@FXML
	private Label id;
	@FXML
	private Label rt;
	@FXML
	private Label rn;
	@FXML
	private TextField enterid;
	@FXML
	private TextField enterroomnum;
	@FXML
	private TextField entercheckintime;
	@FXML
	private TextField entercheckouthour;
	@FXML
	private TextField entercheckoutminute;
	@FXML
	private DatePicker entercheckoutdate;
	
	private CheckInFrame checkinframe;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * 选择框的监听
	 */
	private void checkboxAction(){
		if(checkbox.isSelected()){
			id.setDisable(false);
			enterid.setDisable(false);
			rt.setDisable(true);
			rn.setDisable(true);
			roomtype.setDisable(true);
			enterroomnum.setDisable(true);
		}else{
			id.setDisable(true);
			enterid.setDisable(true);
			rt.setDisable(false);
			rn.setDisable(false);
			roomtype.setDisable(false);
			enterroomnum.setDisable(false);
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
	private void confirmAction() throws NumberFormatException, SQLException{
		if(checkbox.isSelected()){
			String id = enterid.getText();
			String intime = entercheckintime.getText();
			String outtime = entercheckoutdate.getValue().toString()+" "+entercheckouthour.getText()+":"+entercheckoutminute.getText();
			CustomerViewOrderService s = new CustomerViewOrderController();
			OrderVO ordervo = s.ShowOrderMessage(id);
			ordervo.setEntryTime(intime);
			ordervo.setlastTime(outtime);
			ExcuteOrderService service = new ExcuteOrderController();
			service.CheckIn(ordervo);
		}else{
			String room = roomtype.getSelectionModel().getSelectedItem();
			String roomnum = enterroomnum.getText();
			UpdateService service = new UpdateController();
			service.CheckIn(FrameToFrameVO.getHotelname(),room,Integer.valueOf(roomnum));
		}
		checkinframe.getPrimaryStage().close();
		FrameToFrameVO.setword("登记成功");
		viewcontrol.openSuccessSaveFrame();
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
		roomtype.getItems().addAll("单人间","标准间","家庭套房");
	}

	public void setCheckInFrame(CheckInFrame checkinframe) {
		this.checkinframe = checkinframe;
	}

}
