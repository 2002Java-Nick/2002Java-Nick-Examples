package com.revature.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revature.util.SessionFactoryUtil;

@Configuration
public class AppConfig {
	
	@Bean
	public SessionFactory sf() {
		return SessionFactoryUtil.getSessionFactoryUtil().getSessionFactory();
	}

}
