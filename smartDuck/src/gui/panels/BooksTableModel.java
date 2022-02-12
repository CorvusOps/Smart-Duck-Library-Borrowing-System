package gui.panels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import values.Book;

public abstract class BooksTableModel extends AbstractTableModel{
	
	protected BooksPanel booksPanel;
	
	private static List<Book> currentValue;
	@Override
	public int getRowCount() {
		if(currentValue == null)
			return 0;
		
		return currentValue.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return "ISBN";
			
		case 1:
			return "Title";	

		case 2:
			return "Author";
		
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
