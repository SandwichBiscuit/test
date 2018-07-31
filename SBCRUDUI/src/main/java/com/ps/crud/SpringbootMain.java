package com.ps.crud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 前端web微服务，展示给用户，注册到注册中心 访问后端微服务获取数据渲染视图
 * @author SDJX
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients 
@EnableCircuitBreaker
public class SpringbootMain {

	@LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
   public static void main(String[] args) {
		new SpringApplicationBuilder(SpringbootMain .class).web(true).run(args);
	}
}
