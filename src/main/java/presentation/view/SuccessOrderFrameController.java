package presentation.view;

import javafx.fxml.FXML;

public class SuccessOrderFrameController {

	private SuccessOrderFrame successorderframe;
	
	@FXML
	/**
	 * 确定的监听
	 */
	private void confirmAction(){
		successorderframe.getPrimaryStage().close();
	}

	public void setSuccessOrderFrame(SuccessOrderFrame successOrderFrame2) {
		// TODO Auto-generated method stub
		successorderframe = successOrderFrame2;
	}

}
