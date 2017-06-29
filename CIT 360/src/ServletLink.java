// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class ServletLink extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
      // Set response content type
      response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.println("<h1>Do not login directly.</h1>");
      out.println("<a href='/Home'>Go to the Home Page</a>");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      try {

          String user=request.getParameter("user");

          if(Character.isDigit(user.charAt(0))){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Please give us a name not numbers...");
          }
          else{
            out.println("<h2> Welcome "+user+"</h2>");
            out.println("<a href='/Home'>Go to the Home Page</a>");
          }
      } finally {
          out.close();
      }
  }
}