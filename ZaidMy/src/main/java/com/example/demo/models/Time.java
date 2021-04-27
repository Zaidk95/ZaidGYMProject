package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="users")
@Table(name="Hours")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Time implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Column(name="userId")
	private int id;
	@Column
	private String date;
	@Column
	private String start;
	@Column
	private String finish;
	@Column
	private double total;
	
	
	
	public Time(int id, String date, String start, String finish, double total) {
		super();
		this.id = id;
		this.date = date;
		this.start = start;
		this.finish = finish;
		this.total = total;
	}



	@Override
	public String toString() {
		return "Time [id=" + id + ", date=" + date + ", start=" + start + ", finish=" + finish + ", total=" + total
				+ "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getStart() {
		return start;
	}



	public void setStart(String start) {
		this.start = start;
	}



	public String getFinish() {
		return finish;
	}



	public void setFinish(String finish) {
		this.finish = finish;
	}



	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Time() {}

}
