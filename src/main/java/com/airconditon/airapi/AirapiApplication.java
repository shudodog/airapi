package com.airconditon.airapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class AirapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirapiApplication.class, args);
	}

}
