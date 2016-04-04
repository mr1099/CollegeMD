//Scott Miller
//3/31/2016
//6:45pm


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class NewUser {

	protected Shell shlNewUser;
	private Text txtFirstName;
	private Text txtMiddleName;
	private Text txtLastName;
	private Text txtPassword;
	private Text txtUsername;
	private Text txtConfirmPassword;
	private Label lblMiddleName;
	private Label lblLastName;
	private Label lblConfirmPassword;
	private Label lblUserType;
	private Label lblUsername;
	private Label lblPassword;
	private Button btnCancel;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void newScreen() {
		try {
			NewUser window = new NewUser();
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
		shlNewUser.open();
		shlNewUser.layout();
		while (!shlNewUser.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlNewUser = new Shell();
		shlNewUser.setSize(339, 308);
		shlNewUser.setText("New User");
		shlNewUser.setLayout(new FormLayout());
		shlNewUser.forceFocus();
		
		Group grpInformation = new Group(shlNewUser, SWT.NONE);
		grpInformation.setText("New Information");
		FormData fd_grpInformation = new FormData();
		fd_grpInformation.top = new FormAttachment(0, 10);
		fd_grpInformation.left = new FormAttachment(0, 10);
		fd_grpInformation.bottom = new FormAttachment(0, 231);
		fd_grpInformation.right = new FormAttachment(0, 314);
		grpInformation.setLayoutData(fd_grpInformation);
		
		txtFirstName = new Text(grpInformation, SWT.BORDER);
		txtFirstName.setBounds(155, 27, 139, 21);
		
		txtMiddleName = new Text(grpInformation, SWT.BORDER);
		txtMiddleName.setBounds(155, 54, 139, 21);
		
		txtLastName = new Text(grpInformation, SWT.BORDER);
		txtLastName.setBounds(155, 81, 139, 21);
		
		txtPassword = new Text(grpInformation, SWT.BORDER | SWT.PASSWORD);
		txtPassword.setBounds(155, 162, 139, 21);
		
		txtUsername = new Text(grpInformation, SWT.BORDER);
		txtUsername.setBounds(155, 135, 139, 21);
		
		txtConfirmPassword = new Text(grpInformation, SWT.BORDER | SWT.PASSWORD);
		txtConfirmPassword.setBounds(155, 189, 139, 21);
		
		Combo cmbUserType = new Combo(grpInformation, SWT.READ_ONLY);
		cmbUserType.setItems(new String[] {"Admin", "Teacher", "Student"});
		cmbUserType.setBounds(155, 107, 139, 23);
		
		Label lblFirstName = new Label(grpInformation, SWT.NONE);
		lblFirstName.setAlignment(SWT.RIGHT);
		lblFirstName.setBounds(79, 30, 70, 15);
		lblFirstName.setText("First Name:");
		
		lblMiddleName = new Label(grpInformation, SWT.NONE);
		lblMiddleName.setAlignment(SWT.RIGHT);
		lblMiddleName.setBounds(67, 57, 82, 15);
		lblMiddleName.setText("Middle Name:");
		
		lblLastName = new Label(grpInformation, SWT.NONE);
		lblLastName.setAlignment(SWT.RIGHT);
		lblLastName.setBounds(79, 84, 70, 15);
		lblLastName.setText("Last Name:");
		
		lblConfirmPassword = new Label(grpInformation, SWT.NONE);
		lblConfirmPassword.setAlignment(SWT.RIGHT);
		lblConfirmPassword.setBounds(10, 192, 139, 15);
		lblConfirmPassword.setText("Confirm Password:");
		
		lblUserType = new Label(grpInformation, SWT.NONE);
		lblUserType.setBounds(94, 110, 55, 15);
		lblUserType.setText("User Type:");
		
		lblUsername = new Label(grpInformation, SWT.NONE);
		lblUsername.setAlignment(SWT.RIGHT);
		lblUsername.setBounds(94, 138, 55, 15);
		lblUsername.setText("Username:");
		
		lblPassword = new Label(grpInformation, SWT.NONE);
		lblPassword.setBounds(94, 165, 55, 15);
		lblPassword.setText("Password:");
		
		Button btnConfirm = new Button(shlNewUser, SWT.NONE);
		
		//Confirm button
		btnConfirm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("AM I READY?");
				//Giant if statement checking if all the fields have content and if the password and confirmPassword match
				if(txtFirstName.getText().equals("") || txtMiddleName.getText().equals("") || txtLastName.getText().equals("") || 
						cmbUserType.getSelectionIndex() == -1 || txtUsername.getText().equals("") ||
						txtPassword.getText().equals("") || txtConfirmPassword.getText().equals("") || 
						!(txtConfirmPassword.getText().equals(txtPassword.getText()))){
					//put dialog box here abut why it didn't work
					System.out.println("YOU ARE NOT READY");
				}else{
					//put actual user creation here
					System.out.println("YOU ARE READY");
					shlNewUser.close();
				}
			}
		});
		
		
		FormData fd_btnConfirm = new FormData();
		fd_btnConfirm.right = new FormAttachment(0, 89);
		fd_btnConfirm.top = new FormAttachment(grpInformation, 6);
		fd_btnConfirm.left = new FormAttachment(0, 10);
		btnConfirm.setLayoutData(fd_btnConfirm);
		btnConfirm.setText("Confirm");
		
		btnCancel = new Button(shlNewUser, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlNewUser.close();
			}
		});
		btnCancel.setText("Cancel");
		FormData fd_btnCancel = new FormData();
		fd_btnCancel.left = new FormAttachment(100, -89);
		fd_btnCancel.top = new FormAttachment(grpInformation, 6);
		fd_btnCancel.right = new FormAttachment(100, -10);
		btnCancel.setLayoutData(fd_btnCancel);

	}
}
