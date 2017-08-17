package com.jithin.code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jithin.database.DBUtils;

public class Quiz extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{  

		DBUtils Db = new DBUtils();
		HashMap<String, String> questions=Db.getAllQuestions();
		String userid=(String) req.getSession().getAttribute("uname");
	    ServletOutputStream out=resp.getOutputStream();
		out.println(" <head> <meta charset=\"UTF-8\"><title>Questions</title> <link rel=\"stylesheet\" href=\"webpages/css/style.css\"></head>");
		out.println("<h1 align=\"center\" style=\"color:red\">QUESTIONAIRRE</h1>");
		out.println("<form id=\"submit\" action=\"submit\">");
		out.println("<body bgcolor=lightyellow><font size=5px color=green><center>");
		Set<String> qnos=questions.keySet();
		   for(String s:qnos)
		   {
			out.println("<br> Question No :"+s+" -->"+questions.get(s)+"</br>");
			out.println("<br> <input type=\"text\" placeholder=\"Type Answer Here \" name=\"ans"+s+"\" style=\"width: 580px; \"> </br>");
			
		   }
			
			
		
		out.println("<input type=\"submit\" class=\"send\" value=\"Submit Answer\" style=\"width: 100px; \">");
		out.println("</center></font></body></form>");
	}

}
