package Controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GradeControler extends HttpServlet {

    public void service(HttpServletRequest req,
                        HttpServletResponse res)
            throws ServletException, IOException {

        PrintWriter pw = res.getWriter();

        HttpSession session = req.getSession();

        float percentage =
                (float) session.getAttribute("percentage");

        String grade;

        if(percentage >= 90) {
            grade = "A+";
        }
        else if(percentage >= 80) {
            grade = "A";
        }
        else if(percentage >= 70) {
            grade = "B";
        }
        else if(percentage >= 60) {
            grade = "C";
        }
        else {
            grade = "FAIL";
        }

        pw.println("<h3>Grade : " + grade + "</h3>");
    }
}