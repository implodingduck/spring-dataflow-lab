package com.implodingduck.batch.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SumApplication {

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(SumApplication.class, args)));
	}

}
