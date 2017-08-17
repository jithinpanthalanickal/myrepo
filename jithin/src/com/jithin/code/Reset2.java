package com.jithin.code;


import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jithin.database.DBUtils;

public class Reset2 extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
	String userid= (String) req.getSession().getAttribute("uname");
	System.out.println("Username Fron Session : "+userid);
	String pswd =req.getParameter("pwd1");
	System.out.println("Password :"+pswd);
	DBUtils Db = new DBUtils();
	Db.setPassword(userid,pswd);
	ServletOutputStream out=resp.getOutputStream();
	out.println(" <head> <meta charset=\"UTF-8\"><title>Success PAge</title> <link rel=\"stylesheet\" href=\"webpages/css/style.css\"></head>");
	out.println("<h1 align=\"center\" style=\"color:red\">QUESTIONAIRRE</h1>");
	out.println("<body bgcolor=lightyellow><font size=5px color=green><center>");
    out.println("<br><br> Password Reset for "+userid+" Successfully Completed ");
    out.println("</center></font><a href=\"index.html\" id=\"lnkhome\"><h2>Proceed to login</h2><a>");
    out.println("</center></font></body>");
	}
	public void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
	doGet(req, resp);
		
		
	}
}
