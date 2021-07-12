package com.oracle.oBootMybatis03.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.oBootMybatis03.model.Emp;

@Repository
public class EmpDaompl implements EmpDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public int total() {
		int tot = 0;
		System.out.println("EmpDaoImpl Start total...");
		try {
				//session -> mapper ID total 호출
			tot = session.selectOne("total");
		} catch (Exception e) {
			System.out.println("EmpDaoImpl total Exception -> " + e.getMessage());
		}
		return tot;
	}

	@Override
	public List<Emp> listEmp(Emp emp) {
		List<Emp> empList = null;
		try {
			empList = session.selectList("mhEmpListAll", emp); // Naming Rule
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

}
