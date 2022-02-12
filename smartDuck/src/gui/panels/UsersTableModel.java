package gui.panels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import values.Account;
import values.Book;

public abstract class UsersTableModel extends AbstractTableModel{
	
	protected UsersPanel usersPanel;
	
	private static List<Account> currentValue;
	
	
	@Override
	public int getRowCount() {
		if(currentValue == null)
			return 0;
		
		return currentValue.size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return "Account ID";
			
		case 1:
			return "Name";	

		case 2:
			return "Course";
			
		case 3:
			return "Department";
			
		case 4:
			return "Email";
		
		default:
			return null;
		
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
