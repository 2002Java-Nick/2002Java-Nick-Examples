package com.revature.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan
public class SpringConfig extends WebMvcConfigurerAdapter { //implements WebApplicationInitializer{

	/*
	 * public void onStartup(ServletContext servletContext) throws ServletException
	 * {
	 * 
	 * AnnotationConfigWebApplicationContext ac = new
	 * AnnotationConfigWebApplicationContext(); ac.register(AppConfig.class);
	 * ac.refresh();
	 * 
	 * DispatcherServlet servlet = new DispatcherServlet(ac);
	 * ServletRegistration.Dynamic registration =
	 * servletContext.addServlet("front-controller", servlet);
	 * 
	 * registration.setLoadOnStartup(1); registration.addMapping("/"); }
	 */
}
