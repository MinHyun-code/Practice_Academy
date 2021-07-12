package com.example.oBootJpaAPI01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.oBootJpaAPI01.domain.Member;
import com.example.oBootJpaAPI01.repository.MemberRepository;

@SpringBootTest
class OBootJpaApi01ApplicationTests {

	@Autowired
	MemberRepository memberRepository;
	
	@Test
	@Transactional // 밑에 코드가 되면 전부 실행 o, 안되면 전부 실행 x
	@Rollback(false)	
	 public void testMember() {
		Member member = new Member();
		member.setName("memberTestA");
		Long saveId = memberRepository.save(member);
		Member findMember = memberRepository.findByMember(saveId);
		Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
		Assertions.assertThat(findMember.getId()).isEqualTo(10);
		
	}

}
