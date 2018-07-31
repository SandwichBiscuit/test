package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entiy.User;
import com.springboot.ps.UserRepoitory;

@RestController
public class UserController {
	@Autowired
	private UserRepoitory up;
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	} 
	
	@RequestMapping("/queryuser")
	public Iterable<User> queryUser(){
	
		return up.findAll();
	}
}
