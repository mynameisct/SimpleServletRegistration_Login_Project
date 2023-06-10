package com.rapportsoft.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validate {
	
	public static boolean isExistingUser(String email, String pass) throws ClassNotFoundException, SQLException {
		
		boolean status = false;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_form","root","root");
			
			PreparedStatement pst = con.prepareStatement("SELECT * FROM student WHERE email=? AND pass=?");
			
			pst.setString(1,email);
			pst.setString(2, pass);
			
			ResultSet rs = pst.executeQuery();
			
			status = rs.next();
			
} catch(Exception e1) {
	e1.printStackTrace();
}
		return status;
	}
}
