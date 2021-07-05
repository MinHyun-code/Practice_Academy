package sdlc01;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean {

	private String name;
	private int age;
	
	public void destroy() throws Exception {
		System.out.println("Student�� destroy() --> �Ҹ��ڰ� �Ҹ�Ǳ� ��...");

	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Student afterPropertiesSet --> ������ �������� ");

	}

	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
}
