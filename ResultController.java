package Controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.GetData;

public class ResultController extends HttpServlet {

    GetData ref;
    PrintWriter pw;

    public void init() {
        ref = new GetData();
    }

    public void service(HttpServletRequest req,
                        HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");

        pw = res.getWriter();

        HttpSession session = req.getSession();

        int id = (int) session.getAttribute("id");

        ref.getStudent(id);

        String name = ref.getName();
        int marks1 = ref.getMarks1();
        int marks2 = ref.getMarks2();
        int marks3 = ref.getMarks3();

        session.setAttribute("marks1", marks1);
        session.setAttribute("marks2", marks2);
        session.setAttribute("marks3", marks3);

        pw.println("<html>");

        pw.println("<head>");
        pw.println("<title>Student Result</title>");
        pw.println("<link rel='stylesheet' href='css/style.css'>");
        pw.println("</head>");

        pw.println("<body>");

        pw.println("<div class='container'>");

        pw.println("<h2>Student Result</h2>");

        pw.println("<table>");

        pw.println("<tr>");
        pw.println("<th>ID</th>");
        pw.println("<th>Name</th>");
        pw.println("<th>Marks1</th>");
        pw.println("<th>Marks2</th>");
        pw.println("<th>Marks3</th>");
        pw.println("</tr>");

        pw.println("<tr>");
        pw.println("<td>" + id + "</td>");
        pw.println("<td>" + name + "</td>");
        pw.println("<td>" + marks1 + "</td>");
        pw.println("<td>" + marks2 + "</td>");
        pw.println("<td>" + marks3 + "</td>");
        pw.println("</tr>");

        pw.println("</table>");

        req.getServletContext()
           .getRequestDispatcher("/PercentageController")
           .include(req, res);

        pw.println("</div>");

        pw.println("</body>");
        pw.println("</html>");
    }
}