package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.DOA.RepoCourse;
import com.example.demo.models.user;

import antlr.collections.List;

@Service
public class userService {

	@Autowired
	private RepoCourse repos;
	
	public user adduser(user a) {
		return repos.save(a);
	}
	
	public Collection<user> getAllUsers(){
		return repos.findAll();
	}
	
	public user findById(int id) {
		 for(int i=0 ; i < repos.findAll().size()+1; i++) {
			 if(repos.findAll().get(i).getID() == id) {
				 return repos.findAll().get(i);
			 }
		 }
		 return null;
	}
	
	
	public boolean foundspecial(int id) {
		for(int i=0 ; i < repos.findAll().size(); i++) {
			 if(repos.findAll().get(i).getSpecial_id() == id) {
				  return true;
			 }
		 }
		return false;
	}
	

	public boolean foundem(String id) {
		for(int i=0 ; i < repos.findAll().size(); i++) {
			 if(repos.findAll().get(i).getEmail().equals(id)) {
				  return true;
			 }
		 }
		return false;
	}
	
	public boolean foundname(String id) {
		for(int i=0 ; i < repos.findAll().size(); i++) {
			 if(repos.findAll().get(i).getUsername().equals(id)) {
				  return true;
			 }
		 }
		return false;
	}
	
	public boolean foundSpecial(int id) {
		for(int i=0 ; i < repos.findAll().size(); i++) {
			 if(repos.findAll().get(i).getSpecial_id() == id) {
				  return true;
			 }
		 }
		return false;
	}
	public boolean Login1(String a, String b) {
		for(int i=0 ; i < repos.findAll().size(); i++) {
			 if(repos.findAll().get(i).getEmail().equals(a)) {
				  if(repos.findAll().get(i).getPassword().equals(b)) {
					  return true;
				  }
			 }
		 }
		return false;
	}
	
	public boolean Login2(String a, String b) {
		int x = Integer. parseInt(a);
		for(int i=0 ; i < repos.findAll().size(); i++) {
			 if(repos.findAll().get(i).getSpecial_id() == x) {
				  if(repos.findAll().get(i).getPassword().equals(b)) {
					  return true;
				  }
			 }
		 }
		return false;
	}
	
	public int getidbyid(String a) {
		int x = Integer. parseInt(a);
		for(int i=0 ; i < repos.findAll().size(); i++) {
			 if(repos.findAll().get(i).getSpecial_id() == x) {
				  return repos.findAll().get(i).getID();
			 }
		 }
		return -1;
	}
	
	public int getidbyem(String a) {
		for(int i=0 ; i < repos.findAll().size(); i++) {
			 if(repos.findAll().get(i).getEmail().equals(a)) {
				  return repos.findAll().get(i).getID();
			 }
		 }
		return -1;
	}
	public void delete(user a) {
		repos.delete(a);
	}
	
	public void removeUser(int x) {
		repos.deleteById(x);
	}
	
	public void removAll() {
		repos.deleteAll();
	}
	
	public user updateUsr(user x) {
		return repos.save(x);
	}

}
