package Execution;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import CRUD.AccountCRUD;
import CRUD.BorrowFormCRUD;
import values.Account;
import values.BorrowForm;

public class BorrowFormEXE {
	
	public static void setValues (BorrowForm borrowForm, String AccountID, 
			String ISBN, String Status, Date IssueDate, Date DueDate) {
		borrowForm.setAccountID(AccountID);
		borrowForm.setISBN(ISBN);
		borrowForm.setStatus(Status);
		borrowForm.setIssueDate(IssueDate);
		borrowForm.setDueDate(DueDate);
	}
	
	public static String exeInsertStatements (BorrowForm borrowForm) {
		int intRes = BorrowFormCRUD.CreateBorrowForm(borrowForm);
		
		if (intRes > 0) {
			return "Saved Changes. Please exit then reload this window.";
		} else {
			return "Changes failed to reflect in the database. Try Again";
		}
	}
	
	public static String exeUpdateStatements (BorrowForm borrowForm) {
		int updateCount = BorrowFormCRUD.UpdateBorrowForm(borrowForm);
		
		if(updateCount > 0) {
			return "Saved changes. Reload to view changes.";
		 } else {
			 return "Changes cannot be saved. Try again.";
		 }
	}

	public static void ReadAccountTable(DefaultTableModel table) {
		ArrayList<BorrowForm> borrowForm = BorrowFormCRUD.ReadBorrowForm();
		
		for (BorrowForm borrowForms : borrowForm) {
			Object objList[] = {
								borrowForms.getBorrowFormID(),
								borrowForms.getAccountID(),
								borrowForms.getISBN(),
								borrowForms.getStatus(),
								borrowForms.getIssueDate(),
								borrowForms.getDueDate()
								};
			table.addRow(objList);
		}
		
	}

}
