package cn.ps;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置中心
 * @author SDJX
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer {

		public static void main(String[] args) {
			new SpringApplicationBuilder(ConfigServer.class).web(true).run(args);
		}
}
