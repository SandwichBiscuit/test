package com.ps.springcloud.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ps.springcloud.user.entity.Result;
import com.ps.springcloud.user.entity.User;

@RestController
public class UserConller {
	
	@Autowired 
	RestTemplate rt;
	
	/*
	 * 微服务调用路径
	 * 获取注册中心的配置的微服务
	 * */
	String url="http://USERSERVICE/login";

	@PostMapping("/login")
	@HystrixCommand(fallbackMethod="rlogin")
	public Result name(User user) {
		ResponseEntity<Result> res= rt.postForEntity(url, user,Result.class);
		return res.getBody();
	}
	
	public Result rlogin(User user) {
		Result r=new Result();
		r.setCode(1);
		r.setMas("登录失败 远程不通");
		return r;
	}
}
