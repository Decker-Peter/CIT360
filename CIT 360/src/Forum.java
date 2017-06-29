import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


// Extend HttpServlet class

public class Forum extends HttpServlet {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // Response type
      response.setContentType("text/html");

      // Here is the forum to fill out.
      PrintWriter out = response.getWriter();
      out.println("<h1>The Home Page</h1>");
      out.println("<h2>Enter your name.</h2>");
      out.println("<form method='post' action='Alink'>");
      out.println("Name <input type='text' name='user' required>");
      out.println("<input type='submit' value='submit'>");
      out.println("</form>");
  }
}