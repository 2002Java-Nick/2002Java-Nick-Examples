package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver irv = new InternalResourceViewResolver();
		irv.setPrefix("WEB-INF/pages/");
		irv.setSuffix(".jsp");
		return irv;
	}

}
