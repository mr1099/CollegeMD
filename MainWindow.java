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

public class MainWindow {

	protected Shell shlLogin;
	private Text txtuserName;
	private Text txtpassword;

	private String userName = null;
	private String password = null;
	
	
	
	int[] things = {0,1,2,3,4};
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] things = {0,1,2,3,4};
		try {
			MainWindow window = new MainWindow();
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
				
				if(userName == null || userName.isEmpty()|| password== null || password.isEmpty()){
					String errorMsg = null;
					MessageBox messageBox = new MessageBox(shlLogin, SWT.OK|SWT.ICON_ERROR);
					messageBox.setText("Alert");
					if(userName == null || userName.isEmpty()){
						errorMsg = "Please enter username";
					}else if(password == null || password.isEmpty()){
						errorMsg = "Please enter password";
					}
					if(errorMsg!=null){
						messageBox.setMessage(errorMsg);
						messageBox.open();
					}	
				}else{
					MessageBox messageBox = new MessageBox(shlLogin, SWT.OK | SWT.ICON_WORKING);
					messageBox.setText("Info");
					messageBox.setMessage("Valid");
					messageBox.open();
					shlLogin.close();
					AdminPage mw = new AdminPage();
					mw.newScreen();
					
				}
			}
		});
	}
}
