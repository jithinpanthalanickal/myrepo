package com.jithin.code;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jithin.database.DBUtils;

public class Reset1 extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		String userid =req.getParameter("uname");
		DBUtils Db = new DBUtils();
		HashMap<String, String> userTable = Db.getAllUsers();
		ServletOutputStream out=resp.getOutputStream();
		if(userTable.containsKey(userid))
		{   req.getSession().setAttribute("uname", userid);	
			resp.sendRedirect("resetpage2.html");
					
		}
		else 
		{
			resp.setContentType("text/html");
			out.println(" <head> <meta charset=\"UTF-8\"><title>Error Page</title> <link rel=\"stylesheet\" href=\"webpages/css/style.css\"></head>");
			out.println("<h1 align=\"center\" style=\"color:red\">QUESTIONAIRRE</h1>");
			out.println("<body bgcolor=black><font size=5px color=red><center>");
	        out.println("<br><br> This Username Not Found .. Please Verify it again   !!! ");
	        out.println("</center></font></body>");
			resp.sendRedirect("resetpage1.html");
			
			
			
		}
	}
	public void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
	doGet(req, resp);
		
		
	}

}
