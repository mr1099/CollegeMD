//Scott Miller
//3/31/2016
//6:45pm


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.graphics.Point;

public class AdminPageV2 {

	protected Shell shlAdminPage;
	private Text txtSearchBar;
	private Text txtClassDescription;

	boolean newClassOpen = false;
	boolean newUserOpen = false;
	
	LoadSaveDatabaseV3 database = new LoadSaveDatabaseV3();
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void newScreen(LoadSaveDatabaseV3 stuff) {
		database = stuff;
		try {
			AdminPageV2 window = new AdminPageV2();
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
		shlAdminPage.open();
		shlAdminPage.layout();
		while (!shlAdminPage.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		NewClassV2 nC = new NewClassV2();
		NewUserV2 nU = new NewUserV2();
		Combo cmbUsersClasses;
		
		
		shlAdminPage = new Shell();
		shlAdminPage.setMinimumSize(new Point(540, 364));
		shlAdminPage.setSize(549, 374);
		shlAdminPage.setText("Admin");
		
		Group grpClassInfo = new Group(shlAdminPage, SWT.NONE);
		grpClassInfo.setLocation(194, 10);
		grpClassInfo.setSize(321, 283);
		
		
		grpClassInfo.setText("Information");
		grpClassInfo.setVisible(false);
		//
		//Class Information Controls
		//
		Label lblProfessorName = new Label(grpClassInfo, SWT.NONE);
		lblProfessorName.setText("Professor Name:");
		lblProfessorName.setAlignment(SWT.RIGHT);
		lblProfessorName.setBounds(15, 46, 95, 15);
		
		Label lblCNum = new Label(grpClassInfo, SWT.NONE);
		lblCNum.setText("Class Number:");
		lblCNum.setAlignment(SWT.RIGHT);
		lblCNum.setBounds(25, 67, 85, 15);
		
		Label lblClassTitleName = new Label(grpClassInfo, SWT.BORDER);
		lblClassTitleName.setBounds(116, 24, 123, 15);
		
		Label lblProfessor = new Label(grpClassInfo, SWT.BORDER);
		lblProfessor.setBounds(116, 45, 123, 15);
		
		Label lblClassNumber = new Label(grpClassInfo, SWT.BORDER);
		lblClassNumber.setBounds(116, 66, 61, 15);
		
		Group grpClassDescription = new Group(grpClassInfo, SWT.NONE);
		grpClassDescription.setText("Class Description");
		grpClassDescription.setBounds(10, 88, 159, 185);
		
		txtClassDescription = new Text(grpClassDescription, SWT.BORDER);
		txtClassDescription.setEditable(false);
		txtClassDescription.setBounds(10, 20, 132, 155);
		
		Label lblCTN = new Label(grpClassInfo, SWT.NONE);
		lblCTN.setBounds(10, 25, 99, 15);
		lblCTN.setText("Class Title/Name");
		lblCTN.setAlignment(SWT.RIGHT);
		
		Group grpClassRoster = new Group(grpClassInfo, SWT.NONE);
		grpClassRoster.setBounds(175, 88, 136, 185);
		grpClassRoster.setText("Class Roster");
		
		List lstClassRoster = new List(grpClassRoster, SWT.BORDER);
		lstClassRoster.setBounds(10, 20, 116, 155);
		Group grpUserInfo = new Group(shlAdminPage, SWT.NONE);
		
		//
		//End Class Information Controls
		//
		
		txtSearchBar = new Text(shlAdminPage, SWT.BORDER);
		txtSearchBar.setText("Search");
		txtSearchBar.setBounds(85, 12, 92, 21);
		
		Menu menu = new Menu(shlAdminPage, SWT.BAR);
		shlAdminPage.setMenuBar(menu);
		
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");
		
		Menu menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);
		
		MenuItem mntmSave = new MenuItem(menu_1, SWT.NONE);
		mntmSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				database.saveUsers();
				database.saveClasses();
			}
		});
		mntmSave.setText("Save");
		
		MenuItem mntmExit = new MenuItem(menu_1, SWT.NONE);
		mntmExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				database.saveUsers();
				database.saveClasses();
				shlAdminPage.close();
			}
		});
		mntmExit.setText("Exit");
		
		MenuItem mntmHelp = new MenuItem(menu, SWT.CASCADE);
		mntmHelp.setText("Help");
		
		Menu menu_2 = new Menu(mntmHelp);
		mntmHelp.setMenu(menu_2);
		
		MenuItem mntmManual = new MenuItem(menu_2, SWT.NONE);
		mntmManual.setText("Manual");
		
		MenuItem mntmFaq = new MenuItem(menu_2, SWT.NONE);
		mntmFaq.setText("FAQ");
		
		
		grpUserInfo.setText("Information");
		grpUserInfo.setBounds(194, 10, 321, 283);
		
		//
		//User Information Controls
		//
		
		Label lblFirst = new Label(grpUserInfo, SWT.NONE);
		lblFirst.setAlignment(SWT.RIGHT);
		lblFirst.setBounds(13, 25, 67, 15);
		lblFirst.setText("First Name:");
		
		Label lblMiddle = new Label(grpUserInfo, SWT.NONE);
		lblMiddle.setAlignment(SWT.RIGHT);
		lblMiddle.setBounds(2, 46, 78, 15);
		lblMiddle.setText("Middle Name:");
		
		Label lblLast = new Label(grpUserInfo, SWT.NONE);
		lblLast.setAlignment(SWT.RIGHT);
		lblLast.setBounds(15, 67, 65, 15);
		lblLast.setText("Last Name:");
		
		Label lblFirstName = new Label(grpUserInfo, SWT.BORDER);
		lblFirstName.setBounds(86, 25, 85, 15);
		
		Label lblMiddleName = new Label(grpUserInfo, SWT.BORDER);
		lblMiddleName.setBounds(86, 46, 85, 15);
		
		Label lblLastName = new Label(grpUserInfo, SWT.BORDER);
		lblLastName.setBounds(86, 67, 85, 15);
		
		Label lblUname = new Label(grpUserInfo, SWT.NONE);
		lblUname.setBounds(208, 10, 55, 15);
		lblUname.setText("Username:");
		
		Label lblpass = new Label(grpUserInfo, SWT.NONE);
		lblpass.setBounds(208, 46, 55, 15);
		lblpass.setText("Password:");
		
		Label lblUsername = new Label(grpUserInfo, SWT.BORDER);
		lblUsername.setBounds(196, 25, 85, 15);
		
		Label lblPassword = new Label(grpUserInfo, SWT.BORDER);
		lblPassword.setBounds(196, 66, 85, 15);
		
		Group grpClass = new Group(grpUserInfo, SWT.NONE);
		grpClass.setText("Class");
		grpClass.setBounds(10, 108, 147, 165);
		
		List lstUserClasses = new List(grpClass, SWT.BORDER);
		lstUserClasses.setBounds(10, 22, 127, 133);
		
		Group grpStatus = new Group(grpUserInfo, SWT.NONE);
		grpStatus.setText("Status");
		grpStatus.setBounds(164, 108, 147, 165);
		
		List lstUserStatuses = new List(grpStatus, SWT.BORDER);
		lstUserStatuses.setBounds(10, 23, 127, 133);
		
		//
		//End User Information COntrols
		//
		List lstUsersClasses = new List(shlAdminPage, SWT.BORDER);
		
		cmbUsersClasses = new Combo(shlAdminPage, SWT.READ_ONLY);
		cmbUsersClasses.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lstUsersClasses.removeAll();
				if(cmbUsersClasses.getSelectionIndex() == 1){
					grpUserInfo.setVisible(false);
					grpClassInfo.setVisible(true);
					System.out.println(database.CourseList.size());
					for(int i=0;i<database.CourseList.size();i++)
					{
						lstUsersClasses.add(database.CourseList.get(i).getCourseNumber());
					}
				}else{
					grpClassInfo.setVisible(false);
					grpUserInfo.setVisible(true);
					for(int i=0;i<database.StudentList.size();i++)
					{
						lstUsersClasses.add(database.StudentList.get(i).getID());
					}
				}
			}
		});
		cmbUsersClasses.setItems(new String[] {"Users", "Classes"});
		cmbUsersClasses.setBounds(10, 10, 69, 23);
		
		
		
		lstUsersClasses.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String selected = lstUsersClasses.getItem(lstUsersClasses.getSelectionIndex());
				if(cmbUsersClasses.getSelectionIndex() == 0)
				{
					for(int i=0;i<database.StudentList.size();i++)
			        {
			            if(selected.equals(database.StudentList.get(i).getID())){
			            	lblFirstName.setText(database.StudentList.get(i).getFirst());
			            	lblLastName.setText(database.StudentList.get(i).getLast());
			            	//Fill in Rest of Labels
			            }
			        }	
				}else{
					
				}
				
			}
		});
		lstUsersClasses.setBounds(10, 41, 167, 190);
		if(cmbUsersClasses.getSelectionIndex() == 0)
		{
			
		}else{
			
		}
		
		
		
		Button btnAdd = new Button(shlAdminPage, SWT.NONE);		//Add Button
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(cmbUsersClasses.getSelectionIndex() == 1 && newClassOpen == false){
					newClassOpen = true;
					nC.newScreen(database);
					newClassOpen = false;
					database.saveClasses();
				}else if(cmbUsersClasses.getSelectionIndex() == 0 && newUserOpen == false){
					newUserOpen = true;
					nU.newScreen(database);
					newUserOpen = false;
					database.saveUsers();
				}
			}
		});
		btnAdd.setBounds(10, 237, 75, 25);
		btnAdd.setText("Add");
		
		Button btnRemove = new Button(shlAdminPage, SWT.NONE);		//Remove Button
		btnRemove.setBounds(102, 237, 75, 25);
		btnRemove.setText("Remove");
		
		Button btnEdit = new Button(shlAdminPage, SWT.NONE);		//Remove Edit
		btnEdit.setBounds(10, 268, 167, 25);
		btnEdit.setText("Edit");
	}
}
