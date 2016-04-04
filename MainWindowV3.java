//Scott Miller
//3/31/2016
//6:45pm



import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Event;

public class MainWindowV3 {

	protected Shell shlLogin;
	private Text txtuserName;
	private Text txtpassword;

	private String userName = null;
	private String password = null;
	
	LoadSaveDatabase database = new LoadSaveDatabase();
	
	
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			MainWindowV3 window = new MainWindowV3();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlLogin.open();
		shlLogin.layout();
		while (!shlLogin.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLogin = new Shell(SWT.CLOSE|SWT.TITLE|SWT.MIN);
		shlLogin.setSize(450, 300);
		shlLogin.setText("Login");
		
		Label lblLogo = new Label(shlLogin, SWT.NONE);
		lblLogo.setBounds(143, 24, 147, 21);
		lblLogo.setText("College Manager Database");
		
		Label lblUsername = new Label(shlLogin, SWT.NONE);
		lblUsername.setBounds(117, 91, 61, 15);
		lblUsername.setText("Username");
		
		Label lblPassword = new Label(shlLogin, SWT.NONE);
		lblPassword.setBounds(117, 124, 61, 15);
		lblPassword.setText("Password");
		
		txtuserName = new Text(shlLogin, SWT.BORDER);
		txtuserName.setBounds(184, 88, 120, 21);
		
		txtpassword = new Text(shlLogin, SWT.BORDER |SWT.PASSWORD);
		txtpassword.setBounds(184, 121, 120, 21);
		
		Button btnLogin = new Button(shlLogin, SWT.NONE);
		btnLogin.setBounds(179, 164, 75, 25);
		btnLogin.setText("Login");

		btnLogin.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                userName = txtuserName.getText();
                password = txtpassword.getText();
                boolean login = false;
                for(int i=0;i<database.StudentList.size();i++)
                {
                    if(userName.equals(database.StudentList.get(i).getID()))
                        if(password.equals(database.StudentList.get(i).getPass()))
                        {
                            login = true;
                        }
                }
                for(int i=0;i<database.ProfessorList.size();i++)
                {
                    if(userName.equals(database.ProfessorList.get(i).getID()))
                        if(password.equals(database.ProfessorList.get(i).getPass()))
                        {
                        	login = true;
                        }
                }
                for(int i=0;i<database.AdministratorList.size();i++)
                {
                    if(userName.equals(database.AdministratorList.get(i).getID()))
                        if(password.equals(database.AdministratorList.get(i).getPass()))
                        {
                        	login = true;
                        	shlLogin.close();
                            AdminPage mw = new AdminPage();
                            mw.newScreen();
                        }
                }
                if(login == false)
                	System.out.println("YOU DONE GOOF");
            }
        });
}
}
