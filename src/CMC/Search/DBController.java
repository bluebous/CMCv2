
package CMC.Search;

import java.util.ArrayList;
//import CMC.DBLibraryDriver;
import java.util.List;

import CMC.User.*;
import dblibrary.project.csci230.UniversityDBLibrary;
import CMC.University.*;

public class DBController {
		//private static Account account = new Account("amoralesg001", "thumb thumb", null, null, null); 

		//private static User userArray[]; //should we do an array or list?  
		
		//public static ArrayList<University> uArray = new ArrayList<University>();
		static String dbUsername = "thumbthumbs";
		static String dbPassword = "csci230";
		public static UniversityDBLibrary univDBlib = new UniversityDBLibrary(dbUsername,dbPassword);
		
		public static Account getAccountDB(String username, String password) {
			
			Account user = dbGetUser(username);
			//System.out.println(user.getPassword());
			//System.out.println(user.getLoginStatus());
			Account tempA = new Account("errorError", "f", "f", "f", "f", "f");
			if (user.getUsername() == null) {
				return tempA;
			}
			if (user.getPassword() == null) {
				return tempA;
			}
			if (user.getLoginStatus() == null) {
				return tempA;
			}
			String tempU = user.getUsername();
			String tempP = user.getPassword();
			String tempS = user.getLoginStatus();
			
			if (tempU.equals(username) && tempP.equals(password) && (tempS.equals("Y") || tempS.equals("y"))){
				//System.out.println("pass");
				return user;
				
			}
			else {
				
				//System.out.println("fail");
				return tempA;
			}
			
		}
		
		public static Account getAccountDB2(String username) {
			
			Account user = dbGetUser(username);
			
			String tempU;
			if (user != null) {
				tempU = user.getUsername();
			}
			else {
				tempU = null;
			}
			
			if (tempU == null){
				Account tempA = new Account(null, null, null, null, null, null);
				return tempA;
			}
			else {
				return user;
			}
			
		}
		
		public static Account dbGetUser(String username){	
			String[][] ar = univDBlib.user_getUsers();
			
			//String [] user = new String[6];
			//user[2] = "";
			//user[3] = "";
			for(int i = 0; i < ar.length; i++) {
				if (ar[i][2].equals(username)) {
					
					//First Name
					String fName = ar[i][0]; 
					//System.out.println(user[0])
					
					//Last Name
					String lName= ar[i][1];
					//System.out.println(user[1]);
					
					//Username
					String uName = ar[i][2];
					//System.out.println(user[2]);
					
					//Password
					String password = ar[i][3];
					//System.out.println(user[3]);
					
					//User Type
					String uType = ar[i][4];
					//System.out.println(user[4]);
					
					//Status
					String status = ar[i][5];
					//System.out.println(user[5]);
					
					Account account =  new Account(fName, lName, uName, password, uType, status);
					return account;
				}
			}
			Account tempA = new Account("errorError", "f", "f", "f", "f", "f");
			//System.out.println("fail");
			return tempA;	
		}		  
		//USED BY READYSON
		public static University dbGetUniversity(String university) {	
			String[][] un = univDBlib.university_getUniversities();
			ArrayList<String> emphasis = new ArrayList<String>();
			for(int i = 0; i < un.length; i++) {
				if (un[i][0].equals(university)) {
					
					//University Name
					String universityName = un[i][0];
					if (universityName.equals("o")) {
						universityName = "N/A";
					}
					
					//State
					String state = un[i][1];
					if (state.equals("o")) {
						state = "N/A";
					}
					
					//Location
					String location = un[i][2];
					if (location.equals("o")) {
						location = "N/A";
					}
					
					//Control
					String control = un[i][3];
					if (control.equals("o")) {
						control = "N/A";
					}
					
					//Number of Students
					String numStudents = un[i][4];
					if (numStudents.equals("-1")) {
						numStudents = "N/A";
					}
					
					//Percent Female
					String femalePer = un[i][5];
					if (femalePer.equals("-1")) {
						femalePer = "N/A";
					}
					
					//SAT Verbal
					String verbalSAT = un[i][6];
					if (verbalSAT.equals("-1")) {
						verbalSAT = "N/A";
					}
					
					//SAT Math
					String mathSAT = un[i][7];
					if (mathSAT.equals("-1")) {
						mathSAT = "N/A";
					}
					//Expenses
					String expenses = un[i][8];
					if (expenses.equals("-1")) {
						expenses = "N/A";
					}
					//Financial Aid Percent
					String finAidPer = un[i][9];
					if (finAidPer.equals("-1")) {
						finAidPer = "N/A";
					}	
					
					//Number of Applicants
					String numApplicants = un[i][10];
					if (numApplicants.equals("-1")) {
						numApplicants = "N/A";
					}
					
					//Admitted percent
					String admittedPer = un[i][11];
					if (admittedPer.equals("-1")) {
						admittedPer = "N/A";
					}
					
					//Enrolled percent
					String enrolledPer = un[i][12];
					if (enrolledPer.equals("-1")) {
						enrolledPer = "N/A";
					}
					
					//Academic Scale
					String academicsScale = un[i][13];
					if (academicsScale.equals("-1")) {
						academicsScale = "N/A";
					}
					
					//Social Scale
					String socialScale = un[i][14];
					if (socialScale.equals("-1")) {
						socialScale = "N/A";
					}
					
					//Quality of Life Scale
					String qualityScale = un[i][15];
					if (qualityScale.equals("-1")) {
						qualityScale = "N/A";
					}
					
					//Emphasis
					String[][] em = univDBlib.university_getNamesWithEmphases();
					for(int j = 0; j < em.length; j++) {
						if (em[j][0].equals(university)) {
							if (emphasis.contains(em[j][1])) {
								
							}
							else {
								emphasis.add(em[j][1]);
							}
						}
					}
						if (emphasis.size() == 0) {
						emphasis.add("No Emphases");
					}
				
					
					//Blacklist
					boolean blacklist = false;
							
					University universityRet =  new University(universityName, state, location, control, numStudents, femalePer, verbalSAT, 
							mathSAT, expenses, finAidPer, numApplicants, admittedPer, enrolledPer, academicsScale, socialScale, qualityScale, emphasis, blacklist);
					
					return universityRet;
				}
			}
			return null;
			
			
		}
		
