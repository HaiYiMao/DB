package edu.neu.CS5200.msn.ds.entity;

public class Cast {
	private String id;
	private String actor;
	private String movie;
	private String characterName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public Cast(String id, String actor, String movie, String characterName) {
		super();
		this.id = id;
		this.actor = actor;
		this.movie = movie;
		this.characterName = characterName;
	}
	public Cast() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Cast [id=" + id + ", actor=" + actor + ", movie=" + movie
				+ ", characterName=" + characterName + "]";
	}
	
	
	
}


