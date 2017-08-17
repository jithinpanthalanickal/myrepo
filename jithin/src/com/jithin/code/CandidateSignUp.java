package com.jithin.code;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jithin.database.DBUtils;

public class CandidateSignUp extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		String userid =req.getParameter("uname");
		String pswd = req.getParameter("pwd");
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String gender=req.getParameter("gender");
		String place=req.getParameter("place");
		DBUtils Db = new DBUtils();
		HashMap<String, String> userTable = Db.getAllUsers();
		System.out.println(userTable.keySet());
		 ServletOutputStream out=resp.getOutputStream();
		if(userTable.containsKey(userid)||(userid.equals(null))||userid.matches("[ ]+")||userid==null||pswd==null||fname==null||lname==null)
		{resp.setContentType("text/html");
		out.println(" <head> <meta charset=\"UTF-8\"><title>Error PAge</title> <link rel=\"stylesheet\" href=\"webpages/css/style.css\"></head>");
		out.println("<h1 align=\"center\" style=\"color:red\">QUESTIONAIRRE</h1>");
		out.println("<body  bgcolor=black><font size=5px color=red><center>");
        out.println("<br><br> This Username Already Exists  !!! ");
        out.println("</center></font><a href=\"signup.html\" id=\"lnkhome\"><h2>Go to Signup Page</h2><a>");
        out.println("<script>setTimeout(function(){ }, 50000);</script></body>");
        
		}
		else
		{ 
//			onload=\"document.getElementById('lnkhome').click();\" 
			Db.InsertUser(userid, pswd, fname, lname,gender,place);
			resp.setContentType("text/html");
			out.println(" <head> <meta charset=\"UTF-8\"><title>Success PAge</title> <link rel=\"stylesheet\" href=\"webpages/css/style.css\"></head>");
			out.println("<h1 align=\"center\" style=\"color:red\">QUESTIONAIRRE</h1>");
			out.println("<body bgcolor=white><font size=5px color=green><center>");
	        out.println("<br><br> User Account Created Successfully !!! ");
	        out.println("</center></font><a href=\"index.html\" id=\"lnkhome\">Go to Signin Page<a>");
	        out.println("<script>setTimeout(function(){ }, 50000);</script></body>");
	      
		}
	}
	public void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
	doGet(req, resp);
		
		
	}
	
}
