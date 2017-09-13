package com.bridgelabz.DTO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bridgelabz.hibernateutil.HibernateUtil;
import com.bridgelabz.hibernateutil.QueryUtil;
import com.bridgelabz.modal.UserDetails;

public class userDTO {

	public int register(UserDetails objUserDetails) {
		SessionFactory factory=HibernateUtil.getFactory();
		Session session = factory.openSession(); 
		Transaction transaction = session.beginTransaction();
		int id= (int)session.save(objUserDetails);
		
		transaction.commit();
		session.close();
		return id;
	}

	public UserDetails getLogin(UserDetails objUserDetails) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Transaction transaction = session.getTransaction();
		Query query = session.createQuery(QueryUtil.GET_LOGIN_AUTHENTICATION);
		query.setString("email", objUserDetails.getUserEmail());
		UserDetails userDetails = (UserDetails) query.uniqueResult();
		
		return userDetails;
	}

}
