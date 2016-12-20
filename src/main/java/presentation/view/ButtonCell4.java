package presentation.view;

import businessLogic.hotelbl.ViewController;
import businessLogicService.hotelBLService.ViewService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import presentation.controller.FrameController;
import vo.HotelNameVO;
import vo.OrderVO;
import vo.StageVO;

public class ButtonCell4 extends TableCell<OrderVO,Boolean>{

	FrameController viewcontrol = new FrameController();
	
	final Button cellButton = new Button("再订一次");
	
	ButtonCell4(){
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
            public void handle(ActionEvent t) {
				OrderVO ordervo = getTableView().getItems().get( getIndex() );
				String hotelid = ordervo.getHotelId();
				ViewService service = new ViewController();
				String hotelname = service.ViewByid(hotelid).getName();
				HotelNameVO.sethotelname(hotelname);
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
