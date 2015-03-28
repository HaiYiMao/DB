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

import edu.neu.CS5200.msn.ds.entity.Comment;

public class CommentManager {
	DataSource ds;

	public CommentManager() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx
					.lookup("java:comp/env/jdbc/MovieSocialNetworkDB");
			System.out.println(ds);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// createComment
	public void createComment(Comment newComment) {
		String sql = "insert into Comment values(?,?,?,?,?)";
		try {
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, newComment.getId());
			stmt.setString(2, newComment.getComment());
			stmt.setDate(3, newComment.getDate());
			stmt.setString(4, newComment.getUser());
			stmt.setString(5, newComment.getMovie());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// readALlComments
	public List<Comment> readAllCommentsForUsername(String username)
 {
		List<Comment> Comments = new ArrayList<Comment>();
		String sql = "select * from Comment where user = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,username);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				Comment Comment = new Comment();
				Comment.setId(results.getString("id"));
				Comment.setComment(results.getString("comment"));
				Comment.setUser(results.getString("user"));
				Comment.setMovie(results.getString("movie"));
				Comment.setDate(results.getDate("date"));
				Comments.add(Comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Comments;
	}

	// readComment
	public List<Comment> readAllCommentsForMovie(String movie)
 {
		List<Comment> Comments = new ArrayList<Comment>();
		String sql = "select * from Comment where movie = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,movie);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				Comment Comment = new Comment();
				Comment.setId(results.getString("id"));
				Comment.setComment(results.getString("comment"));
				Comment.setUser(results.getString("user"));
				Comment.setMovie(results.getString("movie"));
				Comment.setDate(results.getDate("date"));
				Comments.add(Comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Comments;
	}

	
	public Comment readCommentForId(String id)
	{
		Comment comment = new Comment();
		
		String sql = "select * from Comment where id = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				comment.setId(result.getString("id"));
				comment.setUser(result.getString("user"));
				comment.setMovie(result.getString("movie"));
				comment.setDate(result.getDate("date"));
				comment.setComment(result.getString("comment"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return comment;
	}
	
	// updateComment
	public void updateComment(String id, Comment Comment) {
		String sql = "update Comment set comment=?, date=?, user=?, movie=? where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(5, Comment.getId());
			statement.setString(1, Comment.getComment());
			statement.setDate(2, Comment.getDate());
			statement.setString(3, Comment.getUser());
			statement.setString(4, Comment.getMovie());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// deleteComment
	public void deleteComment(String id) {
		String sql = "delete from Comment where id=?";
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
