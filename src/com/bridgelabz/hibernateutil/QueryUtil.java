package com.bridgelabz.hibernateutil;

public class QueryUtil {
	public static final String GET_LOGIN_AUTHENTICATION = "from UserDetails where userEmail= :userEmail and userPassword=:userPassword";
	public static final String FETCH_BOOK_DETAILS = "from BookDetails where userId= :userId";
	public static final String DELETE_BOOK_DETAILS = "delete from BookDetails where bookId= :bookId";
	public static final String UPDATE_BOOK_DETAILS = "UPDATE BookDetails set bookTitle= :bookTitle,bookAuthor = :bookAuthor,bookCatagory= :bookCatagory where bookId= :bookId";
	public static final String GET_BOOK_TITLE="from UserDetails u where u.bookCatagory= :bookCatagory and u.userId= :userId";

}
