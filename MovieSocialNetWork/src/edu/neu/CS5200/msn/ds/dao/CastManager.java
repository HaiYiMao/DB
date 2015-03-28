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

import edu.neu.CS5200.msn.ds.entity.Cast;

public class CastManager {
	DataSource ds;

	public CastManager() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx
					.lookup("java:comp/env/jdbc/MovieSocialNetworkDB");
			System.out.println(ds);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// createCast
	public void createCast(Cast newCast) {
		String sql = "insert into Cast values(?,?,?,?)";
		try {
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(4, newCast.getId());
			stmt.setString(1, newCast.getCharacterName());
			stmt.setString(2, newCast.getMovie());
			stmt.setString(3, newCast.getActor());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// readALlCasts
	public List<Cast> readAllCastsForActor(String id)
 {
		List<Cast> Casts = new ArrayList<Cast>();
		String sql = "select * from Cast where actorid = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,id);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				Cast Cast = new Cast();
				Cast.setId(results.getString("id"));
				Cast.setMovie(results.getString("movieid"));
				Cast.setActor(results.getString("actorid"));
				Cast.setCharacterName(results.getString("characterName"));
				Casts.add(Cast);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Casts;
	}

	// readCast
	public List<Cast> readAllCastsForMovie(String movie)
 {
		List<Cast> Casts = new ArrayList<Cast>();
		String sql = "select * from Cast where movieid = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,movie);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				Cast Cast = new Cast();
				Cast.setId(results.getString("id"));
				Cast.setMovie(results.getString("movieid"));
				Cast.setActor(results.getString("actorid"));
				Cast.setCharacterName(results.getString("characterName"));
				Casts.add(Cast);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Casts;
	}

	
	public Cast readCastForId(String id)
	{
		Cast Cast = new Cast();
		
		String sql = "select * from Cast where id = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				Cast.setId(result.getString("id"));
				Cast.setMovie(result.getString("movieid"));
				Cast.setActor(result.getString("actorid"));
				Cast.setCharacterName(result.getString("characterName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return Cast;
	}
	
	// updateCast
	public void updateCast(String id, Cast Cast) {
		String sql = "update Cast set id=?, characterName=?, movieid=?, actorid=? where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, Cast.getId());
			statement.setString(2, Cast.getCharacterName());
			statement.setString(3, Cast.getMovie());
			statement.setString(4, Cast.getActor());
			statement.setString(5, Cast.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// deleteCast
	public void deleteCast(String id) {
		String sql = "delete from Cast where id=?";
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
