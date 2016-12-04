package presentation.view;

import javafx.fxml.FXML;
import presentation.controller.ViewController;

/**
 * 
 * @author 费慧通
 *
 *DoCancelPopup的控制器
 */
public class DoCancelPopupController {	
	private DoCancelPopup docancelpopup;
	
	ViewController viewcontrol = new ViewController();
	
	@FXML
	/**
	 * 确定按钮的监听
	 */
	private void confirmAction(){
		docancelpopup.getPrimaryStage().close();
//		try{
//			RegisterClientFrameController a = new RegisterClientFrameController();
//			a.registerclientframe.getPrimaryStage().close();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		viewcontrol.openLoginFrame();
	}
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		docancelpopup.getPrimaryStage().close();
	}
	
	public void setDoCancelPopup(DoCancelPopup docancelpopup){
		this.docancelpopup = docancelpopup;
	}
}
