package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan
public class DemoApplication {

	private static Logger log = LoggerFactory.getLogger(DemoApplication.class);


	public static void main(String[] args) {
		Environment env = SpringApplication.run(DemoApplication.class, args).getEnvironment();
		log.info("----------------ok-------------------");
	}
}
