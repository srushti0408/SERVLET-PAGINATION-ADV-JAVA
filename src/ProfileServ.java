

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDao;

@WebServlet("/profileserv")
public class ProfileServ extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int pageid=Integer.parseInt(request.getParameter("pageid"));
		int end=5;
		
		Cookie c[]=request.getCookies();
		
		if(c!=null)
		{
			String uname=c[0].getValue();
			String email=c[1].getValue();
			
		request.getRequestDispatcher("navbar.html").include(request, response);
		out.print("Wecome to Profile page :"+uname+" "+email);
		out.println("<h2>Page No. "+pageid+"</h2>");
		out.print(" <meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.print("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
		out.print("  <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
		out.print("  <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'></script>");

		if(pageid==1)
		{
			
		}
		else
		{
			pageid-=1;
			pageid=pageid*end+1;
		}
		out.print("<table class='table table-striped'");
		out.print("<tr><th>EmpId</th> <th>Name</th> <th>Email</th> <th>MobileNo</th> <th colspan='2'>Actions</th></tr>");
		
		
		UserDao ud=new UserDao();
		try 
		{
			ArrayList<User> ul=ud.getFiveUsers((pageid-1), end);
			for(User u:ul)
			{
				out.print("<tr>");
				out.print("<td>"+u.getEmpid()+"</td><td>"+u.getUname()+"</td><td>"+u.getEmail()+"</td><td>"+u.getMob()+"</td>");
				out.print("<td>"+"<a class='btn btn-primary' href='updateserv?empid="+ u.getEmpid() +"'>Edit</a>"+"</td>");
				out.print("<td>"+"<a class='btn btn-danger' href='deleteserv?empid="+ u.getEmpid() +"'>Delete</a>"+"</td>");
				out.print("</tr>");
			}
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		out.print("</table border>");
		out.print("<center><ul class='pagination'>");
		out.print("<li><a href='profileserv?pageid=1'><</a></li>");
		out.print("<li><a href='profileserv?pageid=1'>1</a></li>");
		out.print("<li><a href='profileserv?pageid=2'>2</a></li>");
		out.print("<li><a href='profileserv?pageid=3'>3</a></li>");
		out.print("<li><a href='profileserv?pageid=4'>4</a></li>");
		out.print("<li><a href='profileserv?pageid=5'>5</a></li>");
		out.print("<li><a href='profileserv?pageid=6'>6</a></li>");
		out.print("<li><a href='profileserv?pageid=6'>></a></li>");
		out.print("</ul></center>");
		}
		
		else
		{
			request.getRequestDispatcher("login.html").include(request, response);
			out.print("<br><br><br>Please login first before visiting profile page");
		}
		
		/*String uname=request.getParameter("uname");
		String email=request.getParameter("email");
		String mob=request.getParameter("mob");
		
		out.print("User Data <br>");
		out.print("username :"+uname+"<br>");
		out.print("email :"+email+"<br>");
		out.print("mobile number :"+mob+"<br>");*/
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
