package adminEnd;

import java.net.URL;
import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ApplicationDetails {
	
	public ApplicationDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public ApplicationDetails (String EN, String name, String link)
	{
		this.applicantName = name;
		this.enrollmentNumber = EN;
//		this.dataLink = link;.
		
		this.ENP = new SimpleStringProperty (EN);
		this.NP = new SimpleStringProperty (name);
		this.LP = new SimpleStringProperty (link);
	}
	
	
	// Personal Information
	
	 String applicantName;
	 String eMail;
	 char gender;
	 String enrollmentNumber;
//	 String addressOfCorresponadance;
//	 String contactNumber;
	 String phdStream;
//	 String phdAreaPref_1, phdAreaPref_2, phdAreaPref_3;
	 String category;
	 boolean physicallyDisabled;
//	 boolean cwDefense;
	 LocalDate DoB;
//	 String fatherName;
//	 String permanentAddress;
//	 String pinCode;
	
	// Educational Information
	
	 String X_Board;
	 double X_Marks;
//	 String X_yearOfPassing;
	 String XII_Board;
	 double XII_Marks;
//	 String XII_yearOfPassing;
	
	 String gradDegree;
	 String gradDiscipline;
//	 String gradCollege;
	 String gradUniversity;
//	 String gradCity;
	 String gradState;
//	 String grad_yearOfPassing;
	
	 boolean gradCgpa;				// CGPA or Marks
	 double grad_cgpa_marks;
	
//	 boolean ecePhD;
//	 String ecePhD_pref1, ecePhD_pref2, ecePhD_pref3, ecePhD_pref4;
	
//	 boolean postGrad;
//	 String postCollege;
	 String postUniversity;
//	 String postCity;
	 String postState;
	 String postDiscipline;
	 String postDegree;
//	 String postThesis;
//	 String post_yearOfPassing;
	
	 boolean postCgpa;				// CGPA or Marks
	 double post_cgpa_marks;
	
//	 boolean otherAcademicDegree;
//	 String oA_ExamName;
//	 String oA_Subject;
//	 String oA_yearOfPassing;
//	 String oA_Score;
//	 String oA_Rank;
	
	 boolean gateExam;
//	 String gateArea;
//	 String gate_yearOfPassing;
//	 int gate_Marks;
	 double gate_Score;
//	 String gate_rank;
	
//	 boolean attachedCV;
//	 boolean attachedStatementOfPurpose;
	 
	 // Other Information
	 
	 LocalDate filledOn;
	 URL dataLink;
	 
	 SimpleStringProperty ENP;
	 SimpleStringProperty NP;
	 SimpleStringProperty LP;
	 
	 public StringProperty enrollmentProperty ()
	 {
		 return ENP;
	 }
	 
	 public StringProperty nameProperty ()
	 {
		 return NP;
	 }
	 
	 public StringProperty linkToDataProperty ()
	 {
		 return LP;
	 }
	
}