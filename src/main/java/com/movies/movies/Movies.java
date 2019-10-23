package com.movies.movies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Movies {
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String director;
	private Integer year;
	
	public Movies(Long id, String title, String director, Integer year) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
		this.year = year;
	}
	



	public Movies() {
		
	};

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	




  
}
