/**
 * 
 */

/**
 * @author nlarson002

 *
 */
package CMC.User;

import java.util.ArrayList;

import CMC.University.*;

public class UserUI {

	String user;
	String pass;
	UniversityController universityController;
	UserController userController;
	/**
	 * 
	 * @param username
	 * @param password
	 */
	public static boolean login(String username, String password) {
		
		return UserController.login(username, password);
	}
	
	//instead of using the goToPage method for my use case, I changed the method to this. Its more specific
	public static Account getUserInfo(String username, String password) { 
		return UserController.getUserInfo(username, password);
	} 
	
	/**
	 * Saves the user information to the database.
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 */
	public static Account saveUserInfo(String username, String password, String firstName, String lastName, String userType) {
		Account user = UserController.saveUserInfo(username, password, firstName, lastName, userType);
		return user;
	}
	/**
	 * 
	 */
	public void editSchool() {
		
	}
	/**
	 * 
	 */
	public static void manageSchool() {
		UniversityController.getAllUniversities();
	}
	
	/**
	 * 
	 * @param university School you want to display information about
	 */
	public static void displayUniversityInfo(University university) {
		System.out.println("School Name: "  + university.getuniversityName());
		System.out.println("School State Location: " + university.getState());
		System.out.println("School Location: " + university.getLocation());
		System.out.println("Number of Students: " + university.getNumStudents());
		System.out.println("Percentage of Females: " + university.getFemalePer());
		System.out.println("Average Ver. SAT score: " + university.getVerSAT());
		System.out.println("Average Math SAT score: " + university.getMathSAT());
		System.out.println("Tuition Costs: " + university.getTuition());
		System.out.println("Average Financial Aid: " + university.getFinAid());
		System.out.println("Number of Applicants: " + university.getNumApplicants());
		System.out.println("Percentage of Admitted Applicants: " + university.getAdmitPer());
		System.out.println("Percentange of Enrolled: " + university.getEnrolledPer());
		System.out.println("Academic Scale: " + university.getAcademicScale());
		System.out.println("Social Scale: " + university.getSocialScale());
		System.out.println("QOA Scale: " + university.getQoaScale());
		System.out.println("Emphasis: ");
		if (university.getEmphasis().get(0).equals("No Emphases")) {
			System.out.println("No Emphases");
		}
		else {
			for (int i = 0; i < university.getEmphasis().size(); i++) {
					System.out.println((i + 1) + ". " + university.getEmphasis().get(i));
			}
		}
		if (university.isBlacklisted()) {
			System.out.println("Blacklisted: Yes");
		}
		else {
			System.out.println("Blacklisted: No");
		}
		
	}
	
	public void getSavedList(Account account) {
		
	}
	
	/**
	 * Adds a specified school to users saved school list
	 * @Author John Engh
	 * @param SName Name of university as string
	 * @param AName Account username as string
	 * @return 
	 */
	public static boolean addSavedUniversities(String SName, String AName) {
		return UserController.addSavedUniversities(SName, AName);
	}

	/**
	 * 
	 * @param account
	 */
	public void displaySavedSchool(Account account) {
		
	}
	/**
	 * 
	 * @param school
	 */
	public void blacklistSchool(University school) {
		
	}
	/**
	 * 
	 *
	 */
	public static void saveScoolInfo(String universityName, String state, String location, String control, int numStudents, int femalePer,
			int verSAT, int mathSAT, double tuition, double finAid, double numApplicants, int admitPer, int enrolledPer,
			int academicScale, int socialScale, int qoaScale) {
		// TODO Auto-generated method stub
		UniversityController.editUniversityinfo(universityName, state, location, control, numStudents, femalePer, verSAT, mathSAT, tuition, finAid, numApplicants, admitPer, enrolledPer, academicScale, socialScale, qoaScale);
	}

	/**
	 * 
	 */
	public void logOut() {
		
	}
	/**
	 * 
	 * @param account
	 */
	public void lookup(Account account) {
		
	}
		
	/**
	 * Displays the search results to the user.
	 */
	public static String viewResults() {
		String results = "Temporary search results";
		return results;
	}
	
	/**
	 * 
	 * @param school
	 */
	public void displayUserInfo(University school) {		//need to add to class diagram
		
	}

	/**
	 * 
	 * @param school
	 */
	public void removeSchool(String school) {
		UniversityController.removeUniversity(school);
	}
	
	/**
	 * 
	 */
	public void displaySavedList() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * This method goes to the UserController
	 * @param username the username of Account
	 */
	public static ArrayList<String> getSavedUniversityList(String username) {
		
		return UserController.getSavedUniversityList(username);
	}
	/**
	 * this method displays the saved universities from the specific account
	 * @param account
	 */
	public static void displaySavedUniversity(Account account) {
		System.out.println("Here are the schools");
	}
	/**
	 * 
	 */
	public static void goToLoginPage() {
		System.out.println("User is brought to main page");
		
	}
	/**

	 * Calls UniversityController to pass on to DBController and Account
	 * 
	 * @param university
	 */
	public static void removeUniversity(String university) {
		UniversityController.removeUniversity(university);
	}
	/**
	 * 
	 */
	public static ArrayList<User> manageUsers() {
		return UserController.getAllUsers();
		
	}

	public static void addSchool(String universityName, String state, String location, String control, int numStudents, int femalePer,
			int verSAT, int mathSAT, double tuition, double finAid, int numApplicants, int admitPer, int enrolledPer,
			int academicScale, int socialScale, int qoaScale) {
		// TODO Auto-generated method stub
		UniversityController.addUniversity(universityName, state, location, control, numStudents, femalePer, verSAT, mathSAT, tuition, finAid, numApplicants, admitPer, enrolledPer, academicScale, socialScale, qoaScale);
	}

	public static void getUniversity(String university) {
		UniversityController.getUniversity(university);
	}
	/**
	 * Displays the account information to the UserUI.
	 * @param account
	 */
	public static void displayAccountInfo(Account account) {
		System.out.println(account.getUsername());
		System.out.println(account.getFirstName());
		System.out.println(account.getLastName());

	}

}








