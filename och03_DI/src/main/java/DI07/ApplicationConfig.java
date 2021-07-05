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
		hobbys.add("ÆË¹ÂÁ÷");
		hobbys.add("ÇÇ¾Æ³ë");
		Student student = new Student("¾È¿¹Àº", 24, hobbys);
		student.setHeight(160);
		student.setWeight(50);
		
		return student;
	}
	@Bean
	public Student student2() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("½È¾î");
		hobbys.add("´Ù½È¾î");
		Student student = new Student("¸ô¶ó", 24, hobbys);
		student.setHeight(160);
		student.setWeight(50);
		
		return student;
	}
}
