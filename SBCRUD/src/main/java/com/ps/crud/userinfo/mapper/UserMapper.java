package com.ps.crud.userinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ps.crud.userinfo.entity.User;

@Mapper
public interface UserMapper {
	
	@Select("select * from user where id=#{0}")
	public List<User> queryUserById(@Param(value = "uid") String uid);
	
	@Select("select * from user where username like '%${username}%' limit #{startIdex},#{limit}")
	public List<User> queryAllUser(@Param(value = "startIdex") Integer startIdex,
			@Param(value = "limit") Integer limit,
			@Param(value = "username") String username);
	
	@Select("select count(*) from user")
	public Integer queryUserCount();
	
	@Insert("INSERT INTO user (username, money, password) VALUES (#{username},#{money},#{password})")
	public int addUser(User user);

	@Delete("delete from user where id=#{dID}")
	public int deleteUserById(@Param(value = "dID") String dID);

	@Delete("delete from user where id in($dID})")
	public int deleteUsersByIds(@Param(value = "dID") String dID);

	@Update("update user set username=#{u.username},password=#{u.password},money=#{u.money} where id=#{u.id}")
	public int updateUsersById(@Param(value = "u") User user);
	
	
}
