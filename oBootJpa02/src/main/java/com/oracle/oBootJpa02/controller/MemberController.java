package com.oracle.oBootJpa02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oracle.oBootJpa02.domain.Member;
import com.oracle.oBootJpa02.service.MemberService;

@Controller
public class MemberController {

	private final MemberService memberService;
	
	@Autowired
	private MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping(value="/member/new")
	public String createForm() {
		System.out.println("MemberController /member/new start...");
		return "members/createMemberForm";
	}
	
	@PostMapping(value="/member/save")
	public String create(Member member) {
		System.out.println("MemberController create start..");
		System.out.println("member.getName()->" + member.getName());
		memberService.join(member);
		return "redirect:/";
	}
}
