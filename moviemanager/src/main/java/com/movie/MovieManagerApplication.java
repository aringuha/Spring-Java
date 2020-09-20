package com.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class MovieManagerApplication {
	
    @RequestMapping("/")
    public String home() {
        return "Hello Movie World";
    }

	public static void main(String[] args) {
		SpringApplication.run(MovieManagerApplication.class, args);
	}

}

