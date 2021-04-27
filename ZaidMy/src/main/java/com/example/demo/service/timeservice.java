package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.DOA.Times;
import com.example.demo.models.Time;

import antlr.collections.List;

@Service
public class timeservice {

	@Autowired
	private Times time;
	
	public Time addTime(Time a) {
		return time.save(a);
	}
	
	public Collection<Time> getAllUsers(){
		return time.findAll();
	}
	
	public void delete(Time a) {
		time.delete(a);
	}
	
	public void removeUser(int x) {
		time.deleteById(x);
	}
	
	public void removAll() {
		time.deleteAll();
	}


}
