package com.jeecourse.account.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "account")
public class Account extends IdEntity
{

	@Column(name = "NAME", unique = true)
	private String name;
    
    @Column(name = "AGE")
    private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
