package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connection.DbConnection;
import values.Account;


public class AccountCRUD {
	
	static Connection conn = null;
	static PreparedStatement objPreparedStatementObject = null;
	static ResultSet ojbResultSetObject = null;
	
	public static String setFields() {
		String strfields = 
						"(AccountID, "  +
						"Name,"		+
						"Course,"       +
						"Department,"	+
						"Email)";
		return strfields;
	}
	
	public static  String setValues() {
		String strfields = "VALUES(?,"+
								"?,"  + 
								"?,"  +
								"?,"  +
							    "?)";
		return strfields;
	}
		
	public static int CreateAccount (Account account) {
		conn =   DbConnection.getConnection();
		int intResult = 0;

		try {
			
			objPreparedStatementObject = conn.prepareStatement("INSERT INTO account_table " + setFields()
					+ setValues());
			objPreparedStatementObject.setString(1, account.getAccountId());
			objPreparedStatementObject.setString(2, account.getName());
			objPreparedStatementObject.setString(3, account.getCourse());
			objPreparedStatementObject.setString(4, account.getDepartment());
			objPreparedStatementObject.setString(5, account.getEmail());
			
			intResult = objPreparedStatementObject.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return intResult;
	}
	
	public static ArrayList<Account> ReadAccount() {
		ArrayList<Account> account = new ArrayList<Account>();
		try {
			conn =   DbConnection.getConnection();
			objPreparedStatementObject = conn.prepareStatement("SELECT * FROM account_table");  
			ojbResultSetObject = objPreparedStatementObject.executeQuery();
		
			while(ojbResultSetObject.next()) {
				Account accounts = new Account();
				accounts.setAccountId(ojbResultSetObject.getString("AccountID"));
				accounts.setName(ojbResultSetObject.getString("Name"));
				accounts.setCourse(ojbResultSetObject.getString("Course"));
				accounts.setDepartment(ojbResultSetObject.getString("Department"));
				accounts.setEmail(ojbResultSetObject.getString("Email"));
				
				account.add(accounts);

			}
		}catch(Exception e){
		// TODO Auto-generated catch block
		e.printStackTrace();
		}  
	return account;
	}
	
	public static void UpdateAccount (Account accountValues) {
		conn =   DbConnection.getConnection();
		try {
			
		objPreparedStatementObject = conn.prepareStatement("UPDATE account_table SET Name = ?, Course = ?, "
														+ "Department = ?, Email = ? WHERE AccountID = ?");  
		
		objPreparedStatementObject.setString(5, accountValues.getAccountId());
		objPreparedStatementObject.setString(1, accountValues.getName());
		objPreparedStatementObject.setString(2, accountValues.getCourse());
		objPreparedStatementObject.setString(3, accountValues.getDepartment());
		objPreparedStatementObject.setString(4, accountValues.getEmail());
		
		objPreparedStatementObject.execute();
		
		JOptionPane.showMessageDialog(null, "Saved changes.");
		
		}catch(Exception e) {
			e.printStackTrace();
			
			JOptionPane.showMessageDialog(null, "Changes cannot be saved. Try again.");
		}
	}
	public static void DeleteAccount(String AccountID) {
		conn =   DbConnection.getConnection();
		
		try {
			objPreparedStatementObject = conn.prepareStatement("DELETE FROM account_table WHERE AccountID = ?");  
			
			objPreparedStatementObject.setString(1, AccountID);
			objPreparedStatementObject.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
