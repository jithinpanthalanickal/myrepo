package com.jithin.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class DBUtils {

	public static HashMap<String, String> getAllQuestions() {
		
		Connection connection = DBAccess.getMySqlConnection();
		if(connection != null){
			try {
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from questions");
				HashMap<String, String> result = new HashMap<>();
				while (rs.next()) {
					
				result.put( String.valueOf(rs.getInt("question_number")),String.valueOf(rs.getString("question_text")));
					
					
				}
				connection.close();
				return result;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static HashMap<String, String> getQuestion(Integer questionNumber) {
		
		Connection connection = DBAccess.getMySqlConnection();
		if(connection != null){
			try {
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from questions where question_number = " + questionNumber);
				HashMap<String, String> result = new HashMap<>(); 
				if (rs.next()) {
					result.put("question_number", String.valueOf(rs.getInt("question_number")));
					result.put("question_text", String.valueOf(rs.getString("question_text")));
				}
				connection.close();
				return result;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
public static HashMap<String, String> getAllUsers() {
		
		Connection connection = DBAccess.getMySqlConnection();
		if(connection != null){
			try {
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from user");
				//ArrayList<HashMap<String, String>> output = new ArrayList<>();
				HashMap<String, String> result = new HashMap<>();
				while (rs.next()) {
					result.put(String.valueOf(rs.getString("username")),String.valueOf(rs.getString("password")));
//					result.put("question_text", String.valueOf(rs.getString("question_text")));
					//output.add(result);
				}
				connection.close();
				return result;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
public static String getNamefromUserId(String uname) {
	
	Connection connection = DBAccess.getMySqlConnection();
	if(connection != null){
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from user where username = '" + uname+"'");
			rs.next();
			String name =String.valueOf(rs.getString("f_name"))+" "+String.valueOf(rs.getString("l_name"));
			connection.close();
//			HashMap<String, String> result = new HashMap<>(); 
//			if (rs.next()) {
//				result.put("question_number", String.valueOf(rs.getInt("question_number")));
//				result.put("question_text", String.valueOf(rs.getString("question_text")));
//			}
			
			return name;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return null;
}
public static void InsertUser(String username, String pasword, String Fname, String Lname,String gender, String place)
{
	Connection con = DBAccess.getMySqlConnection();
PreparedStatement stmt=null;
try {

	stmt = con.prepareStatement("insert into user(username,password,f_name,l_name,gender,place)values(?,?,?,?,?,?)");
	stmt.setString(1, username);
	stmt.setString(2, pasword);
	stmt.setString(3, Fname);
	stmt.setString(4, Lname);
	stmt.setString(5, gender);
	stmt.setString(6, place);
	
    stmt.executeUpdate();
    con.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
	public static void main(String[] args) {
		System.out.println(getQuestion(1));
	}

	public void setPassword(String userid,String pswd) {
        //UPDATE USER SET PASSWO'  WHERE username = '
		// TODO Auto-generated method stub
       System.out.println(userid+":"+pswd);
        Connection connection = null;
		connection = DBAccess.getMySqlConnection();
		
		if(connection != null){
			try {
				
//				Statement statement = connection.createStatement();
				PreparedStatement stmt = null;
				String upquery="UPDATE user SET password= ? WHERE username = ?";
				stmt = connection.prepareStatement(upquery);
				stmt.setString(1, pswd);
				stmt.setString(2, userid);
//				 stmt.executeUpdate();
				 int result = stmt.executeUpdate();
				 System.out.println("Reset Successfull result !! "+result);
				 connection.close();
				
     		
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}


		
	}

	public void submitAnswer(String userid, HashMap<String, String> ans) {
		// TODO Auto-generated method stub
		Connection connection = null;
		connection = DBAccess.getMySqlConnection();
		
		if(connection != null){
			try {PreparedStatement stmt = null;
				String upquery="insert into submission(username,question_number,answer)values(?,?,?)";
				stmt = connection.prepareStatement(upquery);
				Set<String> qset=ans.keySet();
				for(String q:qset)
				{
				 stmt.setString(1,userid);
				 stmt.setString(2,q);
				 stmt.setString(3, ans.get(q));
				 stmt.executeUpdate();
				}
				
//			Statement statement = connection.createStatement();
				
				
				
//				 stmt.executeUpdate();
//				 int result = stmt.executeUpdate();
//				 System.out.println("Reset Successfull result !! "+result);
				 connection.close();
				
     		
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}

	public void setArchive(String userid, int i) {

        
		// TODO Auto-generated method stub
      
        Connection connection = null;
		connection = DBAccess.getMySqlConnection();
		
		if(connection != null){
			try {
				
//				Statement statement = connection.createStatement();
				PreparedStatement stmt = null;
				String upquery="UPDATE user SET archive= ? WHERE username = ?";
				stmt = connection.prepareStatement(upquery);
				stmt.setInt(1, i);
				stmt.setString(2, userid);
//				 stmt.executeUpdate();
				 int result = stmt.executeUpdate();
				 System.out.println("Reset Successfull result !! "+result);
				 connection.close();
				
     		
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}


		
	
		
	}

	public int getArchive(String userid) {
		// TODO Auto-generated method stub

		
		Connection connection = DBAccess.getMySqlConnection();
		if(connection != null){
			try {
				int isarchive=0;
				
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from user where username = '" + userid+"'");
				rs.next();
				isarchive=Integer.valueOf(rs.getInt("archive"));
				connection.close();
//				HashMap<String, String> result = new HashMap<>(); 
//				if (rs.next()) {
//					result.put("question_number", String.valueOf(rs.getInt("question_number")));
//					result.put("question_text", String.valueOf(rs.getString("question_text")));
//				}
				
				return isarchive;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
		

		
	}

	
}
