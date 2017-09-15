package com.bridgelabz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.processor.Processor;


public class Controller extends HttpServlet{
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String actionMode = request.getParameter("ACTION_MODE");
			Processor objRequestProcessor = new Processor(); 
			switch(actionMode){
			case "REGISTER":
				objRequestProcessor.doRegister(request,response);
				break;
			case "LOGIN":
				objRequestProcessor.doLogin(request,response);
				break;
			case "SAVE_BOOK":
				objRequestProcessor.doSaveData(request,response);
				break;
			case "FETCH_BOOK_TITLE":
				objRequestProcessor.fetchBookTitle(request, response);
				break;
			/*case:"FETCH_BOOK":
				objRequestProcessor.getBook(request,response);*/
			case "FETCH_BOOK_DETAILS":
				objRequestProcessor.fetchBookDetails(request, response);
				break;
			case "DELETE_BOOK":
				objRequestProcessor.deleteBook(request, response);
				break;
			case "EDIT_BOOK_DETAILS":
				objRequestProcessor.editBookDetails(request, response);
				break;
			case "LOGOUT":
				objRequestProcessor.doLogout(request, response);
				break;
			default:
				System.out.println("wrong input");
		 

			}
			
		}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
		
	}

