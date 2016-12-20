package presentation.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import presentation.controller.FrameController;
import vo.HotelNameVO;
import vo.HotelVO;

public class ButtonCell5 extends TableCell<HotelVO,Boolean> {
	FrameController viewcontrol = new FrameController();
	
	final Button cellButton = new Button("查看");
	
	ButtonCell5(){
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
            public void handle(ActionEvent t) {
				HotelVO hotelvo = getTableView().getItems().get( getIndex() );
				String hotelname = hotelvo.getName();
				HotelNameVO.sethotelname(hotelname);
				viewcontrol.openUserViewRoomFrame();
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
