package com.implodingduck.batch.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(ProductApplication.class, args)));
	}

}
