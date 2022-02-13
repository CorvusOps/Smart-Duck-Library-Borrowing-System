package Execution;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import CRUD.AccountCRUD;
import values.Account;

public class AccountEXE {
	
	public static void setValues (Account account, String AccountID, String AccountName, 
			String Course, String Department, String Email) {
		account.setAccountId(AccountID);
		account.setName(AccountName);
		account.setCourse(Course);
		account.setDepartment(Department);
		account.setEmail(Email);
	}
	
	public static String exeInsertStatements (Account account) {
		int intRes = AccountCRUD.CreateAccount(account);
		
		if (intRes > 0) {
			return "Saved Changes. Please exit then reload this window.";
		} else {
			return "Changes failed to reflect in the database. Try Again";
		}
	}

	public static String exeUpdateStatements (Account account) {
		int updateCount = AccountCRUD.UpdateAccount(account);
		
		if(updateCount > 0) {
			return "Saved changes. Reload to view changes.";
		 } else {
			 return "Changes cannot be saved. Try again.";
		 }
	}
	
	public static void ReadAccountTable(DefaultTableModel table) {
		ArrayList<Account> account = AccountCRUD.ReadAccount();
		
		for (Account accounts : account) {
			Object objList[] = {
								accounts.getAccountId(),
								accounts.getName(), 
								accounts.getCourse(),
								accounts.getDepartment(),
								accounts.getEmail()
								};
			table.addRow(objList);
		}
		
	}

}
