package com.oracle.oBootMybatis03.model;

import lombok.Data;

@Data
public class EmpDept {

	//Emp용
	private int empno;	
	private String name;
	private String job;
	private int mgr;
	private String hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	//dept용
	private String dname;
	private String loc;
}
