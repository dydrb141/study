package com.jpastudy.manyMapping.manyToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member {
	public Member(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	@Column(name = "MEMBER_ID")
	private String id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	//연관관계 주인
	//일대다 다대일 연관관계는 항상 다에 외래키가 있음
	private Team team;

	public void setTeam(Team team) {
		this.team = team;

		if (!team.getMembers().contains(this)) {
			team.getMembers().add(this);
		}
	}
}
