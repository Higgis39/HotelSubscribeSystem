package presentation.view;

import businessLogic.userbl.RegisterVIPController;
import businessLogicService.userBLService.RegisterVIPBLService;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import presentation.controller.FrameController;
import vo.IdVO;
import vo.StageVO;


/**
 * 
 * @author 费慧通
 *
 *RegisterVIPFrame的监听
 */
public class RegisterVIPFrameController {
	@FXML
	private RadioButton commonVIP;
	@FXML
	private RadioButton companyVIP;
	@FXML
	private Label birthday;
	@FXML
	private DatePicker enterbirthday;
	@FXML
	private TextField entercompany;
	
	private RegisterVIPFrame registerVIPframe;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * 普通会员选择器的监听
	 */
	private void commonVIPAction(){
		if(commonVIP.isSelected()){
			enterbirthday.setVisible(true);
			entercompany.setVisible(false);
			birthday.setText("生日：");
			companyVIP.setSelected(false);
		}else{
			enterbirthday.setVisible(false);
			entercompany.setVisible(true);
			birthday.setText("企业：");
			companyVIP.setSelected(true);
		}
	}
	
	@FXML
	/**
	 * 企业会员选择器的监听
	 */
	private void companyVIPAction(){
		if(companyVIP.isSelected()){
			enterbirthday.setVisible(false);
			entercompany.setVisible(true);
			birthday.setText("企业：");
			commonVIP.setSelected(false);
		}else{
			enterbirthday.setVisible(true);
			entercompany.setVisible(false);
			birthday.setText("生日：");
			commonVIP.setSelected(true);
		}
	}
	
	@FXML
	/**
	 * 确定按钮的监听
	 */
	private void confirmAction(){
		RegisterVIPBLService service = new RegisterVIPController();
		if(commonVIP.isSelected()){
			String birthday = enterbirthday.getValue().toString();
			service.RegisterVIP(IdVO.getid(),"普通会员",birthday);
		}else{
			String company = entercompany.getText();
			service.RegisterVIP(IdVO.getid(),"企业会员",company);
		}
		viewcontrol.openSuccessAdd2Frame();
		StageVO.getSatge().close();
		viewcontrol.openUserPersonalFrame();
		registerVIPframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		registerVIPframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		
	}

	public void setRegisterVIPFrame(RegisterVIPFrame registerVIPframe) {
		this.registerVIPframe = registerVIPframe;
	}

}
