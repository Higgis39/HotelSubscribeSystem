package presentation.view;

import javafx.fxml.FXML;

public class SuccessSaveFrameController {
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
		
	}
	
	public void setSuccessSaveFrame(SuccessSaveFrame successsaveframe){
		this.successsaveframe = successsaveframe;
	}
}
