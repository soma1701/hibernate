package com.bridgelabz.controller;

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
		if(actionMode ==null) {
			System.out.println("tomcat error");
		}
		else {
			System.out.println(actionMode);
			Processor objRequestProcessor = new Processor(); 
			switch(actionMode){
			case "REGISTER":
				objRequestProcessor.doRegister(request,response);
				break;
			case "LOGIN":
				objRequestProcessor.doLogin(request,response);
				break;
		 

			}
			
		}
		
	}
}
