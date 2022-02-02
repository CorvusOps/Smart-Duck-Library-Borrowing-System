package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.DbConnection;
import values.ReturnForm;

public class ReturnFormCRUD {
	static Connection conn = null;
	static PreparedStatement objPreparedStatementObject = null;
	static ResultSet ojbResultSetObject = null;
	
	public static String setFields() {
		String strfields = 
						"(ReturnFormNo,"		+
						"BorrowFormID,"       +
						"ReturnDate)";
		return strfields;
	}
	
	public static  String setValues() {
		String strfields = "VALUES(?,"+
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
			/*objPreparedStatementObject.setString(1, account.getAccountName());
			objPreparedStatementObject.setString(2, account.getAddress());
			objPreparedStatementObject.setString(3, account.getCity());
			objPreparedStatementObject.setString(4, account.getProvince());
			objPreparedStatementObject.setString(5, account.getCountry());
			objPreparedStatementObject.setString(6, account.getRole());
			objPreparedStatementObject.setString(7, account.getContactNum());
			objPreparedStatementObject.setString(8, account.getEmail());
			intResult = objPreparedStatementObject.executeUpdate();
			*/
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
	return returnForm;
	}
}
