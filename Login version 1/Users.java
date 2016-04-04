public class Users
{
    String ID,pass,name;
    double balance;

    /**
     * Constructor for objects of class accounts
     */
    public Users(String x,String y, String z)
    {
        ID=x;
        pass=y;
        name=z;
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
        return(name);
    }

}
