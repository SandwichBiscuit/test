package com.ps.springcloud.user.service;

import com.ps.springcloud.user.entity.ResponseEntity;
import com.ps.springcloud.user.entity.User;

public interface UserService {

	public ResponseEntity login(User user);
}
