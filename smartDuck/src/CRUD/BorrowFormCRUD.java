package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import connection.DbConnection;
import values.Account;
import values.Book;
import values.BorrowForm;

public class BorrowFormCRUD {
	static Connection conn = null;
	static PreparedStatement objPreparedStatementObject = null;
	static ResultSet ojbResultSetObject = null;
	
	public static String setFields() {
		String strfields = 
						"(borrowFormID,"		+
						"AccountID,"       +
						"ISBN,"       +
						"Status,"       +
						"IssueDate,"       +
						"DueDate)";
		return strfields;
	}
	
	public static  String setValues() {
		String strfields = "VALUES(null,"+
								"?,"  + 
								"?,"  +
								"?,"  +
								"?,"  +
								"?)";
		return strfields;
	}
		
	public static int CreateBorrowForm (BorrowForm borrowform) {
		conn =   DbConnection.getConnection();
		int intResult = 0;

		try {
			
			objPreparedStatementObject = conn.prepareStatement("INSERT INTO borrowform_table " + setFields()
					+ setValues());
			objPreparedStatementObject.setString(1, borrowform.getAccountID());
			objPreparedStatementObject.setString(2, borrowform.getISBN());
			objPreparedStatementObject.setString(3, borrowform.getStatus());
			objPreparedStatementObject.setDate(4, borrowform.getIssueDate());
			objPreparedStatementObject.setDate(5, borrowform.getDueDate());
			
			intResult = objPreparedStatementObject.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return intResult;
	}
	
	public static ArrayList<BorrowForm> ReadBorrowForm() {
		ArrayList<BorrowForm> borrowForm = new ArrayList<BorrowForm>();
		try {
			conn =   DbConnection.getConnection();
			objPreparedStatementObject = conn.prepareStatement("SELECT * FROM borrowform_table");  
			ojbResultSetObject = objPreparedStatementObject.executeQuery();
		
			while(ojbResultSetObject.next()) {
				BorrowForm borrowValues = new BorrowForm();
				  
				borrowValues.setBorrowFormID(ojbResultSetObject.getInt("borrowFormID"));
				borrowValues.setAccountID(ojbResultSetObject.getString("AccountID"));
				borrowValues.setISBN(ojbResultSetObject.getString("ISBN"));
				borrowValues.setStatus(ojbResultSetObject.getString("Status"));
				borrowValues.setIssueDate(ojbResultSetObject.getDate("IssueDate"));
				borrowValues.setDueDate(ojbResultSetObject.getDate("DueDate"));
				
				borrowForm.add(borrowValues);
				
			}
		}catch(Exception e){
		// TODO Auto-generated catch block
		e.printStackTrace();
		}  
	return borrowForm;
	}
	
	
	public static int UpdateBorrowForm (BorrowForm borrowform) {
		conn =   DbConnection.getConnection();
		int updateCount = 0;
		try {
		objPreparedStatementObject = conn.prepareStatement("UPDATE borrowform_table SET AccountID = ?, ISBN = ?, Status = ?, IssueDate = ?, DueDate = ? WHERE borrowformID = ?");  
		
		
		objPreparedStatementObject.setString(1, borrowform.getAccountID());
		objPreparedStatementObject.setString(2, borrowform.getISBN());
		objPreparedStatementObject.setString(3, borrowform.getStatus());
		objPreparedStatementObject.setDate(4, borrowform.getIssueDate());
		objPreparedStatementObject.setDate(5, borrowform.getDueDate());
		objPreparedStatementObject.setInt(6, borrowform.getBorrowFormID());
		
		updateCount = objPreparedStatementObject.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return updateCount;
	}
	
	public static void DeleteBorrowForm(int borrowFormID) {
		conn =   DbConnection.getConnection();
		
		try {
			objPreparedStatementObject = conn.prepareStatement("DELETE FROM borrowform_table WHERE borrowformID = ?");  
			
			objPreparedStatementObject.setInt(1, borrowFormID);
			objPreparedStatementObject.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//Retrieve ISBN and Add to Combobox
	public static void ISBNComboBox(JComboBox combobox) {
		conn =   DbConnection.getConnection();
		try{
			objPreparedStatementObject = conn.prepareStatement("SELECT * FROM book_table");  
			ojbResultSetObject = objPreparedStatementObject.executeQuery();
			while(ojbResultSetObject.next()) {
				String ISBN = ojbResultSetObject.getString("ISBN");
				combobox.addItem(ISBN);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Retrieve Account and Add to Combobox
	public static void AccountIDComboBox(JComboBox combobox) {
		conn =   DbConnection.getConnection();
		try{
			objPreparedStatementObject = conn.prepareStatement("SELECT * FROM account_table");  
			ojbResultSetObject = objPreparedStatementObject.executeQuery();
			while(ojbResultSetObject.next()) {
				String AccountID = ojbResultSetObject.getString("AccountID");
				combobox.addItem(AccountID);
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Retrieve values of a book using its ISBN
	public static Book getBookDetails(String ISBN) {
		Book bookValues = new Book();
		conn =   DbConnection.getConnection();
		try{
			objPreparedStatementObject = conn.prepareStatement("SELECT * FROM book_table WHERE ISBN = '" + ISBN +"'");  
			ojbResultSetObject = objPreparedStatementObject.executeQuery();
			if(ojbResultSetObject.next()) {
				bookValues.setISBN(ojbResultSetObject.getString("ISBN"));
				bookValues.setTitle(ojbResultSetObject.getString("Title"));
				bookValues.setAuthor(ojbResultSetObject.getString("Author"));
				}	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bookValues;
	}
	//Retrieve values of an account using its AccountID
		public static Account getAccountDetails(String AccountID) {
			Account accountValues = new Account();
			conn =   DbConnection.getConnection();
			try{
				objPreparedStatementObject = conn.prepareStatement("SELECT * FROM account_table WHERE AccountID = '" + AccountID +"'");  
				ojbResultSetObject = objPreparedStatementObject.executeQuery();
				if(ojbResultSetObject.next()) {
					accountValues.setAccountId(ojbResultSetObject.getString("AccountID"));
					accountValues.setName(ojbResultSetObject.getString("Name"));
					accountValues.setCourse(ojbResultSetObject.getString("Course"));
					accountValues.setDepartment(ojbResultSetObject.getString("Department"));
					accountValues.setEmail(ojbResultSetObject.getString("Email"));
					}	
			}catch(Exception e) {
				e.printStackTrace();
			}
			return accountValues;
		}
		
		
}
