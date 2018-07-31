package com.ps.crud.userinfo.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps.crud.userinfo.entity.Result;
import com.ps.crud.userinfo.entity.User;


@FeignClient(value="userservice",fallback=UserFeignImpl.class)
public interface UserFeign {
	
	@GetMapping("/queryUser")
	public Result queryUser(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit,@RequestParam("username") String username);
	
	@PostMapping("/addUser")
	public Result addUser(@RequestBody User user);
	
	
	@DeleteMapping("/deluser/{dID}")
	public Result deleteUser(String dID);
	
	@DeleteMapping("/delusers/{deleteIds}")
	public Result deleteUsers(@PathVariable("deleteIds") String deleteIds);
	
	
	@PutMapping("/updateuser")
	public Result updateUsers(@RequestBody User user);

}

@Component
class UserFeignImpl implements UserFeign{
	
		@Override
		public Result queryUser(Integer page, Integer limit, String username) {
			Result result=new Result();
			result.setCode(1);
			result.setMas("连接超时");
			return result;
		}
		
		@Override
		public Result addUser(User user) {
			Result result=new Result();
			result.setCode(1);
			result.setMas("连接超时");
			return result;
		}
		
		@Override
		public Result deleteUser(String dID) {
			Result result=new Result();
			result.setCode(1);
			result.setMas("连接超时");
			return result;
		}
		
		@Override
		public Result deleteUsers(String deleteIds) {
			Result result=new Result();
			result.setCode(1);
			result.setMas("连接超时");
			return result;
		}
		
		@Override
		public Result updateUsers(User user) {
			Result result=new Result();
			result.setCode(1);
			result.setMas("连接超时");
			return result;
}
}
