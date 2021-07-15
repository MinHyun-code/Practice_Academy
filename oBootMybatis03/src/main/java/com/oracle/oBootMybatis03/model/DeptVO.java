package com.oracle.oBootMybatis03.model;

import lombok.Data;

@Data
public class DeptVO {

	private int deptno;
	private String dname;
	private String loc;
	private int odeptno;
	private String odname;
	private String oloc;
}
