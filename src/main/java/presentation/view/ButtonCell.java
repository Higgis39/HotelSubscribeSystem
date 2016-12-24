package presentation.view;

import java.sql.SQLException;

import businessLogic.hotelbl.AddRoomController;
import businessLogic.userbl.MessageController;
import businessLogicService.hotelBLService.AddRoomService;
import businessLogicService.userBLService.MessageBLService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import presentation.controller.FrameController;
import vo.FrameToFrameVO;
import vo.HotelVO;
import vo.UserVO;

public class ButtonCell extends TableCell<HotelVO,Boolean> {
	FrameController viewcontrol = new FrameController();
	
	final Button cellButton = new Button("去下订单");
	
	ButtonCell(){
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
            public void handle(ActionEvent t) {
				AddRoomService s = new AddRoomController();
				MessageBLService service = new MessageController();
				UserVO uservo = service.GetMessage(FrameToFrameVO.getid());
				HotelVO hotelvo = getTableView().getItems().get( getIndex() );
				boolean hasroom = true;
				try {
					hasroom = s.HasRoom(hotelvo.getName());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if(hasroom==false){
					FrameToFrameVO.setword("酒店已经没有空闲客房了");
					viewcontrol.openSuccessAddFrame();
				}else{
					if(uservo.getcreditvalue()<0){
						viewcontrol.openNoEnoughCreditFrame();
					}else{
						FrameToFrameVO.sethotelname(hotelvo.getName());
						FrameToFrameVO.getSatge2().hide();
						viewcontrol.openFillOrderFrame();
					}
				}
            }
        });
    }
    
	@Override
    protected void updateItem(Boolean t, boolean empty) {
		super.updateItem(t, empty);
        if(!empty){
        	setGraphic(cellButton);
        }
    }
}