		/**
		 * This method is used to edit all of the information inside of a University object
		 * 
		 * @param universityName is university object name
		 * @param state is university object state
		 * @param location is university object location
		 * @param numStudents number of students in the university
		 * @param femalePer percent of female students going to university
		 * @param verSAT average Verbal SAT score for university
		 * @param mathSAT average Math SAT score for university
		 * @param tuition tuition cost for the university
		 * @param finAid financial aid for university
		 * @param numApplicants number of applicants for the university
		 * @param admitPer Percentage of applicants admitted
		 * @param enrolledPer percent of enrolled 
		 * @param academicScale the University's academic scale
		 * @param socialScale the University's Social scale
		 * @param qoaScale the University's qoa scale
		 * @param emphasis the University's emphasis on Majors
		 * @param blacklist if the school is blacklisted
		 * 
		 * @return boolean value if the school has been edited
		 */
		public static boolean updateUniversityDB(String universityName, String state, String location, String control, String numStudents,
				String femalePer, String verSAT, String mathSAT, String tuition, String finAid, String numApplicants, String admitPer,
				String enrolledPer, String academicScale, String socialScale, String qoaScale, ArrayList<String> emphasis, boolean blacklist) {
			//String[][] un = univDBlib.university_getUniversities();
			
			boolean edited = false;
			if (dbGetUniversity(universityName) == null)
			{
				System.out.println("No such university as: " + universityName);
				throw new NullPointerException("No such University");
			}
			
			else
			{
				University u = dbGetUniversity(universityName);
				if( u.getuniversityName().equals(universityName))
				{
					univDBlib.university_editUniversity(u.getuniversityName(), state, location, control, Integer.parseInt(numStudents), Double.parseDouble(femalePer),
							Double.parseDouble(verSAT), Double.parseDouble(mathSAT), Double.parseDouble(tuition), Double.parseDouble(finAid), Integer.parseInt(numApplicants), Double.parseDouble(admitPer), 
							Double.parseDouble(enrolledPer), Integer.parseInt(academicScale), Integer.parseInt(socialScale), Integer.parseInt(qoaScale));
					System.out.println("University: " + u.getuniversityName() + " has been found and has been editted.");
					edited = true;
					u.setBlacklist(blacklist);
					ArrayList<String> oldEmphases = new ArrayList<String>();
					for (int i = 0; i < univDBlib.university_getNamesWithEmphases().length; i ++)
					{
						if (univDBlib.university_getNamesWithEmphases()[i][0].equals(universityName))
						{
							oldEmphases.add(univDBlib.university_getNamesWithEmphases()[i][1]);
						}
					}
					
					for(String s: oldEmphases)
					{
						
						if(oldEmphases.contains(s))
						{
							univDBlib.university_removeUniversityEmphasis(universityName, s);
							
						}
					}
					for(String s: emphasis) {
						univDBlib.university_addUniversityEmphasis(universityName, s);
					}
					
					
				}
			}

			return edited;
			
		}


