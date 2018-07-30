package com.ps.crud.userinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.crud.userinfo.entity.ResponseEntity;
import com.ps.crud.userinfo.entity.User;
import com.ps.crud.userinfo.mapper.UserMapper;
import com.ps.crud.userinfo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	
	@Override
	public ResponseEntity queryAllUser(Integer page, Integer limit,String username) {

		Integer startIdex=(page-1)*limit;
		List<User> queryAllUser=userMapper.queryAllUser(startIdex, limit, username);
		ResponseEntity re=new ResponseEntity();
		re.setData(queryAllUser);
		re.setCount(userMapper.queryUserCount());
		
		return re;
	}


	@Override
	public int addUser(User user) {
		return userMapper.addUser(user);
	}


	@Override
	public int deleteUserById(String dID) {
		return userMapper.deleteUserById(dID);
	}


	@Override
	public int deleteUsersByIds(String dID) {
		return userMapper.deleteUsersByIds(dID);
	}


	@Override
	public int UpdateUsersById(User user) {
		return userMapper.updateUsersById(user);
	}

}
