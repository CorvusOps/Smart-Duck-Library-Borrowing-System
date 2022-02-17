package Execution;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import CRUD.BorrowFormCRUD;
import CRUD.ReturnFormCRUD;
import values.BorrowForm;
import values.ReturnForm;

public class ReturnFormEXE {
	
	public static void setValues (ReturnForm returnForm, int BorrowFormID, 
			Date ReturnDate) {
		returnForm.setBorrowFormID(BorrowFormID);
		returnForm.setReturnDate(ReturnDate);
	}
	
	public static String exeInsertStatements (ReturnForm returnForm) {
		int intRes = ReturnFormCRUD.CreateReturnForm(returnForm);
		
		if (intRes > 0) {
			return "Saved Changes. Please exit then reload this window.";
		} else {
			return "Changes failed to reflect in the database. Try Again";
		}
	}
	
	public static String exeUpdateStatements (ReturnForm returnForm) {
		int updateCount = ReturnFormCRUD.UpdateReturnForm(returnForm);
		
		if(updateCount > 0) {
			return "Saved changes. Reload to view changes.";
		 } else {
			 return "Changes cannot be saved. Try again.";
		 }
	}

	public static void ReadAccountTable(DefaultTableModel table) {
		ArrayList<ReturnForm> returnForm = ReturnFormCRUD.ReadReturnForm();
		
		for (ReturnForm returnForms : returnForm) {
			Object objList[] = {
								returnForms.getReturnFormNo(),
								returnForms.getBorrowFormID(),
								returnForms.getReturnDate()
								};
			table.addRow(objList);
		}
		
	}

}
