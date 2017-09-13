package com.bridgelabz.processor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.DTO.userDTO;
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
		
		
		
		// TODO Auto-generated method stub
		
	}
	