		/**
		 * This method is used to add a University Object to the database
		 * 
		 * @param universityName is university object name
		 * @param state is university object state
		 * @param location is university object location
		 * @param numStudents number of students in the university
		 * @param femalePer percent of female students going to university
		 * @param verSAT average Verbal SAT score for university
		 * @param mathSAT average Math SAT score for university
		 * @param tuition tuition cost for the university
		 * @param finAid financial aid for university
		 * @param numApplicants number of applicants for the university
		 * @param admitPer Percentage of applicants admitted
		 * @param enrolledPer percent of enrolled 
		 * @param academicScale the University's academic scale
		 * @param socialScale the University's Social scale
		 * @param qoaScale the University's qoa scale
		 * 
		 * @return boolean value if the school has been added
		 */
		public static boolean addUniversity(String universityName, String state, String location, String control, String numStudents, String femalePer, String verSAT,
				String mathSAT, String tuition, String finAid, String numApplicants, String admitPer, String enrolledPer,
				String academicScale, String socialScale, String qoaScale, ArrayList<String> emphasis)  {//is this adding all information of a university or just on the saved list? 		
			boolean added = false;
	
			
			if (dbGetUniversity(universityName) == null)
			{
				univDBlib.university_addUniversity(universityName, state, location, control, Integer.parseInt(numStudents), Double.parseDouble(femalePer),
						Double.parseDouble(verSAT), Double.parseDouble(mathSAT), Double.parseDouble(tuition), Double.parseDouble(finAid), Integer.parseInt(numApplicants), Double.parseDouble(admitPer), 
						Double.parseDouble(enrolledPer), Integer.parseInt(academicScale), Integer.parseInt(socialScale), Integer.parseInt(qoaScale));
				for (String s: emphasis)
				{
					univDBlib.university_addUniversityEmphasis(universityName, s);
				}
				added = true;
				System.out.println("Univerity: " + universityName + " not in database... It will be added.");
			}
			else
			{
		
				added = false;
			}
				
			return added;
		}
		/**
		 * In use by John
		 * @param username username of account to update
		 * @param uniName name of university to add to list
		 * @return boolean if successful or not
		 */
		public static boolean updateSavedUniversities(String username, String uniName) {
			int output = univDBlib.user_saveSchool(username, uniName);
			
			return output == 1;
		

		}
		/**
		 * In use by John
		 * @return Arraylist of all users in database
		 */
		public static ArrayList<Account> getAllUsers() {		//how to return an array
			String[][] userlist = univDBlib.user_getUsers();
			ArrayList<Account> users = new ArrayList<>();
			for (int row = 0; row < userlist.length; row++) {
				String firstName = userlist[row][0];
				String lastName = userlist[row][1];
				String username = userlist[row][2];
				String password = userlist[row][3];
				String type = userlist[row][4];
				String active = userlist[row][5];
				Account acc = new Account(firstName, lastName, username, password, type, active);
				users.add(acc);
			}
			return users;
		}
		/**
		 * In use by John
		 * @param username
		 * @return
		 */
		public static Account getUserInfo(String username) {
			return null;
			//return account;
		}

