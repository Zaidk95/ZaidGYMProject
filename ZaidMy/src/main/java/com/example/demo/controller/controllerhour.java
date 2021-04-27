package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.models.Time;
import com.example.demo.service.timeservice;
import com.example.demo.service.userService;

public class controllerhour {
	@Autowired
	timeservice hours;
	
	
	@PostMapping(
			  value = "/add/time", consumes = "application/json", produces = "application/json")
	public Time addUser(@RequestBody Time hr)
	{
		Time n = new  Time();
		System.out.println(hr);	
		n.setId(hr.getId());
		n.setDate(hr.getDate());
		n.setStart(hr.getStart());
		n.setFinish(hr.getFinish());
		n.setTotal(hr.getTotal());
		this.hours.addTime(n);
	    return n;
	}
}
