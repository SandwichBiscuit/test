package com.ps.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 后端微服务项目 从配置中心读取jdbc四要素 ，并注册到注册中心
 * @author SDJX
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringbootMain {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringbootMain.class).web(true).run(args);
	}
}
