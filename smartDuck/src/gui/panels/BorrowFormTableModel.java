package gui.panels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import values.BorrowForm;

public abstract class BorrowFormTableModel extends AbstractTableModel {
	
	protected BorrowFormPanel borrowFormPanel;
	
	private static List<BorrowForm> currentValue;
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return "Borrow Form ID";
			
		case 1:
			return "Account ID";	

		case 2:
			return "ISBN";
			
		case 3:
			return "Status";
			
		case 4:
			return "Issue Date";	

		case 5:
			return "Due Date";
		
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
