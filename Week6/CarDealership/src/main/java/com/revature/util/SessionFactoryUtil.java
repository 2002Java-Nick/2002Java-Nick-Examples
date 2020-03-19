package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryUtil {
	
	private static SessionFactory sf;
	
	private static SessionFactoryUtil sfu;
	
	private static String configFileLocation = "hibernate.cfg.xml";
	
	public static SessionFactoryUtil getSessionFactoryUtil() {
		if (sfu == null) {
			sfu = new SessionFactoryUtil();
		}
		return sfu;
	}
	
	private SessionFactoryUtil() {
		if (sf == null) {
			//Hibernate 4 Set-Up
			/*
			 * Configuration configuration = new
			 * Configuration().configure(configFileLocation); ServiceRegistry
			 * serviceRegistry = new
			 * StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
			 * .build(); sf = configuration.buildSessionFactory(serviceRegistry);
			 */
			//Hibernate 5 Set-Up
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure(configFileLocation).build();
			Metadata metadata = new MetadataSources(standardRegistry)
					.getMetadataBuilder()
					.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
					.build();
			sf = metadata.getSessionFactoryBuilder().build();
		}
	}
	
	public SessionFactory getSessionFactory() {
		return this.sf;
	}

	public static void setConfigFileLocationToTest() {
		configFileLocation = "hibernate.cfg.xml";
	}
	
}
