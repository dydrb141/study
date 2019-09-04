package com.jpastudy.manyMapping.manyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class OneToMayFault {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
	EntityManager em = emf.createEntityManager();

	public void testSave_OneToMayFault() {
		Member member1 = new Member("member1");
		Member member2 = new Member("member2");

		Team team1 = new Team("team1");
		team1.getMembers().add(member1);
		team1.getMembers().add(member2);

		em.persist(member1); //INSERT-member1
		em.persist(member2); //INSERT-member2
		em.persist(team1); //INSERT-team1, UPDATE-member1.fk, UPDATE-member2.fk
	}
}