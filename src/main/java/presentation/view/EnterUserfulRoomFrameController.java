package presentation.view;

import java.sql.SQLException;

import businessLogic.hotelbl.AddRoomController;
import businessLogicService.hotelBLService.AddRoomService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import presentation.controller.FrameController;
import vo.FrameToFrameVO;

/**
 * 
 * @author 费慧通
 *
 *EnterUserfulRoomFrame的监听
 */
public class EnterUserfulRoomFrameController {
	@FXML
	private TextField enterroomnum;
	@FXML
	private TextField enterpeoplenum;
	@FXML
	private TextField enterroomprice;
	@FXML
	private ComboBox<String> enterroomtype;
	
	private EnterUserfulRoomFrame enteruserfulroomframe;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	/**
	 * +号按钮的监听
	 */
	private void plusAction(){
		int num = Integer.valueOf(enterpeoplenum.getText());
		num++;
		enterpeoplenum.setText(Integer.toString(num));
	}
	
	@FXML
	/**
	 * -号按钮的监听
	 */
	private void minusAction(){
		int num = Integer.valueOf(enterpeoplenum.getText());
		if(num>1){
			num--;
		}
		enterpeoplenum.setText(Integer.toString(num));
	}
	
	@FXML
	/**
	 * 继续添加按钮的监听
	 */
	private void continueAction() throws SQLException{
		confirmAction();
		enteruserfulroomframe.getPrimaryStage().close();
		viewcontrol.openEnterUserfulRoomFrame();
	}
	
	@FXML
	/**
	 * 确定按钮的监听
	 */
	private void confirmAction() throws SQLException{
		String roomtype = enterroomtype.getSelectionModel().getSelectedItem();
		int peoplenum = Integer.valueOf(enterpeoplenum.getText());
		int roomnum = Integer.valueOf(enterroomnum.getText());
		int roomprice = Integer.valueOf(enterroomprice.getText());
		//保存客房信息
		AddRoomService service = new AddRoomController();
		service.UpdateRoom(FrameToFrameVO.getHotelname(), roomtype, peoplenum, roomnum, roomprice);
		
		enteruserfulroomframe.getPrimaryStage().close();
		FrameToFrameVO.getSatge().close();
		viewcontrol.openHotelMainFrame();
		FrameToFrameVO.setword("保存成功");
		viewcontrol.openSuccessSaveFrame();
	}
	
	@FXML
	/**
	 * 取消按钮的监听
	 */
	private void cancelAction(){
		enteruserfulroomframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		enterroomtype.getItems().addAll("单人间","标准间","家庭套间");
	}

	public void setEnterUserfulRoomFrame(EnterUserfulRoomFrame enteruserfulroomframe) {
		this.enteruserfulroomframe = enteruserfulroomframe;
	}

}
