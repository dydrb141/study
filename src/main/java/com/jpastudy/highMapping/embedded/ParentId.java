package com.jpastudy.highMapping.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ParentId implements Serializable {
	@Column(name = "PARENT_ID1")
	private String id1;
	@Column(name = "PARENT_ID2")
	private String id2;

	//equlas and hashcode 구현
}
