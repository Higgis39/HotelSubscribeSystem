package presentation.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import presentation.controller.FrameController;
import vo.IdVO;

public class SuccessRegisterFrameController {
	@FXML
	private Label id;

	private SuccessRegisterFrame successregisterframe;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * 转去登录的监听
	 */
	private void confirmAction(){
		viewcontrol.openLoginFrame();
		successregisterframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		id.setText(IdVO.getid());
	}
	
	public void setSuccessRegisterFrame(SuccessRegisterFrame successregisterframe){
		this.successregisterframe = successregisterframe;
	}
}
