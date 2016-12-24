package presentation.view;

import businessLogic.userbl.MessageController;
import businessLogicService.userBLService.MessageBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.controller.FrameController;
import vo.FrameToFrameVO;
import vo.UserVO;

/**
 * 
 * @author 费慧通
 *
 *ChangeBirOrComFrame的监听
 */
public class ChangeBirOrComFrameController {
	@FXML
	private Label bircom;
	@FXML
	private TextField enterbircom;
	
	private ChangeBirOrComFrame changebirorcomframe;
	
	MessageBLService service = new MessageController();
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	private void confirmAction(){
		String birorcom = enterbircom.getText();
		//保存新输入的生日/公司信息
		service.ChangeBirOrCom(FrameToFrameVO.getid(), birorcom);
		changebirorcomframe.getPrimaryStage().close();
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
		changebirorcomframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		UserVO uservo = service.GetMessage(FrameToFrameVO.getid());
		if(uservo.getbirthday()==null){
			bircom.setText("企业");
			enterbircom.setText(uservo.getcompany());
		}else{
			enterbircom.setText(uservo.getbirthday());
		}
	}
	
	public void setChangeBirOrComFrame(ChangeBirOrComFrame changebirorcomframe){
		this.changebirorcomframe = changebirorcomframe;
	}
}
