package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;

import connection.DbConnection;
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
				/*Account accounts = new Account();
				accounts.setAccountID(ojbResultSetObject.getInt("AccountID"));
				accounts.setAccountName(ojbResultSetObject.getString("AccountName"));
				accounts.setAddress(ojbResultSetObject.getString("Address"));
				accounts.setCity(ojbResultSetObject.getString("City"));
				accounts.setProvince(ojbResultSetObject.getString("Province"));
				accounts.setCountry(ojbResultSetObject.getString("Country"));
				accounts.setRole(ojbResultSetObject.getString("Role"));
				accounts.setContactNum(ojbResultSetObject.getString("ContactNum"));
				accounts.setEmail(ojbResultSetObject.getString("Email"));

				
				account.add(accounts);
				*/
			}
		}catch(Exception e){
		// TODO Auto-generated catch block
		e.printStackTrace();
		}  
	return borrowForm;
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
}
