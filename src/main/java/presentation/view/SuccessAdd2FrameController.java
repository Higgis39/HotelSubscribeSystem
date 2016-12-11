package presentation.view;

import javafx.fxml.FXML;
import presentation.controller.FrameController;
import vo.OtherIdVO;

public class SuccessAdd2FrameController {

	private SuccessAdd2Frame successadd2frame;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * 确定的监听
	 */
	private void confirmAction(){
		successadd2frame.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		
	}
	
	public void setSuccessAdd2Frame(SuccessAdd2Frame successadd2frame){
		this.successadd2frame = successadd2frame;
	}
}
