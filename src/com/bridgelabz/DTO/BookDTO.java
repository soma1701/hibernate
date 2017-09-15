package com.bridgelabz.DTO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.bridgelabz.hibernateutil.HibernateUtil;
import com.bridgelabz.hibernateutil.QueryUtil;
import com.bridgelabz.modal.BookDetails;
import com.bridgelabz.modal.UserDetails;

public class BookDTO {

	public void saveBookDetails(BookDetails objBookDetails) {
		SessionFactory factory=HibernateUtil.getFactory();
		Session session = factory.openSession(); 
		Transaction transaction = session.beginTransaction();
		session.save(objBookDetails);
		transaction.commit();
		session.close();
		
	}

	

	/*public List<BookDetails> fetchBookTitle(String bookCatagory, int userId) {
		SessionFactory factory=HibernateUtil.getFactory();
		Session session = factory.openSession(); 
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(QueryUtil.GET_BOOK_TITLE);
		query.setString("bookCatagory",bookCatagory);
		query.setInteger("userId", userId);
		List bookDetails= query.list();
		
		// TODO Auto-generated method stub
		return bookDetails;
	}*/
	
	public List<BookDetails> fetchBookTitle(String bookCatagory, int userId) {
		SessionFactory factory=HibernateUtil.getFactory();
		Session session = factory.openSession(); 
		
		UserDetails usd = new UserDetails();
		usd.setUserId(userId);
		Criteria cr = session.createCriteria(BookDetails.class);
		cr.add(Restrictions.eq("bookCatagory", bookCatagory));
		cr.add(Restrictions.eq("userDetails", usd));
		List bookDetails = cr.list();
		
		// TODO Auto-generated method stub
		return bookDetails;
	}



	/*public BookDetails fetchBookDetails(int bookId) {
		SessionFactory factory=HibernateUtil.getFactory();
		Session session = factory.openSession(); 
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(QueryUtil.FETCH_BOOK_DETAILS);
		query.setInteger("bookId", bookId);
		List<BookDetails> bookDetails = query.list();
		return (BookDetails) bookDetails;
	}*/

	public BookDetails fetchBookDetails(int bookId) {
		SessionFactory factory=HibernateUtil.getFactory();
		Session session = factory.openSession(); 
		Transaction transaction = session.beginTransaction();
		Criteria cr = session.createCriteria(BookDetails.class);
		cr.add(Restrictions.eq("bookId", bookId));
		List<BookDetails> bookDetails = cr.list();
		return  bookDetails.get(0);
	}


	public void delete(int bookId) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession(); 
		Transaction transaction = session.beginTransaction();
		BookDetails bookDetails= new BookDetails();
		bookDetails.setBookId(bookId);
		session.delete(bookDetails);
		transaction.commit();
		session.close();
	}



	public void updateBookDetails(BookDetails objBookDetails) {
		SessionFactory factory=HibernateUtil.getFactory();
		Session session = factory.openSession(); 
		Transaction transaction = session.beginTransaction();
		session.update(objBookDetails);
		transaction.commit();
		session.close();
	}
		
		
}


