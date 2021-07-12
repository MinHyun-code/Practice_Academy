package com.example.oBootJpaAPI01.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.oBootJpaAPI01.domain.Member;
import com.example.oBootJpaAPI01.repository.MemberRepository;

@Service
@Transactional
public class MemberService {
	private final MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	// 전체회원 조회
	public List<Member> getListAllMember(){
		List<Member> listMember = memberRepository.findAll();
		return listMember;
	}
	
	
}
