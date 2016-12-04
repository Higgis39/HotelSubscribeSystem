package presentation.view;

import javafx.fxml.FXML;


/**
 * 
 * @author 费慧通
 *
 *ViewCreditChange的界面
 */
public class ViewCreditChangeFrameController {
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
