package com.example.oBootJpaAPI01.repository;

import java.util.List;

import com.example.oBootJpaAPI01.domain.Member;

public interface MemberRepository {
	List<Member> 	findAll();
	Long			save(Member member); 
	Member			findByMember(Long id);
}
