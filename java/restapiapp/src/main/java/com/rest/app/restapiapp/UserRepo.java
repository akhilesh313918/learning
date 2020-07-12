package com.rest.app.restapiapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {
	
	Connection con = null;
	UserResource ur;
	
	public UserRepo(){
		String url = "jdbc:mysql://localhost:3306/mysql";
		String uname = "root";
		String pass = "password";
		try{
		Class.forName("com.mysql.jdbc.Driver");	
		con = DriverManager.getConnection(url, uname, pass);
		
		}catch(Exception e){
			System.out.println(e);
		}	
		
	}
	
	
	public List<User> getAllUser(){
		
		List<User> user = new ArrayList<>();
		String sql = "select * from users";
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				
				User u = new User();
				u.setEmpid(rs.getString(1));
				u.setName(rs.getString(2));
				u.setExp(rs.getString(3));
				u.setSalary(rs.getString(4));
				
				user.add(u);
				
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		return user;
		
	}


	public void createUser(User u1) {
		
		String sql = "insert into users values (?, ?, ?, ?)";
		try{
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u1.getEmpid());
			ps.setString(2, u1.getName());
			ps.setString(3, u1.getExp());
			ps.setString(4, u1.getSalary());
			ps.executeUpdate();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
	}


	public void deleteUser(User u1) {
		
		String sql = "delete from users where u_id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u1.getEmpid());
			ps.executeUpdate();
			//ur.getUsers();
		}catch(Exception e){
			System.out.println(e);
		}
		
		
	}


	public void updateUser(User u1) {
		
		String sql = "update users set u_name=?, u_exp=?, u_sal=? where u_id=?";
		//update users set u_name='update test', u_exp='update test', u_sal='update test' where u_id = '?';
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u1.getName());
			ps.setString(2, u1.getExp());
			ps.setString(3, u1.getSalary());
			ps.setString(4, u1.getEmpid());
			ps.executeUpdate();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

}
