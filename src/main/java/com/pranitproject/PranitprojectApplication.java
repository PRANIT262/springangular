 package com.pranitproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class PranitprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PranitprojectApplication.class, args);
	}

}
