package person;

public class FacultyMember extends Person {
	protected String department;

	public FacultyMember(String name, String department) {
		super(name);
		this.department = department;
	}

	public String toString() {
		return name + ", " + department;
	}
} 

