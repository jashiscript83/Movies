package com.movies.movies;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class MoviesController {

	Connection cn;
	Statement st;
	ResultSet rs;

	public MoviesController() {

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

	@GetMapping("/movies")
	public Map<String, ArrayList<String>> getInfo() throws SQLException {

		Map<String, ArrayList<String>> map = new LinkedHashMap<>();

		ArrayList<String> listTitle = new ArrayList<String>();
		ArrayList<String> listDirector = new ArrayList<String>();
		ArrayList<String> listYear = new ArrayList<String>();
		ArrayList<String> listUrl = new ArrayList<String>();

		File robocop = new File("https://images-na.ssl-images-amazon.com/images/I/51COuEYOmJL._SY445_.jpg");
		File gremlins = new File("https://resizing.flixster.com/7gKD95TjCKqC4k8pvAHPinTaKvo=/206x305/v1.bTsxMTE3MDc5NDtqOzE4MjY0OzEyMDA7ODAwOzEyMDA");
		File starWars = new File("https://images-na.ssl-images-amazon.com/images/I/51zRGNNUXqL._SY445_.jpg");		
		File theFly = new File("https://upload.wikimedia.org/wikipedia/en/thumb/a/aa/Fly_poster.jpg/220px-Fly_poster.jpg");
		File goonies = new File("http://t1.gstatic.com/images?q=tbn:ANd9GcTg2ECQIB3x6ryjJKlDea9uDp-ui5qChDa9U7I3itZgcc74mAXH");
		File bladeRunner = new File("https://is5-ssl.mzstatic.com/image/thumb/Video113/v4/c6/40/15/c640156c-0603-7dba-bb19-734c8f2c192e/pr_source.lsr/268x0w.jpg");
		File karate = new File("https://img03.mgo-images.com/image/thumbnail?id=1MV131e4ca183452260de439427c71ec3cf&ql=70&sizes=310x465");
		File rambo = new File("https://upload.wikimedia.org/wikipedia/en/thumb/d/d6/First_blood_poster.jpg/220px-First_blood_poster.jpg");
		File topGun = new File("https://pics.filmaffinity.com/Top_Gun_dolos_del_aire-784306900-large.jpg");
		File willow = new File("https://musicart.xboxlive.com/7/de5e0900-0000-0000-0000-000000000002/504/image.jpg?w=1920&h=1080");
		
		
		
		listUrl.add(gremlins.toString());
		listUrl.add(starWars.toString());
		listUrl.add(theFly.toString());
		listUrl.add(goonies.toString());
		listUrl.add(bladeRunner.toString());
		listUrl.add(karate.toString());
		listUrl.add(rambo.toString());
		listUrl.add(robocop.toString());
		listUrl.add(topGun.toString());
		listUrl.add(willow.toString());

		rs = st.executeQuery("SELECT * FROM MOVIES");

		while (rs.next()) {

			String title = rs.getString("title");
			String director = rs.getString("director");
			Integer year = rs.getInt("year");

			listTitle.add(title);
			listDirector.add(director);

			listYear.add(year.toString());

			map.put("director", listTitle);
			map.put("title", listDirector);
			map.put("year", listYear);

			System.out.println(map);

		}
		map.put("url", listUrl);

		return map;

	}

}
