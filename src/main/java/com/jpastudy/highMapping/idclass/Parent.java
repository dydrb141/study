package com.jpastudy.highMapping.idclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(PrentId.class)
public class Parent {
	@Id
	@Column(name = "PARENT_ID1")
	private String id1; //ParentId.id1과 연결

	@Id
	@Column(name = "PARENT_ID2")
	private String id2; //ParentId.id2과 연결

	private String name;

}
