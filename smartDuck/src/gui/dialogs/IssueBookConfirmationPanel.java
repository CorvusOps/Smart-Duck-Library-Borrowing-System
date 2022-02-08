package gui.dialogs;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import CRUD.BorrowFormCRUD;
import values.Account;
import values.Book;

public class IssueBookConfirmationPanel extends JPanel {
	
	static Connection conn = null;
	static PreparedStatement objPreparedStatementObject = null;
	static ResultSet ojbResultSetObject = null;
	
	private TextField ISBNBookDetail;
	private TextField TitleBookDetail;
	private TextField AuthorBookDetail;
	private TextField IDAccountDetail;
	private TextField NameAccountDetail;
	private TextField CourseAccountDetail;
	private TextField DepartmentAccountDetail;
	/**
	 * Create the panel.
	 */
	public IssueBookConfirmationPanel() {
		setBackground(new Color(255, 255, 204));
		setLayout(null);
		
		JLabel lblBookDetails = new JLabel("Book Details");
		lblBookDetails.setIcon(new ImageIcon(IssueBookConfirmationPanel.class.getResource("/img/bookConfirmation_50px.png")));
		lblBookDetails.setForeground(new Color(204, 102, 51));
		lblBookDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBookDetails.setBounds(25, 90, 213, 50);
		add(lblBookDetails);
		
		JLabel lblIsbnBookDetails = new JLabel("ISBN :");
		lblIsbnBookDetails.setForeground(new Color(153, 102, 0));
		lblIsbnBookDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIsbnBookDetails.setBounds(25, 165, 48, 16);
		add(lblIsbnBookDetails);
		
		ISBNBookDetail = new TextField();
		ISBNBookDetail.setEditable(false);
		ISBNBookDetail.setBounds(131, 165, 231, 22);
		add(ISBNBookDetail);
		
		JLabel lblTitle = new JLabel("Title :");
		lblTitle.setForeground(new Color(153, 102, 0));
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitle.setBounds(25, 211, 48, 16);
		add(lblTitle);
		
		TitleBookDetail = new TextField();
		TitleBookDetail.setEditable(false);
		TitleBookDetail.setBounds(131, 211, 231, 22);
		add(TitleBookDetail);
		
		JLabel lblAuthor = new JLabel("Author :");
		lblAuthor.setForeground(new Color(153, 102, 0));
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAuthor.setBounds(25, 254, 72, 16);
		add(lblAuthor);
		
		AuthorBookDetail = new TextField();
		AuthorBookDetail.setEditable(false);
		AuthorBookDetail.setBounds(131, 254, 231, 22);
		add(AuthorBookDetail);
		
		JLabel lblAccountDetails = new JLabel("Account Details");
		lblAccountDetails.setIcon(new ImageIcon(IssueBookConfirmationPanel.class.getResource("/img/addUser_50px.png")));
		lblAccountDetails.setForeground(new Color(204, 102, 51));
		lblAccountDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAccountDetails.setBounds(25, 305, 188, 50);
		add(lblAccountDetails);
		
		IDAccountDetail = new TextField();
		IDAccountDetail.setEditable(false);
		IDAccountDetail.setBounds(131, 366, 231, 22);
		add(IDAccountDetail);
		
		NameAccountDetail = new TextField();
		NameAccountDetail.setEditable(false);
		NameAccountDetail.setBounds(131, 406, 231, 22);
		add(NameAccountDetail);
		
		CourseAccountDetail = new TextField();
		CourseAccountDetail.setEditable(false);
		CourseAccountDetail.setBounds(131, 449, 231, 22);
		add(CourseAccountDetail);
		
		DepartmentAccountDetail = new TextField();
		DepartmentAccountDetail.setEditable(false);
		DepartmentAccountDetail.setBounds(129, 493, 231, 22);
		add(DepartmentAccountDetail);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setForeground(new Color(153, 102, 0));
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(25, 366, 23, 17);
		add(lblId);
		
		JLabel lblName = new JLabel("Name :  ");
		lblName.setForeground(new Color(153, 102, 0));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(25, 407, 52, 17);
		add(lblName);
		
		JLabel lblCourse = new JLabel("Course :");
		lblCourse.setForeground(new Color(153, 102, 0));
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourse.setBounds(25, 450, 72, 16);
		add(lblCourse);
		
		JLabel lblDepartment = new JLabel("Department :");
		lblDepartment.setForeground(new Color(153, 102, 0));
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepartment.setBounds(23, 493, 83, 17);
		add(lblDepartment);
		
		JLabel lblReviewBorrowForm = new JLabel("REVIEW BORROW FORM");
		lblReviewBorrowForm.setIcon(new ImageIcon(IssueBookConfirmationPanel.class.getResource("/img/books_50px.png")));
		lblReviewBorrowForm.setForeground(new Color(102, 0, 0));
		lblReviewBorrowForm.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblReviewBorrowForm.setBounds(45, 11, 273, 56);
		add(lblReviewBorrowForm);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(51, 0, 0));
		separator.setForeground(new Color(51, 0, 0));
		separator.setBounds(105, 58, 213, 2);
		add(separator);

	}
	
	public void setTexts(String ISBN, String AccID) {
	//set the texts to the JTextFields of the details of the Book and the Borrower
		
		Book bookValues = BorrowFormCRUD.getBookDetails(ISBN);
		Account accountValues = BorrowFormCRUD.getAccountDetails(AccID);
		
		ISBNBookDetail.setText(bookValues.getISBN());
		TitleBookDetail.setText(bookValues.getTitle());
		AuthorBookDetail.setText(bookValues.getAuthor());
		IDAccountDetail.setText(accountValues.getAccountId());
		NameAccountDetail.setText(accountValues.getName());
		CourseAccountDetail.setText(accountValues.getCourse());
		DepartmentAccountDetail.setText(accountValues.getDepartment());
		
	}
}
