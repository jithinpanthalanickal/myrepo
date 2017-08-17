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

public class Submit extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{  
		String userid=(String) req.getSession().getAttribute("uname");
		DBUtils Db = new DBUtils();
		HashMap<String, String> questions=Db.getAllQuestions();
		Set<String> qnos=questions.keySet();
		HashMap<String, String> ans = new HashMap();
		   for(String s:qnos)
		   {
			   ans.put(s, req.getParameter("ans"+s));
		   }
		Db.submitAnswer(userid,ans);
		Db.setArchive(userid,1);
		ServletOutputStream out=resp.getOutputStream();
		out.println(" <head> <meta charset=\"UTF-8\"><title>Success PAge</title> <link rel=\"stylesheet\" href=\"webpages/css/style.css\"></head>");
		out.println("<h1 align=\"center\" style=\"color:DarkTurquoise \">QUESTIONAIRRE</h1>");
		out.println("<body bgcolor=Tomato ><font size=5px color=LawnGreen ><center>");
		
		out.println("<br><br> Quiz Submission Successful !!! ");
        out.println("<br><br>Thank You  "+Db.getNamefromUserId(userid)+" For Attending the Quiz");
        
        out.println("</center></font><a href=\"index.html\" id=\"lnkhome\"><h2>Home Page</h2></a>");
		
	}

}
