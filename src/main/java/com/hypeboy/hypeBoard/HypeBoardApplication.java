package com.hypeboy.hypeBoard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class HypeBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HypeBoardApplication.class, args);
	}

}
