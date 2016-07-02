package adminEnd;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ResultController implements Initializable {
	
	
	/* ************************************************************************************************************************
	 *										RESULTS FIELDS / METHODS	
	 *************************************************************************************************************************/
	
	@FXML private TableView<ApplicationDetails> resultTable;
		@FXML private TableColumn<ApplicationDetails, String> enrollmentNumber_Col;
		@FXML private TableColumn<ApplicationDetails, String> name_Col;
		@FXML private TableColumn<ApplicationDetails, String> linkToData_Col;
		@FXML private Button backButton;
		
		ObservableList<ApplicationDetails> tableData = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		enrollmentNumber_Col.setCellValueFactory (cellData -> cellData.getValue ().enrollmentProperty());
		name_Col.setCellValueFactory (cellData -> cellData.getValue ().nameProperty());
		linkToData_Col.setCellValueFactory (cellData -> cellData.getValue ().linkToDataProperty());
	}
	
	public void backButtonHandler (ActionEvent E)
	{
		Parent root;
		try {
			root = FXMLLoader.load (getClass().getResource ("/adminEnd/FS.fxml"));
			Stage secondaryStage = new Stage();
			Scene filterScene = new Scene (root);
			secondaryStage.setScene (filterScene);
			secondaryStage.show();
			((Node)(E.getSource())).getScene().getWindow().hide();
		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.println ("Cant Open new Window");
		}
	}
	
	public void setTable (ArrayList<ApplicationDetails> ARR)
	{
		ApplicationDetails AP = null;
		
		for (int i = 0; i < ARR.size(); i++)
		{
			AP = ARR.get(i);
			tableData.add (new ApplicationDetails (new String(AP.enrollmentNumber), new String(AP.applicantName), new String(AP.dataLink.toString())));
		}
		resultTable.setItems (tableData);
	}
	

}