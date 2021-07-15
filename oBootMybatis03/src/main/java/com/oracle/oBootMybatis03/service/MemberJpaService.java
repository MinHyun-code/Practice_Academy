package com.oracle.oBootMybatis03.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.oracle.oBootMybatis03.dao.MemberJpaRepository;
import com.oracle.oBootMybatis03.domain.Member;

@Transactional
public class MemberJpaService {
	
	private final MemberJpaRepository memberJpaRepository;

	public MemberJpaService(MemberJpaRepository memberJpaRepository) {
		super();
		this.memberJpaRepository = memberJpaRepository;
	}
	
	public Long join(Member member) {
		memberJpaRepository.save(member);
		return member.getId();
	}

	public List<Member> getListAllMember() {
		List<Member> listMember  = memberJpaRepository.findAll();
		return listMember; 
	}
}
