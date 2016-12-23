package presentation.view;

import java.sql.SQLException;

import businessLogic.userbl.AddHotelController;
import businessLogicService.userBLService.AddHotelBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.controller.FrameController;
import vo.FrameToFrameVO;
import vo.WorkerVO;

public class ChangeWorkerMessageFrameController {
	@FXML
	private Label name;
	@FXML
	private TextField age;
	@FXML
	private TextField sex;
	@FXML
	private TextField begindate;

	private ChangeWorkerMessageFrame changeworkermessageframe;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	private void confirmAction() throws SQLException{
		String n = name.getText();
		int a = Integer.valueOf(age.getText());
		String s = sex.getText();
		String b = begindate.getText();
		
		AddHotelBLService service = new AddHotelController();
		service.ChangeHotelWorkerMessage(FrameToFrameVO.gethotelid(), n, a, s, b);
		
		changeworkermessageframe.getPrimaryStage().close();
		FrameToFrameVO.setword("修改成功");
		viewcontrol.openSuccessSaveFrame();
	}
	
	@FXML
	private void CancelAction(){
		changeworkermessageframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		WorkerVO vo = FrameToFrameVO.getworkervo();
		name.setText(vo.getName());
		age.setText(Integer.toString(vo.getAge()));
		sex.setText(vo.getSex());
		begindate.setText(vo.getBeginTime());
	}
	
	public void setChangeWorkerMessageFrame(ChangeWorkerMessageFrame changeworkermessageframe){
		this.changeworkermessageframe = changeworkermessageframe;
	}
}
