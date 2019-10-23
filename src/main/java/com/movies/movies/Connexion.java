package com.movies.movies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {

	Connection cn;
	Statement st;
	ResultSet rs;	

	public Connexion() {

		try {
			Class.forName("org.h2.Driver");
			cn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
			st = cn.createStatement();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public void getInfo() {
				

		try {
			rs = st.executeQuery("SELECT * FROM MOVIES");

			while (rs.next()) {
				String title = rs.getString("title");
				String director =  rs.getString("director");
				Integer year =  rs.getInt("year");
				
				System.out.println();
				System.out.println("ID: " + rs.getInt("id")+"\t"+"Title: "+ title+
						"\t"+ "Director: " +  director + "\t"+ "Year: " + year );
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

