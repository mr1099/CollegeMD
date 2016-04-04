import java.util.ArrayList;
public class Students
{
    String ID,pass,nameFirst, nameMiddle, nameLast;
    ArrayList<String> className = new ArrayList();
    ArrayList<Character> classStatus = new ArrayList();
    int numberOfClasses = 0;
    
    

    /**
     * Constructor for objects of class accounts
     */
    public Students(Students s)
    {
        ID=s.getID();
        pass=s.getPass();
        nameFirst = s.getFirst();
        nameMiddle = s.getMiddle();
        nameLast = s.getLast();
        className.addAll(s.getClasses());
        classStatus.addAll(s.getClassStatus());
        numberOfClasses = (s.getNumberOfClasses());
    }
    
    public Students()
    {
    	
    }
    
    public String getID()
    {
        return(ID);
    }

    public String getPass()
    {
        return(pass);
    }

    public String getName()
    {
        return(nameFirst + " " + nameMiddle + " " + nameLast);
    }
    
    public String getFirst()
    {
    	return nameFirst;
    }
    
    public String getMiddle()	
    {
    	return nameMiddle;
    }
    
    public String getLast()
    {
    	return nameLast;
    }
    
    public void setID(String i)
    {
    	ID = i;
    }
    
    public void setPass(String p)
    {
    	pass = p;
    }
    
    public void setFirst(String f)
    {
    	nameFirst = f;
    }
    
    public void setMiddle(String m)
    {
    	nameMiddle = m;
    }
    
    public void setLast(String l)
    {
    	nameLast = l;
    }
    
    public void setClass(String c, Character s)
    {
    	className.add(new String(c));
    	classStatus.add(new Character(s));
    }

    public ArrayList<String> getClasses()
    {
    	return className;
    }

  
    
     public ArrayList<Character> getClassStatus()
    {
    	return classStatus;
    }
    
    public String getClass(int i)
    {
    	String temp = "";
    	
    	System.out.println("What Waht");
    	temp = className.get(i);
    	System.out.println("IN THE BUTT");
    	return temp;
    }
    
    public int getClassNumber()
    {
    	return className.size();
    }
    
    public Character getClassStatus(int i)
    {
    	return classStatus.get(i);
    }

    public int getNumberOfClasses()
    {
    	return numberOfClasses;
    }
    
    public void incrementNumberOfClasses()
    {
    	numberOfClasses++;
    }
    
    public void dincrimentNumberOfClasses()
    {
    	numberOfClasses--;
    }

    public void setNumberOfClasses(int i)
    {
    	numberOfClasses = i;
    }
}
