package adminEnd;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root;
			Scene filterScreen;
			root = FXMLLoader.load (getClass().getResource("/adminEnd/FS.fxml"));
			filterScreen = new Scene (root);
			primaryStage.setResizable (false);
			primaryStage.setScene (filterScreen);
			primaryStage.show ();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}