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

import edu.neu.CS5200.msn.ds.entity.Actor;

public class ActorManager {

	DataSource ds;

	public ActorManager() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx
					.lookup("java:comp/env/jdbc/MovieSocialNetworkDB");
			System.out.println(ds);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// createActor
	public void createActor(Actor newActor) {
		String sql = "insert into Actor values(?,?,?,?)";
		try {
			Connection conn = ds.getConnection();
			System.out.println("It's there");
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, newActor.getId());
			stmt.setString(2, newActor.getFirstName());
			stmt.setString(3, newActor.getLastName());
			stmt.setDate(4, newActor.getDateOfBirth());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// readALlActors
	public List<Actor> readAllActors() {
		List<Actor> Actors = new ArrayList<Actor>();
		String sql = "select * from Actor";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				Actor Actor = new Actor();
				Actor.setId(results.getString("id"));
				
				Actor.setFirstName(results.getString("firstname"));
				Actor.setLastName(results.getString("lastname"));
				
				Actor.setDateOfBirth(results.getDate("dateOfBirth"));
				Actors.add(Actor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Actors;
	}

	// readActor
	public Actor readActor(String id) {
		Actor Actor = new Actor();

		String sql = "select * from Actor where id = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				Actor.setId(result.getString("id"));
				Actor.setFirstName(result.getString("firstname"));
				Actor.setLastName(result.getString("lastname"));
				Actor.setDateOfBirth(result.getDate("dateOfBirth"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Actor;
	}

	// updateActor
	public void updateActor(String id, Actor Actor) {
		String sql = "update Actor set firstname=?, lastname=?, dateOfBirth=? where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, Actor.getFirstName());
			statement.setString(2, Actor.getLastName());
			statement.setDate(3, Actor.getDateOfBirth());
			statement.setString(4, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// deleteActor
	public void deleteActor(String id) {
		String sql = "delete from Actor where id=?";
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
