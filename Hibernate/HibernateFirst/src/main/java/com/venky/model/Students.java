package com.venky.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name= "StudentTable")
public class Students {
	
	@Id
	private Integer Id;
	private String name;
	private String city;
	
	public Students() {
		System.out.println("Working.........");
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Students [Id=" + Id + ", name=" + name + ", city=" + city + "]";
	}

}
