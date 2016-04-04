//Scott Miller
//3/31/2016
//6:45pm


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class NewClassV2 {

	protected Shell shlNewClass;
	private Text txtDescription;
	private Text txtClassNameTitle;
	private Text txtClassNumber;
	private Text txtClassProfessor;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void newScreen(LoadSaveDatabaseV3 stuff) {
		try {
			NewClassV2 window = new NewClassV2();
			window.open(stuff);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open(LoadSaveDatabaseV3 stuff) {
		Display display = Display.getDefault();
		createContents(stuff);
		shlNewClass.open();
		shlNewClass.layout();
		while (!shlNewClass.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	
	
	protected void createContents(LoadSaveDatabaseV3 database) {
		shlNewClass = new Shell();
		shlNewClass.setSize(322, 358);
		shlNewClass.setText("New Class");
		shlNewClass.setLayout(new FormLayout());
		
		Group grpNewInformation = new Group(shlNewClass, SWT.NONE);
		grpNewInformation.setLayout(new FormLayout());
		FormData fd_grpNewInformation = new FormData();
		fd_grpNewInformation.bottom = new FormAttachment(0, 287);
		fd_grpNewInformation.right = new FormAttachment(0, 299);
		fd_grpNewInformation.top = new FormAttachment(0, 10);
		fd_grpNewInformation.left = new FormAttachment(0, 10);
		grpNewInformation.setLayoutData(fd_grpNewInformation);
		grpNewInformation.setText("New Information");
		
		Group grpDescription = new Group(grpNewInformation, SWT.NONE);
		FormData fd_grpDescription = new FormData();
		fd_grpDescription.bottom = new FormAttachment(0, 252);
		fd_grpDescription.right = new FormAttachment(0, 276);
		fd_grpDescription.top = new FormAttachment(0, 92);
		fd_grpDescription.left = new FormAttachment(0, 7);
		grpDescription.setLayoutData(fd_grpDescription);
		grpDescription.setText("Description");
		
		txtDescription = new Text(grpDescription, SWT.BORDER | SWT.WRAP);
		txtDescription.setBounds(10, 22, 249, 128);
		
		
		
		Button btnCancel = new Button(shlNewClass, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlNewClass.close();
			}
		});
		btnCancel.setText("Cancel");
		FormData fd_btnCancel = new FormData();
		fd_btnCancel.left = new FormAttachment(grpNewInformation, -75);
		fd_btnCancel.top = new FormAttachment(grpNewInformation, 3);
		fd_btnCancel.right = new FormAttachment(grpNewInformation, 0, SWT.RIGHT);
		
		Label lblClassNametitle = new Label(grpNewInformation, SWT.NONE);
		FormData fd_lblClassNametitle = new FormData();
		fd_lblClassNametitle.right = new FormAttachment(0, 110);
		fd_lblClassNametitle.top = new FormAttachment(0, 11);
		fd_lblClassNametitle.left = new FormAttachment(0, 7);
		lblClassNametitle.setLayoutData(fd_lblClassNametitle);
		lblClassNametitle.setAlignment(SWT.RIGHT);
		lblClassNametitle.setText("Class Name/Title:");
		
		Label lblClassNumber = new Label(grpNewInformation, SWT.NONE);
		FormData fd_lblClassNumber = new FormData();
		fd_lblClassNumber.right = new FormAttachment(lblClassNametitle, 0, SWT.RIGHT);
		fd_lblClassNumber.left = new FormAttachment(0, 17);
		lblClassNumber.setLayoutData(fd_lblClassNumber);
		lblClassNumber.setAlignment(SWT.RIGHT);
		lblClassNumber.setText("Class Number:");
		
		Label lblProfessor = new Label(grpNewInformation, SWT.NONE);
		FormData fd_lblProfessor = new FormData();
		fd_lblProfessor.left = new FormAttachment(0, 55);
		lblProfessor.setLayoutData(fd_lblProfessor);
		lblProfessor.setAlignment(SWT.RIGHT);
		lblProfessor.setText("Professor:");
		
		txtClassNameTitle = new Text(grpNewInformation, SWT.BORDER);
		FormData fd_txtClassNameTitle = new FormData();
		fd_txtClassNameTitle.right = new FormAttachment(0, 256);
		fd_txtClassNameTitle.top = new FormAttachment(0, 8);
		fd_txtClassNameTitle.left = new FormAttachment(0, 121);
		txtClassNameTitle.setLayoutData(fd_txtClassNameTitle);
		
		txtClassNumber = new Text(grpNewInformation, SWT.BORDER);
		fd_lblClassNumber.top = new FormAttachment(txtClassNumber, 3, SWT.TOP);
		FormData fd_txtClassNumber = new FormData();
		fd_txtClassNumber.left = new FormAttachment(txtClassNameTitle, 0, SWT.LEFT);
		fd_txtClassNumber.right = new FormAttachment(0, 256);
		fd_txtClassNumber.top = new FormAttachment(0, 35);
		txtClassNumber.setLayoutData(fd_txtClassNumber);
		txtClassNumber.setText("");
		
		txtClassProfessor = new Text(grpNewInformation, SWT.BORDER);
		fd_lblProfessor.top = new FormAttachment(txtClassProfessor, 3, SWT.TOP);
		fd_lblProfessor.right = new FormAttachment(txtClassProfessor, -11);
		FormData fd_txtClassProfessor = new FormData();
		fd_txtClassProfessor.top = new FormAttachment(txtClassNumber, 6);
		fd_txtClassProfessor.right = new FormAttachment(txtClassNameTitle, 0, SWT.RIGHT);
		fd_txtClassProfessor.left = new FormAttachment(0, 121);
		txtClassProfessor.setLayoutData(fd_txtClassProfessor);
		btnCancel.setLayoutData(fd_btnCancel);
		
		//Confirm Button
				Button btnConfirm = new Button(shlNewClass, SWT.NONE);
				btnConfirm.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						if(txtClassNameTitle.getText().equals("") || txtClassNumber.getText().equals("") || 
								txtClassProfessor.getText().equals("") || txtDescription.getText().equals("") ){
							//put dialog box here abut why it didn't work
							System.out.println("YOU ARE NOT READY");
						}else{
							CoursesV2 temp = new CoursesV2();
							temp.setCourseName(txtClassNameTitle.getText());
							temp.setCourseNumber(txtClassNumber.getText());
							temp.setProfessor(txtClassProfessor.getText());
							temp.setDescription(txtDescription.getText());
							database.CourseList.add(temp);
							System.out.println("YOU ARE READY");
							shlNewClass.close();
						}
					}
				});
				btnConfirm.setText("Confirm");
				FormData fd_btnConfirm = new FormData();
				fd_btnConfirm.right = new FormAttachment(0, 78);
				fd_btnConfirm.left = new FormAttachment(0, 3);
				fd_btnConfirm.top = new FormAttachment(grpNewInformation, 3);
				btnConfirm.setLayoutData(fd_btnConfirm);

	}

}
