package presentation.view;

import businessLogic.userbl.ManageUserController;
import businessLogic.userbl.MessageController;
import businessLogicService.userBLService.MessageBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import presentation.controller.ViewController;
import vo.IdVO;
import vo.UserVO;


/**
 * 
 * @author 费慧通
 *
 *MarketerMainFrame的监听
 */
public class MarketerMainFrameController {
	@FXML
	private Label id;
	@FXML
	private Label name;

	private MarketerMainFrame marketermainframe;
	
	ViewController viewcontrol = new ViewController();
	
	ManageUserController manageruser = new ManageUserController();
	
	@FXML
	/**
	 * 促销策略的监听
	 */
	private void promotionAction(){
		//打开网站营销人员促销策略界面
		viewcontrol.openMarketerPromotionFrame();
		marketermainframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 处理订单申诉的监听
	 */
	private void orderappealAction(){
		//打开处理订单申诉界面
		viewcontrol.openOrderAppealFrame();
	}
	
	@FXML
	/**
	 * 充值信用的监听
	 */
	private void rechargecreditAction(){
		//打开充值信用界面
		viewcontrol.openRechargeCreditFrame();
	}
	
	@FXML
	/**
	 * 退出登录的监听
	 */
	private void logoutAction(){
		viewcontrol.openLoginFrame();
		marketermainframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		MessageBLService service = new MessageController();
		UserVO uservo = service.GetMessage(IdVO.getid());
		id.setId(uservo.getid());
		name.setText(uservo.getname());
	}
	
	public void setMarketerMainFrame(MarketerMainFrame marketermainframe){
		this.marketermainframe = marketermainframe;
	}
}
