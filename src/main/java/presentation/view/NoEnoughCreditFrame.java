package presentation.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NoEnoughCreditFrame extends Application{
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage){
		this.primaryStage = primaryStage;

	    try{
	    	 FXMLLoader loader = new FXMLLoader();
		     loader.setLocation(getClass().getResource("NoEnoughCredit.fxml"));
		     AnchorPane frame = (AnchorPane) loader.load();
		        
		     Scene scene = new Scene(frame);
		     primaryStage.setScene(scene);
		     primaryStage.show();
		     NoEnoughCreditFrameController controller = loader.getController();
		     controller.setNoEnoughCreditFrame(this);
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
