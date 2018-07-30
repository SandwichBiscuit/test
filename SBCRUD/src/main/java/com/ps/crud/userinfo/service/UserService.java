package com.ps.crud.userinfo.service;

import com.ps.crud.userinfo.entity.ResponseEntity;
import com.ps.crud.userinfo.entity.User;

public interface UserService {

	public ResponseEntity queryAllUser(Integer page,Integer limit,String username) ;
	
	public int addUser(User user);

	public int deleteUserById(String dID);

	public int deleteUsersByIds(String dID);

	public int UpdateUsersById(User user);
	}
