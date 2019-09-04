package com.jpastudy.manyMapping.manyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
	@Id
	@Column(name = "MEMBER_ID")
	private String id;

	private String userName;

	@ManyToMany
	@JoinTable(name = "MEMBER_PRODUCT", joinColumns = @JoinColumn(name="MEMBER_ID"), inverseJoinColumns = @JoinColumn(name ="PRODUCT_ID"))
	//@JoinTable.name : 연결 테이블 지정 여기서는 MEMBER_PRODUCT 테이블 선택
	//@JoinTable.joinCoumns : 현재 방향인 회원과 매핑할 조인컬럼 정보를 지정
	//@JoinTabe.inverseJoinColumns : 반대 방향인 상품과 매핑할 조인 컬ㄹ머 정보를 지정
	private List<Product> products = new ArrayList<Product>();



}
