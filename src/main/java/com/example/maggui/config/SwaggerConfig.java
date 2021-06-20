package com.example.maggui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * config the swagger
 * 
 * @author Magdaly Santos
 * 
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {

    @Bean
    public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2).select()
		.apis(RequestHandlerSelectors.basePackage("com.example.maggui.controllers")).paths(PathSelectors.any())
		.build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// enabling swagger-ui part for visual documentation
	registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
	registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
