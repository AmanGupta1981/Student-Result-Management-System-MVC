package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetData {
	
	int id;
	String name;
	int marks1;
	int marks2;
	int marks3;
	String email;
	String phone;
	String password;
    
	String url = "jdbc:mysql://localhost:3306/novstudent";
	String user = "root";
	String pwd = "1981";
	String dpath = "com.mysql.cj.jdbc.Driver";
	
	Connection con=null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	
	//Constructor = 
	public GetData() {
		try {
			Class.forName(dpath);
			con = DriverManager.getConnection(url,user,pwd);
			System.out.println("Database Connection Established");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean register(int id, String name, int marks1, int marks2, int marks3, String email, String phone, String password) 
	{
		try {
		String sql = "insert into student values(?,?,?,?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, marks1);
		ps.setInt(4, marks2);
		ps.setInt(5, marks3);
		ps.setString(6, email);
		ps.setString(7, phone);
		ps.setString(8, password); 
		
		 int rows = ps.executeUpdate();
		 if(rows>0) {
			 return true;
		 }
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
  public boolean login(int id, String password) {
	  
	  try {
		  String sql = "select * from student where id=? and password=?";
		  
		  ps = con.prepareStatement(sql);
		  ps.setInt(1, id);
		  ps.setString(2, password);
		  
		  rs = ps.executeQuery();
		  
		  if(rs.next()) {
			  return true;
		  }
		  
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  return false;
  }

  
  public void getStudent(int id) {
	  try {
		  
		  String sql = "SELECT * FROM student where id = ?";
		  ps = con.prepareStatement(sql);
		  
		  ps.setInt(1, id);
		  rs = ps.executeQuery();
		  if(rs.next()) {
			  
			  this.id=rs.getInt(1);
			  this.name=rs.getString(2);
			  this.marks1=rs.getInt(3);
			  this.marks2=rs.getInt(4);
			  this.marks3=rs.getInt(5);
			  this.email=rs.getString(6);
			  this.phone=rs.getString(7);
			  this.password=rs.getString(8);
			  
		  }  
		  
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
  }
  
	  public int getId()
	  {
	      return id;
	  }
	
	  public String getName()
	  {
	      return name;
	  }
	
	  public int getMarks1()
	  {
	      return marks1;
	  }
	
	  public int getMarks2()
	  {
	      return marks2;
	  }
	
	  public int getMarks3()
	  {
	      return marks3;
	  }
  
  
}
