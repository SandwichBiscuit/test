package com.ps.springcloud.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("/a")

	public void getip(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		 System.out.println(ip);
	}
}
