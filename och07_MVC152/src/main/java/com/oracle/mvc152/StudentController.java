package com.oracle.mvc152;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@RequestMapping("/studentForm")
	public String studentForm() {
		return "createPage";
	}
	
	@RequestMapping("/student/create")
	public String studentCreate(@ModelAttribute("student") Student student, BindingResult result) {
//	 	 BindingResult -> ��ȿ�� ��������� ��Ƶδ� ��ü
		String page = "createDonePage";
		StudentValidate validator = new StudentValidate();
		validator.validate(student, result);
		if(result.hasErrors()) {
			page = "createPage";
		}
		return page;
	}
}
