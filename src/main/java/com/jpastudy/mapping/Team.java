package com.jpastudy.mapping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team {
	public Team(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Id
	@Column(name = "TEAM_ID")
	private String id;

	private String name;

	//회원이 외래키를 가지고 있으므로 Member.team이 주인
	//주인이 아닌 Team.members에서는 mappedBy="team"을 명시
	@OneToMany(mappedBy = "team")
	private List<Member> members = new ArrayList<>();
}
