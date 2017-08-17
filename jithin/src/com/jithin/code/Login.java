package com.jithin.code;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jithin.database.DBUtils;

public class Login extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		String userid =req.getParameter("uname");
		String pswd = req.getParameter("pwd");
		System.out.println(userid);
		System.out.println(pswd);
		DBUtils Db = new DBUtils();
		HashMap<String, String> userTable = Db.getAllUsers();
		System.out.println(userTable.keySet());
		 ServletOutputStream out=resp.getOutputStream();
		if(userTable.containsKey(userid) && userTable.get(userid).equals(pswd)&&Db.getArchive(userid)<1)
		{   req.getSession().setAttribute("uname", userid);	
			resp.setContentType("text/html");
			out.println(" <head> <meta charset=\"UTF-8\"><title>Success PAge</title> <link rel=\"stylesheet\" href=\"webpages/css/style.css\"></head>");
			out.println("<h1 align=\"center\" style=\"color:lightyellow\">QUESTIONAIRRE</h1>");
			out.println("<body bgcolor=Tomato><font size=5px color=green><center>");
            out.println("<br><br>Welcome "+Db.getNamefromUserId(userid));
            out.println("<br><br> Login Successful !!! ");
	        out.println("</center></font><a href=\"/quiz/quizit\" id=\"lnkhome\"><h2>Proceed to Questions</h2></a>");
//			resp.sendRedirect("Questions.html");
			
		}
		else if(userTable.containsKey(userid) && userTable.get(userid).equals(pswd)&&Db.getArchive(userid)==1)
		{
			
		resp.setContentType("text/html");
		out.println(" <head> <meta charset=\"UTF-8\"><title>Success PAge</title> <link rel=\"stylesheet\" href=\"webpages/css/style.css\"></head>");
		out.println("<h1 align=\"center\" style=\"color:lightyellow\">QUESTIONAIRRE</h1>");
		out.println("<body bgcolor=Tomato><font size=5px color=green><center>");
        out.println("<br><br>Welcome "+Db.getNamefromUserId(userid));
        out.println("<br><br>Thanks for Coming , but  You Already Attended the Quiz!!!");
        out.println("</center></font><a href=\"index.html\" id=\"lnkhome\"><h2>Home page</h2></a>");
			
		}
		else
		{
			
			resp.setContentType("text/html");
	       
	        
	        out.println(" <head> <meta charset=\"UTF-8\"><title>Error PAge</title> <link rel=\"stylesheet\" href=\"webpages/css/style.css\"></head>");
	        out.println("<h1 align=\"center\" style=\"color:red\">QUESTIONAIRRE</h1>");
	        out.println("<body bgcolor=lightyellow><font size=5px color=blue><center>");
            out.println("<br><br>Invalid Login ! Recheck your credentials");
//            out.println("<br><br<a href='index.html'> login </a>");
            out.println("</center></font><a href='index.html' id=\"lnkhome1\"><h2>Proceed to Login</h2> </a>");
            out.println("</center></font><a href='signup.html' id=\"lnkhome2\"><h2>Create an Account</h2> </a>");
//            out.println("<br><br<a href='signup.html'> signup </a>");
            out.println("</center></font></body>");
	        
		}

	}
	public void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
	doGet(req, resp);
		
		
	}
}
