package ch.makery.address;

import java.io.IOException;

//import ch.makery.address.model.Data;
import ch.makery.address.view.DataController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	private Stage primaryStage;
	
	public MainApp() {
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Mortgage Estimator");
        
        initData();
	}
	
	/**
     * Shows the person overview inside the root layout.
     */
	public void initData() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Data.fxml"));
            AnchorPane Data = (AnchorPane) loader.load();
            
			// Set password prompt into the center of the scene.
			Scene scene = new Scene(Data);
			primaryStage.setScene(scene);
			
			// Give the controller access to the main app.
			DataController controller = loader.getController();
			controller.setMainApp(this);
			
			primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	/**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
	public static void main(String[] args) {
		launch(args);
	}
//	
//	public static double housingPayment() {
//		return 0;
//	}
//	
//	public static double housingPaymentWithObligations() {
//		return 0;
//	}
}