		/**
		 * Updates the account in the database.
		 * @param user
		 */
		public static void updateAccountDB(String userToUpdate, String password, String firstName, String lastName, String userType, String loginStatus) {
			char uType = userType.charAt(0);
			char logStatus = loginStatus.charAt(0);
			univDBlib.user_editUser(userToUpdate, firstName, lastName, password, uType, logStatus);
		}


		/**
		 *
		 * @param username Username as string
		 * @param universityname name of university as string to remove
		 */
		public static int removeUniversity(String username, String universityName) {
			University universityToRemove = DBController.dbGetUniversity(universityName);
			if (universityToRemove == null) {
				return 3;
			}
			int i = univDBlib.user_removeSchool(username, universityName);
			return i;
		}
		/**
		 * 
		 * @param universityName
		 * @return
		 */
		public University lookUpUniversity(String universityName) {
			return null;
		}
		/**
		 * 
		 * @param accountName
		 * @return
		 */
		public static Account lookUpAccount(String accountName) {
			return null; 
		}
		/**
		 * 
		 */
		public void updateProfile() {
			
		}
		/**
		 * 
		 * @param universityName
		 * @return
		 */
		public static University getUniversity(String universityName) {
			//return university;
			return null;
		}
	
		public static ArrayList<String> dbGetSavedUniversityList(String username){	
			String[][] ar = univDBlib.user_getUsernamesWithSavedSchools();
		
			ArrayList<String> userSchool = new ArrayList<String>();
			for(int row = 0; row<ar.length; row++) {
			boolean userFound=false;
			if (ar[row][0].equals(username)){
				userFound=true;
				userSchool.add(ar[row][0]);
				userSchool.add(ar[row][1]);
				userSchool.add(ar[row][2]);
				}
			}
			if(userSchool.size()<1) {
				return null;
			}
			else {
				return userSchool;
			}
			
			}
		
