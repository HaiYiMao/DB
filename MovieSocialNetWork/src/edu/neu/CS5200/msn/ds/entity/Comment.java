package edu.neu.CS5200.msn.ds.entity;

import java.sql.Date;

public class Comment {
	private String id;
	private String user;
	private String movie;
	private String comment;
	private Date date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Comment(String id, String user, String movie, String comment,
			Date date) {
		super();
		this.id = id;
		this.user = user;
		this.movie = movie;
		this.comment = comment;
		this.date = date;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", user=" + user + ", movie=" + movie
				+ ", comment=" + comment + ", date=" + date + "]";
	}

}
