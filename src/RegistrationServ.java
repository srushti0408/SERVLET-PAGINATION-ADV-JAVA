import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDao;

@WebServlet("/regserv")
public class RegistrationServ extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("uname");
		String email=request.getParameter("email");
		String mob=request.getParameter("mob");
		
		User u=new User(uname, email, mob);
		
		UserDao ud=new UserDao();
		try 
		{
			int a=ud.save(u);
			if(a>0)
			{
				out.print("Data inserted");
				response.sendRedirect("profileserv");
			}
			else
			{
				out.print("Data not inserted");
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
		
		
		/*if(upass.equals("abc123"))
		{
			//response.sendRedirect("profile");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("profile");
			requestDispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.html");
			requestDispatcher.include(request, response);
			out.print("<p style ='color:red'>Wrong Password</p>");
		}
		*/
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		doGet(request, response);
	}
}
