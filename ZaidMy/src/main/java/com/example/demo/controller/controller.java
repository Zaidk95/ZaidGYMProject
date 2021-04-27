package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.time.Month;
import com.example.demo.models.user;
import com.example.demo.service.userService;


@RestController
public class controller {
	@Autowired
	userService usr;
	
	@PostMapping(
			  value = "/add", consumes = "application/json", produces = "application/json")
	public user addUser(@RequestBody user usr)
	{
		user n = new  user();
		System.out.println(usr);	
		n.setUsername(usr.getUsername());
		n.setAge(usr.getAge());
		n.setEmail(usr.getEmail());
		n.setPassword(usr.getPassword());
		n.setGender(usr.getGender());
	    LocalDate currentdate = LocalDate.now();
		n.setDate(currentdate+"");
		n.setSpecial_id(fill());
		this.usr.adduser(n);
	    return n;
	}
	
	private int RandId() {
		String h = "123456789123456789123456789";
		String a = "";
		for(int i=0; i < 4; i++) {
			int x = (int) (Math.random()*h.length()+0);
			a = a + h.charAt(x)+"";
		}
		return Integer.parseInt(a);
	}

	public int fill() {
		int x = RandId();
		if(exist(x) == true) {
			while(exist(x) == true) {
				x = RandId();
			}
		}
		
		return x;
	}
	public boolean exist(int id) {
		return usr.foundspecial(id);
	}
	
	@GetMapping("/admin/getAll")
	public Collection<user> getAllUsers()
	{
		return usr.getAllUsers(); 
	}
	
	@GetMapping("/getAll")
	public String get()
	{
		return usr.getAllUsers()+""; 
	}
	
	@DeleteMapping("admin/deleteUser/{id}")
	public void removeById(@RequestParam(name="id") int id)
	{
		usr.removeUser(id);
	}
	
	@DeleteMapping("admin/deleteall")
	public void Dall()
	{
		usr.removAll();
	}
	
	@RequestMapping("/admin/ch/{email}")
	@ResponseBody
	public boolean isValid(@RequestParam(name="email") String email) 
    { 
		String [] p = email.split("@");
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 

	@RequestMapping("/admin/va/{email}")
	@ResponseBody
	public boolean IsFound(@RequestParam(name="email") String x) {
		return usr.foundem(x);
	}
	
	@RequestMapping("/admin/na/{name}")
	@ResponseBody
	public boolean IsFoundna(@RequestParam(name="name") String x) {
		return usr.foundname(x);
	}
	
	@RequestMapping("/admin/id/{id}")
	@ResponseBody
	public boolean IsFoundnid(@RequestParam(name="id") int x) {
		return usr.foundSpecial(x);
	}
	
	@RequestMapping("/send/{email}/{password}")
	@ResponseBody
	public boolean IsFound(@PathVariable(name="email") String x, @PathVariable(name="password") String y) {
		return (usr.Login1(x,y) || usr.Login2(x,y));
	}
	
	@RequestMapping("/getidi/{em}")
	@ResponseBody
	public int getbyid(@RequestParam(name="em") String x) {
		return usr.getidbyid(x);
	}
	
	@RequestMapping("/getide/{em}")
	@ResponseBody
	public int getbyem(@RequestParam(name="em") String x) {
		return usr.getidbyem(x);
	}

	@RequestMapping("/admin/info/{id}")
	@ResponseBody
	public String find(@RequestParam(name="id") int a) {
		user n = usr.findById(a);	
		return n.getUsername()+"--"+n.getSpecial_id()+"--"+n.getAge()+"--"+n.getEmail()+"--"+n.getPassword()+"--"+n.getGender()+"--"+n.getDate();
	}	
	@RequestMapping("/admin/gn/{id}")
	@ResponseBody
	public String findname(@RequestParam(name="id") int a) {
		user n = usr.findById(a);	
		return n.getUsername()+" # "+n.getSpecial_id();
	}	
	@PutMapping("/chpass/{id}/{pass}")
	@ResponseBody
	public user getbyb(@PathVariable(name="id") int x, @PathVariable(name="pass") String y) {
		user a = usr.findById(x);
		a.setPassword(y);
		usr.adduser(a);
		return a;
	}
	
	@RequestMapping("/pass/{ps}")
	@ResponseBody
	public boolean isValidpass(@RequestParam(name="ps") String password) 
    { 
		 if (password == null) return false;
		    if (password.length() < 7 || password.length() > 12) return false;
		    boolean containsUpperCase = false;
		    boolean containsLowerCase = false;
		    boolean containsDigit = false;
		    for(char ch: password.toCharArray()){
		        if(Character.isUpperCase(ch)) containsUpperCase = true;
		        if(Character.isLowerCase(ch)) containsLowerCase = true;
		        if(Character.isDigit(ch)) containsDigit = true;
		    }
		    return containsUpperCase && containsLowerCase && containsDigit;
    }
}
