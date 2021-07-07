package com.oracle.oBootDBConnect.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.oracle.oBootDBConnect.domain.Member;

public class JdbcTemplateMemberRepository implements MemberRepository {

	private final JdbcTemplate jdbcTemplate;
	public JdbcTemplateMemberRepository(DataSource dataSource) {
		// TODO Auto-generated constructor stub
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public Member save(Member member) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		jdbcInsert.withTableName("member");
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", member.getId());
		parameters.put("name", member.getName());
		jdbcInsert.execute(parameters);
		return member;	
	}
	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from member order by id asc", memberRowMapper());
	}
	private RowMapper<Member> memberRowMapper() {
		// 확장 for문과 비슷
		return (rs, rowNum) -> {
			Member member = new Member();
			member.setId(rs.getLong("id"));
			member.setName(rs.getString("name"));
			return member;
		};
	}

}
