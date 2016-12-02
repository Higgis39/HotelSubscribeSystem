package presentation.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ViewCreditChangeFrameController {
	@FXML
	private Button confirm;
	
	private ViewCreditChangeFrame viewcreditchangeframe;
	
	@FXML
	private void confirmAction(){
		viewcreditchangeframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		
	}

	public void setUserPersonalFrame(ViewCreditChangeFrame viewcreditchangeframe) {
		this.viewcreditchangeframe = viewcreditchangeframe;
	}

}
