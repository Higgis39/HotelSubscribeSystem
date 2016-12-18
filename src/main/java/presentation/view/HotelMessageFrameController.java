package presentation.view;

import businessLogic.hotelbl.ViewController;
import businessLogicService.hotelBLService.ViewService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import presentation.controller.FrameController;
import vo.HotelNameVO;
import vo.HotelVO;
import vo.IdVO;
import vo.StageVO;


/**
 * 
 * @author 费慧通
 *
 *HotelMessageFrame的监听
 */
public class HotelMessageFrameController {
	@FXML
	private Label id;
	@FXML
	private Label hotelname;
	@FXML
	private Label phonenumber;
	@FXML
	private Label address;
	@FXML
	private Label city;
	@FXML
	private Label introduction;
	@FXML
	private Label service;
	@FXML
	private Label star;
	
	private HotelMessageFrame hotelmessageframe;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * 管理房间的监听
	 */
	private void roomAction(){
		//打开酒店主界面
		viewcontrol.openHotelMainFrame();
		hotelmessageframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 处理订单的监听
	 */
	private void dealorderAction(){
		//打开处理订单界面
		viewcontrol.openDealOrderFrame();
		hotelmessageframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 促销策略的监听
	 */
	private void promotionAction(){
		//打开促销策略界面
		viewcontrol.openHotelPromotionFrame();
		hotelmessageframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 修改信息的监听
	 */
	private void linkAction(){
		//打开修改酒店基本信息界面
		StageVO.setStage(hotelmessageframe.getPrimaryStage());
		HotelNameVO.sethotelname(hotelname.getText());
		viewcontrol.openChangeHotelMessageFrame();
	}
	
	@FXML
	/**
	 * 退出登录的监听
	 */
	private void logoutAction(){
		viewcontrol.openLoginFrame();
		hotelmessageframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		ViewService s = new ViewController();
		HotelVO hotelvo = s.ViewByid(IdVO.getid());
		id.setText(IdVO.getid());
		hotelname.setText(hotelvo.getName());
		phonenumber.setText(hotelvo.getPhonenumber());
		address.setText(hotelvo.getAddress());
		city.setText(hotelvo.getBusinessArea());
		introduction.setText(hotelvo.getIntroduction());
		service.setText(hotelvo.getFacilities());
		star.setText(Integer.toString(hotelvo.getStar()));
	}
	
	public void setHotelMessageFrame(HotelMessageFrame hotelmessageframe){
		this.hotelmessageframe = hotelmessageframe;
	}

}
