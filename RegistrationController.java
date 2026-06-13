package Controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.GetData;


public class RegistrationController extends HttpServlet {

	GetData ref ;
	
	public void init() {
		try {
			ref = new GetData();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void service(HttpServletRequest req , HttpServletResponse res)  throws ServletException, IOException{
		try {
			
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			int marks1 = Integer.parseInt(req.getParameter("marks1"));
			int marks2 = Integer.parseInt(req.getParameter("marks2"));
			int marks3 = Integer.parseInt(req.getParameter("marks3"));
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String password = req.getParameter("password");
			
			boolean status = ref.register(id, name, marks1, marks2, marks3, email, phone, password);
			
			if(status == true) {
				res.sendRedirect("login.html");
			}
			else {
				res.sendRedirect("regfail.html");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
