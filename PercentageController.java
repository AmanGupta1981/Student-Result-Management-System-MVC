package Controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PercentageController extends HttpServlet {

    public void service(HttpServletRequest req,
                        HttpServletResponse res)
            throws ServletException, IOException {

        PrintWriter pw = res.getWriter();
        HttpSession session = req.getSession();

        int m1 = (int) session.getAttribute("marks1");
        int m2 = (int) session.getAttribute("marks2");
        int m3 = (int) session.getAttribute("marks3");

        float percentage =
                ((float)(m1 + m2 + m3) / 300) * 100;

        // NEW
        session.setAttribute("percentage", percentage);

        pw.println("<br><br>");
        pw.println("<h3>Percentage : "
                + String.format("%.2f", percentage)
                + "%</h3>");

        // NEW
        req.getServletContext()
           .getRequestDispatcher("/GradeControler")
           .include(req, res);
    }
}