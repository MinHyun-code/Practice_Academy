package DI07;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import DI08.Student;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public Student student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("�˹���");
		hobbys.add("�ǾƳ�");
		Student student = new Student("�ȿ���", 24, hobbys);
		student.setHeight(160);
		student.setWeight(50);
		
		return student;
	}
	@Bean
	public Student student2() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("�Ⱦ�");
		hobbys.add("�ٽȾ�");
		Student student = new Student("����", 24, hobbys);
		student.setHeight(160);
		student.setWeight(50);
		
		return student;
	}
}
