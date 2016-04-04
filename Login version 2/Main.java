import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.geom.*;
public class Main extends JPanel
{
    JFrame frame= new JFrame("Login");
    boolean stop=false;
    boolean error1=false;
    String errorMessage1="Invalid login";
    volatile boolean login=false;
    String ID,pass;
    String newID,newPass,name;
    ArrayList<Administrators>administrator=new ArrayList<Administrators>();
    ArrayList<Professors>professor=new ArrayList<Professors>();
    ArrayList<Students>student=new ArrayList<Students>();
    JTextField IDField= new JTextField("UserID");
    JTextField PassField= new JTextField("UserPass");
    JButton loginBtn=new JButton("login");

    JButton logoutBtn=new JButton("logout");
    public Main()
    {
        super();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0,700,600);
        frame.add(this);
        frame.setResizable(false);
        frame.setVisible(true);
        this.setLayout(null);

        LoadSaveDatabase database = new LoadSaveDatabase();

        logoutBtn.setVisible(false);

        IDField.setBounds(184, 88, 120, 21);
        this.add(IDField);
        IDField.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    IDField.setText("");    
                }
            });
        PassField.setBounds(184, 121, 120, 21);
        this.add(PassField);
        PassField.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    PassField.setText("");    
                }
            });
        loginBtn.setBounds(179, 164, 75, 25);
        this.add(loginBtn);
        loginBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed (ActionEvent evt)
                {
                    ID=IDField.getText();
                    pass=PassField.getText();
                    for(int i=0;i<database.StudentList.size();i++)
                    {
                        if(ID.equals(database.StudentList.get(i).getID()))
                            if(pass.equals(database.StudentList.get(i).getPass()))
                                login=true; 

                        if(login)
                        {
                            loginBtn.setVisible(false);
                            PassField.setVisible(false);
                            IDField.setVisible(false);

                            logoutBtn.setVisible(true);
                        }

                    }
                    /*for(Professors userID:professor)
                    {
                    login=true; 
                    if(login)
                    {
                    loginBtn.setVisible(false);
                    PassField.setVisible(false);
                    IDField.setVisible(false);

                    logoutBtn.setVisible(true);
                    }

                    }
                    for(Administrators userID:administrator)
                    {
                    login=true; 
                    if(login)
                    {
                    loginBtn.setVisible(false);
                    PassField.setVisible(false);
                    IDField.setVisible(false);

                    logoutBtn.setVisible(true);
                    }

                    }*/
                    if(!login)
                        System.out.println("Invalid login");    
                    }
            });
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
    }

    public static void main(String[] args) 
    {
        new Main();
    }
}