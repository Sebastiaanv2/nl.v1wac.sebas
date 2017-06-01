package nl.hu.v1wac.firstapp.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = "/DynamicServlet.do")
public class DynamicServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");

        PrintWriter out = resp.getWriter();


        String cijfer1 = req.getParameter("cijfer1");
        String cijfer2 = req.getParameter("cijfer2");

        int intCijfer1 = 0;
        int intCijfer2 = 0;

        try {
            intCijfer1 = Integer.parseInt(cijfer1);
            intCijfer2 = Integer.parseInt(cijfer2);
        } catch (NumberFormatException nfe) {
            out.println("haha ... grapjas!");
            return;
        }

        String modifier = req.getParameter("modifier");
        int somTotaal = 0;

        if (modifier.equals("+")) {
            somTotaal = intCijfer1 + intCijfer2;
        } else if (modifier.equals("-")) {
            somTotaal = intCijfer1 - intCijfer2;
        } else if (modifier.equals("/")) {
            somTotaal = intCijfer1 / intCijfer2;
        } else if (modifier.equals("*")) {
            somTotaal = intCijfer1 * intCijfer2;
        }


        resp.setContentType("text/html");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println(" <title>Dynamic Example</title>");
        out.println(" <body>");
        out.println(" <h2>Dynamic webapplication example</h2>");
        out.println(" <h2>Hello " + name + "!</h2>");
        out.println(" <h2>De uitkomst van " + cijfer1 + " " + modifier + " " + cijfer2 + " = " + somTotaal + "</h2>");
        out.println(" </body>");
        out.println("</html>");
    }
}
