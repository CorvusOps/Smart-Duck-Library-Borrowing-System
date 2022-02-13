package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.DbConnection;
import values.Book;

public class BookCRUD {
	static Connection conn = null;
	static PreparedStatement objPreparedStatementObject = null;
	static ResultSet ojbResultSetObject = null;
	
	public static String setFields() {
		String strfields = 
						"(ISBN,"	+
						"Title,"       +
						"Author)";
		return strfields;
	}
	
	public static  String setValues() {
		String strfields = "VALUES(?,"+
								"?,"  + 
								"?)";
		return strfields;
	}
		
	public static int CreateBook (Book book) {
		conn =   DbConnection.getConnection();
		int intResult = 0;

		try {
			
			objPreparedStatementObject = conn.prepareStatement("INSERT INTO book_table " + setFields()
					+ setValues());
			objPreparedStatementObject.setString(1, book.getISBN());
			objPreparedStatementObject.setString(2, book.getTitle());
			objPreparedStatementObject.setString(3, book.getAuthor());
			
			intResult = objPreparedStatementObject.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return intResult;
	}
	
	public static ArrayList<Book> ReadBook() {
		ArrayList<Book> book = new ArrayList<Book>();
		try {
			conn =   DbConnection.getConnection();
			objPreparedStatementObject = conn.prepareStatement("SELECT * FROM book_table");  
			ojbResultSetObject = objPreparedStatementObject.executeQuery();
		
			while(ojbResultSetObject.next()) {
				Book books = new Book();
				books.setISBN(ojbResultSetObject.getString("ISBN"));
				books.setTitle(ojbResultSetObject.getString("Title"));
				books.setAuthor(ojbResultSetObject.getString("Author"));
				
				book.add(books);
			}
		}catch(Exception e){
		// TODO Auto-generated catch block
		e.printStackTrace();
		}  
	return book;
	}
	
	public static int UpdateBook (Book bookValues) {
		conn =   DbConnection.getConnection();
		int updateCount = 0;
		try {
			
		objPreparedStatementObject = conn.prepareStatement("UPDATE book_table SET Title = ?, Author = ? WHERE ISBN = ?");  
		
		objPreparedStatementObject.setString(3, bookValues.getISBN());
		objPreparedStatementObject.setString(1, bookValues.getTitle());
		objPreparedStatementObject.setString(2, bookValues.getAuthor());
		
		updateCount = objPreparedStatementObject.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return updateCount;
	}
	
	public static void DeleteBook(String ISBN) {
		conn =   DbConnection.getConnection();
		
		try {
			objPreparedStatementObject = conn.prepareStatement("DELETE FROM book_table WHERE ISBN = ?");  
			
			objPreparedStatementObject.setString(1, ISBN);
			objPreparedStatementObject.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
