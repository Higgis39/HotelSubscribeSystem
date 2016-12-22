package presentation.view;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import vo.FrameToFrameVO;

public class SuccessSaveFrameController {
	@FXML
	private Label word;
	
	private SuccessSaveFrame successsaveframe;
	
	@FXML
	/**
	 * 确定的按钮
	 */
	private void confirmAction(){
		successsaveframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		word.setText(FrameToFrameVO.getword());
	}
	
	public void setSuccessSaveFrame(SuccessSaveFrame successsaveframe){
		this.successsaveframe = successsaveframe;
	}
}
