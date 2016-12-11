package presentation.view;

import javafx.fxml.FXML;

public class NoEnoughCreditFrameController {

	private NoEnoughCreditFrame noenoughcreditframe;
	
	@FXML
	/**
	 * 确定的监听
	 */
	private void confirmAction(){
		noenoughcreditframe.getPrimaryStage().close();
	}
	
	public void setNoEnoughCreditFrame(NoEnoughCreditFrame noenoughcreditframe){
		this.noenoughcreditframe = noenoughcreditframe;
	}
}
