package com.example.demo.models;


import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name="user")
@Table(name="users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class user implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column
	private String username;
	@Column
	private int age;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String gender;
	@Column
	private String date;
	
	
	public String getDate() {
		return date;
	}





	public void setDate(String date) {
		this.date = date;
	}





	public String getGender() {
		return gender;
	}





	public void setGender(String gender) {
		this.gender = gender;
	}





	@Column
	private int special_id;
	
	
	
	

	public int getID() {
		return ID;
	}





	public void setID(int iD) {
		ID = iD;
	}





	public int getSpecial_id() {
		return special_id;
	}





	public void setSpecial_id(int special_id) {
		this.special_id = special_id;
	}





	@Override
	public String toString() {
		return "user [ID=" + ID + ", username=" + username + ", age=" + age + ", email=" + email + ", password="
				+ password + ", special_id=" + special_id + "]";
	}





	public user(String username, int age, String email, String password) {
		super();
		this.username = username;
		this.age = age;
		this.email = email;
		this.password = password;
	}





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}





	public int getAge() {
		return age;
	}





	public void setAge(int age) {
		this.age = age;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	public user() {}
	
	
}
	

	