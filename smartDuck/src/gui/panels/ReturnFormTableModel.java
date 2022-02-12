package gui.panels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import values.Book;
import values.ReturnForm;

public abstract class ReturnFormTableModel extends AbstractTableModel {
	
	protected ReturnFormPanel returnFormPanel;
	
	private static List<ReturnForm> currentValue;
	
	@Override
	public int getRowCount() {
		if(currentValue == null)
			return 0;
		
		return currentValue.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return "Return Form No.";
			
		case 1:
			return "Borrow Form ID";	

		case 2:
			return "Return Date";
		
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
