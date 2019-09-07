package com.jpastudy.highMapping.oneToOneTable;

import javax.persistence.*;

@Entity
public class Parent {
	@Id
	@GeneratedValue
	@Column(name = "PARENT_ID")
	private Long id;

	private String name;

	@OneToOne
	@JoinTable(name = "PARENT_CHILD", joinColumns = @JoinColumn(name = "PARENT_ID"), inverseJoinColumns =  @JoinColumn(name = "CHILD_ID"))
	//name : 매핑할 조인 테이블 이름
	//joinColumns : 현재 엔티티를 참조하는 외래키
	//inverseJoinColumns : 반대방향 엔티티를 참조하는 외래키
	//OneToMany : 일대다 사용시
	//ManyToMany : 다대다 사용시
	private Child child;

	//private List<Child> child = new ArrayLIst<Child>(); 는 일대다, 다대다 사용시



}
