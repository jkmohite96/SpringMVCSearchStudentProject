package com.nareshit.entity;

import javax.persistence.*;

@Entity
@Table(name = "StudentRegi")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	@Column
	private String fullname;
	@Column
	private String address;
	@Column
	private int age;
	@Column
	private String qualification;
	@Column
	private int yop;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getYop() {
		return yop;
	}
	public void setYop(int yop) {
		this.yop = yop;
	}
	
	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", fullname=" + fullname + ", address=" + address + ", age=" + age
				+ ", qualification=" + qualification + ", yop=" + yop + "]";
	}
	
	
	
}
