package com.jpastudy.mapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.Assert.*;

public class TeamTest {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
	EntityManager em = emf.createEntityManager();

	public void testSave() {
		//팀저장
		Team team = new Team("team1", "팀1");
		em.persist(team);

		//회원1 저장
		Member member = new Member("member1", "회원1");
		member.setTeam(team);

		Member member2 = new Member("member2", "회원2");
		member2.setTeam(team);
	}

	public void updateRelation() {
		Team team2 = new Team("team2", "팀2");
		em.persist(team2);

		Member member = em.find(Member.class, "member1");
		member.setTeam(team2);

	}

	public void deleteRelation() {
		Member member1 = em.find(Member.class, "member1");
		member1.setTeam(null);//연관관계 제거
	}

	public void removeRelationEntity() {
		Team team = new Team("team1", "팀1");

		Member member1 = em.find(Member.class, "member1");
		Member member2 = em.find(Member.class, "member2");

		member1.setTeam(null);
		member2.setTeam(null);
		em.remove(team);
	}

	public void test순수한객체_양방향() {
		Team team1 = new Team("team1", "팀1");
		Member member1 = new Member("member1", "회원1");
		Member member2 = new Member("member2", "회원2");

		member1.setTeam(team1);
		team1.getMembers().add(member1);

		member2.setTeam(team1);
		team1.getMembers().add(member2);

		List<Member> memberList = team1.getMembers();

		System.out.println("member.size" + memberList.size());
	}
	public void ORM_양방향_리팽토링() {
		Team team1 = new Team("team1", "팀1");
		em.persist(team1);

		Member member1 = new Member("member1", "회원1");
		member1.setTeam(team1);
//		team1.getMembers().add(member1);
		em.persist(member1);

		Member member2 = new Member("member2", "회원2");
		member2.setTeam(team1);
		//team1.getMembers().add(member2);
		em.persist(member2);


	}

}