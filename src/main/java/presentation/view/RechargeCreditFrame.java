package presentation.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * 
 * @author 费慧通
 *
 *充值信用界面
 */
public class RechargeCreditFrame extends Application{
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
	    this.primaryStage.setTitle("互联网酒店预订系统");

	    try{
	    	 FXMLLoader loader = new FXMLLoader();
		     loader.setLocation(getClass().getResource("RechargeCredit.fxml"));
		     AnchorPane frame = (AnchorPane) loader.load();
		        
		     Scene scene = new Scene(frame);
		     primaryStage.setScene(scene);
		     primaryStage.show();
		     RechargeCreditFrameController controller = loader.getController();
		     controller.setRechargeCreditFrame(this);
	    }catch(Exception e){
	       	e.printStackTrace();
	    }
	}


	/**
     * Return the main stage.
    */
    public Stage getPrimaryStage() {
	    return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
