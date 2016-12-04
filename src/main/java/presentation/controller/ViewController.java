package presentation.controller;

import javafx.stage.Stage;
import presentation.view.RegisterClientFrame;
import presentation.view.RegisterVIPFrame;
import presentation.view.UserMainFrame;
import presentation.view.UserPersonalFrame;
import presentation.view.ViewCreditChangeFrame;
import presentation.view.ChangeBirOrComFrame;
import presentation.view.ChangeHotelMessageFrame;
import presentation.view.ChangePersonalMessageFrame;
import presentation.view.CheckInFrame;
import presentation.view.CheckOutFrame;
import presentation.view.DealOrderFrame;
import presentation.view.DoCancelPopup;
import presentation.view.EnterUserfulRoomFrame;
import presentation.view.FailLoginPopup;
import presentation.view.HistoricalOrderFrame;
import presentation.view.HotelMainFrame;
import presentation.view.HotelMessageFrame;
import presentation.view.HotelPromotionFrame;
import presentation.view.LoginFrame;
import presentation.view.MakeHotelPromotionFrame;

/**
 * 
 * @author 费慧通
 *
 *控制界面之间的跳转
 */
public class ViewController{
	/**
	 * 打开用户登录界面
	 */
	public void openLoginFrame(){
		new LoginFrame().start(new Stage());
	}
	
	/**
	 * 打开账号注册界面
	 */
	public void openRegisterClientFrame(){
		new RegisterClientFrame().start(new Stage());
	}
	
	/**
	 * 打开用户主界面（普通客户）
	 */
	public void openUserMainFrame(){
		new UserMainFrame().start(new Stage());
	}
	
	/**
	 * 打开个人信息界面
	 */
	public void openUserPersonalFrame(){
		new UserPersonalFrame().start(new Stage());
	}
	
	/**
	 * 打开历史订单界面
	 */
	public void openHistoricalOrderFrame(){
		new HistoricalOrderFrame().start(new Stage());
	}
	
	/**
	 * 打开修改个人基本信息界面
	 */
	public void openChangePersonalMessageFrame(){
		new ChangePersonalMessageFrame().start(new Stage());
	}
	
	/**
	 * 打开查看信用变化界面
	 */
	public void openViewCreditChange(){
		new ViewCreditChangeFrame().start(new Stage());
	}
	
	/**
	 * 打开修改生日/公司界面
	 */
	public void openChangeBirOrComFrame(){
		new ChangeBirOrComFrame().start(new Stage());
	}
	
	/**
	 * 打开注册会员界面
	 */
	public void openRegisterVIPFrame(){
		new RegisterVIPFrame().start(new Stage());
	}
	
	/**
	 * 打开录入可用客房界面
	 */
	public void openEnterUserfulRoomFrame(){
		new EnterUserfulRoomFrame().start(new Stage());
	}
	
	/**
	 * 打开更新入住信息的界面
	 */
	public void openCheckInFrame(){
		new CheckInFrame().start(new Stage());
	}
	
	/**
	 * 打开更新退房信息的界面
	 */
	public void openCheckOutFrame(){
		new CheckOutFrame().start(new Stage());
	}
	
	/**
	 * 打开酒店主界面
	 */
	public void openHotelMainFrame(){
		new HotelMainFrame().start(new Stage());
	}
	
	/**
	 * 打开处理订单界面
	 */
	public void openDealOrderFrame(){
		new DealOrderFrame().start(new Stage());
	}
	
	/**
	 * 打开促销策略界面
	 */
	public void openHotelPromotionFrame(){
		new HotelPromotionFrame().start(new Stage());
	}
	
	/**
	 * 打开酒店信息界面
	 */
	public void openHotelMessageFrame(){
		new HotelMessageFrame().start(new Stage());
	}
	
	/**
	 * 打开制定酒店促销策略界面
	 */
	public void openMakeHotelPromotionFrame(){
		new MakeHotelPromotionFrame().start(new Stage());
	}
	
	/**
	 * 打开维护酒店基本信息界面
	 */
	public void openChangeHotelMessageFrame(){
		new ChangeHotelMessageFrame().start(new Stage());
	}
	
	/**
	 * 打开“登录失败”弹框
	 */
	public void openFailLoginPopup(){
		new FailLoginPopup().start(new Stage());
	}
	
	/**
	 * 打开“是否取消注册账号”弹框
	 */
	public void openDoCancelPopup(){
		new DoCancelPopup().start(new Stage());
	}
	
}