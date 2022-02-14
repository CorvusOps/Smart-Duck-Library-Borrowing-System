package gui.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import CRUD.BorrowFormCRUD;
import CRUD.ReturnFormCRUD;
import Execution.BorrowFormEXE;
import gui.panels.BorrowFormPanel;
import values.BorrowForm;

public class EditBorrowForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static int borrowFormID;
	private String statusChoices[] = {"Returned", "Issued"};
	private JComboBox ISBNcomboBox;
	private JComboBox AccountIDcomboBox;
	private JComboBox StatusComboBox;
	private JDateChooser IssueDate;
	private JDateChooser DueDate;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditBorrowForm dialog = new EditBorrowForm(borrowFormID);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param borrowFormID 
	 */
	public EditBorrowForm(int borrowFormID) {
		setBounds(100, 100, 450, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 204, 153));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 255, 204));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPanel.add(panel, gbc_panel);
		
		JLabel lblIssueBook = new JLabel("Edit Borrow Form");
		lblIssueBook.setIcon(new ImageIcon(IssueBook.class.getResource("/img/books_50px.png")));
		lblIssueBook.setForeground(new Color(255, 102, 0));
		lblIssueBook.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIssueBook.setBounds(97, 38, 236, 74);
		panel.add(lblIssueBook);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(204, 102, 0));
		separator.setBackground(new Color(204, 102, 0));
		separator.setBounds(118, 106, 181, 6);
		panel.add(separator);
		
		JLabel lblIsbn = new JLabel("ISBN :");
		lblIsbn.setForeground(new Color(153, 102, 0));
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIsbn.setBounds(40, 146, 48, 16);
		panel.add(lblIsbn);
		
		JLabel lblAccId = new JLabel("Account ID :");
		lblAccId.setForeground(new Color(153, 102, 0));
		lblAccId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAccId.setBounds(40, 197, 84, 16);
		panel.add(lblAccId);
		
		JLabel lblIssueDate = new JLabel("Issue Date :");
		lblIssueDate.setForeground(new Color(153, 102, 0));
		lblIssueDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIssueDate.setBounds(40, 252, 84, 16);
		panel.add(lblIssueDate);
		
		IssueDate = new JDateChooser();
		IssueDate.setDateFormatString("yyyy-MM-dd");
		IssueDate.setBounds(143, 248, 211, 20);
		panel.add(IssueDate);
		
		JLabel lblDueDate = new JLabel("Due Date :");
		lblDueDate.setForeground(new Color(153, 102, 0));
		lblDueDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDueDate.setBounds(40, 307, 84, 16);
		panel.add(lblDueDate);
		
		DueDate = new JDateChooser();
		DueDate.setDateFormatString("yyyy-MM-dd");
		DueDate.setBounds(143, 303, 211, 20);
		panel.add(DueDate);
		
		ISBNcomboBox = new JComboBox();
		ISBNcomboBox.setBackground(Color.WHITE);
		ISBNcomboBox.setBounds(143, 145, 211, 22);
		panel.add(ISBNcomboBox);
		ISBNcomboBox.addItem("Select");
		BorrowFormCRUD.ISBNComboBox(ISBNcomboBox);
		
		AccountIDcomboBox = new JComboBox();
		AccountIDcomboBox.setBackground(Color.WHITE);
		AccountIDcomboBox.setBounds(143, 196, 211, 22);
		panel.add(AccountIDcomboBox);
		AccountIDcomboBox.addItem("Select");
		BorrowFormCRUD.AccountIDComboBox(AccountIDcomboBox);
		
		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setForeground(new Color(153, 102, 0));
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(40, 354, 84, 16);
		panel.add(lblStatus);
		
		StatusComboBox = new JComboBox(statusChoices);
		StatusComboBox.setBackground(Color.WHITE);
		StatusComboBox.setBounds(143, 353, 211, 22);
		panel.add(StatusComboBox);
		
		setTexts(borrowFormID);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 204, 153));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton SaveButton = new JButton("Save");
				SaveButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						BorrowForm borrowFormValues = new BorrowForm();
						borrowFormValues.setBorrowFormID(borrowFormID);
						
						String ISBN = (String) ISBNcomboBox.getSelectedItem();
						String AccountID = (String) AccountIDcomboBox.getSelectedItem();
						String Status = (String) StatusComboBox.getSelectedItem();
						//fields that needs to be filled out
						
							boolean isFilled = !ISBN.equals("") && !ISBN.equals("Select")
												&& !AccountID.equals("") && !AccountID.equals("Select");
							try {
								if(isFilled) {
									java.sql.Date issuedate = new java.sql.Date(IssueDate.getDate().getTime());
									java.sql.Date duedate = new java.sql.Date(DueDate.getDate().getTime());
					
									//System.out.println(AccountID + " " + ISBN + " " + Status+ " " +issuedate + " " + duedate);
									//Set Values and Update DB
									BorrowFormEXE.setValues(borrowFormValues, AccountID, 
											ISBN, Status, issuedate, duedate);
									BorrowFormCRUD.UpdateBorrowForm(borrowFormValues);
									setVisible(false);
									
									
								} else {
									JOptionPane.showMessageDialog(null, "Not saved. Input Required Fields.");
									}
								} catch (Exception e1) {
								e1.printStackTrace();
							}					
					}
				});
				SaveButton.setActionCommand("OK");
				buttonPane.add(SaveButton);
				getRootPane().setDefaultButton(SaveButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
	}
	
	public void setTexts(int borrowID) {
		//set the texts to the JTextFields of the details from the Borrower Table
			BorrowForm borrowValues = ReturnFormCRUD.getBorrowDetails(borrowID);
			
			
			ISBNcomboBox.setSelectedItem(borrowValues.getISBN());
			AccountIDcomboBox.setSelectedItem(borrowValues.getAccountID());
			StatusComboBox.setSelectedItem(borrowValues.getStatus());
			IssueDate.setDate(borrowValues.getIssueDate());
			DueDate.setDate(borrowValues.getDueDate());
	}
	
	
}
