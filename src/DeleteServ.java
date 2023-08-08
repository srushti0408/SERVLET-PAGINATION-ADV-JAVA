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

@WebServlet("/deleteserv")
public class DeleteServ extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int empid=Integer.parseInt(request.getParameter("empid"));
		String uname=request.getParameter("uname");
		String email=request.getParameter("email");
		String mob=request.getParameter("mob");
		
		User u=new User(empid, uname, email, mob);
		UserDao ud=new UserDao();
		try 
		{
			int a=ud.delete(u);
			if(a>0)
			{
				out.print("Data successfully deleted");
				response.sendRedirect("profileserv");
				
			}
			else
			{
				out.print("Data not deleted");
			}
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
