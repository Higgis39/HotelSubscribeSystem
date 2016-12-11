package presentation.view;

import businessLogic.userbl.MessageController;
import businessLogicService.userBLService.MessageBLService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import presentation.controller.FrameController;
import vo.HotelNameVO;
import vo.HotelVO;
import vo.IdVO;
import vo.StageVO;
import vo.UserVO;

public class ButtonCell extends TableCell<HotelVO,Boolean> {
	FrameController viewcontrol = new FrameController();
	
	final Button cellButton = new Button("去下订单");
	
	ButtonCell(){
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
            public void handle(ActionEvent t) {
				MessageBLService service = new MessageController();
				UserVO uservo = service.GetMessage(IdVO.getid());
				if(uservo.getcreditvalue()<0){
					viewcontrol.openNoEnoughCreditFrame();
				}else{
					HotelVO hotelvo = getTableView().getItems().get( getIndex() );
					HotelNameVO.sethotelname(hotelvo.getName());
					StageVO.getSatge2().hide();
					viewcontrol.openFillOrderFrame();
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
