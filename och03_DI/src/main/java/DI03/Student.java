package DI03;

public class Student {
	
	private String name;
	private int age;
	private String gradeNum;
	private String classNum;
	
	public Student(String name, int age, String gradeNum, String classNum) {
		super();
		this.name = name;
		this.age = age;
		this.gradeNum = gradeNum;
		this.classNum = classNum;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGradeNum(String gradeNum) {
		this.gradeNum = gradeNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGradeNum() {
		return gradeNum;
	}

	public String getClassNum() {
		return classNum;
	}
	
	
}
