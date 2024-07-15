package com.coderscampus.assignment9.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coderscampus.assignment9.service.FileService;

@Configuration
public class Assignment9Config {
	@Bean
	public FileService fileService() throws IOException {
		return new FileService("recipes.txt");
	}
}
