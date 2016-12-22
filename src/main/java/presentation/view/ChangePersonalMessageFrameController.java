package presentation.view;

import businessLogic.userbl.MessageController;
import businessLogicService.userBLService.MessageBLService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import presentation.controller.FrameController;
import vo.FrameToFrameVO;
import vo.UserVO;

/**
 * 
 * @author 费慧通
 *
 *ChangePersonalMessageFrame的监听
 */
public class ChangePersonalMessageFrameController {
	@FXML
	private TextField entername;
	@FXML
	private TextField enterphonenumber;
	
	private ChangePersonalMessageFrame changepersonalmessageframe;
	
	MessageBLService service = new MessageController();
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * 保存的监听
	 */
	private void confirmAction(){
		String name = entername.getText();
		String phonenumber = enterphonenumber.getText();
		//进行保存操作
		service.ChangeMessage(FrameToFrameVO.getid(), name, phonenumber);
		changepersonalmessageframe.getPrimaryStage().close();
		FrameToFrameVO.getSatge().close();
		viewcontrol.openUserPersonalFrame();
		FrameToFrameVO.setword("保存成功");
		viewcontrol.openSuccessSaveFrame();
	}
	
	@FXML
	/**
	 * 取消的监听
	 */
	private void cancelAction(){
		changepersonalmessageframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		UserVO uservo = service.GetMessage(FrameToFrameVO.getid());
		entername.setText(uservo.getname());
		enterphonenumber.setText(uservo.getphonenumber());
	}
	
	public void setChangePersonalMessageFrame(ChangePersonalMessageFrame changepersonalmessageframe){
		this.changepersonalmessageframe = changepersonalmessageframe;
	}
}
