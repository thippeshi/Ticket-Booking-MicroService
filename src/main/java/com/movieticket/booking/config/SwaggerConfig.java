package com.movieticket.booking.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by kartik on 12/11/16.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
						.basePackage("com.movieticket.booking.controller"))
				.paths(regex("/api/.*")).build().pathMapping("/").apiInfo(metadata());
	}

	@Bean
	public UiConfiguration uiConfig() {
		return UiConfiguration.DEFAULT;
	}

	private ApiInfo metadata() {
		String description = "The Movie Ticket Booking services is to book the tickes online. "
				+ "Movie Ticket Booking services is built as a REST style service using the Spring boot."
				+ "Currently the Requests and Responses are always in JSON format and likely to continue this way. ";
			
		Contact contact = new Contact("Movie Ticket Booking Services Team\n\n", "", "thippeshib@gmail.com");
		return new ApiInfoBuilder().title("Movie Ticket Booking").description(description).contact(contact)
				.build();
	}
}
