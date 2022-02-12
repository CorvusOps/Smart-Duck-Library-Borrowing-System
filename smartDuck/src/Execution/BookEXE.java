package Execution;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import CRUD.BookCRUD;
import values.Book;

public class BookEXE {
	
	public static void setValues (Book book, String ISBN, 
			String Title, String Author) {
		book.setISBN(ISBN);
		book.setTitle(Title);
		book.setAuthor(Author);
	}
	
	public static String exeInsertStatements (Book book) {
		int intRes = BookCRUD.CreateBook(book);
		
		if (intRes > 0) {
			return "Saved Changes. Please exit then reload this window.";
		} else {
			return "Changes failed to reflect in the database. Try Again";
		}
	}

	public static void ReadBookTable(DefaultTableModel table) {
		ArrayList<Book> book = BookCRUD.ReadBook();
		
		for (Book books : book) {
			Object objList[] = {
								books.getISBN(),
								books.getTitle(),
								books.getAuthor()
								};
			table.addRow(objList);
		}
		
	}

}
