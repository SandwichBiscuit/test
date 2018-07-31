package com.ps.springcloud.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.springcloud.user.entity.ResponseEntity;
import com.ps.springcloud.user.entity.User;
import com.ps.springcloud.user.mapper.UserMapper;
import com.ps.springcloud.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public ResponseEntity login(User user) {
		ResponseEntity rs=new ResponseEntity();
		if (userMapper.login(user)==null) {
			rs.setCode(1);
			rs.setMas("login 失败");
		}
		
		return rs;
	}

}
