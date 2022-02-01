package values;

import java.sql.Date;

public class BorrowForm {
	private int BorrowFormID;
	private String AccountID, ISBN, Status;
	private Date IssueDate, DueDate;
	public int getBorrowFormID() {
		return BorrowFormID;
	}
	public void setBorrowFormID(int borrowFormID) {
		BorrowFormID = borrowFormID;
	}
	public String getAccountID() {
		return AccountID;
	}
	public void setAccountID(String accountID) {
		AccountID = accountID;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Date getIssueDate() {
		return IssueDate;
	}
	public void setIssueDate(Date issueDate) {
		IssueDate = issueDate;
	}
	public Date getDueDate() {
		return DueDate;
	}
	public void setDueDate(Date dueDate) {
		DueDate = dueDate;
	}
}
