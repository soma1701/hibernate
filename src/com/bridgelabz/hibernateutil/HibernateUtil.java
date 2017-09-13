package com.bridgelabz.hibernateutil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory factory;
	static {
		Configuration configuration = new Configuration();
		factory = configuration.configure().buildSessionFactory();
	}
	public static SessionFactory getFactory() {
		return factory;
	}
}
