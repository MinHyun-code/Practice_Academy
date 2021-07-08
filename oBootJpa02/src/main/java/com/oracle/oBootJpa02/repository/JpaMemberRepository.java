package com.oracle.oBootJpa02.repository;

import javax.persistence.EntityManager;

import com.oracle.oBootJpa02.domain.Member;
import com.oracle.oBootJpa02.domain.Team;

public class JpaMemberRepository implements MemberRepository {

	private final EntityManager em;
	
	public JpaMemberRepository(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public Member save(Member member) {
		// 회원 저장
		Team team = new Team();
		team.setName(member.getTeamname());
		em.persist(team);
		member.setTeam(team); //단방향 연관관계 설정, 참조 저장	
		em.persist(member);
		return member;
	}

}
