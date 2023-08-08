package model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDao 
{
   String driver="com.mysql.cj.jdbc.Driver";
   String url="jdbc:mysql://localhost:3306/servdatabasepractice";
   String username="root";
   String pass="abc123";
   
   Connection getconnection() throws ClassNotFoundException, SQLException
   {
	   Class.forName(driver);
	   Connection con=DriverManager.getConnection(url, username, pass);
	   return con;
   }
   public int save(User u) throws ClassNotFoundException, SQLException
   {
	   Connection con=getconnection();
	   String sql="insert into emp_table(uname, email, mobileno) values(?,?,?)";
	   PreparedStatement ps=con.prepareStatement(sql);
	   ps.setString(1, u.getUname());
	   ps.setString(2, u.getEmail());
	   ps.setString(3, u.getMob());
	   int a=ps.executeUpdate();
	   
	   con.close();
	   return a;
   }
   
   public ArrayList<User> getAllUsers() throws ClassNotFoundException, SQLException
   {
	   Connection con=getconnection();
	   String sql="select * from emp_table";
	  PreparedStatement ps=con.prepareStatement(sql);
	  ResultSet rs=ps.executeQuery(sql);
	  
	  ArrayList<User> ul=new ArrayList<>();
	  while(rs.next())
	  {
		  User u=new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		  
		  ul.add(u);
	  }
	   con.close();
	   
	   return ul;
   }
   
   public ArrayList<User> getFiveUsers(int start, int end) throws ClassNotFoundException, SQLException
   {
	   Connection con=getconnection();
	   String sql="select * from emp_table limit "+start+","+end;
	   PreparedStatement ps=con.prepareStatement(sql);
		  ResultSet rs=ps.executeQuery(sql);
	  
	  ArrayList<User> ul=new ArrayList<>();
	  while(rs.next())
	  {
		  User u=new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		  
		  ul.add(u);
	  }
	   con.close();
	   
	   return ul;
   }
   
   public int delete(User u) throws ClassNotFoundException, SQLException
   {
	   
	   Connection con=getconnection();
	   String sql="DELETE FROM emp_table WHERE empid=?";
	   PreparedStatement ps=con.prepareStatement(sql);
	   ps.setInt(1, u.getEmpid());
       int a=ps.executeUpdate();
	   
	   con.close();
	   return a;
   }
   
   public User getOneUser(int empid) throws ClassNotFoundException, SQLException 
   {
	   Connection con=getconnection();
	   String sql="select * from emp_table where empid="+empid;
	   Statement st=con.createStatement();
	   ResultSet rs=st.executeQuery(sql);
	   
	   User u=new User();
	   
	   while(rs.next())
	   {
		   if(empid==rs.getInt(1))
		   {
			   u.setEmpid(rs.getInt(1));
			   u.setUname(rs.getString(2));
			   u.setEmail(rs.getString(3));
			   u.setMob(rs.getString(4));
		   }
	   }
	return u;
	 
   }
public int update(User u) throws ClassNotFoundException, SQLException
{
	   Connection con=getconnection();
	   String sql="update emp_table set uname=?, email=?, mobileno=? where empid=?";
	   PreparedStatement ps=con.prepareStatement(sql);
	   ps.setString(1, u.getUname());
	   ps.setString(2, u.getEmail());
	   ps.setString(3, u.getMob());
	   ps.setInt(4, u.getEmpid());
	   int a=ps.executeUpdate();
	   
	   con.close();
	   return a;
}

}
