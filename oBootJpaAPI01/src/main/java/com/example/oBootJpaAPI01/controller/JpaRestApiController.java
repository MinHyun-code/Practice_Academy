package com.example.oBootJpaAPI01.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.oBootJpaAPI01.domain.Member;
import com.example.oBootJpaAPI01.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
//Controller + ResponseBody
@RestController
@RequiredArgsConstructor	// @AutoWired 생성자 생성
public class JpaRestApiController {

	private final MemberService memberService;
  //	  * 등록 V1: 요청 값으로 Member 엔티티를 직접 받는다.
  //	  * 문제점
  //	  * - 엔티티에 프레젠테이션 계층을 위한 로직이 추가된다.
  //	  * - 엔티티에 API 검증을 위한 로직이 들어간다. (@NotEmpty 등등)
  //	  * - 실무에서는 회원 엔티티를 위한 API가 다양하게 만들어지는데, 한 엔티티에 각각의 API를 위한 모든 요청 요구사항을 담기는 어렵다.
  //	  * - 엔티티가 변경되면 API 스펙이 변한다.

	
	@GetMapping("/RestApi/v1/members")
	public List<Member> membersV1(){
		return memberService.getListAllMember();
	}
	
	@GetMapping("/RestApi/v2/members")
	public Result membersV2(String kkk) {
		System.out.println("kkk-> " + kkk);
		List<Member> findMembers = memberService.getListAllMember();
		List<MemberDto> collect = findMembers.stream()
									.map(m -> new MemberDto(m.getName()))
									.collect(Collectors.toList());
		return new Result(collect.size(), collect);
		
	}
	@Data
	@AllArgsConstructor
	class Result<T>{
		private int totCnt;
		private T data;
	}
	
	@Data
	@AllArgsConstructor
	class MemberDto {
		private String name;
	}
}

