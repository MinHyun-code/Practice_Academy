package sdlc02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
	
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX02.xml");
	
		Student student1 = ctx.getBean("student", Student.class);
		System.out.println("student1 �̸� : " + student1.getName());
		System.out.println("student1 ���� : " + student1.getAge());
		
		System.out.println("====================================");
		Student student2 = ctx.getBean("student", Student.class);
		student2.setName("����");
		student2.setAge(100);
		System.out.println("student2 �̸� : " + student2.getName());
		System.out.println("student2 ���� : " + student2.getAge());
		
		System.out.println("====================================");
		System.out.println("student1 �̸� : " + student1.getName());
		System.out.println("student1 ���� : " + student1.getAge());
		
		if(student1.equals(student2)) {
			System.out.println("����");
		} else {
			System.out.println("�ٸ���");
		}

		ctx.close();
	}
}
