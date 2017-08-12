package com.group1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group1.data.DbMgr;

/**
 * Servlet implementation class update
 */
@WebServlet(name= "update", urlPatterns= {"/update"})
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email= request.getParameter("email");
		String country= request.getParameter("country");
		String userName = "james";
		HttpSession session=request.getSession();
		userName = (String) session.getAttribute("username")!=null ? (String) session.getAttribute("userName"): userName;
		
		ServletContext ctx = getServletContext();
		DbMgr dbMgr = (DbMgr) ctx.getAttribute("DbMgr");
		Connection con = dbMgr.getConnection();
		String insrtQuery = "UPDATE USERS SET email=?,country =? WHERE user_name=?";
		boolean success = false;
		try {
			PreparedStatement ps = con.prepareStatement(insrtQuery);
			ps.setString(1, email);
			ps.setString(2, country);
			ps.setString(3, userName);
			success=ps.execute();
			}
		catch (SQLException e) {
			e.printStackTrace();
			}
		
		
		
		RequestDispatcher rd = ctx.getRequestDispatcher("/profile.html");
		PrintWriter out = response.getWriter();
		out.println("<font color=green>profile updated"+"</font>");
		rd.include(request, response);
		
		doGet(request, response);
	}

}