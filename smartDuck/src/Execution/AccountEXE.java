package Execution;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import CRUD.AccountCRUD;
import values.Account;

public class AccountEXE {
	
	public static void setValues (Account account, String AccountName, 
			String Course, String Department, String Email) {
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
