import java.util.ArrayList;

public class CoursesV2
{
	//variables and arraylist
	String courseName, professor, courseNumber, description;
	ArrayList<String> roster = new ArrayList();
	int numberOfStudents = 0;
	
	//constructor
	public CoursesV2(CoursesV2 c)
	{
		courseName = c.getCourseName();
		professor = c.getProfessor();
		courseNumber = c.getCourseNumber();
		numberOfStudents = c.getNumberOfStudents();
		roster.addAll(c.getRoster());
		description = c.getDescription();
	}
	
	public CoursesV2()
	{
		
	}
	
	public String getCourseName()
	{
		return courseName;
	}
	
	public String getProfessor()
	{
		return professor;
	}
	
	public String getCourseNumber()
	{
		return courseNumber;
	}
	
	public int getNumberOfStudents()
	{
		return numberOfStudents;
	}
	
	public ArrayList<String> getRoster()
	{
		return roster;
	}
	
	public String getRosterStudents(int i)
	{
		return roster.get(i);
	}

	public void setCourseName(String n)
	{
		courseName = n;
	}
	
	public void setProfessor(String p)
	{
		professor = p;
	}
	
	public void setCourseNumber(String c)
	{
		courseNumber = c;
	}
	
	public void setNumberOfStudents(int s)
	{
		numberOfStudents = s;
	}
	
	public void setRoster(String n)
	{
		roster.add(n);
	}
	
	public void setDescription(String d)
	{
		description = d;
	}
	
	
	public String getDescription()
	{
		return description;
	}
}