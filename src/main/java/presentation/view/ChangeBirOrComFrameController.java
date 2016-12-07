package presentation.view;

import businessLogic.userbl.MessageController;
import businessLogicService.userBLService.MessageBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import vo.IdVO;
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
	
	@FXML
	private void confirmAction(){
		String birorcom = enterbircom.getText();
		//保存新输入的生日/公司信息
		service.ChangeBirOrComFrame(IdVO.getid(), birorcom);
		changebirorcomframe.getPrimaryStage().close();
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
		UserVO uservo = service.GetMessage(IdVO.getid());
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
