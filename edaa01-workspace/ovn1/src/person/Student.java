package person;
public class Student extends Person {
	protected String program;
	protected int credits;

	public Student(String name, String program) {
		super(name);
		this.program = program;
		credits = 0;
	}

	public String toString() {
		return name + ", " + program;
	}
}
