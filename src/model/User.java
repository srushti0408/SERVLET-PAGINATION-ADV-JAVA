package model;

public class User 
{
  private int empid;
  private String uname;
  private String email;
  private String mob;
  
  public User()
  {
	super();
  }
  
  
public User(String uname, String email, String mob) {
	super();
	this.uname = uname;
	this.email = email;
	this.mob = mob;
}


public User(int empid, String uname, String email, String mob) 
{
	super();
	this.empid = empid;
	this.uname = uname;
	this.email = email;
	this.mob = mob;
}

public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMob() {
	return mob;
}
public void setMob(String mob) {
	this.mob = mob;
}


@Override
public String toString() {
	return "User [empid=" + empid + ", uname=" + uname + ", email=" + email + ", mob=" + mob + "]";
}
  
  
}
