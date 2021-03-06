package presentation.view;

import java.time.LocalDate;

import businessLogic.userbl.AddHotelController;
import businessLogicService.userBLService.AddHotelBLService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import presentation.controller.FrameController;
import vo.FrameToFrameVO;
import vo.WorkerVO;

/**
 * 
 * @author 费慧通
 *
 *AddHotelWorkerFrame的监听
 */
public class AddHotelWorkerFrameController {
	@FXML
	private TextField enterhotelname;
	@FXML
	private TextField enterworkername;
	@FXML
	private TextField enterage;
	@FXML
	private TextField enterdate;
	@FXML
	private ComboBox<String> entersex;

	private AddHotelWorkerFrame addhotelworkerframe;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * 获得当前日期的监听
	 */
	private void getnowAction(){
		String now = LocalDate.now().toString();
		enterdate.setText(now);
	}
	
	@FXML
	/**
	 * 确定按钮的监听
	 */
	private void confirmAction(){
		String hotelname = enterhotelname.getText();
		String workername = enterworkername.getText();
		int age = Integer.valueOf(enterage.getText());
		String sex = entersex.getSelectionModel().getSelectedItem();
		String begindate = enterdate.getText();
		AddHotelBLService addhotelblservice = new AddHotelController();
		boolean result = addhotelblservice.AddHotelWorker(new WorkerVO(hotelname,workername,age,sex,begindate));
		if(result==true){
			addhotelworkerframe.getPrimaryStage().close();
			FrameToFrameVO.setword("添加成功！");
			viewcontrol.openSuccessSaveFrame();
		}
	}
	
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		addhotelworkerframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		entersex.getItems().addAll("男","女");
	}
	
	public void setAddHotelWorkerFrame(AddHotelWorkerFrame addhotelworkerframe){
		this.addhotelworkerframe = addhotelworkerframe;
	}
}
