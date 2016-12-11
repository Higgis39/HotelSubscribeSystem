package presentation.view;

import javafx.fxml.FXML;
import presentation.controller.FrameController;
import vo.StageVO;

/**
 * 
 * @author 费慧通
 *
 *DoCancelPopup的控制器
 */
public class DoCancelFrameController {	
	private DoCancelFrame docancelpopup;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * 确定按钮的监听
	 */
	private void confirmAction(){
		docancelpopup.getPrimaryStage().close();
		StageVO.getSatge().close();
		viewcontrol.openLoginFrame();
	}
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		docancelpopup.getPrimaryStage().close();
	}
	
	public void setDoCancelPopup(DoCancelFrame docancelpopup){
		this.docancelpopup = docancelpopup;
	}
}
