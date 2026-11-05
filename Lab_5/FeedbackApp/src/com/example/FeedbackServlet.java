
package com.example;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class FeedbackServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                       throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String type = request.getParameter("type");
        String comments = request.getParameter("comments");

        String dateTime = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        );

        out.println("<html><body>");
        out.println("<h2>Thank you, " + name +
                    " for your feedback!</h2>");
        out.println("<p><b>Email:</b> " + email + "</p>");
        out.println("<p><b>Feedback Type:</b> " + type + "</p>");
        out.println("<p><b>Comments:</b> " + comments + "</p>");
        out.println("<p><b>Date and Time:</b> " +
                    dateTime + "</p>");
        out.println("</body></html>");
    }
}
