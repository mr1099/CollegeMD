import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class LoadSaveDatabase {

ArrayList<Students> StudentList = new ArrayList();
ArrayList<Professors> ProfessorList = new ArrayList();
ArrayList< Administrators> AdministratorList = new ArrayList();

public LoadSaveDatabase() {
	LoadStudents();
	//LoadProfessors();
	//LoadAdministrators();
}

public void LoadStudents() {
	String tempClass = "";
	String tempStatusString = "";
	Character tempStatus = ' ';
	boolean moreClasses = true;
	try {
		File readStudents = new File("Students.txt");
		if (readStudents.exists())
		{
			System.out.println("Yay, the file exists.");
			Scanner inputStudents = new Scanner(readStudents);
			Students tempStudent = new Students();
			while(inputStudents.hasNext()) {
				tempStudent.setID(inputStudents.nextLine());
				//System.out.println("I found a student with ID: " + tempStudent.getID());
				tempStudent.setPass(inputStudents.nextLine());
				tempStudent.setFirst(inputStudents.nextLine());
				tempStudent.setMiddle(inputStudents.nextLine());
				tempStudent.setLast(inputStudents.nextLine());
				tempStudent.setNumberOfClasses(Integer.parseInt(inputStudents.nextLine()));
				
				for(int i = 0; i <tempStudent.getNumberOfClasses();i++)
				{
					tempClass = inputStudents.nextLine();
					
						System.out.println("The student is taking the class: " + tempClass);
						tempStatus = inputStudents.nextLine().charAt(0);//tempStatusString.charAt(0);
						System.out.println("Their status for this class is: " + tempStatus);
						tempStudent.setClass(tempClass, tempStatus);
						System.out.println(tempStudent.getClassNumber());
				}
		
				StudentList.add(new Students(tempStudent));
				System.out.println("I added a student. we now have: " + StudentList.size());
			}inputStudents.close();
			
		} else { //if readstudents doesnt exist
			PrintWriter outputStudents = new PrintWriter("Students.txt");
			outputStudents.close();
		}
	
	}
	catch (Exception e) {
		System.out.println(e.toString());
	}
	
	System.out.println("ID: " + StudentList.get(0).getID());
	System.out.println("Password: " + StudentList.get(0).getPass());
	System.out.println("Name: "+ StudentList.get(0).getFirst() + " " + StudentList.get(0).getMiddle() + " " + StudentList.get(0).getLast());
	System.out.println("This asshole is taking this many classes: " + StudentList.get(0).getNumberOfClasses());
	for(int i = 0; i < StudentList.get(0).getNumberOfClasses(); i++)
	{
		System.out.println("kill me");
		System.out.println("Class: " + StudentList.get(0).getClass(i));
		System.out.println("kill me again");
		System.out.println("Status: " + StudentList.get(0).getClassStatus(i));
	}
	
}

public void LoadProfessors() {
	
}

public void LoadAdministrators() {
	
}


}