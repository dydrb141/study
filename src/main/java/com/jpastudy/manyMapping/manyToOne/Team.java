package com.jpastudy.manyMapping.manyToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team {
	@Id
	@GeneratedValue
	@Column(name = "TEAM_ID")
	private Long id;

	private String name;

	@OneToMany(mappedBy = "team")
	//@JoinColumn(name ="TEAM_ID") //MEMBER 테이블의 TEAM_ID (FK)
	//일대다 단방향 구조일때는 조인컬럼을 명시해야함.
	//그렇지 않으면 JPA는 연결 테이블을 중간에 두고 연관관계를 관리하는 조인 테이블 전략을 기본으로 사용함.
	private List<Member> members = new ArrayList<>();

	public Team(String name) {
		this.name = name;
	}

	public void addMember(Member member) {
		this.members.add(member);

		if (member.getTeam() !=  this) {
			member.setTeam(this);
		}
	}

}
