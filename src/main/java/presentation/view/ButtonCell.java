package presentation.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import presentation.controller.ViewController;
import vo.HotelNameVO;
import vo.HotelVO;
import vo.StageVO;

public class ButtonCell extends TableCell<HotelVO,Boolean> {
	ViewController viewcontrol = new ViewController();
	
	final Button cellButton = new Button("去下订单");
	
	ButtonCell(){
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
            public void handle(ActionEvent t) {
				HotelVO hotelvo = getTableView().getItems().get( getIndex() );
				HotelNameVO.sethotelname(hotelvo.getName());
				StageVO.getSatge2().hide();
                viewcontrol.openFillOrderFrame();
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
