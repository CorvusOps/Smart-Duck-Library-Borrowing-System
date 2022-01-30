package values;

import java.sql.Date;

public class ReturnForm {
	public int ReturnFormNo, BorrowFormID;
	public Date ReturnDate;
	
	public int getReturnFormNo() {
		return ReturnFormNo;
	}
	
	public void setReturnFormNo(int returnFormNo) {
		ReturnFormNo = returnFormNo;
	}
	
	public int getBorrowFormID() {
		return BorrowFormID;
	}
	
	public void setBorrowFormID(int borrowFormID) {
		BorrowFormID = borrowFormID;
	}
	
	public Date getReturnDate() {
		return ReturnDate;
	}
	
	public void setReturnDate(Date returnDate) {
		ReturnDate = returnDate;
	}
}
