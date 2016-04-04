//Matt Colarusso 
import java.util.ArrayList;

public class Professors
{
	 String ID,pass,nameFirst, nameMiddle, nameLast;
	    ArrayList<String> className = new ArrayList();
	    
	    

	    /**
	     * Constructor for objects of class accounts
	     */
	    public Professors(String x,String y, String zf, String zm, String zl)
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
	    
	    public void setClass(String c, Character s)
	    {
	    	className.add(c);
	    }

}