		/**
		 * In use by alex morales
		 * 
		 * This method searches universities from the criterias given beloow. 
		 * @param universityName
		 * @param state
		 * @param location
		 * @param control
		 * @param numStudents
		 * @param femalePer
		 * @param verbalSAT
		 * @param mathSAT
		 * @param expenses
		 * @param finAidPer
		 * @param numApplicants
		 * @param admitPer
		 * @param enrolledPer
		 * @param academicScale
		 * @param socialScale
		 * @param qoaScale
		 * @param qoaScale2 
		 * @param qoaScale1 
		 * @param socialScale2 
		 * @param socialScale1 
		 * @param academicScale2 
		 * @param academicScale1 
		 * @param enrolledPer2 
		 * @param enrolledPer1 
		 * @param admitPer2 
		 * @param admitPer1 
		 * @param numApplicants2 
		 * @param numApplicants1 
		 * @param finAidPer2 
		 * @param finAidPer1 
		 * @param emphasis
		 * @return ArrayList of a string that has the universities that match those criterias
		 */
		public static ArrayList<String> dbSearchUniversity(String universityName, String state, String location, String control, String numStudents1, String numStudents2, String femalePer1, String femalePer2, String verbalSAT1, String verbalSAT2,
	            String mathSAT1, String mathSAT2, String expenses1, String expenses2, String finAidPer1, String finAidPer2, String numApplicants1, String numApplicants2, String admitPer1, String admitPer2, String enrolledPer1, String enrolledPer2,
	            String academicScale1, String academicScale2, String socialScale1, String socialScale2, String qoaScale1, String qoaScale2, String[] emphasis) {    
            String[][] un = univDBlib.university_getUniversities();
            ArrayList<String> uniAndEmphasisMatch = new ArrayList<>();
            ArrayList<String> uniSearchFound = new ArrayList<>();
            boolean searchCondition=true; 
          
            for(int i = 0; i < un.length; i++) {
            	searchCondition = true; 
            	
            	if((!universityName.equals("")) && (!un[i][0].contains(universityName))){
            		searchCondition = false; 
            	}
            	
            	if((!state.equals("")) && (!un[i][1].contains(state))){
            		searchCondition = false; 
        	    }  
            	if((!location.equals("")) && (!un[i][2].contains(location))){
            		searchCondition = false; 
        	    }  
            	
            	if((!control.equals("")) && (!un[i][3].contains(control))) {
            		searchCondition = false; 
            	}


            
            	int checkBetweennum = Integer.parseInt(un[i][4]);
            	if(!numStudents1.equals("") && numStudents2 == "") {
            		if(!(Integer.parseInt(numStudents1)<checkBetweennum)) {
            			searchCondition=false;
            		} 		
            	}
            	else if(!numStudents1.equals("") && !numStudents2.equals("")) {
            		if((Integer.parseInt(numStudents1)>checkBetweennum) || (checkBetweennum> Integer.parseInt(numStudents2))) {
            			searchCondition = false;
            		}
            	}
            	else if(!(numStudents1.equals("")) && !numStudents2.equals("")) {
            		searchCondition = false;
            	}
            	
            	checkBetweennum = Integer.parseInt(un[i][5]); 	
            	if(!femalePer1.equals("") && femalePer2.equals("")) {
            		if(!(Integer.parseInt(femalePer1)<checkBetweennum)) {
            			searchCondition=false;
            		} 		
            	}
            	else if(!femalePer1.equals("") && !femalePer2.equals("")) {
            		if((Integer.parseInt(femalePer1)>checkBetweennum) || (checkBetweennum> Integer.parseInt(femalePer2))) {
            			searchCondition = false;
            		}
            	}
            	else if(!(femalePer1.equals("")) && !femalePer2.equals("")) {
            		searchCondition = false;
            	}
            	//verbal SAT
            	checkBetweennum = Integer.parseInt(un[i][6]); 	
            	if(!verbalSAT1.equals("") && verbalSAT2.equals("")) {
            		if(!(Integer.parseInt(verbalSAT1)<checkBetweennum)) {
            			searchCondition=false;
            		} 		
            	}
            	else if(!verbalSAT1.equals("") && !verbalSAT2.equals("")) {
            		if((Integer.parseInt(verbalSAT1)>checkBetweennum) || (checkBetweennum> Integer.parseInt(verbalSAT2))) {
            			searchCondition = false;
            		}
            	}
            	else if(!(verbalSAT1.equals("")) && !verbalSAT2.equals("")) {
            		searchCondition = false;
            	}
            	//math SAT
            	checkBetweennum = Integer.parseInt(un[i][7]); 	
            	if(!mathSAT1.equals("") && mathSAT2.equals("")) {
            		if(!(Integer.parseInt(mathSAT1)<checkBetweennum)) {
            			searchCondition=false;
            		} 		
            	}
            	else if(!mathSAT1.equals("") && !mathSAT2.equals("")) {
            		if((Integer.parseInt(mathSAT1)>checkBetweennum) || (checkBetweennum> Integer.parseInt(mathSAT2))) {
            			searchCondition = false;
            		}
            	}
            	else if(!(mathSAT1.equals("")) && !mathSAT2.equals("")) {
            		searchCondition = false;
            	}
            	//expenses
            	checkBetweennum = Integer.parseInt(un[i][8]); 	
            	if(!(expenses1.equals("")) && expenses2=="") {
            		if(!(Integer.parseInt(expenses1)<checkBetweennum)) {
            			searchCondition=false;
            		} 		
            	}
            	else if(!expenses1.equals("") && !expenses2.equals("")) {
            		if((Integer.parseInt(expenses1)>checkBetweennum) || (checkBetweennum> Integer.parseInt(expenses2))) {
            			searchCondition = false;
            		}
            	}
            	else if(!expenses1.equals("") && !expenses2.equals("")) {
            		searchCondition = false;
            	}
            	//financial aid
            	checkBetweennum = Integer.parseInt(un[i][9]); 	
            	if(!(finAidPer1.equals("")) && finAidPer2=="") {
            		if(!(Integer.parseInt(finAidPer1)<checkBetweennum)) {
            			searchCondition=false;
            		} 		
            	}
            	else if(!finAidPer1.equals("") && !finAidPer2.equals("")) {
            		if((Integer.parseInt(finAidPer1)>checkBetweennum) || (checkBetweennum> Integer.parseInt(finAidPer2))) {
            			searchCondition = false;
            		}
            	}
            	else if(!finAidPer1.equals("") && !finAidPer2.equals("")) {
            		searchCondition = false;
            	}
            	//number of applicants
            	checkBetweennum = Integer.parseInt(un[i][10]); 	
            	if(!(numApplicants1.equals("")) && numApplicants2=="") {
            		if(!(Integer.parseInt(numApplicants1)<checkBetweennum)) {
            			searchCondition=false;
            		} 		
            	}
            	else if(!numApplicants1.equals("") && !numApplicants2.equals("")) {
            		if((Integer.parseInt(numApplicants1)>checkBetweennum) || (checkBetweennum> Integer.parseInt(numApplicants2))) {
            			searchCondition = false;
            		}
            	}
            	else if(!numApplicants1.equals("") && !numApplicants2.equals("")) {
            		searchCondition = false;
            	}
            	//percentage of admitted applicants
            	checkBetweennum = Integer.parseInt(un[i][11]); 	
            	if(!(admitPer1.equals("")) && admitPer2=="") {
            		if(!(Integer.parseInt(admitPer1)<checkBetweennum)) {
            			searchCondition=false;
            		} 		
            	}
            	else if(!admitPer1.equals("") && !admitPer2.equals("")) {
            		if((Integer.parseInt(admitPer1)>checkBetweennum) || (checkBetweennum> Integer.parseInt(admitPer2))) {
            			searchCondition = false;
            		}
            	}
            	else if(!admitPer1.equals("") && !admitPer2.equals("")) {
            		searchCondition = false;
            	}
            	//percentage of enrolled
            	checkBetweennum = Integer.parseInt(un[i][12]); 	
            	if(!(enrolledPer1.equals("")) && enrolledPer2=="") {
            		if(!(Integer.parseInt(enrolledPer1)<checkBetweennum)) {
            			searchCondition=false;
            		} 		
            	}
            	else if(!enrolledPer1.equals("") && !enrolledPer2.equals("")) {
            		if((Integer.parseInt(enrolledPer1)>checkBetweennum) || (checkBetweennum> Integer.parseInt(enrolledPer2))) {
            			searchCondition = false;
            		}
            	}
            	else if(!enrolledPer1.equals("") && !enrolledPer2.equals("")) {
            		searchCondition = false;
            	}
            	//Academic scale
            	checkBetweennum = Integer.parseInt(un[i][13]); 	
            	if(!(academicScale1.equals("")) && academicScale2=="") {
            		if(!(Integer.parseInt(academicScale1)<checkBetweennum)) {
            			searchCondition=false;
            		} 		
            	}
            	else if(!academicScale1.equals("") && !academicScale2.equals("")) {
            		if((Integer.parseInt(academicScale1)>checkBetweennum) || (checkBetweennum> Integer.parseInt(academicScale2))) {
            			searchCondition = false;
            		}
            	}
            	else if(!academicScale1.equals("") && !academicScale2.equals("")) {
            		searchCondition = false;
            	}
            	//social scale
            	checkBetweennum = Integer.parseInt(un[i][14]); 	
            	if(!(socialScale1.equals("")) && socialScale2=="") {
            		if(!(Integer.parseInt(socialScale1)<checkBetweennum)) {
            			searchCondition=false;
            		} 		
            	}
            	else if(!socialScale1.equals("") && !socialScale2.equals("")) {
            		if((Integer.parseInt(socialScale1)>checkBetweennum) || (checkBetweennum> Integer.parseInt(socialScale2))) {
            			searchCondition = false;
            		}
            	}
            	else if(!socialScale1.equals("") && !socialScale2.equals("")) {
            		searchCondition = false;
            	}

            	//QUOA Scale
            	checkBetweennum = Integer.parseInt(un[i][15]); 	
            	if(!(qoaScale1.equals("")) && qoaScale2=="") {
            		if(!(Integer.parseInt(qoaScale1)<checkBetweennum)) {
            			searchCondition=false;
            		} 		
            	}
            	else if(!qoaScale1.equals("") && !qoaScale2.equals("")) {
            		if((Integer.parseInt(qoaScale1)>checkBetweennum) || (checkBetweennum> Integer.parseInt(qoaScale2))) {
            			searchCondition = false;
            		}
            	}
            	else if(!qoaScale1.equals("") && !qoaScale2.equals("")) {
            		searchCondition = false;
            	}

            	if (searchCondition!=false) {
                	String uniName = un[i][0];
            		uniSearchFound.add(uniName);
            	}   
            }
                    

                    //need to get another loop that gets emphasis
                    //Emphasis
                    String[][] em = univDBlib.university_getNamesWithEmphases();
                   boolean emphasisMatches;
                   ArrayList<String> emphasisFound = new ArrayList<String>();
                   for (int i=0; i<em.length;i++) {
                	   emphasisMatches = false;
                	   for(int j=0; j<em[i].length;j++) {	  
                		  if((em[i][j].contains(emphasis[0])) && (!emphasis[0].equals(""))) {
                			  emphasisMatches=true;
                		  }
                		  if((em[i][j].contains(emphasis[1])) && (!emphasis[1].equals(""))) {
                			  emphasisMatches=true;
                		  }
                		  if((em[i][j].contains(emphasis[2])) && (!emphasis[2].equals(""))) {
                			  emphasisMatches=true;
                		  }
                		  if((em[i][j].contains(emphasis[3])) && (!emphasis[3].equals(""))) {
                			  emphasisMatches=true;
                		  }
                		  if((em[i][j].contains(emphasis[4])) && (!emphasis[4].equals(""))) {
                			  emphasisMatches=true;
                		  }
                	   
                	   if (emphasisMatches!=false) {
                		   String found =em[i][0];
                		   emphasisFound.add(found);
                	   }
                	   }
                	
                   }
                   //if the user had no criteria for emphasis, return the university criteria
               
				if(emphasis[0].equals("") && emphasis[1].equals("") &&emphasis[2].equals("") &&emphasis[3].equals("") &&emphasis[4].equals("")) {
                	   return uniSearchFound;
                   }
                   //do rest: if the all university criteria is empty, but their is criteria in emphasis
                   else if(universityName.equals("")&& state.equals("") && location.equals("") && numStudents1.equals("")&& control.equals("")&& numStudents1.equals("")&& femalePer1.equals("")&& verbalSAT1.equals("")
                		   && mathSAT1.equals("") && expenses1.equals("")&& finAidPer1.equals("")&& numApplicants1.equals("")&& admitPer1.equals("")&& enrolledPer1.equals("")&& academicScale1.equals("")&& socialScale1.equals("")&& qoaScale1.equals("")) {
                	return emphasisFound;   
                  }
                   
                   else if(uniSearchFound.size()>emphasisFound.size()) {
                	   for(int i=0; i< uniSearchFound.size();i++) {
                		  for(int k=0; k<emphasisFound.size();k++) {
                			if(uniSearchFound.get(i).contains(emphasisFound.get(k)) && !uniAndEmphasisMatch.contains(uniSearchFound.get(i))){
                			uniAndEmphasisMatch.add(uniSearchFound.get(i));	
                			}
                		  }
                   }
                   return uniAndEmphasisMatch;
		}
                   else {
                	   for(int i=0; i< emphasisFound.size();i++) {
                 		  for(int k=0; k<uniSearchFound.size();k++) {
                 			if(emphasisFound.get(i).contains(uniSearchFound.get(k)) && !uniAndEmphasisMatch.contains(uniSearchFound.get(k))){
                 			uniAndEmphasisMatch.add(emphasisFound.get(i));	
                 			}
                 		  }  
                 		 
                   
                   }
                	   return uniAndEmphasisMatch;
                   }
                 
		}
		 /**
		  * @author alex morales
		  * this method is simply used for my testing JUNIT. I do not use this apart from that 
		  * @param firstName
		  * @param lastName
		  * @param userName
		  * @param password
		  * @param userType
		  * @return
		  */
            public static Account addUser(String firstName, String lastName, String userName, String password, char userType) {
            	String userTypeString = Character.toString(userType);
            	Account user = new Account(firstName,lastName, userName, password, userTypeString,"Y");
            	
            	int userUpdate = univDBlib.user_addUser(firstName, lastName, userName, password, userType);
            	
            	return user;
            }
		}
	

			

		

	
