package com.movies.movies;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(MoviesApplication.class, args);

		Connexion conect = new Connexion();
		conect.getInfo();
		
		MoviesController mc = new MoviesController();
		mc.getInfo();

	}

}
