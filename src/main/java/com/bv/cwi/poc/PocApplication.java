package com.bv.cwi.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocApplication {

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(PocApplication.class, args)));
	}

}
