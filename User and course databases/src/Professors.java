
import java.util.ArrayList;

public class Professors
{
	//variables and arraylists 
	String ID,pass,nameFirst, nameMiddle, nameLast;
	 ArrayList<String> className = new ArrayList();
	 int numberOfClasses = 0; 
	    

	    /**
	     * Constructor for objects of class accounts
	     */
	    public Professors(Professors s)
	    {
	        ID=s.getID();
	        pass=s.getPass();
	        nameFirst = s.getFirst();
	        nameMiddle = s.getMiddle();
	        nameLast = s.getLast();
	        className.addAll(s.getClasses());
	        numberOfClasses = (s.getNumberOfClasses());
	    }
	    
	    public Professors()
	    {
	    	
	    }
	    
	   
	    //getters and setters
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
	    
	    public void setClass(String c)
	    {
	    	className.add(new String(c));
	    	
	    }

	    public ArrayList<String> getClasses()
	    {
	    	return className;
	    }

	  
	    
	    
	    
	    public String getClass(int i)
	    {
	    	String temp = "";
	    	
	    	//System.out.println("What Waht");
	    	temp = className.get(i);
	    	//System.out.println("IN THE BUTT");
	    	return temp;
	    }
	    
	    public int getClassNumber()
	    {
	    	return className.size();
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
