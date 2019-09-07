package com.jpastudy.highMapping.embedded;

import com.jpastudy.highMapping.idclass.PrentId;

import javax.persistence.*;

@Entity
@IdClass(PrentId.class)
public class Parent {
	@EmbeddedId
	private ParentId id;

	private String name;

}
