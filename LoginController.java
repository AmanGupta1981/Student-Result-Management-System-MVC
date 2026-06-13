package Controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.GetData;


public class LoginController extends HttpServlet {

	
	GetData ref;
	
	public void init() {
		ref = new GetData();
	}
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		int id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("password");
		boolean status = ref.login(id, password);
		
		if(status) {
			
			HttpSession session = req.getSession(true);
			session.setAttribute("id", id);
            res.sendRedirect("ResultController");
		}
		else {
			res.sendRedirect("loginfail.html");
		}
	}
	
	

}
