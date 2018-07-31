package com.ps.springcloud.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ps.springcloud.user.entity.User;

@Mapper
public interface UserMapper {


	public User login(User user);
}
