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
 *询问用户是否取消注册账号
 */
public class DoCancelPopup extends Application{
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;

	    try{
	    	 FXMLLoader loader = new FXMLLoader();
		     loader.setLocation(getClass().getResource("DoCancel.fxml"));
		     AnchorPane frame = (AnchorPane) loader.load();
		        
		     Scene scene = new Scene(frame);
		     primaryStage.setScene(scene);
		     primaryStage.show();
		     DoCancelPopupController controller = loader.getController();
		     controller.setDoCancelPopup(this);
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
