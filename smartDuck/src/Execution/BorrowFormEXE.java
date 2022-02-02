package Execution;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import CRUD.BorrowFormCRUD;
import values.BorrowForm;

public class BorrowFormEXE {
	
	public static void setValues (BorrowForm borrowForm, String AccountID, 
			String ISBN, Date IssueDate, Date DueDate) {
		borrowForm.setAccountID(AccountID);
		borrowForm.setISBN(ISBN);
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

	public static void ReadAccountTable(DefaultTableModel table) {
		ArrayList<BorrowForm> borrowForm = BorrowFormCRUD.ReadBorrowForm();
		
		for (BorrowForm borrowForms : borrowForm) {
			Object objList[] = {
								borrowForms.getBorrowFormID(),
								borrowForms.getAccountID(),
								borrowForms.getISBN(),
								borrowForms.getIssueDate(),
								borrowForms.getDueDate()
								};
			table.addRow(objList);
		}
		
	}

}
