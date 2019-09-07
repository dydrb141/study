package com.jpastudy.highMapping;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Movie extends Item {
	private String director;
	private String actor;
	
}
