import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class LoadSaveDatabaseV3 {

ArrayList<Students> StudentList = new ArrayList();
ArrayList<Professors> ProfessorList = new ArrayList();
ArrayList< Administrators> AdministratorList = new ArrayList();
ArrayList<CoursesV2> CourseList = new ArrayList();

public LoadSaveDatabaseV3() {
	//loads the databases
	LoadStudents();
	LoadProfessors();
	LoadAdministrators();
	LoadClasses();
	//int bubba;
	//System.out.println("What do?");
	//Scanner keyboard = new Scanner(System.in);
	//bubba = keyboard.nextInt();
	//saveStudents();
}

public void  saveUsers()
{
	saveProfessors();
	saveStudents();
	saveAdministrators();
}

public void LoadStudents() {
	String tempClass = "";
	String tempStatusString = "";
	Character tempStatus = ' ';
	boolean moreClasses = true;
	//tries to open the file and load the information from it
	try {
		//System.out.println("I am checking if the user file exists.");
		File readStudents = new File("Students.txt");
		if (readStudents.exists())
		{
			//System.out.println("Yay, the user file exists.");
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
					
						//System.out.println("The student is taking the class: " + tempClass);
						tempStatus = inputStudents.nextLine().charAt(0);//tempStatusString.charAt(0);
						//System.out.println("Their status for this class is: " + tempStatus);
						tempStudent.setClass(tempClass, tempStatus);
						//System.out.println(tempStudent.getClassNumber());
				}
		
				StudentList.add(new Students(tempStudent));
				//System.out.println("I added a student. we now have: " + StudentList.size());
			}inputStudents.close();
			
		} else { //if the file doesn't exist it creates the file
			PrintWriter outputStudents = new PrintWriter("Students.txt");
			outputStudents.close();
		}
	
	}
	//catches any exceptions
	catch (Exception e) {
		System.out.println(e.toString());
	}
	//shows what information was saved
	/*
	for(int i = 0; i < StudentList.size(); i++)
	{
		System.out.println("ID: " + StudentList.get(i).getID());
		System.out.println("Password: " + StudentList.get(i).getPass());
		System.out.println("Name: "+ StudentList.get(i).getFirst() + " " + StudentList.get(i).getMiddle() + " " + StudentList.get(i).getLast());
		System.out.println("This person is taking this many classes: " + StudentList.get(i).getNumberOfClasses());
		for(int j = 0; j < StudentList.get(i).getNumberOfClasses(); j++)
		{
			
			System.out.println("Class: " + StudentList.get(i).getClass(j));
			
			System.out.println("Status: " + StudentList.get(i).getClassStatus(j));
		}	
	}*/
	
	
}

public void LoadProfessors() {
	String tempClass = "";
	
	boolean moreClasses = true;
	//tries to open the file and load the information
	try {
		//System.out.println("I am checking if the professor file exists.");
		File readProfessors = new File("Professors.txt");
		if (readProfessors.exists())
		{
			//System.out.println("Yay, the Professor file exists.");
			Scanner inputProfessors = new Scanner(readProfessors);
			
			Professors tempProfessor = new Professors();
			
			while(inputProfessors.hasNext()) {
				tempProfessor.setID(inputProfessors.nextLine());
				//System.out.println("I found a student with ID: " + tempStudent.getID());
				tempProfessor.setPass(inputProfessors.nextLine());
				tempProfessor.setFirst(inputProfessors.nextLine());
				tempProfessor.setMiddle(inputProfessors.nextLine());
				tempProfessor.setLast(inputProfessors.nextLine());
				tempProfessor.setNumberOfClasses(Integer.parseInt(inputProfessors.nextLine()));
				
				for(int i = 0; i <tempProfessor.getNumberOfClasses();i++)
				{
					
					tempClass = inputProfessors.nextLine();
						tempProfessor.setClass(tempClass);
				}
		
				ProfessorList.add(new Professors(tempProfessor));
				//System.out.println("I added a professor. we now have: " + ProfessorList.size());
			}inputProfessors.close();
			
		} else { //if the file doesn't exist it creates it
			//System.out.println("The file didnt exist.");
			PrintWriter outputProfessors = new PrintWriter("Professors.txt");
			outputProfessors.close();
		}
	
	}
	catch (Exception e) {
		System.out.println(e.toString());
	}
	//displays the information loaded
	/*
	for(int i = 0; i < ProfessorList.size(); i++)
	{
		System.out.println("ID: " + ProfessorList.get(i).getID());
		System.out.println("Password: " + ProfessorList.get(i).getPass());
		System.out.println("Name: "+ ProfessorList.get(i).getFirst() + " " + ProfessorList.get(i).getMiddle() + " " + ProfessorList.get(i).getLast());
		System.out.println("This person is teaching this many classes: " + ProfessorList.get(i).getNumberOfClasses());
		for(int j = 0; j < ProfessorList.get(i).getNumberOfClasses(); j++)
		{
			
			System.out.println("Class: " + ProfessorList.get(i).getClass(j));
		}	
	}*/
	
		
}

