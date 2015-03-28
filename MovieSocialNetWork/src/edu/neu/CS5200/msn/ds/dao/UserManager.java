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

import edu.neu.CS5200.msn.ds.entity.*;

public class UserManager {
    
	DataSource ds;
    public UserManager(){
       	try {
      		Context ctx = new InitialContext();
      		ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MovieSocialNetworkDB");
      		System.out.println(ds);
      	  } catch (NamingException e) {
      		e.printStackTrace();
      	  }	
    }
    //createUser
    public void createUser (User newUser)
    {
    	String sql = "insert into User values(?,?,?,?,?,?)";
    	try {
			Connection conn = ds.getConnection();
			System.out.println("It's there");
			PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.setString(1, newUser.getUsername());
		    stmt.setString(2, newUser.getPassword());
		    stmt.setString(3, newUser.getFirstName());
            stmt.setString(4, newUser.getLastName());
            stmt.setString(5, newUser.getEmail());
            stmt.setDate(6, newUser.getDateOfBirth());
            stmt.executeUpdate();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }	
    
    	
    	
    //readALlUsers
	public List<User> readAllUsers()
	{
		List<User> Users = new ArrayList<User>();
		String sql = "select * from User";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				User User = new User();
				User.setUsername(results.getString("username"));
				User.setPassword(results.getString("password"));
				User.setFirstName(results.getString("firstname"));
				User.setLastName(results.getString("lastname"));
				User.setEmail(results.getString("email"));
				User.setDateOfBirth(results.getDate("dateOfBirth"));
				Users.add(User);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Users;
	}

    
    
    //readUser
	public User readUser(String name)
	{
		User User = new User();
		
		String sql = "select * from User where username = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				User.setUsername(result.getString("username"));
				User.setPassword(result.getString("password"));
				User.setFirstName(result.getString("firstname"));
				User.setLastName(result.getString("lastname"));
				User.setEmail(result.getString("email"));
				User.setDateOfBirth(result.getDate("dateOfBirth"));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return User;
	}

	//updateUser
	public void updateUser(String username, User User)
	{
		String sql = "update User set password=?, firstname=?, lastname=?, email=?, dateOfBirth=? where username=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, User.getPassword());
			statement.setString(2, User.getFirstName());
			statement.setString(3, User.getLastName());
			statement.setString(4, User.getEmail());
			statement.setDate(5, User.getDateOfBirth());
			statement.setString(6, username);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	
	
	//deleteUser
	public void deleteUser(String username)
	{
		String sql = "delete from User where username=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,username);
		    statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    
 }
