package cn.ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * zuul路由，将ui项目进行负载均衡+
 * @author SDJX
 *
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulProxy {

	   public static void main(String[] args) {
			SpringApplication.run(ZuulProxy.class,args);
		}
}
