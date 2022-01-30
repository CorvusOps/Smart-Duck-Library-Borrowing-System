package values;

public class Account {
	private String AccountId,
					Name,
					Course,
					Department,
					Email;
	
	public void setAccountId(String tAccId) {
		AccountId = tAccId;
	}
	
	public String getAccountId() {
		return AccountId;
	}
	
	public void setName(String tName) {
		Name = tName;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setCourse(String tCourse) {
		Course = tCourse;
	}
	
	public String getCourse() {
		return Course;
	}
	
	public void setDepartment(String tDepartment) {
		Department = tDepartment;
	}
	
	public String getDepartment() {
		return Department;
	}
	
	public void setEmail(String tEmail) {
		Email = tEmail;
	}
	
	public String setEmail() {
		return Email;
	}
}
