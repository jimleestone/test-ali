package com.izayoi.account;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class AccountApplication {

	@Value("${custom.hello}")
	private String hello;

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@RequestMapping
	public String hello() {
		return hello;
	}
}
