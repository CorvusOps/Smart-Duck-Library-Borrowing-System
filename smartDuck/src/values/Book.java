package values;

public class Book {
	private String ISBN, 
				Title,
				Author;

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String tISBN) {
		ISBN = tISBN;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String tAuthor) {
		Author = tAuthor;
	}
}
