package cn.ps;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SolrMain {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SolrMain.class).web(true).run(args);
	}
}
