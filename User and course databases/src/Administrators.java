import java.util.ArrayList;

public class Administrators
{
	//variables and arraylists
	String ID,pass,nameFirst, nameMiddle, nameLast;
	 ArrayList<String> className = new ArrayList();
	 int numberOfClasses = 0; 
	    

	    /**
	     * Constructor for objects of class accounts
	     */
	    public Administrators(Administrators s)
	    {
	        ID=s.getID();
	        pass=s.getPass();
	        nameFirst = s.getFirst();
	        nameMiddle = s.getMiddle();
	        nameLast = s.getLast();
	        
	    }
	    
	    public Administrators()
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
	    
	   

	   
}
