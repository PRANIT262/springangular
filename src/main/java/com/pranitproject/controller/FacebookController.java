package com.pranitproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pranitproject.Exception.UserDefineException;
import com.pranitproject.entity.FacebookUser;
import com.pranitproject.service.FacebookServiceInterface;

@RestController
@CrossOrigin(origins = "*")
public class FacebookController { 
	
	@Autowired // it will inform to BeanFactory to create object of that class which is using given interface and inject that object using setter method
				// this object will be singleton by default
	private FacebookServiceInterface fs; 
 
	@PostMapping("/register")
	public @ResponseBody FacebookUser createProfile(@RequestBody FacebookUser fb) {// here we are taking user data from UI and storing inside entity class via @RequestBody)
		return fs.createProfile(fb); 
	}

	@DeleteMapping("/delete/{email}")
	public String deleteProfile(@PathVariable("email") String em) {
		
		fs.deleteProfile(em);
		
		return "profile deleted "+em;
	}
	
	@GetMapping("/login/{id}/{pass}")
	public FacebookUser loginUser(@PathVariable("id") String email,@PathVariable("pass") String password) {
		FacebookUser f=fs.loginUserService(email,password);
		return f;
	}
	
	
	@PutMapping("/edituser/{em}")
	public String editProfile(@PathVariable("em") String email,@RequestBody FacebookUser fb) {
		fb.setEmail(email);
		fs.editProfile(fb);
		return "profile edited";
	}

	@GetMapping("/view/{em}")
	public FacebookUser viewProfile(@PathVariable("em") String email) throws UserDefineException {
		FacebookUser ff=fs.viewProfile(email);
		return ff;
	}
	@GetMapping("/viewall")
	public List<FacebookUser> viewAllProfile() throws UserDefineException {
		List<FacebookUser> ff=(List<FacebookUser>) fs.getAll();
		return ff;
	}
}
