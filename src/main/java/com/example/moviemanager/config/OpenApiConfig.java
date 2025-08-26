package com.example.moviemanager.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
	@Bean
	public OpenAPI movieApi() {
		return new OpenAPI()
				.info(new Info().title("Movie Management API").version("1.0").description("CRUD API for movies")
						.contact(new Contact().name("Saurabh Sawant").email("saurabhsawant143143@gmail.com")));
	}
}
