package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;

import connection.DbConnection;
import values.Account;
import values.Book;
import values.BorrowForm;
import values.ReturnForm;

public class ReturnFormCRUD {
	static Connection conn = null;
	static PreparedStatement objPreparedStatementObject = null;
	static ResultSet objResultSetObject = null;
	
	public static String setFields() {
		String strfields = 
						"(ReturnFormNo,"		+
						"BorrowFormID,"       +
						"ReturnDate)";
		return strfields;
	}
	
	public static  String setValues() {
		String strfields = "VALUES(null,"+
								"?,"  + 
								"?)";
		return strfields;
	}
		
	public static int CreateReturnForm (ReturnForm returnform) {
		conn =   DbConnection.getConnection();
		int intResult = 0;

		try {
			
			objPreparedStatementObject = conn.prepareStatement("INSERT INTO returnform_table " + setFields()
					+ setValues());
			objPreparedStatementObject.setInt(1, returnform.getBorrowFormID());
			objPreparedStatementObject.setDate(2, returnform.getReturnDate());
			
			intResult = objPreparedStatementObject.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return intResult;
	}
	
	
	
	public static ArrayList<ReturnForm> ReadReturnForm() {
		ArrayList<ReturnForm> returnForm = new ArrayList<ReturnForm>();
		try {
			conn =   DbConnection.getConnection();
			objPreparedStatementObject = conn.prepareStatement("SELECT * FROM returnform_table");  
			objResultSetObject = objPreparedStatementObject.executeQuery();
		
			while(objResultSetObject.next()) {
				ReturnForm returnform = new ReturnForm();
				
				returnform.setReturnFormNo(objResultSetObject.getInt("ReturnFormNo"));
				returnform.setBorrowFormID(objResultSetObject.getInt("BorrowFormID"));
				returnform.setReturnDate(objResultSetObject.getDate("ReturnDate"));
				
				
				returnForm.add(returnform);
				
			}
		}catch(Exception e){
		// TODO Auto-generated catch block
		e.printStackTrace();
		}  
		
		
		
	return returnForm;
	}
	
	public static void ReturnComboBox(JComboBox combobox) {
		conn =   DbConnection.getConnection();
		try{
			objPreparedStatementObject = conn.prepareStatement("SELECT * FROM borrowform_table");  
			objResultSetObject = objPreparedStatementObject.executeQuery();
			while(objResultSetObject.next()) {
				String borrowformID = objResultSetObject.getString("borrowformID");
				combobox.addItem(borrowformID);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Book getBookDetails(String ISBN) {
		Book bookValues = new Book();
		conn =   DbConnection.getConnection();
		try{
			objPreparedStatementObject = conn.prepareStatement("SELECT * FROM book_table WHERE ISBN = '" + ISBN +"'");  
			objResultSetObject = objPreparedStatementObject.executeQuery();
			if(objResultSetObject.next()) {
				bookValues.setISBN(objResultSetObject.getString("ISBN"));
				bookValues.setTitle(objResultSetObject.getString("Title"));
				bookValues.setAuthor(objResultSetObject.getString("Author"));
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
				objResultSetObject = objPreparedStatementObject.executeQuery();
				if(objResultSetObject.next()) {
					accountValues.setAccountId(objResultSetObject.getString("AccountID"));
					accountValues.setName(objResultSetObject.getString("Name"));
					accountValues.setCourse(objResultSetObject.getString("Course"));
					accountValues.setDepartment(objResultSetObject.getString("Department"));
					}	
			}catch(Exception e) {
				e.printStackTrace();
			}
			return accountValues;
		}
		public static BorrowForm getBorrowDetails(int borrowID) {
			BorrowForm borrowValues = new BorrowForm();
			conn = DbConnection.getConnection();
			
			try {
				objPreparedStatementObject = conn.prepareStatement("SELECT * FROM borrowform_table WHERE borrowformID = '" + borrowID +"'");  
				objResultSetObject = objPreparedStatementObject.executeQuery();
				if(objResultSetObject.next()) {
					borrowValues.setBorrowFormID(objResultSetObject.getInt("borrowformID"));
					borrowValues.setAccountID(objResultSetObject.getString("AccountID"));
					borrowValues.setISBN(objResultSetObject.getString("ISBN"));
					borrowValues.setIssueDate(objResultSetObject.getDate("IssueDate"));
					borrowValues.setDueDate(objResultSetObject.getDate("DueDate"));
					borrowValues.setStatus(objResultSetObject.getString("Status"));
					}	
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return borrowValues;
		}
		
		public static void setStatusReturned(int BorrowID) {
			conn = DbConnection.getConnection();
			
			try {
				System.out.println("Updating borrow form table");
				objPreparedStatementObject = conn.prepareStatement("UPDATE borrowform_table SET status = 'Returned' WHERE borrowformID = '" + BorrowID +"'");
				objPreparedStatementObject.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
}
