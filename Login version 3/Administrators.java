import java.util.ArrayList;

public class Administrators
{
	 String ID,pass,nameFirst, nameMiddle, nameLast;
	    
	    
	    

	    /**
	     * Constructor for objects of class accounts
	     */
	    public Administrators(String x,String y, String zf, String zm, String zl)
	    {
	        ID=x;
	        pass=y;
	        nameFirst = zf;
	        nameMiddle = zm;
	        nameLast = zl;
	        
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
	    
	   
}
