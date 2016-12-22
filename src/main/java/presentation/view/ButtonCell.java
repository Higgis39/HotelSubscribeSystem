package presentation.view;

import businessLogic.userbl.MessageController;
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
				MessageBLService service = new MessageController();
				UserVO uservo = service.GetMessage(FrameToFrameVO.getid());
				if(uservo.getcreditvalue()<0){
					viewcontrol.openNoEnoughCreditFrame();
				}else{
					HotelVO hotelvo = getTableView().getItems().get( getIndex() );
					FrameToFrameVO.sethotelname(hotelvo.getName());
					FrameToFrameVO.getSatge2().hide();
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
