package com.training.pms;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class Project2SpringBootApplication 
{

	public static void main(String[] args) 
	{
		ApplicationContext con = SpringApplication.run(Project2SpringBootApplication.class, args);
		String allBeans[] = con.getBeanDefinitionNames();
		
		Arrays.sort(allBeans);
		for(String temp : allBeans)
			System.out.println(temp);
	}

	@Bean
	public CorsFilter corsFilter() 
	{
		CorsConfiguration config = new CorsConfiguration();
		
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Arrays.asList(		"http://localhost:4200"));
		
		config.setAllowedHeaders(Arrays.asList(		"Origin", "Access-Control-Allow-Origin", "Content-Type",
													"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
													"Access-Control-Request-Method", "Access-Control-Request-Headers"));

		config.setExposedHeaders(Arrays.asList(		"Origin", "Content-Type", "Accept", "Authorization",
													"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));

		config.setAllowedMethods(Arrays.asList(		"GET", "POST", "PUT", "DELETE", "OPTIONS"));

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);

		return new CorsFilter(source);
	}
}
