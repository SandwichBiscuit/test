package com.ps.crud.userinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ps.crud.userinfo.entity.ResponseEntity;
import com.ps.crud.userinfo.entity.User;
import com.ps.crud.userinfo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userServuce;
	
	@GetMapping("/queryUser")
	public ResponseEntity queryUser(Integer page,Integer limit,String username){
		return userServuce.queryAllUser(page, limit, username);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity addUser(@RequestBody User user){
		ResponseEntity res=new ResponseEntity();
		if (userServuce.addUser(user)!=0) {
			res.setCode(1);
		}
		
		return res;
	}
	
	@DeleteMapping("/deluser/{dID}")
	public ResponseEntity deleteUser(@PathVariable String dID) {
		ResponseEntity r = new ResponseEntity();
		try {
			userServuce.deleteUserById(dID);
			r.setCode(1);
		} catch (Exception e) {
			r.setMas(e.getMessage());
		}
		return r;
	}
	
	@DeleteMapping("/delusers/{deleteIds}")
	public ResponseEntity deleteUsers(@PathVariable String deleteIds) {
	
		ResponseEntity r = new ResponseEntity();
		try {
			userServuce.deleteUsersByIds(deleteIds);
			r.setCode(1);
		} catch (Exception e) {
			e.printStackTrace();
			r.setMas(e.getMessage());
		}
		return r;
	}
	
	@PutMapping("/updateuser")
	public ResponseEntity updateUsers(@RequestBody User user) {
		ResponseEntity r = new ResponseEntity();
		try {
			userServuce.UpdateUsersById(user);
			r.setCode(1);
		} catch (Exception e) {
			r.setMas(e.getMessage());
		}
		return r;
	}
}
