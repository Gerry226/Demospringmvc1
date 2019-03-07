package org.fkit.controller;

public class User2 {

	private String name;
	private Integer age;
	private ContactInfo info;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	public ContactInfo getInfo() {
		return info;
	}

	public void setInfo(ContactInfo info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "User2 [name=" + name + ", age=" + age + ", info=" + info + "]";
	}

	

	
	
}
