package edu.neu.CS5200.msn.ds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.neu.CS5200.msn.ds.entity.Movie;

public class MovieManager {
 
    DataSource ds;
    public MovieManager(){
    	try {
  		Context ctx = new InitialContext();
  		ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MovieSocialNetworkDB");
  		System.out.println(ds);
  	  } catch (NamingException e) {
  		e.printStackTrace();
  	  }	
    }
    //createMovie
    public void createMovie (Movie newMovie)
    {
    	String sql = "insert into Movie values(?,?,?,?)";
    	try {
			Connection conn = ds.getConnection();
			System.out.println("It's there");
			PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.setString(1, newMovie.getId());
		    stmt.setString(2, newMovie.getTitle());
		    stmt.setString(3, newMovie.getPosterImage());
            stmt.setDate(4, newMovie.getReleaseDate());
		    stmt.executeUpdate();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }	
    
    	
    	
    //readALlMovies
	public List<Movie> readAllMovies()
	{
		List<Movie> movies = new ArrayList<Movie>();
		String sql = "select * from movie";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Movie movie = new Movie();
				movie.setId(results.getString("id"));
				movie.setTitle(results.getString("title"));
				movie.setPosterImage(results.getString("posterimage"));
				movie.setReleaseDate(results.getDate("releaseDate"));
				movies.add(movie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movies;
	}

    
    
    //readMovie
	public Movie readMovie(String id)
	{
		Movie movie = new Movie();
		
		String sql = "select * from Movie where id = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				movie.setId(result.getString("id"));
				movie.setTitle(result.getString("title"));
				movie.setPosterImage(result.getString("posterimage"));
				movie.setReleaseDate(result.getDate("releaseDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return movie;
	}

	//updateMovie
	public void updateMovie(String id, Movie movie)
	{
		String sql = "update movie set  title=?, posterimage=?, releaseDate=? where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, movie.getTitle());
			statement.setString(2, movie.getPosterImage());
			statement.setDate(3, movie.getReleaseDate());
			statement.setString(4, movie.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	
	
	//deleteMovie
	public void deleteMovie(String id)
	{
		String sql = "delete from Movie where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, id);
		    statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    
    



}
