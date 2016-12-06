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
 *制定网站促销策略的界面
 */
public class MakeMarketerPromotionFrame extends Application{
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
	    this.primaryStage.setTitle("互联网酒店预订系统");
	    try{
	    	 FXMLLoader loader = new FXMLLoader();
		     loader.setLocation(getClass().getResource("MakeMarketerPromotion.fxml"));
		     AnchorPane frame = (AnchorPane)loader.load();
		       
		     Scene scene = new Scene(frame);
		     primaryStage.setScene(scene);
		     primaryStage.show();
		     MakeMarketerPromotionFrameController controller = loader.getController();
		     controller.setMakeMarketerPromotionFrame(this);
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
