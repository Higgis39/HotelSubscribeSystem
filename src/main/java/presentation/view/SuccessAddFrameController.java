package presentation.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import presentation.controller.FrameController;
import vo.WordVO;

public class SuccessAddFrameController {
	@FXML
	private Label word;

	private SuccessAddFrame successaddframe;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * 确定的监听
	 */
	private void confirmAction(){
		successaddframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		word.setText(WordVO.getword());
	}
	
	public void setSuccessAddFrame(SuccessAddFrame successaddframe){
		this.successaddframe = successaddframe;
	}
}
