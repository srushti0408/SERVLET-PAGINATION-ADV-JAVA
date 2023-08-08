

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logoutserv")
public class LogoutServ extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("uname");
		String email=request.getParameter("email");
		
		request.getRequestDispatcher("navbar.html").include(request, response);
		
		out.print("Welcome to login page : "+uname+" "+email);
		out.print("<a href='profileserv?pageid=1'>Profile</a>");
		
		Cookie c=new Cookie("uname", "");
		Cookie c1=new Cookie("email", "");
		c.setMaxAge(0);
		c1.setMaxAge(0);
		response.addCookie(c);
		response.addCookie(c1);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}