public void LoadAdministrators() {

	
	
	try {
		//tries to open the file and load the information
		//System.out.println("I am checking if the file administrator exists.");
		File readAdministrators = new File("Administrators.txt");
		if (readAdministrators.exists())
		{
			System.out.println("Yay, the Professor file exists.");
			Scanner inputAdministrators = new Scanner(readAdministrators);
			
			Administrators tempAdministrator = new Administrators();
			
			while(inputAdministrators.hasNext()) {
				tempAdministrator.setID(inputAdministrators.nextLine());
				//System.out.println("I found a student with ID: " + tempStudent.getID());
				tempAdministrator.setPass(inputAdministrators.nextLine());
				tempAdministrator.setFirst(inputAdministrators.nextLine());
				tempAdministrator.setMiddle(inputAdministrators.nextLine());
				tempAdministrator.setLast(inputAdministrators.nextLine());
				
				
				AdministratorList.add(new Administrators(tempAdministrator));
				//System.out.println("I added an administrator. we now have: " + AdministratorList.size());
			}inputAdministrators.close();
			
		} else { //if the file does not exist it creates it
			//System.out.println("The file didnt exist.");
			PrintWriter outputAdministrators = new PrintWriter("Administrators.txt");
			outputAdministrators.close();
		}
	
	}
	catch (Exception e) {
		System.out.println(e.toString());
	}
	/*
	for(int i = 0; i < AdministratorList.size(); i++)
	{
		System.out.println("ID: " + AdministratorList.get(i).getID());
		System.out.println("Password: " + AdministratorList.get(i).getPass());
		System.out.println("Name: "+ AdministratorList.get(i).getFirst() + " " + AdministratorList.get(i).getMiddle() + " " + AdministratorList.get(i).getLast());	
	}*/
}

public void saveStudents()
{
	try
	{
		//opens the file and saves the student information
		PrintWriter pw = new PrintWriter("Students.txt");
		
		for(int i = 0; i < StudentList.size(); i++)
		{
			pw.println(StudentList.get(i).getID());
			System.out.println("Saving ID: " + StudentList.get(i).getID());
			pw.println(StudentList.get(i).getPass());
			pw.println(StudentList.get(i).getFirst());
			pw.println(StudentList.get(i).getMiddle());
			pw.println(StudentList.get(i).getLast());
			pw.println(Integer.toString(StudentList.get(i).getNumberOfClasses()));
			for(int j = 0; i < StudentList.get(i).getNumberOfClasses(); j++)
			{
				pw.println(StudentList.get(i).getClass(j));
				pw.println(StudentList.get(i).getClassStatus(j));
			}
		}
		//closes the file and handles any errors
		pw.close();
	} 
	catch (Exception e)
	{
		
	}
	
}

public void saveProfessors()
{
	try
	{
		//opens the file and saves the professors information
		PrintWriter pw = new PrintWriter("Professors.txt");
		
		for(int i = 0; i < ProfessorList.size(); i++)
		{
			pw.println(ProfessorList.get(i).getID());
			pw.println(ProfessorList.get(i).getPass());
			pw.println(ProfessorList.get(i).getFirst());
			pw.println(ProfessorList.get(i).getMiddle());
			pw.println(ProfessorList.get(i).getLast());
			pw.println(ProfessorList.get(i).getNumberOfClasses());
			for(int j = 0; j < ProfessorList.get(i).getNumberOfClasses(); j++)
			{
				pw.println(ProfessorList.get(i).getClass(j));
			}
		}
		//closes the file and handles any errors
		pw.close();
	}
	catch (Exception e)
	{
		
	}
}

public void saveAdministrators()
{
	try
	
	{
		//opens the file and saves the administrators information
		PrintWriter pw = new PrintWriter("Administrators.txt");
		
		for(int i = 0; i < AdministratorList.size(); i++)
		{
			pw.println(AdministratorList.get(i).getID());
			pw.println(AdministratorList.get(i).getPass());
			pw.println(AdministratorList.get(i).getFirst());
			pw.println(AdministratorList.get(i).getMiddle());
			pw.println(AdministratorList.get(i).getLast());
		}
		//closes the file and handles any errors
		pw.close();
	}
	catch (Exception e)
	{
		
	}
}

public void LoadClasses()
{
	String tempStudent;
	try
	{
		File readCourses = new File("Courses.txt");
		System.out.println("IMA COURSE IT UP.");
		if(readCourses.exists())
		{
			System.out.println("COURSE ENEMY SIGHTED");
			Scanner inputCourses = new Scanner(readCourses);
			CoursesV2 tempCourse = new CoursesV2();
			while(inputCourses.hasNext())
			{
				tempCourse.setCourseName(inputCourses.nextLine());
				tempCourse.setProfessor(inputCourses.nextLine());
				tempCourse.setCourseNumber(inputCourses.nextLine());
				tempCourse.setDescription(inputCourses.nextLine());
				tempCourse.setNumberOfStudents(Integer.parseInt(inputCourses.nextLine()));
				
				for(int i = 0; i < tempCourse.getNumberOfStudents(); i++)
				{
					tempCourse.setRoster(inputCourses.nextLine());
				}
				CourseList.add(new CoursesV2(tempCourse));
				System.out.println("Created a new course.");
			}
			inputCourses.close();
		}else{PrintWriter outputStudents = new PrintWriter("Courses.txt");
		outputStudents.close();
		System.out.println("TANGO DOWN");
		}
	}
	catch (Exception e)
	{
		System.out.println(e.toString());
	}
	
}

public void saveClasses()
{
	try
	{
	PrintWriter pw = new PrintWriter("Courses.txt");
	
	for(int i = 0; i < CourseList.size(); i++)
	{
		pw.println(CourseList.get(i).getCourseName());
		pw.println(CourseList.get(i).getProfessor());
		pw.println(CourseList.get(i).getCourseNumber());
		pw.println(CourseList.get(i).getDescription());
		pw.println(CourseList.get(i).getNumberOfStudents());
		for(int j = 0; j < CourseList.get(i).getNumberOfStudents(); j++)
		{
			pw.println(CourseList.get(i).getRosterStudents(j));
		}
	}
	pw.close();
	}
	catch (Exception e)
	{
		
	}
}

}