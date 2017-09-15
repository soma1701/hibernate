package com.bridgelabz.processor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.DTO.BookDTO;
import com.bridgelabz.DTO.userDTO;
import com.bridgelabz.modal.BookDetails;
import com.bridgelabz.modal.UserDetails;

public class Processor {

	public void doRegister(HttpServletRequest request, HttpServletResponse response) {
		
		UserDetails objUserDetails = new UserDetails();
		objUserDetails.setUserName(request.getParameter("userName"));
		objUserDetails.setUserEmail(request.getParameter("email"));
		objUserDetails.setUserPassword(request.getParameter("password"));
		objUserDetails.setMobNo(request.getParameter("mobileNumber"));
		objUserDetails.setGender(request.getParameter("gender"));
		userDTO objUserDTO = new userDTO();
		int id = objUserDTO.register(objUserDetails);
		/*HttpSession session = request.getSession();
		session.setAttribute(, arg1);*/
		try {
			response.sendRedirect("signin.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	public void doLogin(HttpServletRequest request, HttpServletResponse response) {
		UserDetails objUserDetails = new UserDetails();
		objUserDetails.setUserEmail(request.getParameter("email"));
		objUserDetails.setUserPassword(request.getParameter("password"));
		userDTO objuserDTO = new userDTO();
		objUserDetails = objuserDTO.getLogin(objUserDetails);
		if(objUserDetails.getUserName()==null) {
			try {
				response.sendRedirect("signin.jsp");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("userName",objUserDetails.getUserName());
			session.setAttribute("userId",objUserDetails.getUserId());
			try {
				response.sendRedirect("HomePage.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
				
			
			
		}

	public void doSaveData(HttpServletRequest request, HttpServletResponse response) {
			BookDetails objBookDetails=new BookDetails();
			objBookDetails.setBookAuthor(request.getParameter("bookAuthor"));
			objBookDetails.setBookCatagory(request.getParameter("bookCatagory"));
			objBookDetails.setBookTitle(request.getParameter("bookTitle"));
			objBookDetails.setBookPrice(Double.parseDouble(request.getParameter("bookPrice")));
			BookDTO objBookDTO=new BookDTO();
			HttpSession session = request.getSession();
			int userId = (int) session.getAttribute("userId");
			
			UserDetails objuserDetails = new UserDetails();
			objuserDetails.setUserId(userId);
			
			objBookDetails.setUserDetails(objuserDetails);
			
			objBookDTO.saveBookDetails(objBookDetails);
			try {
				response.sendRedirect("HomePage.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	

	public void fetchBookTitle(HttpServletRequest request, HttpServletResponse response) {
			String bookCatagory=request.getParameter("bookCatagory");
			int userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());
			BookDTO objBookDTO=new BookDTO();
			List<BookDetails> alBookDetails=objBookDTO.fetchBookTitle(bookCatagory,userId);
			request.setAttribute("BookDetails", alBookDetails);
			RequestDispatcher dispatcher=request.getRequestDispatcher("book-title.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

	public void fetchBookDetails(HttpServletRequest request, HttpServletResponse response) {
		
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String isEditFlow = request.getParameter("isEditFlow");
		
		BookDTO objBookDTO = new BookDTO();
		BookDetails objBookDetails = objBookDTO.fetchBookDetails(bookId);
		request.setAttribute("isEditFlow", isEditFlow);
		request.setAttribute("bookDetails", objBookDetails);
		RequestDispatcher dispatcher = request.getRequestDispatcher("book-details.jsp");
		try {
			dispatcher.include(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public void deleteBook(HttpServletRequest request, HttpServletResponse response) {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		BookDTO objBookDTO = new BookDTO();
		objBookDTO.delete(bookId);
		
		// TODO Auto-generated method stub
		
	}

	public void editBookDetails(HttpServletRequest request, HttpServletResponse response) {
		BookDetails objBookDetails = new BookDetails();
		objBookDetails.setBookTitle(request.getParameter("bookTitle"));
		objBookDetails.setBookAuthor(request.getParameter("bookAuthor"));
		objBookDetails.setBookPrice(Double.parseDouble(request.getParameter("bookPrice")));
		objBookDetails.setBookId(Integer.parseInt(request.getParameter("bookId")));
		BookDTO objBookDTO = new BookDTO();
		objBookDTO.updateBookDetails(objBookDetails);
		try {
			response.sendRedirect("HomePage.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doLogout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		session.removeAttribute("userName");
		session.invalidate();
		try {
			response.sendRedirect("signin.jsp");
			response.setHeader("Cache-Control", "no-cache,no-store,must-validate");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires","0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*public void getBook(HttpServletRequest request, HttpServletResponse response) {
		int 
		
		// TODO Auto-generated method stub
		
	}*/
}

		
		
		
		
	
	


