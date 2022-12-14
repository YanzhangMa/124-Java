package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	private Stage primaryStage;
	
	/*
	 * Function that start the scene stage.
	 */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		//primaryStage.show();
		mainWindow();
	}
	
	/*
	 * Function that build the main window.
	 */
	public void mainWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainWindowView.fxml"));
			AnchorPane pane = loader.load();
			
			MainWindowController mainWindowController = loader.getController();
			mainWindowController.setMain(this);
			
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
