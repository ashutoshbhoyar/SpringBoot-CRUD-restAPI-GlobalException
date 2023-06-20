package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.userEntity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SpringBootRestApiCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiCrudApplication.class, args);
		
		ObjectMapper om=new ObjectMapper();
		try {
			String writeValueAsString = om.writeValueAsString(new User());
			System.out.println(writeValueAsString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
