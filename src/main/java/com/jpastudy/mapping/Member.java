package com.jpastudy.mapping;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member {

	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Id
	@GeneratedValue
	@Column(name = "MEMBER_ID")
	private String id;

	private String name;
	private String city;
	private String street;
	private String zipcode;
	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	public void setTeam(Team team) {
		if (this.team != null) { //기존 팀이 있으면 기존 팀과 회원의 연관관계를 삭제해야함.
			this.team.getMembers().remove(this);
		}

		this.team = team;
		team.getMembers().add(this);
	}}
