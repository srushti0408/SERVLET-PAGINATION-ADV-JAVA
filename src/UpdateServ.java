

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

@WebServlet("/updateserv")
public class UpdateServ extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int empid=Integer.parseInt(request.getParameter("empid"));
		
		UserDao ud=new UserDao();
		
		try 
		{
			User u = ud.getOneUser(empid);
			//out.print("User Data :"+u);
			//System.out.println("User Data :"+u);
			
			out.print("<form action='fupdate'>");
			out.print("<input type='text' name='empid' value='"+u.getEmpid()+"'readonly><br>");
			out.print("<input type='text' name='uname' value='"+u.getUname()+"'><br>");
			out.print("<input type='text' name='email' value='"+u.getEmail()+"'><br>");
			out.print("<input type='text' name='mob' value='"+u.getMob()+"'><br>");
			out.print("<input type='submit' value='Update'><br>");
			out.print("</form>");

		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		doGet(request, response);
	}
}
