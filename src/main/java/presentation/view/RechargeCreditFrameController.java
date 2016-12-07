package presentation.view;

import businessLogic.userbl.RechargeCreditController;
import businessLogicService.userBLService.RechargeCreditBLService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * 
 * @author 费慧通
 *
 *RechargeCreditFrame的监听
 */
public class RechargeCreditFrameController {
	@FXML
	private TextField enterid;
	@FXML
	private TextField enterrecharge;
	
	private RechargeCreditFrame rechargecreditframe;
	
	RechargeCreditBLService service = new RechargeCreditController();
	
	@FXML
	/**
	 * 确定按钮的监听
	 */
	private void confirmAction(){
		String id = enterid.getText();
		int creditrecharge = Integer.valueOf(enterrecharge.getText());
		service.RechargeCredit("网站营销人员",id,creditrecharge);
	}
	
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		rechargecreditframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		
	}

	public void setRechargeCreditFrame(RechargeCreditFrame rechargecreditframe){
		this.rechargecreditframe = rechargecreditframe;
	}
}
