package presentation.view;

import businessLogic.orderbl.CancelOrderController;
import businessLogicService.orderBLService.CancelOrderService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import presentation.controller.FrameController;
import vo.FrameToFrameVO;
import vo.OrderVO;

public class ButtonCell3 extends TableCell<OrderVO,Boolean>{
FrameController viewcontrol = new FrameController();
	
	final Button cellButton = new Button("撤销");
	
	ButtonCell3(){
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
            public void handle(ActionEvent t) {
				OrderVO ordervo = getTableView().getItems().get( getIndex() );
				CancelOrderService service = new CancelOrderController();
				service.Cancel(ordervo);
				FrameToFrameVO.setword("撤销成功");
				viewcontrol.openSuccessSaveFrame();
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
