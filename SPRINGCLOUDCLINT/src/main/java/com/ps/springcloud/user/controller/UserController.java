package com.ps.springcloud.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ps.springcloud.user.entity.ResponseEntity;
import com.ps.springcloud.user.entity.User;
import com.ps.springcloud.user.service.UserService;

@RestController
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody User user){
		try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ResponseEntity rs=userService.login(user);
		return rs;
	}
}
