package presentation.view;

import java.time.LocalDate;

import businessLogic.userbl.ManageUserController;
import businessLogic.userbl.MessageController;
import businessLogicService.userBLService.ManageUserBLService;
import businessLogicService.userBLService.MessageBLService;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.controller.FrameController;
import vo.FrameToFrameVO;
import vo.UserVO;

/**
 * 
 * @author 费慧通
 *
 *ChangeUserMessageFrame的界面
 */
public class ChangeUserMessageFrameController {
	@FXML
	private TextField entername;
	@FXML
	private TextField enterphonenumber;
	@FXML
	private TextField entercreditvalue;
	@FXML
	private TextField entercompany;
	@FXML
	private DatePicker enterbirthday;
	@FXML
	private Label birthdaylabel;
	@FXML
	private Label companylabel;

	private ChangeUserMessageFrame changeusermessageframe;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * 确定按钮的监听
	 */
	private void confirmAction(){
		ManageUserBLService service = new ManageUserController();
		String name = entername.getText();
		String phonenumber = enterphonenumber.getText();
		int creditvalue = Integer.valueOf(entercreditvalue.getText());
		if(!enterbirthday.isDisable()){
			String birthday = enterbirthday.getValue().toString();
			service.ChangeClientMessaage(FrameToFrameVO.getotherid(), name, phonenumber, creditvalue, birthday, null);
		}else{
			String company = entercompany.getText();
			service.ChangeClientMessaage(FrameToFrameVO.getotherid(), name, phonenumber, creditvalue, null, company);
		}
		changeusermessageframe.getPrimaryStage().close();
		FrameToFrameVO.setword("保存成功");
		viewcontrol.openSuccessSaveFrame();
	}
	
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		changeusermessageframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		MessageBLService service = new MessageController();
		UserVO uservo = service.GetMessage(FrameToFrameVO.getotherid());
		entername.setText(uservo.getname());
		enterphonenumber.setText(uservo.getphonenumber());
		entercreditvalue.setText(Integer.toString(uservo.getcreditvalue()));
		if(uservo.getbirthday()==null){
			birthdaylabel.setDisable(true);
			enterbirthday.setDisable(true);
			companylabel.setDisable(false);
			entercompany.setDisable(false);
			entercompany.setText(uservo.getcompany());
		}else{
			birthdaylabel.setDisable(false);
			enterbirthday.setDisable(false);
			companylabel.setDisable(true);
			entercompany.setDisable(true);
			enterbirthday.setValue(LocalDate.parse(uservo.getbirthday()));
		}
	}
	
	public void setChangeUserMessageFrame(ChangeUserMessageFrame changeusermessageframe){
		this.changeusermessageframe = changeusermessageframe;
	}
}
