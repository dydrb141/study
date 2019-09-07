package com.jpastudy.highMapping.oneToOneTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Child {
	@Id
	@GeneratedValue
	@Column(name = "CHILD_ID")
	private Long id;

	private String name;

	//OneToOne(mappedBy="child") 양방향 매핑
	private Parent parent;

}
