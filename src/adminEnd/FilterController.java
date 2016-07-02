package adminEnd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FilterController implements Initializable {
	public static ArrayList<ApplicationDetails> filteredData = new ArrayList<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		PI_category.setItems (PI_categoryList);
		
		EI_phdStream.setItems (EI_phdStreamList);
		EI_gradDegree.setItems (EI_gradDegreeList);
		EI_postGradDegree.setItems (EI_postGradDegreeList);
		EI_XBoard.setItems (EI_XBoardList);
		EI_XIIBoard.setItems (EI_XIIBoardList);
		EI_gradDiscipline.setItems (EI_gradDisciplineList);
		EI_postGradDiscipline.setItems (EI_postGradDisciplineList);
		EI_gradState.setItems (EI_gradStateList);
		EI_postGradState.setItems (EI_postGradStateList);
		
	}
	
	/* ************************************************************************************************************************
	 *										PERSONAL INFORMATION TAB FIELDS / METHODS	
	 **************************************************************************************************************************/
	
	@FXML private Tab PI;
		@FXML private TextField PI_eMail;
		@FXML private TextField PI_Name;
		@FXML private TextField PI_enrollmentNumber;
		@FXML private ComboBox<String> PI_category;
		@FXML private RadioButton PI_Gender_M;
		@FXML private RadioButton PI_Gender_F;
		@FXML private RadioButton PI_Gender_NOF;
		@FXML private RadioButton PI_phyDisabled_Y;
		@FXML private RadioButton PI_phyDisabled_N;
		@FXML private RadioButton PI_phyDisabled_NOF;
		@FXML private RadioButton PI_DoB_Before;
		@FXML private RadioButton PI_DoB_On;
		@FXML private RadioButton PI_DoB_After;
		@FXML private DatePicker PI_DoB_DatePicker;
		@FXML private Text PI_ErrorText;
		
		ObservableList<String> PI_categoryList = FXCollections.observableArrayList ("NO_CATEGORY_FILTER", "General", "OBC", "SC", "ST");
	
	public void apply_PI_nameFilter ()
	{
		if (!PI_nameFilter)
			return;
		
		System.out.println ("Applying PI_nameFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		String filter = PI_Name.getText().toLowerCase();
		
		for (int i = 0; i < filteredData.size(); i++)
		{
			appData = filteredData.get (i);
			if (appData.applicantName.toLowerCase().compareTo (filter) != 0)
			{
				removeList.add (appData);
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_PI_emailFilter ()
	{
		if (!PI_emailFilter)
			return;
		
		System.out.println ("Applying PI_emailFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		String filter = PI_eMail.getText();
		
		for (int i = 0; i < filteredData.size(); i++)
		{
			appData = filteredData.get (i);
			if (appData.eMail.compareTo (filter) != 0)
			{
				removeList.add (appData);
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_PI_enrollmentNumberFilter ()
	{
		if (!PI_enrollmentNumberFilter)
			return;
		
		System.out.println ("Applying PI_enrollmentNumberFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		String filter = PI_enrollmentNumber.getText();
		
		for (int i = 0; i < filteredData.size(); i++)
		{
			appData = filteredData.get (i);
			if (appData.enrollmentNumber.compareTo (filter) != 0)
			{
				removeList.add (appData);
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_PI_categoryFilter ()
	{
		if (!PI_categoryFilter)
			return;
		
		System.out.println ("Applying PI_categoryFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		String filter = PI_category.getValue().toLowerCase();
		
		for (int i = 0; i < filteredData.size(); i++)
		{
			appData = filteredData.get (i);
			if (appData.category.toLowerCase().compareTo (filter) != 0)
			{
				removeList.add (appData);
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_PI_genderFilter ()
	{
		if (!PI_genderFilter)
			return;
		
		System.out.println ("Applying PI_genderFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		char filter = 0;
		
		if (PI_Gender_M.isSelected())
			filter = 'M';
		else
			filter = 'F';
		
		for (int i = 0; i < filteredData.size(); i++)
		{
			appData = filteredData.get (i);
			if (Character.toUpperCase (appData.gender) != filter)
			{
				removeList.add (appData);
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_PI_phyDisabilityFilter ()
	{
		if (!PI_phyDisabilityFilter)
			return;
		
		System.out.println ("Applying PI_phyDisabilityFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		boolean filter;
		
		if (PI_phyDisabled_Y.isSelected())
			filter = true;
		else
			filter = false;
		
		for (int i = 0; i < filteredData.size(); i++)
		{
			appData = filteredData.get (i);
			if (appData.physicallyDisabled != filter)
			{
				removeList.add (appData);
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_PI_dobFilter ()
	{
		if (!PI_dobFilter)
			return;
		
		System.out.println ("Applying PI_dobFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData;
		LocalDate filter = PI_DoB_DatePicker.getValue();
		
		if (PI_DoB_Before.isSelected())
		{
			for (int i = 0; i < filteredData.size(); i++)
			{
				appData = filteredData.get (i);
				if (!(filter.isBefore (appData.DoB)))
					removeList.add (appData);
			}
		}
		else if (PI_DoB_On.isSelected())
		{
			for (int i = 0; i < filteredData.size(); i++)
			{
				appData = filteredData.get (i);
				
				if (!(filter.isEqual (appData.DoB)))
					removeList.add (appData);
			}
		}
		else if (PI_DoB_After.isSelected())
		{
			for (int i = 0; i < filteredData.size(); i++)
			{
				appData = filteredData.get (i);
				
				if (!(filter.isAfter (appData.DoB)))
					removeList.add (appData);
			}
		}
		
		filteredData.removeAll (removeList);

		/*if (PI_DoB_Before.isSelected())
		{
			for (; i >= 0; i--)
			{
				appData = filteredData.get (i);
				int appDate = appData.DoB.getDayOfMonth();
				int appMonth = appData.DoB.getMonthValue();
				int appYear = appData.DoB.getYear();
				
				if (appYear > Year)
					filteredData.remove (i);
				else if (appYear == Year)
				{
					if (appMonth > Month)
						filteredData.remove (i);
					else if (appMonth == Month)
					{
						if (appDate > Date)
							filteredData.remove (i);
					}
				}
			}
		}
		else if (PI_DoB_On.isSelected())
		{
			for (; i >= 0; i--)
			{
				appData = filteredData.get (i);
				int appDate = appData.DoB.getDayOfMonth();
				int appMonth = appData.DoB.getMonthValue();
				int appYear = appData.DoB.getYear();
				
				if (appDate != Date)
					filteredData.remove (i);
				else if (appMonth != Month)
					filteredData.remove (i);
				else if (appYear != Year)
					filteredData.remove (i);
			}
		}
		else if (PI_DoB_After.isSelected())
		{
			for (; i >= 0; i--)
			{
				appData = filteredData.get (i);
				int appDate = appData.DoB.getDayOfMonth();
				int appMonth = appData.DoB.getMonthValue();
				int appYear = appData.DoB.getYear();
				
				if (appYear < Year)
					filteredData.remove (i);
				else if (appYear == Year)
				{
					if (appMonth < Month)
						filteredData.remove (i);
					else if (appMonth == Month)
					{
						if (appDate < Date)
							filteredData.remove (i);
					}
				}
			}
		}*/
	}
	
	
	/* ************************************************************************************************************************
	 *										EDUCATION INFORMATION TAB FIELDS / METHODS	
	 *************************************************************************************************************************/
	
	@FXML private Tab EI;
		@FXML private ComboBox<String> EI_phdStream;
		@FXML private ComboBox<String> EI_gradDegree;
		@FXML private ComboBox<String> EI_postGradDegree;
		@FXML private ComboBox<String> EI_XBoard;
		@FXML private ComboBox<String> EI_XIIBoard;
		@FXML private ComboBox<String> EI_gradDiscipline;
		@FXML private ComboBox<String> EI_postGradDiscipline;
		@FXML private TextField EI_gradUniversity;
		@FXML private TextField EI_postGradUniversity;
		@FXML private ComboBox<String> EI_gradState;
		@FXML private ComboBox<String> EI_postGradState;
		@FXML private RadioButton EI_XBoardPerc_GT;
		@FXML private RadioButton EI_XBoardPerc_EQ;
		@FXML private RadioButton EI_XBoardPerc_LT;
		@FXML private TextField EI_XBoardPerc;
		@FXML private RadioButton EI_XIIBoardPerc_GT;
		@FXML private RadioButton EI_XIIBoardPerc_EQ;
		@FXML private RadioButton EI_XIIBoardPerc_LT;
		@FXML private TextField EI_XIIBoardPerc;
		@FXML private RadioButton EI_gradPerc_GT;
		@FXML private RadioButton EI_gradPerc_EQ;
		@FXML private RadioButton EI_gradPerc_LT;
		@FXML private TextField EI_gradPerc;
		@FXML private RadioButton EI_postGradPerc_GT;
		@FXML private RadioButton EI_postGradPerc_EQ;
		@FXML private RadioButton EI_postGradPerc_LT;
		@FXML private TextField EI_postGradPerc;
		@FXML private RadioButton EI_gateScore_GT;
		@FXML private RadioButton EI_gateScore_EQ;
		@FXML private RadioButton EI_gateScore_LT;
		@FXML private TextField EI_gateScore;
		
		private String[] stateList = {"NO_STATE_FILTER",
							  "Andaman and Nicobar Islands",
							  "Andhra Pradesh",
							  "Arunachal Pradesh",
							  "Assam",
							  "Bihar",
							  "Chandigarh",
							  "Chhatisgarh",
							  "Dadra and Nagar Haveli",
							  "Daman and Diu",
							  "Delhi",
							  "Goa",
							  "Gujarat",
							  "Haryana",
							  "Himachal Pradesh",
							  "Jammu and Kashmir",
							  "Jharkhand",
							  "Karnataka",
							  "Kerala",
							  "Lakshadweep",
							  "Madhya Pradesh",
							  "Maharashtra",
							  "Manipur",
							  "Meghalaya",
							  "Mizoram",
							  "Nagaland",
							  "Orissa",
							  "Pondicherry",
							  "Punjab",
							  "Rajasthan",
							  "Sikkim",
							  "Tamil Nadu",
							  "Tripura",
							  "Uttaranchal",
							  "Uttar Pradesh",
							  "West Bengal",
							  "Other"
							};
		
		ObservableList<String> EI_phdStreamList = FXCollections.observableArrayList ("NO_PHD_STREAM_FILTER", "Computer Science", "Electronics and Communication", "Computational Biology");
		ObservableList<String> EI_gradDegreeList = FXCollections.observableArrayList ("NO_GRADUATION_DEGREE_FILTER", "B.Tech", "M.Tech");
		ObservableList<String> EI_postGradDegreeList = FXCollections.observableArrayList ("NO_POST_GRADUATION_DEGREE_FILTER", "B.Tech", "M.Tech");
		ObservableList<String> EI_XBoardList = FXCollections.observableArrayList ("NO_X_BOARD_FILTER", "Andhra Pradesh Board of Intermediate Education","Andhra Pradesh Board of Secondary Education","Board of Higher Secondary Education, Delhi","Assam Board of Secondary Education","Bihar School Examination Board","Board of Youth Education India","Board of School Education, Haryana","Board of Secondary Education, Madhya Pradesh","Board of Secondary Education Madhya Bharat Gwalior","Board of Secondary Education, Rajasthan","Chhattisgarh Board of Secondary Education","Central Board of Secondary Education","Central Board Of Patna, Bihar","Central Board Of Education Ajmer New Delhi","Goa Board of Secondary & Higher Secondary Education","Gujarat Secondary Education Board","Himachal Pradesh Board of School Education","Indian Board of Science Education(not recognized)","Indian Board of School Education","Indian Board of Computer Education","J&K State Board of School Education","Jharkhand Academic Council","Karnataka Board of the Pre-University Education","Karnataka Secondary Education Examination Board","Kerala Board of Public Examinations","Maharashtra State Board of Secondary and Higher Secondary Education","Manipur Board of Secondary Education","Manipur Council of Higher Secondary Education","Meghalaya Board of School Education","Mizoram Board of School Education","North East National Board Of School Education (NENBSE)","Northwest Accreditation Commission","Nagaland Board of School Education","National Institute of Open Schooling","Orissa Board of Secondary Education","Orissa Council of Higher Secondary Education","Punjab School Education Board","Rajasthan Board of Secondary Education","Tamil Nadu Board of Higher Secondary Education","Tamil Nadu Board of Secondary Education","Tamilnadu Council for Open and Distance Learning","Tripura Board of Secondary Education","Telangana Board of Intermediate Education","Telangana Board of Secondary Education","Uttar Pradesh Board of High School and Intermediate Education","Sampurnanand Sanskrit Vishwavidyalaya Varanasi Uttar Pradesh","Uttarakhand Board of School Education","West Bengal Board of Secondary Education","West Bengal Council of Higher Secondary Education","West Bengal State Council of Vocational Education and Training","Board of Secondary Education Kant Shahjahanpur Uttar Pradesh","The West Bengal Council of Rabindra Open Schooling");
		ObservableList<String> EI_XIIBoardList = FXCollections.observableArrayList ("NO_XII_BOARD_FILTER", "Andhra Pradesh Board of Intermediate Education","Andhra Pradesh Board of Secondary Education","Board of Higher Secondary Education, Delhi","Assam Board of Secondary Education","Bihar School Examination Board","Board of Youth Education India","Board of School Education, Haryana","Board of Secondary Education, Madhya Pradesh","Board of Secondary Education Madhya Bharat Gwalior","Board of Secondary Education, Rajasthan","Chhattisgarh Board of Secondary Education","Central Board of Secondary Education","Central Board Of Patna, Bihar","Central Board Of Education Ajmer New Delhi","Goa Board of Secondary & Higher Secondary Education","Gujarat Secondary Education Board","Himachal Pradesh Board of School Education","Indian Board of Science Education(not recognized)","Indian Board of School Education","Indian Board of Computer Education","J&K State Board of School Education","Jharkhand Academic Council","Karnataka Board of the Pre-University Education","Karnataka Secondary Education Examination Board","Kerala Board of Public Examinations","Maharashtra State Board of Secondary and Higher Secondary Education","Manipur Board of Secondary Education","Manipur Council of Higher Secondary Education","Meghalaya Board of School Education","Mizoram Board of School Education","North East National Board Of School Education (NENBSE)","Northwest Accreditation Commission","Nagaland Board of School Education","National Institute of Open Schooling","Orissa Board of Secondary Education","Orissa Council of Higher Secondary Education","Punjab School Education Board","Rajasthan Board of Secondary Education","Tamil Nadu Board of Higher Secondary Education","Tamil Nadu Board of Secondary Education","Tamilnadu Council for Open and Distance Learning","Tripura Board of Secondary Education","Telangana Board of Intermediate Education","Telangana Board of Secondary Education","Uttar Pradesh Board of High School and Intermediate Education","Sampurnanand Sanskrit Vishwavidyalaya Varanasi Uttar Pradesh","Uttarakhand Board of School Education","West Bengal Board of Secondary Education","West Bengal Council of Higher Secondary Education","West Bengal State Council of Vocational Education and Training","Board of Secondary Education Kant Shahjahanpur Uttar Pradesh","The West Bengal Council of Rabindra Open Schooling");
		ObservableList<String> EI_gradDisciplineList = FXCollections.observableArrayList ("NO_GRADUATION_DISCIPLINE_FILTER", "CSE", "ECE");
		ObservableList<String> EI_postGradDisciplineList = FXCollections.observableArrayList ("NO_POST_GRADUATION_DISCIPLINE_FILTER", "CSE", "ECE");
		ObservableList<String> EI_gradStateList = FXCollections.observableArrayList (stateList);
		ObservableList<String> EI_postGradStateList = FXCollections.observableArrayList (stateList);
	
	public void apply_EI_phdStreamFilter ()
	{
		if (!EI_phdStreamFilter)
			return;
		
		System.out.println ("Applying EI_phdStreamFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		String filter = EI_phdStream.getValue().toLowerCase();
		
		for (int i = 0; i < filteredData.size(); i++)
		{
			appData = filteredData.get (i);
			if (appData.phdStream.toLowerCase().compareTo (filter) != 0)
			{
				removeList.add (appData);
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_EI_gradDegreeFilter ()
	{
		if (!EI_gradDegreeFilter)
			return;
		
		System.out.println ("Applying EI_gradDegreeFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		String filter = EI_gradDegree.getValue().toLowerCase();
		
		for (int i = 0; i < filteredData.size(); i++)
		{
			appData = filteredData.get (i);
			if (appData.gradDegree.toLowerCase().compareTo(filter) != 0)
			{
				removeList.add (appData);
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_EI_postGradDegreFilter ()
	{
		if (!EI_postGradDegreeFilter)
			return;
		
		System.out.println ("Applying EI_postGradDegreeFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		String filter = EI_postGradDegree.getValue().toLowerCase();
		
		for (int i = 0; i < filteredData.size(); i++)
		{
			appData = filteredData.get (i);
			if (appData.postDegree != null && appData.postDegree.toLowerCase().compareToIgnoreCase(filter) != 0)
			{
				removeList.add (appData);
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_EI_XBoardFilter ()
	{
		if (!EI_XBoardFilter)
			return;
		
		System.out.println ("Applying EI_XBoardFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		String filter = EI_XBoard.getValue().toLowerCase();
		
		for (int i = 0; i < filteredData.size(); i++)
		{
			appData = filteredData.get (i);
			if (appData.X_Board.toLowerCase().compareTo (filter) != 0)
			{
				removeList.add (appData);
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_EI_XIIBoardFilter ()
	{
		if (!EI_XIIBoardFilter)
			return;
		
		System.out.println ("Applying EI_XIIBoardFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		String filter = EI_XIIBoard.getValue().toLowerCase();
		
		for (int i = 0; i < filteredData.size(); i++)
		{
			appData = filteredData.get (i);
			if (appData.XII_Board.toLowerCase().compareTo (filter) != 0)
			{
				removeList.add (appData);
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_EI_gradDisciplineFilter ()
	{
		if (!EI_gradDisciplineFilter)
			return;
		
		System.out.println ("Applying EI_gradDisciplineFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		String filter = EI_gradDiscipline.getValue().toLowerCase();
		
		for (int i = 0; i < filteredData.size(); i++)
		{
			appData = filteredData.get (i);
			if (appData.gradDiscipline.toLowerCase().charAt(0) != filter.charAt(0))
			{
				removeList.add (appData);
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_EI_postGradDisciplineFilter ()
	{
		if (!EI_postGradDisciplineFilter)
			return;
		
		System.out.println ("Applying EI_postGradDisciplineFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		String filter = EI_postGradDiscipline.getValue().toLowerCase();
		
		for (int i = 0; i < filteredData.size(); i++)
		{
			appData = filteredData.get (i);
			if (appData.postDiscipline != null && appData.postDiscipline.toLowerCase().charAt(0) != filter.charAt(0))
			{
				removeList.add (appData);
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_EI_gradUniversityFilter ()
	{
		if (!EI_gradUniversityFilter)
			return;
		
		System.out.println ("Applying EI_gradUniversityFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		String filter = EI_gradUniversity.getText().toLowerCase();
		
		for (int i = 0; i < filteredData.size(); i++)
		{
			appData = filteredData.get (i);
			if (appData.gradUniversity.toLowerCase().compareTo (filter) != 0)
			{
				removeList.add (appData);
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_EI_postGradUniversityFilter ()
	{
		if (!EI_postGradUniversityFilter)
			return;
		
		System.out.println ("Applying EI_postGradUniversityFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		String filter = EI_postGradUniversity.getText().toLowerCase();
		
		for (int i = 0; i < filteredData.size(); i++)
		{
			appData = filteredData.get (i);
			if (appData.postUniversity.toLowerCase().compareTo (filter) != 0)
			{
				removeList.add (appData);
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_EI_gradStateFilter ()
	{
		if (!EI_gradStateFilter)
			return;
		
		System.out.println ("Applying EI_gradStateFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		String filter = EI_gradState.getValue().toLowerCase();
		
		for (int i = 0; i < filteredData.size(); i++)
		{
			appData = filteredData.get (i);
			if (appData.gradState.toLowerCase().compareTo (filter) != 0)
			{
				removeList.add (appData);
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_EI_postGradStateFilter ()
	{
		if (!EI_postGradStateFilter)
			return;
		
		System.out.println ("Applying EI_postGradStateFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		String filter = EI_postGradState.getValue().toLowerCase();
		
		for (int i = 0; i < filteredData.size(); i++)
		{
			appData = filteredData.get (i);
			if (appData.postState.toLowerCase().compareTo (filter) != 0)
			{
				removeList.add (appData);
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_EI_XBoardPercFilter ()
	{
		if (!EI_XBoardPercFilter)
			return;
		
		System.out.println ("Applying EI_XBoardPercFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		int filter = Integer.parseInt (EI_XBoardPerc.getText());
		
		if (EI_XBoardPerc_GT.isSelected())
		{
			for (int i = 0; i < filteredData.size(); i++)
			{
				appData = filteredData.get (i);
				if (appData.X_Marks <= filter)
				{
					removeList.add (appData);
				}
			}
		}
		else if (EI_XBoardPerc_EQ.isSelected())
		{
			for (int i = 0; i < filteredData.size(); i++)
			{
				appData = filteredData.get (i);
				if (appData.X_Marks != filter)
				{
					removeList.add (appData);
				}
			}
		}
		else
		{
			for (int i = 0; i < filteredData.size(); i++)
			{
				appData = filteredData.get (i);
				if (appData.X_Marks >= filter)
				{
					removeList.add (appData);
				}
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_EI_XIIBoardPercFilter ()
	{
		if (!EI_XIIBoardPercFilter)
			return;
		
		System.out.println ("Applying EI_XIIBoardPercFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		int filter = Integer.parseInt (EI_XIIBoardPerc.getText());
		
		if (EI_XIIBoardPerc_GT.isSelected())
		{
			for (int i = 0; i < filteredData.size(); i++)
			{
				appData = filteredData.get (i);
				if (appData.XII_Marks <= filter)
				{
					removeList.add (appData);
				}
			}
		}
		else if (EI_XIIBoardPerc_EQ.isSelected())
		{
			for (int i = 0; i < filteredData.size(); i++)
			{
				appData = filteredData.get (i);
				if (appData.XII_Marks != filter)
				{
					removeList.add (appData);
				}
			}
		}
		else
		{
			for (int i = 0; i < filteredData.size(); i++)
			{
				appData = filteredData.get (i);
				if (appData.XII_Marks >= filter)
				{
					removeList.add (appData);
				}
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_EI_gradPercFilter ()
	{
		if (!EI_gradPercFilter)
			return;
		
		System.out.println ("Applying EI_gradPercFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		int filter = Integer.parseInt (EI_gradPerc.getText());
		
		if (EI_gradPerc_GT.isSelected())
		{
			for (int i = 0; i < filteredData.size(); i++)
			{
				appData = filteredData.get (i);
				if (appData.grad_cgpa_marks <= filter)
				{
					removeList.add (appData);
				}
			}
		}
		else if (EI_gradPerc_EQ.isSelected())
		{
			for (int i = 0; i < filteredData.size(); i++)
			{
				appData = filteredData.get (i);
				if (appData.grad_cgpa_marks != filter)
				{
					removeList.add (appData);
				}
			}
		}
		else
		{
			for (int i = 0; i < filteredData.size(); i++)
			{
				appData = filteredData.get (i);
				if (appData.grad_cgpa_marks >= filter)
				{
					removeList.add (appData);
				}
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_EI_postGradPercFilter ()
	{
		if (!EI_postGradPercFilter)
			return;
		
		System.out.println ("Applying EI_postGradPercFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		int filter = Integer.parseInt (EI_postGradPerc.getText());
		
		if (EI_postGradPerc_GT.isSelected())
		{
			for (int i = 0; i < filteredData.size(); i++)
			{
				appData = filteredData.get (i);
				if (appData.post_cgpa_marks <= filter)
				{
					removeList.add (appData);
				}
			}
		}
		else if (EI_postGradPerc_EQ.isSelected())
		{
			for (int i = 0; i < filteredData.size(); i++)
			{
				appData = filteredData.get (i);
				if (appData.post_cgpa_marks != filter)
				{
					removeList.add (appData);
				}
			}
		}
		else
		{
			for (int i = 0; i < filteredData.size(); i++)
			{
				appData = filteredData.get (i);
				if (appData.post_cgpa_marks >= filter)
				{
					removeList.add (appData);
				}
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	public void apply_EI_gateScoreFilter ()
	{
		if (!EI_gateScoreFilter)
			return;
		
		System.out.println ("Applying EI_gateScoreFilter");
		
		ArrayList<ApplicationDetails> removeList = new ArrayList<>();
		ApplicationDetails appData = null;
		int filter = Integer.parseInt (EI_gateScore.getText());
		
		if (EI_gateScore_GT.isSelected())
		{
			for (int i = 0; i < filteredData.size(); i++)
			{
				appData = filteredData.get (i);
				if (appData.gate_Score <= filter)
				{
					removeList.add (appData);
				}
			}
		}
		else if (EI_gateScore_EQ.isSelected())
		{
			for (int i = 0; i < filteredData.size(); i++)
			{
				appData = filteredData.get (i);
				if (appData.gate_Score != filter)
				{
					removeList.add (appData);
				}
			}
		}
		else
		{
			for (int i = 0; i < filteredData.size(); i++)
			{
				appData = filteredData.get (i);
				if (appData.gate_Score >= filter)
				{
					removeList.add (appData);
				}
			}
		}
		
		filteredData.removeAll (removeList);
	}
	
	/* ************************************************************************************************************************
	 *										SUBMIT TAB FIELDS / METHODS	
	 *************************************************************************************************************************/
	
	@FXML private Tab Submit;
		@FXML DatePicker Submit_datedFrom;
		@FXML DatePicker Submit_datedUpto;
		@FXML Button submitButton;
	
	public void apply_Submit_datedFromFilter ()
	{
		if (!Submit_datedFromFilter)
			return;
		
		int i = filteredData.size() -1;
		ApplicationDetails appData;
		LocalDate Date = Submit_datedFrom.getValue();
		
		for (; i >=0 ; i--)
		{
			appData = filteredData.get (i);
			if (appData.filledOn.isBefore (Date))
				filteredData.remove (i);
		}
	}
	
	public void apply_Submit_datedUptoFilter ()
	{
		if (!Submit_datedUptoFilter)
			return;
		
		int i = filteredData.size() -1;
		ApplicationDetails appData;
		LocalDate Date = Submit_datedUpto.getValue();
		
		for (; i >=0 ; i--)
		{
			appData = filteredData.get (i);
			if (appData.filledOn.isAfter (Date))
				filteredData.remove (i);
		}
	}
	
	public void submitButtonHandler (ActionEvent E)
	{
		initFilters();
		System.out.println ("INITIALIZED");
		setFilters();
		System.out.println ("FILTERS SET");
		applyAllFilters();
		System.out.println ("FILTERS APPLIED");
		
//		System.out.println ("LENGTH :: " + filteredData.size());
		
//		System.out.println (filteredData.get(0).applicantName);
//		System.out.println (filteredData.get(0).enrollmentNumber);
//		System.out.println (filteredData.get(0).dataLink.toString());
		
		Parent root;
		FXMLLoader nLoader = new FXMLLoader (getClass().getResource ("/adminEnd/RS.fxml"));
		try {
			root = nLoader.load();
			ResultController controller = nLoader.getController();
			controller.setTable (filteredData);
			Stage secondaryStage = new Stage();
			Scene resultScene = new Scene (root);
			secondaryStage.setScene (resultScene);
			secondaryStage.show();
			((Node)(E.getSource())).getScene().getWindow().hide();
		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.println ("Cant Open new Window");
		}
		
	}
	
	/* ************************************************************************************************************************
	 *										Fields to Check if Filters are Set	
	 *************************************************************************************************************************/
	
	private boolean PI_nameFilter;
	private boolean PI_emailFilter;
	private boolean PI_enrollmentNumberFilter;
	private boolean PI_categoryFilter;
	private boolean PI_genderFilter;
	private boolean PI_phyDisabilityFilter;
	private boolean PI_dobFilter;
	
	private boolean EI_phdStreamFilter;
	private boolean EI_gradDegreeFilter;
	private boolean EI_postGradDegreeFilter;
	private boolean EI_XBoardFilter;
	private boolean EI_XIIBoardFilter;
	private boolean EI_gradDisciplineFilter;
	private boolean EI_postGradDisciplineFilter;
	private boolean EI_gradUniversityFilter;
	private boolean EI_postGradUniversityFilter;
	private boolean EI_gradStateFilter;
	private boolean EI_postGradStateFilter;
	private boolean EI_XBoardPercFilter;
	private boolean EI_XIIBoardPercFilter;
	private boolean EI_gradPercFilter;
	private boolean EI_postGradPercFilter;
	private boolean EI_gateScoreFilter;
	
	private boolean Submit_datedFromFilter;
	private boolean Submit_datedUptoFilter;
	
	 /* ***********************************************************************************************************************/
	
	public void initFilters ()
	{
		// Initially No Filter is Set
		
		PI_nameFilter = false;
		PI_emailFilter = false;
		PI_enrollmentNumberFilter = false;
		PI_categoryFilter = false;
		PI_genderFilter = false;
		PI_phyDisabilityFilter = false;
		PI_dobFilter = false;
		EI_phdStreamFilter = false;
		EI_gradDegreeFilter = false;
		EI_postGradDegreeFilter = false;
		EI_XBoardFilter = false;
		EI_XIIBoardFilter = false;
		EI_gradDisciplineFilter = false;
		EI_postGradDisciplineFilter = false;
		EI_gradUniversityFilter = false;
		EI_postGradUniversityFilter = false;
		EI_gradStateFilter = false;
		EI_postGradStateFilter = false;
		EI_XBoardPercFilter = false;
		EI_XIIBoardPercFilter = false;
		EI_gradPercFilter = false;
		EI_postGradPercFilter = false;
		EI_gateScoreFilter = false;
		Submit_datedFromFilter = false;
		Submit_datedUptoFilter = false;
		
		// Read All Files and Put in ArrayList
		filteredData.clear();
		
		BufferedReader br = null;
		int fileCount = 0;
		
		try {
			br = new BufferedReader (new FileReader ("src/DataBase/ID.txt"));
			fileCount = Integer.parseInt(br.readLine());
			br.close();
		} catch (Exception e)
		{
		}
		
		for (int i = 1; i <= fileCount; i++)
		{
			String Filepath = "src/DataBase/PHD2015";
			readFile (Filepath + i + ".txt");
		}
	}
	
	public void readFile (String Filepath)
	{
		BufferedReader br = null;
		ApplicationDetails appData = null;
		String TEMP;
		String[] Buffer;
		
		try {
			br = new BufferedReader (new FileReader (Filepath));
			appData = new ApplicationDetails();
			
			appData.dataLink = new File(Filepath).toURI().toURL();
			
			// ******  Following Reads are in Accordance to the Content in File ********
			
			TEMP = br.readLine();													// Line 1 = Enrollment ID
			Buffer = TEMP.split (":");	
			appData.enrollmentNumber = Buffer[1];
			
			TEMP = br.readLine();													// Line 2 = EMail
			Buffer = TEMP.split (":");
			appData.eMail = Buffer[1];
			
			TEMP = br.readLine();													// Line 3 = Name
			Buffer = TEMP.split (":");	
			appData.applicantName = Buffer[1];
			
			br.readLine();	// 4
			br.readLine();	// 5
			
			TEMP = br.readLine();													// Line 3 = Name
			Buffer = TEMP.split (":");
			appData.phdStream = Buffer[1];
			
			br.readLine();	// 7
			
			TEMP = br.readLine();
			Buffer = TEMP.split (":");
			for (int i = 0; i < Integer.parseInt (Buffer[1]); i++)
				br.readLine();
			
			TEMP = br.readLine();	// Gender 11
			Buffer = TEMP.split (":");
			appData.gender = Character.toUpperCase(Buffer[1].charAt(0));
			
			TEMP = br.readLine();	// Category 12
			Buffer = TEMP.split (":");
			appData.category = Buffer[1];
			
			TEMP = br.readLine();	// phy disable 13
			Buffer = TEMP.split (":");
			if (Buffer[1].toLowerCase().compareTo("yes") == 0)
				appData.physicallyDisabled = true;
			else
				appData.physicallyDisabled = false;
			
			TEMP = br.readLine();	// DOB 14
			Buffer = TEMP.split (":");
			DateTimeFormatter DTF = DateTimeFormatter.ofPattern ("yyyy-MM-dd");
			appData.DoB = LocalDate.parse (Buffer[1], DTF);
			
			br.readLine();
			br.readLine();	// 16
			br.readLine();
			br.readLine();
			
			Buffer = br.readLine().split (":");
			if (Buffer[1].toLowerCase().compareTo ("yes") == 0)
				br.readLine();
			
			Buffer = br.readLine().split (":");
			appData.X_Board = Buffer[1];
			
			Buffer = br.readLine().split (":");
			appData.X_Marks = Double.parseDouble (Buffer[1]);
			
			br.readLine(); // 23
			
			Buffer = br.readLine().split (":");
			appData.XII_Board = Buffer[1];
			
			Buffer = br.readLine().split (":");
			appData.XII_Marks = Double.parseDouble (Buffer[1]);
			
			br.readLine(); // 26
			
			Buffer = br.readLine().split (":");
			appData.gradDegree = Buffer[1];			
			
			Buffer = br.readLine().split (":");
			appData.gradDiscipline = Buffer[1];
			
			br.readLine();
			
			Buffer = br.readLine().split (":");
			appData.gradUniversity = Buffer[1];
			
			br.readLine();
			
			Buffer = br.readLine().split (":");
			appData.gradState = Buffer[1];
			
			br.readLine();
			
			Buffer = br.readLine().split (":");
			if (Buffer[1].toLowerCase().compareTo ("yes") == 0)
			{
				Buffer = br.readLine().split (":");
				appData.grad_cgpa_marks = Double.parseDouble (Buffer[1]);
			}
			
			Buffer = br.readLine().split (":");
			if (Buffer[1].toLowerCase().compareTo ("yes") == 0)
			{
				br.readLine();
				br.readLine();
				br.readLine();
				Buffer = br.readLine().split (":");
				if (Buffer[1].toLowerCase().compareTo ("yes") == 0)
				{
					br.readLine();
				}
			}
			
			Buffer = br.readLine().split (":"); //39
			if (Buffer[1].toLowerCase().compareTo ("yes") == 0)
			{
				br.readLine();
				br.readLine();
				
				Buffer = br.readLine().split (":"); //postState
				appData.postState = Buffer[1];
				
				Buffer = br.readLine().split (":"); //postDiscipline
				appData.postDiscipline = Buffer[1];
				
				Buffer = br.readLine().split (":"); //postDegree
				appData.postDegree = Buffer[1];
				
				br.readLine();
				br.readLine();
				
				Buffer = br.readLine().split (":"); //postState
				if (Buffer[1].toLowerCase().compareTo ("yes") == 0)
				{
					Buffer = br.readLine().split (":");
					appData.post_cgpa_marks = Double.parseDouble (Buffer[1]);
				}
			}
			
			Buffer = br.readLine().split (":"); //40
			if (Buffer[1].toLowerCase().compareTo ("yes") == 0)
			{
				br.readLine ();
				br.readLine();		// 
				
				br.readLine(); //
				
				br.readLine(); //
				
				br.readLine(); //rank
			}
			
			Buffer = br.readLine().split (":"); //40
			if (Buffer[1].toLowerCase().compareTo ("yes") == 0)
			{
				br.readLine ();
				br.readLine();		// 
				
				br.readLine(); //
				
				Buffer = br.readLine().split (":"); //Score
				appData.gate_Score = Double.parseDouble (Buffer[1]);
				
				br.readLine(); //postDegree
			}
			
			Buffer = br.readLine().split(":");
			if (Buffer[1].compareToIgnoreCase("yes") == 0)
				br.readLine();
			
			Buffer = br.readLine().split (":");
			DateTimeFormatter DTF2 = DateTimeFormatter.ofPattern ("yyyy/MM/dd");
			appData.filledOn = LocalDate.parse (Buffer[1], DTF2);
			
			br.close();
		} catch (IOException brError)
		{
			System.out.println ("Cant read File");
			brError.printStackTrace();
		}
		
		filteredData.add (appData);
	}
	
	public void setFilters ()
	{
		boolean P_TEMP, N_TEMP;
		
		// EMail Filter
		N_TEMP = (PI_eMail.getText() == null) || (PI_eMail.getText().isEmpty());
		if (!N_TEMP)
			PI_emailFilter = true;
		
		// Name Filter
		N_TEMP = (PI_Name.getText() == null) || (PI_Name.getText().isEmpty());
		if (!N_TEMP)
			PI_nameFilter = true;
		
		// Enrollment Number Filter
		N_TEMP = (PI_enrollmentNumber.getText() == null) || (PI_enrollmentNumber.getText().isEmpty());
		if (!N_TEMP)
			PI_enrollmentNumberFilter = true;
		
		// Category Filter
		N_TEMP = (PI_category.getValue() == null) || (PI_category.getValue().isEmpty()) || (PI_category.getValue().compareTo ("NO_CATEGORY_FILTER") == 0);
		if (!N_TEMP)
			PI_categoryFilter = true;
		
		// Gender Filter
		P_TEMP = PI_Gender_M.isSelected() || PI_Gender_F.isSelected();
		if (P_TEMP)
			PI_genderFilter = true;
		
		// Phy. Disability Filter
		P_TEMP = PI_phyDisabled_Y.isSelected() || PI_phyDisabled_N.isSelected();
		if (P_TEMP)
			PI_phyDisabilityFilter = true;
		
		// DOB Filter
		P_TEMP = PI_DoB_Before.isSelected() || PI_DoB_On.isSelected() || PI_DoB_After.isSelected();
		N_TEMP = (PI_DoB_DatePicker.getValue() == null);
		if (P_TEMP && !N_TEMP)
			PI_dobFilter = true;
		
		/* ***********************************************************************************************************************/
		
		// PhD Stream Filter
		N_TEMP = (EI_phdStream.getValue() == null) || (EI_phdStream.getValue().isEmpty()) || (EI_phdStream.getValue().compareTo ("NO_PHD_STREAM_FILTER") == 0);
		if (!N_TEMP)
			EI_phdStreamFilter = true;
		
		// Graduation Degree Filter
		N_TEMP = (EI_gradDegree.getValue() == null) || (EI_gradDegree.getValue().isEmpty()) || (EI_gradDegree.getValue().compareTo ("NO_GRADUATION_DEGREE_FILTER") == 0);
		if (!N_TEMP)
			EI_gradDegreeFilter = true;
		System.out.println (EI_gradDegree.getValue() + " " + N_TEMP);
		
		// Post Graduation Degree Filter
		N_TEMP = (EI_postGradDegree.getValue() == null) || (EI_postGradDegree.getValue().isEmpty()) || (EI_postGradDegree.getValue().compareTo ("NO_POST_GRADUATION_DEGREE_FILTER") == 0);
		if (!N_TEMP)
			EI_postGradDegreeFilter = true;
		
		// Class X Board Filter
		N_TEMP = (EI_XBoard.getValue() == null) || (EI_XBoard.getValue().isEmpty()) || (EI_XBoard.getValue().compareTo ("NO_X_BOARD_FILTER") == 0);
		if (!N_TEMP)
			EI_XBoardFilter = true;
	
		// Class XII Board Filter
		N_TEMP = (EI_XIIBoard.getValue() == null) || (EI_XIIBoard.getValue().isEmpty()) || (EI_XIIBoard.getValue().compareTo ("NO_XII_BOARD_FILTER") == 0);
		if (!N_TEMP)
			EI_XIIBoardFilter = true;
		
		// Graduation Discipline Filter
		N_TEMP = (EI_gradDiscipline.getValue() == null) || (EI_gradDiscipline.getValue().isEmpty()) || (EI_gradDiscipline.getValue().compareTo ("NO_GRADUATION_DISCIPLINE_FILTER") == 0);
		if (!N_TEMP)
			EI_gradDisciplineFilter = true;
		
		// Graduation Discipline Filter
		N_TEMP = (EI_postGradDiscipline.getValue() == null) || (EI_postGradDiscipline.getValue().isEmpty()) || (EI_postGradDiscipline.getValue().compareTo ("NO_POST_GRADUATION_DISCIPLINE_FILTER") == 0);
		if (!N_TEMP)
			EI_postGradDisciplineFilter = true;
		
		// Graduation University Filter
		N_TEMP = (EI_gradUniversity.getText() == null) || (EI_gradUniversity.getText().isEmpty());
		if (!N_TEMP)
			EI_gradUniversityFilter = true;
		
		// Post Graduation University Filter
		N_TEMP = (EI_postGradUniversity.getText() == null) || (EI_postGradUniversity.getText().isEmpty());
		if (!N_TEMP)
			EI_postGradUniversityFilter = true;
		
		// Graduation State Filter
		N_TEMP = (EI_gradState.getValue() == null) || (EI_gradState.getValue().isEmpty()) || (EI_gradState.getValue().compareTo ("NO_STATE_FILTER") == 0);
		if (!N_TEMP)
			EI_gradStateFilter = true;
		
		// Graduation State Filter
		N_TEMP = (EI_postGradState.getValue() == null) || (EI_postGradState.getValue().isEmpty()) || (EI_postGradState.getValue().compareTo ("NO_STATE_FILTER") == 0);
		if (!N_TEMP)
			EI_postGradStateFilter = true;
		
		// Class X Percentage
		P_TEMP = EI_XBoardPerc_GT.isSelected() || EI_XBoardPerc_EQ.isSelected() || EI_XBoardPerc_LT.isSelected();
		N_TEMP = (EI_XBoardPerc.getText() == null) || (EI_XBoardPerc.getText().isEmpty());
		if (P_TEMP && !N_TEMP)
			EI_XBoardPercFilter = true;
		
		// Class XII Percentage
		P_TEMP = EI_XIIBoardPerc_GT.isSelected() || EI_XIIBoardPerc_EQ.isSelected() || EI_XIIBoardPerc_LT.isSelected();
		N_TEMP = (EI_XIIBoardPerc.getText() == null) || (EI_XIIBoardPerc.getText().isEmpty());
		if (P_TEMP && !N_TEMP)
			EI_XIIBoardPercFilter = true;
		
		// Graduation Percentage
		P_TEMP = EI_gradPerc_GT.isSelected() || EI_gradPerc_EQ.isSelected() || EI_gradPerc_LT.isSelected();
		N_TEMP = (EI_gradPerc.getText() == null) || (EI_gradPerc.getText().isEmpty());
		if (P_TEMP && !N_TEMP)
			EI_gradPercFilter = true;
		
		// Post Graduation Percentage
		P_TEMP = EI_postGradPerc_GT.isSelected() || EI_postGradPerc_EQ.isSelected() || EI_postGradPerc_LT.isSelected();
		N_TEMP = (EI_postGradPerc.getText() == null) || (EI_postGradPerc.getText().isEmpty());
		if (P_TEMP && !N_TEMP)
			EI_postGradPercFilter = true;
		
		// Gate Score
		P_TEMP = EI_gateScore_GT.isSelected() || EI_gateScore_EQ.isSelected() || EI_gateScore_LT.isSelected();
		N_TEMP = (EI_gateScore.getText() == null) || (EI_gateScore.getText().isEmpty());
		if (P_TEMP && !N_TEMP)
			EI_gateScoreFilter = true;

		 /* ***********************************************************************************************************************/
		
		// FromDate Filter
		N_TEMP = (Submit_datedFrom.getValue() == null);
		if (!N_TEMP)
			Submit_datedFromFilter = true;
		
		// UptoDate Filter
		N_TEMP = (Submit_datedUpto.getValue() == null);
		if (!N_TEMP)
			Submit_datedUptoFilter = true;
		
	}
	
	public void applyAllFilters ()
	{
		apply_PI_emailFilter();
		apply_PI_nameFilter();
		apply_PI_enrollmentNumberFilter();
		apply_PI_categoryFilter();
		apply_PI_genderFilter();
		apply_PI_phyDisabilityFilter();
		apply_PI_dobFilter();
		
		apply_EI_phdStreamFilter();
		apply_EI_gradDegreeFilter();
		apply_EI_postGradDegreFilter();
		apply_EI_XBoardFilter();
		apply_EI_XIIBoardFilter();
		apply_EI_gradDisciplineFilter();
		apply_EI_postGradDisciplineFilter();
		apply_EI_gradUniversityFilter();
		apply_EI_postGradUniversityFilter();
		apply_EI_gradStateFilter();
		apply_EI_postGradStateFilter();
		apply_EI_XBoardPercFilter();
		apply_EI_XIIBoardPercFilter();
		apply_EI_gradPercFilter();
		apply_EI_postGradPercFilter();
		apply_EI_gateScoreFilter();	
		
		apply_Submit_datedFromFilter();
		apply_Submit_datedUptoFilter();
	}
}