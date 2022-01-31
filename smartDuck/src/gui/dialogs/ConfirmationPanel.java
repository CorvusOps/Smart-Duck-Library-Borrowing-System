package gui.dialogs;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class ConfirmationPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ConfirmationPanel() {
		setBackground(new Color(255, 255, 204));
		setLayout(null);
		
		JLabel lblBookDetails = new JLabel("Book Details");
		lblBookDetails.setIcon(new ImageIcon(ConfirmationPanel.class.getResource("/img/iconBook.png")));
		lblBookDetails.setForeground(new Color(204, 102, 51));
		lblBookDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBookDetails.setBounds(25, 90, 213, 50);
		add(lblBookDetails);
		
		JLabel lblIsbnBookDetails = new JLabel("ISBN :");
		lblIsbnBookDetails.setForeground(new Color(153, 102, 0));
		lblIsbnBookDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIsbnBookDetails.setBounds(25, 165, 48, 16);
		add(lblIsbnBookDetails);
		
		TextField ISBNBookDetail = new TextField();
		ISBNBookDetail.setEnabled(false);
		ISBNBookDetail.setEditable(false);
		ISBNBookDetail.setBounds(131, 165, 231, 22);
		add(ISBNBookDetail);
		
		JLabel lblTitle = new JLabel("Title :");
		lblTitle.setForeground(new Color(153, 102, 0));
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitle.setBounds(25, 211, 48, 16);
		add(lblTitle);
		
		TextField TitleBookDetail = new TextField();
		TitleBookDetail.setEnabled(false);
		TitleBookDetail.setEditable(false);
		TitleBookDetail.setBounds(131, 211, 231, 22);
		add(TitleBookDetail);
		
		JLabel lblAuthor = new JLabel("Author :");
		lblAuthor.setForeground(new Color(153, 102, 0));
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAuthor.setBounds(25, 254, 72, 16);
		add(lblAuthor);
		
		TextField AuthorBookDetail = new TextField();
		AuthorBookDetail.setEditable(false);
		AuthorBookDetail.setBounds(131, 254, 231, 22);
		add(AuthorBookDetail);
		
		JLabel lblAccountDetails = new JLabel("Account Details");
		lblAccountDetails.setIcon(new ImageIcon("C:\\Users\\JAN NICOLE CASILLAN\\eclipse-workspace\\AppDev-Finals\\img\\Account.png"));
		lblAccountDetails.setForeground(new Color(204, 102, 51));
		lblAccountDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAccountDetails.setBounds(25, 305, 188, 50);
		add(lblAccountDetails);
		
		TextField IDAccountDetail = new TextField();
		IDAccountDetail.setEditable(false);
		IDAccountDetail.setBounds(131, 366, 231, 22);
		add(IDAccountDetail);
		
		TextField NameAccountDetail = new TextField();
		NameAccountDetail.setEditable(false);
		NameAccountDetail.setBounds(131, 406, 231, 22);
		add(NameAccountDetail);
		
		TextField CourseAccountDetail = new TextField();
		CourseAccountDetail.setEditable(false);
		CourseAccountDetail.setBounds(131, 449, 231, 22);
		add(CourseAccountDetail);
		
		TextField DepartmentAccountDetail = new TextField();
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
		lblReviewBorrowForm.setForeground(new Color(102, 0, 0));
		lblReviewBorrowForm.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblReviewBorrowForm.setBounds(79, 30, 213, 37);
		add(lblReviewBorrowForm);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(51, 0, 0));
		separator.setForeground(new Color(51, 0, 0));
		separator.setBounds(79, 59, 213, 2);
		add(separator);

	}
}
