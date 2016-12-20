package presentation.view;

import businessLogic.hotelbl.MaintainController;
import businessLogic.hotelbl.ViewController;
import businessLogicService.hotelBLService.MaintainService;
import businessLogicService.hotelBLService.ViewService;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import presentation.controller.FrameController;
import vo.HotelNameVO;
import vo.HotelVO;
import vo.StageVO;
import vo.WordVO;

public class ChangeHotelMessageFrameController {
	@FXML
	private TextField enterphonenumber;
	@FXML
	private TextField enteraddress;
	@FXML
	private TextArea enterintroduction;
	@FXML
	private TextField enterservice;
	@FXML
	private TextField enterstar;
	
	private ChangeHotelMessageFrame changehotelmessageframe;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * +号按钮的监听
	 */
	private void plusAction(){
		int star = Integer.valueOf(enterstar.getText());
		if(star<5){
			star++;
		}
		enterstar.setText(Integer.toString(star));
	}
	
	@FXML
	/**
	 * -号按钮的监听
	 */
	private void minusAction(){
		int star = Integer.valueOf(enterstar.getText());
		if(star>1){
			star--;
		}
		enterstar.setText(Integer.toString(star));
	}
	
	@FXML
	/**
	 * 确定按钮的监听
	 */
	private void confirmAction(){
		String phonenumber = enterphonenumber.getText();
		String address = enteraddress.getText();
		String introduction = enterintroduction.getText();
		String service = enterservice.getText();
		int star = Integer.valueOf(enterstar.getText());
		MaintainService s = new MaintainController();
		s.Maintain(HotelNameVO.getHotelname(), address, phonenumber, introduction,service, star);
		
		changehotelmessageframe.getPrimaryStage().close();
		StageVO.getSatge().close();
		viewcontrol.openHotelMessageFrame();
		WordVO.setword("保存成功");
		viewcontrol.openSuccessSaveFrame();
	}
	
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		changehotelmessageframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		ViewService s = new ViewController();
		HotelVO hotelvo = s.View(HotelNameVO.getHotelname());
		enterphonenumber.setText(hotelvo.getPhonenumber());
		enteraddress.setText(hotelvo.getAddress());
		enterintroduction.setText(hotelvo.getIntroduction());
		enterservice.setText(hotelvo.getFacilities());
		enterstar.setText(Integer.toString(hotelvo.getStar()));
	}

	public void setChangeHotelMessageFrame(ChangeHotelMessageFrame changehotelmessageframe) {
		this.changehotelmessageframe = changehotelmessageframe;
	}

}
