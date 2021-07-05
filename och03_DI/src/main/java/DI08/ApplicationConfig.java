package DI08;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public Student student1() {
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("����");
		hobbys.add("��������");
		
		Student student = new Student("��������", 55, hobbys);
		student.setHeight(170);
		student.setWeight(68);
		
		return student;
	}
}
