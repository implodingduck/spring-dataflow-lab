package com.implodingduck.batch.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InitdbApplication {

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(InitdbApplication.class, args)));
	}

}
