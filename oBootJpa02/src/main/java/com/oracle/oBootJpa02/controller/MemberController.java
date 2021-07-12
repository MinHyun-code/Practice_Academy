package com.oracle.oBootJpa02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@GetMapping(value="/member")
	public String listMember(Model model) {
		List<Member> memberList = memberService.getListAllMember();
		model.addAttribute("members", memberList);
		return "members/memberList";
	}
	
	@GetMapping(value="/memberModifyForm")
	public String memberModify(Long id, Model model) {
		Optional<Member> member = memberService.findByMember(id);
		Member member2 = new Member();
		member2.setId(member.get().getId());
		member2.setName(member.get().getName());
		member2.setTeam(member.get().getTeam());
		
		model.addAttribute("member", member2);
		return "members/memberModify";
	}
	
	@GetMapping(value="/members/memberUpdate")
	public String memberUpdate(Member member, Model model) {
		memberService.memberUpdate(member);
		return "redirect:/member";
	}
	
	@PostMapping(value="members/search")
	public String search(Member member, Model model) {
		List<Member> memberList = memberService.getListSearchMember(member.getName());
		model.addAttribute("members", memberList);
		return "members/memberList";
	}
}
