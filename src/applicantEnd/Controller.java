package applicantEnd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller implements Initializable{
	
	@FXML 
	TextField Email;
	@FXML 
	TextField Name;
	@FXML 
	TextField EnrollmentNo;
	@FXML 
	TextArea AddressCorrespondence;
	@FXML 
	TextField Mobile;
	@FXML 
	RadioButton CS ;
	@FXML 
	RadioButton ECE;
	@FXML 
	RadioButton CB;
	@FXML
	ComboBox<String> Pref1;
	@FXML
	ComboBox <String>Pref2;
	@FXML
	ComboBox<String> Pref3;
	@FXML 
	RadioButton Male ;
	@FXML 
	RadioButton Female ;
	@FXML 
	RadioButton General ;
	@FXML 
	RadioButton SC ;
	@FXML 
	RadioButton ST ;
	@FXML 
	RadioButton OBC ;
	@FXML 
	RadioButton Yes1 ;
	@FXML 
	RadioButton No1 ;
	@FXML
	DatePicker DOB;
	@FXML 
	RadioButton Yes2 ;
	@FXML 
	RadioButton No2 ;
	@FXML 
	TextField Father;
	@FXML
	ComboBox<String> Nationality;
	@FXML
	TextArea PermanentAddr; 
	@FXML 
	TextField PinCode;
	@FXML 
	ComboBox<String> xboard;
	@FXML 
	TextField xpercent;
	@FXML 
	ComboBox<Integer> xyear;
	@FXML 
	ComboBox<String> xiiboard;
	@FXML 
	TextField xiipercent;
	@FXML 
	ComboBox<Integer> xiiyear;
	@FXML 
	TextField Degree;
	@FXML 
	TextField Department;
	@FXML 
	TextField CollegeName;
	@FXML 
	TextField UniversityName;
	@FXML 
	TextField City;
	@FXML 
	ComboBox<String> State;
	@FXML 
	ComboBox<Integer> GradYear;
	@FXML
	RadioButton CGPA,MARKS;
	@FXML 
	TextField CGPA1;
	@FXML 
	ComboBox<String> CGPA2;
	@FXML 
	TextField MarksPercent;
	@FXML
	ComboBox<String> SubPref1;
	@FXML
	ComboBox<String> SubPref2;
	@FXML
	ComboBox<String> SubPref3;
	@FXML
	ComboBox<String> SubPref4;
	@FXML 
	TextField PGDegree;
	@FXML 
	TextField PGDepartment;
	@FXML 
	TextField PGCollegeName;
	@FXML 
	TextField PGCity;
	@FXML 
	ComboBox<String> PGState;
	@FXML 
	TextField Thesis;
	@FXML
	ComboBox<Integer> PGGradYear;
	@FXML
	RadioButton PGCGPA,PGMARK;
	@FXML 
	TextField PGCGPA1;
	@FXML 
	ComboBox<String> PGCGPA2;
	@FXML 
	TextField PGMarksPercent;
	@FXML
	TextField exmname;
	@FXML
	TextField Subject;
	@FXML
	ComboBox<Integer> Year;
	@FXML
	TextField Score;
	@FXML
	TextField Rank;
	@FXML
	TextField GateArea;
	@FXML
	TextField GateMarks;
	@FXML
	ComboBox<Integer> GateYear;
	@FXML
	TextField GateScore;
	@FXML
	TextField GateRank;
	@FXML
	TextField Achievements;
	@FXML
	Button Browse1;
	@FXML
	Button Browse2;
	@FXML
	Button Save1;
	@FXML
	Button Save2;
	@FXML
	Button Save3;
	@FXML
	Button Save4;
	@FXML
	Button Submit;
	@FXML
	Label EmailLabel,browselabel1;
	@FXML
	Label MobileLabel,browselabel2;
	@FXML
	ToggleGroup TG1;
	@FXML
	ToggleGroup Gender,Category,PD,Widow,Grade,PGGRADE;
	@FXML
	Label pincode;
	
	ObservableList<String> pref1 = FXCollections.observableArrayList("Artificial Intelligence and Robotics - CSE","Compilers - CSE","Computer Architecture and Systems Design - CSE","Computer Graphics - CSE","Computer Vision - CSE","Image Analysis and Biometrics - CSE","Information Management and Data Engineering - CSE","Machine Learning - CSE","Massively Parallel Systems - CSE","Mobile Computing and Networking Applications - CSE","Program Analysis - CSE","Security and Privacy - CSE","Signal and Image Processing - CSE","Software Engineering - CSE","Theoretical Computer Science - CSE","Wireless Networks - CSE");
	ObservableList<String> pref2 = FXCollections.observableArrayList("Computer Architecture and Systems Design - ECE","Controls and Robotics - ECE","Digital and Analog VLSI Systems Design - ECE","Electromagnetics - ECE","Embedded and VLSI systems design - ECE","Embedded Systems - ECE","Fiber-Wireless Architectures - ECE","Machine Learning - ECE","OFDM based Optical Access Networks - ECE","Optical Wireless Communication Systems - ECE","RF and mixed signal electronics - ECE","Signal and Image Processing - ECE","Wireless Communication - ECE","Wireless Networks - ECE");
	ObservableList<String> pref3 = FXCollections.observableArrayList("Biophysics - CB","Structural Biology - CB","Systems Biology - CB");
	ObservableList<String> nationality = FXCollections.observableArrayList("Bhutan","Pakistan","India");
	ObservableList<Integer> xYear = FXCollections.observableArrayList(2013,2012,2011,2010,2009,2008,2007,2006,2005,2004,2003,2002,2001,2000,1999,1998,1997,1996,1995,1994,1993,1992,1991,1990,1989,1988,1987,1986,1985,1984,1983,1982,1981,1980,1979,1978,1977,1976,1975,1974,1973,1972,1971,1970,1969,1968,1967,1966,1965,1964,1963,1962,1961,1960,1959,1958,1957,1956,1955,1954,1953,1952,1951);
	ObservableList<Integer> xiiYear = FXCollections.observableArrayList(2015,2014,2013,2012,2011,2010,2009,2008,2007,2006,2005,2004,2003,2002,2001,2000,1999,1998,1997,1996,1995,1994,1993,1992,1991,1990,1989,1988,1987,1986,1985,1984,1983,1982,1981,1980,1979,1978,1977,1976,1975,1974,1973,1972,1971,1970,1969,1968,1967,1966,1965,1964,1963,1962,1961,1960,1959,1958,1957,1956,1955,1954,1953,1952,1951);
	ObservableList<Integer> gradYear = FXCollections.observableArrayList(2015,2014,2013,2012,2011,2010,2009,2008,2007,2006,2005,2004,2003,2002,2001,2000,1999,1998,1997,1996,1995,1994,1993,1992,1991,1990,1989,1988,1987,1986,1985,1984,1983,1982,1981,1980,1979,1978,1977,1976,1975,1974,1973,1972,1971,1970,1969,1968,1967,1966,1965,1964,1963,1962,1961,1960,1959,1958,1957,1956,1955,1954,1953,1952,1951);
	ObservableList<String> states = FXCollections.observableArrayList("Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Raipur","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu & Kashmir","Jharkhand","Karnataka","Kerela","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha (Orissa)","Punjab","Rajasthan","Jaipur","Sikkim","Tamil Nadu","Chennai","Telangana","Andhra Pradesh","Tripura","Uttar Pradesh","Uttarakhand","West Bengal");
	ObservableList<String> cgpa2 = FXCollections.observableArrayList("4","10");
	ObservableList<String> nations = FXCollections.observableArrayList("Afghanistan","Albania","Algeria","Andorra","Angola","Antigua & Deps","Argentina","Armenia","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bhutan","Bolivia","Bosnia Herzegovina","Botswana","Brazil","Brunei","Bulgaria","Burkina","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Central African Rep","Chad","Chile","China","Colombia","Comoros","Congo","Congo {Democratic Rep}","Costa Rica","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","East Timor","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Fiji","Finland","France","Gabon","Gambia","Georgia","Germany","Ghana","Greece","Grenada","Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti","Honduras","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland {Republic}","Israel","Italy","Ivory Coast","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Kiribati","Korea North","Korea South","Kosovo","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia","Moldova","Monaco","Mongolia","Montenegro","Morocco","Mozambique","Myanmar, {Burma}","Namibia","Nauru","Nepal","Netherlands","New Zealand","Nicaragua","Niger","Nigeria","Norway","Oman","Pakistan","Palau","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Qatar","Romania","Russian Federation","Rwanda","St Kitts & Nevis","St Lucia","Saint Vincent & the Grenadines","Samoa","San Marino","Sao Tome & Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","South Sudan","Spain","Sri Lanka","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Togo","Tonga","Trinidad & Tobago","Tunisia","Turkey","Turkmenistan","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States","Uruguay","Uzbekistan","Vanuatu","Vatican City","Venezuela","Vietnam","Yemen","Zambia","Zimbabwe");
	ObservableList<String> boards = FXCollections.observableArrayList("Andhra Pradesh Board of Intermediate Education","Andhra Pradesh Board of Secondary Education","Board of Higher Secondary Education, Delhi","Assam Board of Secondary Education","Bihar School Examination Board","Board of Youth Education India","Board of School Education, Haryana","Board of Secondary Education, Madhya Pradesh","Board of Secondary Education Madhya Bharat Gwalior","Board of Secondary Education, Rajasthan","Chhattisgarh Board of Secondary Education","Central Board of Secondary Education","Central Board Of Patna, Bihar","Central Board Of Education Ajmer New Delhi","Goa Board of Secondary & Higher Secondary Education","Gujarat Secondary Education Board","Himachal Pradesh Board of School Education","Indian Board of Science Education(not recognized)","Indian Board of School Education","Indian Board of Computer Education","J&K State Board of School Education","Jharkhand Academic Council","Karnataka Board of the Pre-University Education","Karnataka Secondary Education Examination Board","Kerala Board of Public Examinations","Maharashtra State Board of Secondary and Higher Secondary Education","Manipur Board of Secondary Education","Manipur Council of Higher Secondary Education","Meghalaya Board of School Education","Mizoram Board of School Education","North East National Board Of School Education (NENBSE)","Northwest Accreditation Commission","Nagaland Board of School Education","National Institute of Open Schooling","Orissa Board of Secondary Education","Orissa Council of Higher Secondary Education","Punjab School Education Board","Rajasthan Board of Secondary Education","Tamil Nadu Board of Higher Secondary Education","Tamil Nadu Board of Secondary Education","Tamilnadu Council for Open and Distance Learning","Tripura Board of Secondary Education","Telangana Board of Intermediate Education","Telangana Board of Secondary Education","Uttar Pradesh Board of High School and Intermediate Education","Sampurnanand Sanskrit Vishwavidyalaya Varanasi Uttar Pradesh","Uttarakhand Board of School Education","West Bengal Board of Secondary Education","West Bengal Council of Higher Secondary Education","West Bengal State Council of Vocational Education and Training","Board of Secondary Education Kant Shahjahanpur Uttar Pradesh","The West Bengal Council of Rabindra Open Schooling");
	ObservableList<String> subpref1 = FXCollections.observableArrayList("Advanced Signal Processing","Statistical Signal Processing","Digital VLSI Design","Analog CMOS design","Digital Communications","Communication Networks","Linear systems","Introduction to Robotics","RF Circuit design","Antennas and Propagation","Embedded Systems");

	public void call() throws IOException
	{
		String temp;
		BufferedReader f = new BufferedReader(new FileReader("./src/file.txt"));
		while((temp = f.readLine())!= null)
		{
			System.out.print("\"" + temp + "\"," );
		}
		f.close();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Nationality.setItems(nationality);
		xyear.setItems(xYear);
		xiiyear.setItems(xiiYear);
		State.setItems(states);
		CGPA2.setItems(cgpa2);
		PGCGPA2.setItems(cgpa2);		
		GradYear.setItems(gradYear);
		Nationality.setItems(nations);
		xiiboard.setItems(boards);
		xboard.setItems(boards);
		SubPref1.setItems(subpref1);
		SubPref2.setItems(subpref1);
		SubPref3.setItems(subpref1);
		SubPref4.setItems(subpref1);
		PGState.setItems(states);
		PGGradYear.setItems(gradYear);
		GateYear.setItems(gradYear);
		Year.setItems(gradYear);
		EnrollmentNo.setDisable(true);
		T1.setExpanded(false);
		T1.setVisible(false);
		T2.setExpanded(false);T4.setExpanded(false);T4.setVisible(false);
		T2.setVisible(false);T3.setExpanded(false);T3.setVisible(false);
	}
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
 }
	public void checkemail()
	{
		if(!isValidEmailAddress(Email.getText()))
		{
			EmailLabel.setText("Incorrect Email Address");
			EmailLabel.setTextFill(Color.web("#ee0a0a"));
		}
		else
		{
			EmailLabel.setText("");
		}
	}
	public boolean name()
	{
		String regex = "^[\\p{L} .'-]+$";
		String data = Name.getText();
		if(!data.matches(regex))
		{
			namelabel.setText("Invalid Name");
			namelabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
			return false;
		}
		else
		{
			namelabel.setText("");
			Name.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
			return true;
		}
	}
	public boolean mobilecheck()
	{
		String regex = "^\\d+$";
		String data = Mobile.getText();
		if(!(data.matches(regex) && data.length()==10))
		{
			mobilelabel.setText("Incorrect Mobile Number");
			mobilelabel.setTextFill(Color.web("#ee0a0a"));
			return false;
		}
		else
		{
			mobilelabel.setText("");
			Mobile.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
			return true;
		}
	}
	public void stream()
	{
		if(CS.isSelected()== true)
		{
			Pref1.setItems(pref1);
			Pref2.setItems(pref1);
			Pref3.setItems(pref1);
		}
		else if(ECE.isSelected()== true)
		{
			Pref1.setItems(pref2);
			Pref2.setItems(pref2);
			Pref3.setItems(pref2);
		}
		else if(CB.isSelected()== true)
		{
			Pref1.setItems(pref3);
			Pref2.setItems(pref3);
			Pref3.setItems(pref3);
		}
	}
	public boolean fname()
	{
		String regex = "^[\\p{L} .'-]+$";
		String data = Father.getText();
		if(!data.matches(regex))
		{
			fatherlabel.setText("Invalid Name");
			fatherlabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
			return false;
		}
		else
		{
			fatherlabel.setText("");
			Father.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
			return true;
		}
		
	}
	public boolean pincode()
	{
		String regex = "^\\d+$";
		String data = PinCode.getText();
		if(!(data.matches(regex)))
		{
			pincodelabel.setText("Incorrect Pin Code");
			pincodelabel.setTextFill(Color.web("#ee0a0a"));
			return false;
		}
		else
		{
			pincodelabel.setText("");
			PinCode.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
			return true;
		}
	}
	public boolean xmarks()
	{
		String regex = "^\\d.+$";
		String data = xpercent.getText();
		if(!(data.matches(regex) && (Double.parseDouble(data) <= 100)))
		{
			xpercentlabel.setText("Incorrect Input");
			xpercentlabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
			xpercent.setStyle("-fx-text-fill: black; -fx-font-size: 16;");
			return false;
		}
		else
		{
			xpercentlabel.setText("");
			xpercent.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
			return true;
		}
	}
	public boolean xiimarks()
	{
		String regex = "^\\d.+$";
		String data = xpercent.getText();
		if(!(data.matches(regex) && (Double.parseDouble(data) <= 100)))
		{
			xiipercentlabel.setText("Incorrect Input");
			xiipercentlabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
			xiipercent.setStyle("-fx-text-fill: black; -fx-font-size: 16;");
			return false;
		}
		else
		{
			xiipercentlabel.setText("");
			xiipercent.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
			return true;
		}
	}
	public boolean special()
	{
		int i = 0;
		String regex = "^[\\p{L} .'-]+$";
		String data1 = Degree.getText();
		if(!data1.matches(regex))
		{
			degreelabel.setText("Invalid Name");
			degreelabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
			i = 1;
		}
		else 
		{
			degreelabel.setText("");
			Degree.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
			i = 0;
		}
		String data2 = Department.getText();
		if(!data2.matches(regex))
		{
			departmentlabel.setText("Invalid Name");
			departmentlabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
			i = 1;
		}
		else
		{
			departmentlabel.setText("");
			Department.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
			i = 0;
		}
		String data3 = CollegeName.getText();
		if(!data3.matches(regex))
		{
			collegenamelabel.setText("Invalid Name");
			collegenamelabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
			i = 1;
		}
		else
		{
			collegenamelabel.setText("");
			CollegeName.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
			i = 0;
		}
		String data4 = UniversityName.getText();
		if(!data4.matches(regex))
		{
			universitylabel.setText("Invalid Name");
			universitylabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
			i = 1;
		}
		else
		{
			universitylabel.setText("");
			UniversityName.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
			i = 0;
		}
		String data5 = City.getText();
		if(!data5.matches(regex))
		{
			citylabel.setText("Invalid Name");
			citylabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
			i = 1;
		}
		else
		{
			citylabel.setText("");
			City.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
			i = 0;
		}
		if(i==1)
			return false;
		else
			return true;
	}
	public void grade()
	{
		if(CGPA.isSelected() == true)
		{
			MarksPercent.setDisable(true);
			CGPA1.setDisable(false);
			CGPA2.setDisable(false);
		}
		else if(MARKS.isSelected() == true)
		{
			MarksPercent.setDisable(false);
			CGPA1.setDisable(true);
			CGPA2.setDisable(true);
		}
	}
	public boolean cgpa()
	{
		String regex = "^\\d+$";
		String data = CGPA1.getText();
		if(!((data.matches(regex)) && (Double.parseDouble(data) <= Double.parseDouble(CGPA2.getValue()))))
		{
			CGPA1.setText("Incorrect Input");
			CGPA1.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
			return false;
		}
		else
		{
			CGPA1.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
			return true;
		}
	}
	public boolean MarksPercent()
	{
		String regex = "^\\d+$";
		String data = MarksPercent.getText();
		if(!((data.matches(regex))&& (Double.parseDouble(data) <= 100)))
		{
			MarksPercent.setText("Incorrect Input");
			MarksPercent.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
			return false;
		}
		else
		{
			MarksPercent.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
			return true;
		}
	}
	public void pggrade()
	{
		if(PGCGPA.isSelected() == true)
		{
			PGMarksPercent.setDisable(true);
			PGCGPA1.setDisable(false);
			PGCGPA2.setDisable(false);
		}
		else if(PGMARK.isSelected() == true)
		{
			PGMarksPercent.setDisable(false);
			PGCGPA1.setDisable(true);
			PGCGPA2.setDisable(true);
		}
	}
	public void pgcgpa()
	{		
	String regex = "^\\d+$";
	String data = PGCGPA1.getText();
	if(!((data.matches(regex)) && (Integer.parseInt(data) <= Integer.parseInt(PGCGPA2.getValue()))))
	{
		PGCGPA1.setText("Incorrect Input");
		PGCGPA1.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
	}
	else
	{
		PGCGPA1.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
	}
	}
	public void pgmarks()
	{
		String regex = "^\\d+$";
		String data = PGMarksPercent.getText();
		if(!((data.matches(regex))&& (Integer.parseInt(data) <= 100)))
		{
			PGMarksPercent.setText("Incorrect Input");
			PGMarksPercent.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
		}
		else
		{
			PGMarksPercent.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
		}
	}
	public void score()
	{
		String regex = "^\\d+$";
		String data = Score.getText();
		if(!(data.matches(regex) && (Integer.parseInt(data) <= 100)))
		{
			Score.setText("Incorrect Input");
			Score.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
		}
		else
		{
			Score.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
		}
	}
	public void rank()
	{
		String regex = "^\\d+$";
		String data = Rank.getText();
		if(!(data.matches(regex)))
		{
			Rank.setText("Incorrect Input");
			Rank.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
		}
		else
		{
			Rank.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
		}
	}
	public void gatemarks()
	{
		String regex = "^\\d+$";
		String data = GateMarks.getText();
		if(!(data.matches(regex) && (Integer.parseInt(data) <= 100)))
		{
			GateMarks.setText("Incorrect Input");
			GateMarks.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
		}
		else
		{
			GateMarks.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
		}
	}
	public void gaterank()
	{
		String regex = "^\\d+$";
		String data = GateRank.getText();
		if(!(data.matches(regex)))
		{
			GateRank.setText("Incorrect Input");
			GateRank.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
		}
		else
		{
			GateRank.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
		}
	}
	public void gatescore()
	{
		String regex = "^\\d+$";
		String data = GateScore.getText();
		if(!(data.matches(regex) && (Integer.parseInt(data) <= 100)))
		{
			GateScore.setText("Incorrect Input");
			GateScore.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
		}
		else
		{
			GateScore.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
		}
	}
		
	@FXML
	TitledPane T1,T2,T3,T4;
	@FXML
	CheckBox C1,C2,C3,C4;
	public void one()
	{
		if(C1.isSelected()==true)
		{
			T1.setVisible(true);
			T1.setExpanded(true);			
		}
		else
		{
			T1.setVisible(false);
			T1.setExpanded(false);
		}
	}	
	public void two()
	{
		if(C2.isSelected()==true)
		{
			T2.setVisible(true);
			T2.setExpanded(true);			
		}
		else
		{
			T2.setVisible(false);
			T2.setExpanded(false);
		}
	}
	public void three()
	{
		if(C3.isSelected()==true)
		{
			T3.setVisible(true);
			T3.setExpanded(true);			
		}
		else
		{
			T3.setVisible(false);
			T3.setExpanded(false);
		}
	}
	public void four()
	{
		if(C4.isSelected()==true)
		{
			T4.setVisible(true);
			T4.setExpanded(true);			
		}
		else
		{
			T4.setVisible(false);
			T4.setExpanded(false);
		}
	}
	
	public void browse1() throws IOException
	{	
	RandomAccessFile f = new RandomAccessFile("./src/DataBase/ID.txt", "rw");
	String	temp = f.readLine();
	int	x = Integer.parseInt(temp);
	x++;
	f.close();
	FileChooser f1 = new FileChooser();
	File file = f1.showOpenDialog(new Stage());
	f1.setTitle("Open Resource File");
	browselabel1.setText(file.getName());
	try{
		try {
			Files.copy(file.toPath(), new File("./src/CV/PHD2015" + x +".pdf").toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	catch(NullPointerException e)
	{}
	}	
	public void browse2() throws IOException
	{
		RandomAccessFile f = new RandomAccessFile("./src/DataBase/ID.txt", "rw");
		String	temp = f.readLine();
		int	x = Integer.parseInt(temp);
		x++;
		f.close();
		FileChooser f1 = new FileChooser();
		File file = f1.showOpenDialog(new Stage());
		f1.setTitle("Open Resource File");
		browselabel2.setText(file.getName());
		try{
			try {
				Files.copy(file.toPath(), new File("./src/SOP/PHD2015" + x + ".pdf").toPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		catch(NullPointerException e)
		{}
	}
	public void shadow(Label l,TextField t)
	{
		DropShadow borderGlow= new DropShadow();
		borderGlow.setColor(Color.RED);			 
		t.setEffect(borderGlow);
		l.setText("This field is required");
		l.setStyle("-fx-text-fill: red; -fx-font-size: 16;");		
	}
	public void shadow(Label l,TextArea t)
	{
		DropShadow borderGlow= new DropShadow();
		borderGlow.setColor(Color.RED);			 
		t.setEffect(borderGlow);
		l.setText("This field is required");
		l.setStyle("-fx-text-fill: red; -fx-font-size: 16;");		
	}
	public void shadow(Label l,ComboBox<?> t)
	{
		DropShadow borderGlow= new DropShadow();
		borderGlow.setColor(Color.RED);			 
		t.setEffect(borderGlow);
		l.setText("This field is required");
		l.setStyle("-fx-text-fill: red; -fx-font-size: 16;");		
	}	
	public boolean PG()
	{
		int check = 0;
		String regex = "^[\\p{L} .'-]+$";
		String data1 = PGCollegeName.getText();
		if(!data1.matches(regex))
		{
			pgcollegenamelabel.setText("Invalid Name");
			pgcollegenamelabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
			check =1;
		}
		else
		{
			pgcollegenamelabel.setText("");
			PGCollegeName.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
			check = 0;
		}
		String data2 = PGCity.getText();
		if(!data2.matches(regex))
		{
			pgcitylabel.setText("Invalid Name");
			pgcitylabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
			check =1;
		}
		else
		{
			pgcitylabel.setText("");
			PGCity.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
			check = 0;
		}
		String data3 = PGState.getValue();
		if(!data3.matches(regex))
		{
			pgstatelabel.setText("Invalid Name");
			pgstatelabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
			check =1;
		}
		else
		{
			pgstatelabel.setText("");
			PGState.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
			check = 0;
		}
		String data4 = PGDepartment.getText();
		if(!data4.matches(regex))
		{
			pgdepartmentlabel.setText("Invalid Name");
			pgdepartmentlabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
			check =1;
		}
		else
		{
			pgdepartmentlabel.setText("");
			PGDepartment.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
			check = 0;
		}
		String data5 = Thesis.getText();
		if(!data5.matches(regex))
		{
			pgthesislabel.setText("Invalid Name");
			pgthesislabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
			check =1;
		}
		else
		{
			pgthesislabel.setText("");
			Thesis.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
			check = 0;
		}
		String data6 = PGDegree.getText();
		if(!data6.matches(regex))
		{
			pgdegreelabel.setText("Invalid Name");
			pgdegreelabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
			check =1;
		}
		else
		{
			pgdegreelabel.setText("");
			PGDegree.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
			check = 0;
		}
		if(check == 0)
			return true;
		else 
			return false;
	}
	public void shadow(Label l)
	{
		l.setText("This field is required");
		l.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
	}
	@FXML 
	Label mobilelabel,pincodelabel,emaillabel,namelabel,enrollmentlabel,aoclabel,pref1label,doblabel,fatherlabel;
	@FXML
	Label nationalitylabel,pmnaddresslabel,xboardlabel,xpercentlabel,xyearlabel,xiiboardlabel,xiipercentlabel;
	@FXML
	Label xiiyearlabel,degreelabel,departmentlabel,collegenamelabel,universitylabel,citylabel,statelabel,gradyearlabel;
	@FXML
	Label subpref1label,pggradyearlabel,yearlabel,gateyearlabel,subpref2label,subpref3label,streamlabel,genderlabel,categorylabel,pdlabel,widowlabel;
	@FXML
	Label pgcollegenamelabel,pgcitylabel,pgstatelabel,pgdepartmentlabel,pgdegreelabel,pgthesislabel;
	public void submit() throws IOException
	{
		int check = 0;
		if((Email.getText()==null) || (Email.getText().isEmpty()))
		{	 
			shadow(emaillabel,Email);
			check = 1;
		}
		if((Name.getText()==null) || (Name.getText().isEmpty()))
		{	 
			shadow(namelabel,Name);
			check = 1;
		}
		if((AddressCorrespondence.getText()==null) || (AddressCorrespondence.getText().isEmpty()))
		{	 
			shadow(aoclabel,AddressCorrespondence);
			check = 1;
		}
		if((Mobile.getText()==null) || (Mobile.getText().isEmpty()))
		{	 
			shadow(mobilelabel,Mobile);
			check = 1;
		}
		if((TG1.getSelectedToggle()==null))
		{	 
			shadow(streamlabel);	
			check = 1;
		}
		if((Pref1.getValue()==null))
		{	 
			shadow(pref1label,Pref1);
			check = 1;
		}
		if(Gender.getSelectedToggle()==null)
		{
			shadow(genderlabel);
			check = 1;			
		}
		if(Category.getSelectedToggle()==null)
		{
			shadow(categorylabel);
			check = 1;						
		}
		if(PD.getSelectedToggle()==null)
		{
			shadow(pdlabel);
			check = 1;									
		}
		if(DOB == null)
		{
			shadow(doblabel);
			check = 1;	
		}
		if(Widow.getSelectedToggle()==null)
		{
			shadow(widowlabel);
			check = 1;			
		}
		if(Father.getText()==null || (Father.getText().isEmpty()))
		{
			shadow(fatherlabel,Father);
			check = 1;			
		}
		if(Nationality.getValue()==null)
		{
			shadow(nationalitylabel,Nationality);
			check = 1;
		}
		if(PermanentAddr.getText()==null || (PermanentAddr.getText().isEmpty()))
		{
			shadow(pmnaddresslabel,PermanentAddr);
			check = 1;			
		}
		if(PinCode.getText()==null || (PinCode.getText().isEmpty()))
		{
			shadow(pincodelabel,PinCode);
			check = 1;						
		}
		if(xboard.getValue()==null)
		{
			shadow(xboardlabel,xboard);
			check = 1;	
		}
		if(xpercent.getText()==null || (xpercent.getText().isEmpty()))
		{
			shadow(xpercentlabel,xpercent);
			check = 1;						
		}
		if(xyear.getValue()==null)
		{
			shadow(xyearlabel,xyear);
			check = 1;	
		}
		if(xiiboard.getValue()==null)
		{
			shadow(xiiboardlabel,xiiboard);
			check = 1;	
		}
		if(xiipercent.getText()==null || (xpercent.getText().isEmpty()))
		{
			shadow(xiipercentlabel,xiipercent);
			check = 1;						
		}
		if(xiiyear.getValue()==null)
		{
			shadow(xiiyearlabel,xiiyear);
			check = 1;	
		}
		if(Degree.getText()==null || (Degree.getText().isEmpty()))
		{
			shadow(degreelabel,Degree);
			check = 1;						
		}
		if(Department.getText()==null || (Department.getText().isEmpty()))
		{
			shadow(departmentlabel,Department);
			check = 1;						
		}		
		if(CollegeName.getText()==null || (CollegeName.getText().isEmpty()))
		{
			shadow(collegenamelabel,CollegeName);
			check = 1;						
		}
		if(UniversityName.getText()==null || (UniversityName.getText().isEmpty()))
		{
			shadow(universitylabel,UniversityName);
			check = 1;						
		}
		if(City.getText()==null || (City.getText().isEmpty()))
		{
			shadow(citylabel,City);
			check = 1;						
		}
		if(State.getValue()==null)
		{
			shadow(statelabel,State);
			check = 1;	
		}
		if(GradYear.getValue()==null)
		{
			shadow(gradyearlabel,GradYear);
			check = 1;	
		}
		if(C1.isSelected()==true)
		{
			if(SubPref1.getValue()==null)
			{
				shadow(subpref1label,SubPref1);
				check = 1;	
			}
			if(SubPref2.getValue()==null)
			{
				shadow(subpref2label,SubPref2);
				check = 1;	
			}
			if(SubPref3.getValue()==null)
			{
				shadow(subpref3label,SubPref3);
				check = 1;	
			}				
		}
		if(C2.isSelected()==true)
		{
			if(PGDegree.getText()==null || (PGDegree.getText().isEmpty()))
			{
				shadow(pgdegreelabel,PGDegree);
				check = 1;						
			}
			if(PGDepartment.getText()==null || (PGDepartment.getText().isEmpty()))
			{
				shadow(pgdepartmentlabel,PGDepartment);
				check = 1;						
			}		
			if(PGCollegeName.getText()==null || (PGCollegeName.getText().isEmpty()))
			{
				shadow(pgcollegenamelabel,PGCollegeName);
				check = 1;						
			}
			if(PGCity.getText()==null || (PGCity.getText().isEmpty()))
			{
				shadow(pgcitylabel,PGCity);
				check = 1;						
			}
			if(PGState.getValue()==null)
			{
				shadow(pgstatelabel,PGState);
				check = 1;	
			}
			if(PGGradYear.getValue()==null)
			{
				shadow(pggradyearlabel,PGGradYear);
				check = 1;	
			}	
		}
		if(C3.isSelected()==true)
		{
			if(Year.getValue()==null)
			{
				shadow(yearlabel,Year);
				check = 1;	
			}	
		}
		if(C4.isSelected()==true)
		{
			if(GateYear.getValue()==null)
			{
				shadow(gateyearlabel,GateYear);
				check = 1;	
			}	
		}
		
		if(browselabel1.getText().equals("No file selected"))
		{
			DropShadow borderGlow= new DropShadow();
			borderGlow.setColor(Color.RED);			
			check = 1;
			Browse1.setEffect(borderGlow);
		}
		if(browselabel2.getText().equals("No file selected"))
		{
			DropShadow borderGlow= new DropShadow();
			borderGlow.setColor(Color.RED);			
			Browse2.setEffect(borderGlow);
			check = 1;
		}
		if(check == 0)
		{
			if(!isValidEmailAddress(Email.getText()))
			{
				emaillabel.setText("Incorrect Email Address");
				emaillabel.setTextFill(Color.web("#ee0a0a"));
				check = 1;
			}
			else
			{
				emaillabel.setText("");
			}
			
			if(name()==false)
				check = 1;
			if(mobilecheck()==false)
				check = 1;
			if(fname()==false)
				check = 1;
			if(pincode() == false)
				check = 1;			
			if(xmarks() == false)
				check = 1;			
			if(xiimarks() == false)
				check = 1;			
			if(special() == false)
				check = 1;
			if(CGPA.isSelected()==true)
				if(cgpa() == false)
					check = 1;
			if(MARKS.isSelected()==true)
				if(MarksPercent() == false)
					check = 1;
			if(C2.isSelected() == true)
			{
				if(PG() == false)
					check = 1;
			}
			
			
			
			
			if(check == 0)
			{
			String temp;
			Integer x;
			RandomAccessFile f1 = new RandomAccessFile("./src/DataBase/ID.txt", "rw");
			temp = f1.readLine();
			x = Integer.parseInt(temp);
			x++;
			String xs = x.toString();
			f1.seek(0);
			f1.write(xs.getBytes());
			f1.close();
			BufferedWriter f2 = new BufferedWriter(new FileWriter("./src/DataBase/PHD2015" + x + ".txt"));
			f2.write("Enrollment ID :PHD2015" + x + "\r\n");
			f2.write("Email :" + Email.getText() + "\r\n");
			f2.write("Name :" + Name.getText() + "\r\n");
			f2.write("AddressCorrespondence : " + AddressCorrespondence.getText() + "\r\n");
			f2.write("Mobile :" + Mobile.getText() + "\r\n");
			f2.write("PhD Stream :" + ((RadioButton) TG1.getSelectedToggle()).getText() + "\r\n");
			f2.write("PhD Area Preference1 :" + Pref1.getValue() + "\r\n");
			int np = 0;
			if(Pref2.getValue() != null)
			{
				np++;
			}
			if(Pref3.getValue() != null)
			{
				np++;
			}
			f2.write("No. of preferences :" + np + "\r\n");
			if(Pref2.getValue() != null)
			{
				f2.write("PhD Area Preference2 :" + Pref2.getValue() + "\r\n");
			}
			if(Pref3.getValue() != null)
			{
				f2.write("PhD Area Preference3 :" + Pref3.getValue() + "\r\n");
			}
			f2.write("Gender :" + ((RadioButton) Gender.getSelectedToggle()).getText() + "\r\n");
			f2.write("Category :" + ((RadioButton) Category.getSelectedToggle()).getText() + "\r\n");
			f2.write("Physically Disabled :" + ((RadioButton) PD.getSelectedToggle()).getText() + "\r\n");
			String formattedDate = (DOB.getValue()).toString();
			f2.write("DOB :" + formattedDate + "\r\n");
			f2.write("Children/War Widows of Defence Personnel killed/Disabled in Action* :" + ((RadioButton) Widow.getSelectedToggle()).getText() + "\r\n");
			f2.write("Father :" + Father.getText() + "\r\n");
			f2.write("Nationality :" + Nationality.getValue() + "\r\n");
			f2.write("Permanent Address :" + PermanentAddr.getText() + "\r\n");
			if(PinCode.getText() != null)
			{
				f2.write("Pincode :Yes" +  "\r\n");
				f2.write("PinCode :" + PinCode.getText() + "\r\n");
			}
			else
			{
				f2.write("Pincode :No" +  "\r\n");
			}
			f2.write("Xth Board :" + xboard.getValue() + "\r\n");
			f2.write("Xth Marks(%) :" + xpercent.getText() + "\r\n");
			f2.write("Year of passing Xth :" + xyear.getValue() + "\r\n");
			f2.write("XIIth Board :" + xiiboard.getValue() + "\r\n");
			f2.write("XIIth Marks(%) :" + xiipercent.getText() + "\r\n");
			f2.write("Year of passing XIIth :" + xiiyear.getValue() + "\r\n");
			f2.write("Degree :" + Degree.getText() + "\r\n");
			f2.write("Department/Discipline :" + Department.getText() + "\r\n");
			f2.write("Name of College :" + CollegeName.getText() + "\r\n");
			f2.write("Name of University :" + UniversityName.getText() + "\r\n");
			f2.write("City :" + City.getText() + "\r\n");
			f2.write("State :" + State.getValue() + "\r\n");
			f2.write("Year of Graduation :" + GradYear.getValue() + "\r\n");
			if(Grade.getSelectedToggle() != null)
			{
				if(CGPA.isSelected() == true)
				{
					f2.write("Grade :Yes" + "\r\n");
					Double d = (double) ((double)((double)Integer.parseInt(CGPA1.getText())/(double)Integer.parseInt(CGPA2.getValue()))*100);
					f2.write("Marks(%) :" + d + "\r\n");					
				}
				else if(MARKS.isSelected()== true)
				{
					f2.write("Grade :Yes" + "\r\n");
					f2.write("Marks(%) :" + MarksPercent.getText() + "\r\n");
				}
				else
					f2.write("Grade :No" + "\r\n");
			}
			else
			{
				f2.write("Grade :No" + "\r\n");
			}
			if(C1.isSelected()==true)
			{
				f2.write("C1 :Yes" + "\r\n");
				f2.write("ECE PhD subjct Preference 1 :" + SubPref1.getValue() + "\r\n");
				f2.write("ECE PhD subjct Preference 2 :" + SubPref2.getValue()+ "\r\n");
				f2.write("ECE PhD subjct Preference 3 :" + SubPref3.getValue()+ "\r\n");
				if(SubPref4.getValue() != null)
				{
					f2.write("Pref4 :Yes" + "\r\n");
					f2.write("ECE PhD subjct Preference 4 :" + SubPref4.getValue()+ "\r\n");
				}
				else
				{
					f2.write("Pref :No" + "\r\n");
				}
			}
			else
			{
				f2.write("C1 :No" + "\r\n");
			}
			if(C2.isSelected()==true)
			{
				f2.write("PG :Yes" + "\r\n");
				f2.write("PG College Name :" + PGCollegeName.getText()+ "\r\n");
				f2.write("PG City :" + PGCity.getText()+ "\r\n");
				f2.write("PG State :" + PGState.getValue()+ "\r\n");
				f2.write("PG Department/Discipline :" + PGDepartment.getText()+ "\r\n");
				f2.write("PG Degree :" + PGDegree.getText()+ "\r\n");
				f2.write("PG Thesis :" + Thesis.getText()+ "\r\n");
				f2.write("PG Year :" + PGGradYear.getValue()+ "\r\n");
//				if(PGCollegeName.getText()!=null)
//				{
//					f2.write("PG College Name :Yes" + "\r\n");										
//					f2.write("PG College Name :" + PGCollegeName.getText()+ "\r\n");					
//				}
//				else
//					f2.write("PG College Name :No" + "\r\n");										
//
//				if(PGCollegeName.getText()!=null)
//				{
//					f2.write("PG City :Yes" + "\r\n");										
//					f2.write("PG City :" + PGCity.getText()+ "\r\n");					
//				}	
//				else
//					f2.write("PG City :No" + "\r\n");										
//
//				if(PGState.getValue()!=null)
//				{
//					f2.write("PG State :Yes" + "\r\n");										
//					f2.write("PG State :" + PGState.getValue()+ "\r\n");					
//				}	
//				else
//					f2.write("PG State :No" + "\r\n");										
//
//				if(PGDepartment.getText()!=null)
//				{
//					f2.write("PG Department :Yes" + "\r\n");										
//					f2.write("PG Department/Discipline :" + PGDepartment.getText()+ "\r\n");					
//				}
//				else
//					f2.write("PG Department :No" + "\r\n");										
//
//				if(PGDegree.getText()!=null)
//				{
//					f2.write("PG Degree :Yes" + "\r\n");
//					f2.write("PG Degree :" + PGDegree.getText()+ "\r\n");					
//				}
//				else
//				{
//					f2.write("PG Degree :No" + "\r\n");										
//
//				}
//				if(Thesis.getText()!=null)
//				{
//					f2.write("PG Thsesis :Yes" + "\r\n");										
//					f2.write("PG Thesis :" + Thesis.getText()+ "\r\n");					
//				}	
//				else
//				{
//					f2.write("PG thesis :No" + "\r\n");										
//
//				}
//				f2.write("Year Of Post Graduation :" + PGGradYear.getValue()+ "\r\n");
//				if(PGCollegeName.getText()!=null)
//				{
//					f2.write("PG Year :Yes" + "\r\n");										
//					f2.write("PG College Name :" + PGCollegeName.getText()+ "\r\n");					
//				}	
//				else
//					f2.write("PG Year :No" + "\r\n");										

				if(PGGRADE.getSelectedToggle() != null)
				{										
					if(PGCGPA.isSelected() == true)
					{
					f2.write("PGGrade :Yes\r\n");
					Double d = (double) ((double)((double)Integer.parseInt(PGCGPA1.getText())/(double)Integer.parseInt(PGCGPA2.getValue()))*100);
					f2.write("Marks(%) :" + d + "\r\n");					
					}
					else if(PGMARK.isSelected()== true)
					{
					f2.write("PG Grade :Yes" + "\r\n");
					f2.write("Marks(%) :" + PGMarksPercent.getText() + "\r\n");
					}
					else
						f2.write("PG Grade :No" + "\r\n");	
				}
				else
				{
					f2.write("PG Grade :No" + "\r\n");
				}
			}
			else
				f2.write("PG :No" + "\r\n");
			if(C3.isSelected()==true)
			{
				f2.write("Other :Yes" + "\r\n");
				f2.write("Exam Name :" + exmname.getText()+ "\r\n");
				f2.write("Subject :" + Subject.getText()+ "\r\n");
				f2.write("Year :" + Year.getValue()+ "\r\n");	
				f2.write("Score :" + Score.getText()+ "\r\n");	
				f2.write("Rank :" + Rank.getText()+ "\r\n");
//				if(exmname.getText()!=null)
//				{
//					f2.write("Exam Name :Yes" + "\r\n");
//					f2.write("Exam Name :" + exmname.getText()+ "\r\n");					
//				}
//				else
//					f2.write("Exam Name :No" + "\r\n");
//				if(Subject.getText()!=null)
//				{
//					f2.write("Subject :Yes" + "\r\n");
//					f2.write("Subject :" + Subject.getText()+ "\r\n");					
//				}
//				else
//					f2.write("Subject :No" + "\r\n");
//				f2.write("Year :" + Year.getValue()+ "\r\n");					
//				
//				if(Score.getText()!=null)
//				{
//					f2.write("Score :Yes" + "\r\n");
//					f2.write("Score :" + Score.getText()+ "\r\n");					
//				}
//				else
//					f2.write("Score :No" + "\r\n");
//				if(Rank.getText()!=null)
//				{
//					f2.write("Rank :Yes" + "\r\n");
//					f2.write("Rank :" + Rank.getText()+ "\r\n");				
//				}
//				else
//					f2.write("Rank :No" + "\r\n");
			}
			else
				f2.write("Other :No" + "\r\n");
			if(C4.isSelected()==true)
			{
				f2.write("gate :Yes" + "\r\n");
				f2.write("Gate Area :" + GateArea.getText()+ "\r\n");
				f2.write("Gate Year :" + GateYear.getValue()+ "\r\n");
				f2.write("Gate Marks ( out of 100) :" + GateMarks.getText()+ "\r\n");
				f2.write("Gate Score :" + GateScore.getText()+ "\r\n");	
				f2.write("Gate Rank :" + GateRank.getText()+ "\r\n");
//				if(GateArea.getText()!=null)
//				{
//					f2.write("Gate Area :Yes" + "\r\n");
//					f2.write("Gate Area :" + GateArea.getText()+ "\r\n");					
//				}
//				else
//					f2.write("Gate Area :No" + "\r\n");
//				f2.write("Gate Year :" + GateYear.getValue()+ "\r\n");
//				if(GateMarks.getText()!=null)
//				{
//					f2.write("Gate Marks :Yes" + "\r\n");
//					f2.write("Gate Marks ( out of 100) :" + GateMarks.getText()+ "\r\n");					
//				}
//				else
//					f2.write("Gate Marks :No" + "\r\n");
//				
//				if(GateScore.getText()!=null)
//				{
//					f2.write("Gate Score :Yes" + "\r\n");
//					f2.write("Gate Score :" + GateScore.getText()+ "\r\n");					
//				}
//				else
//					f2.write("gate Score :No" + "\r\n");
//				if(GateRank.getText()!=null)
//				{
//					f2.write("Gate Rank :Yes" + "\r\n");
//					f2.write("Gate Rank :" + GateRank.getText()+ "\r\n");					
//				}
//				else
//					f2.write("Gate Rank: No" + "\r\n");
			}
			else
			{
				f2.write("Gate :No" + "\r\n");
			}
			if(Achievements.getText()!=null)
			{
				f2.write("Achievments :Yes" + "\r\n");
				f2.write("Achievements, CV and Statement of Purpose :" + Achievements.getText()+ "\r\n");					
			}
			else
				f2.write("Achievments :No" + "\r\n");
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");Date date = new Date();
			f2.write("TimeStamp :" + dateFormat.format(date) + "\r\n");
			
			f2.close();
			
		}
	}}

}
