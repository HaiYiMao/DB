package edu.neu.cs5200.ispot.model;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="User")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type")
public class User {

	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	@Id
	protected Integer Id;
	protected String Password;
	protected String Firstname;
	protected String Lastname;
	protected String Email;
	protected String Username;
	protected String Type;

	//UserSubscribeSpot
	// ManyToMany Relation
	// Owning Side
	// List<Spot>
	@ManyToMany
	@JoinTable(name="UserSubscribeSpot",
			joinColumns=
            @JoinColumn(name="User"),
       inverseJoinColumns=
            @JoinColumn(name="Spot"))
	protected List<Spot> spots;
	
	//UsershareInformation
	// ManyToMany Relation
	// Owning Side
	//List<Information>
	@ManyToMany
	@JoinTable(name="Share",
			joinColumns=
            @JoinColumn(name="User"),
       inverseJoinColumns=
       @JoinColumn(name="Info"))
	protected List<Information> informations;
	
   //FollowedUser
   // Owning side
   //ManyToMany Relation
   //List<User>
	@ManyToMany
	@JoinTable(name="UserFollowUser",
			joinColumns=
            @JoinColumn(name="Following"),
       inverseJoinColumns=
       @JoinColumn(name="Followed"))
	protected List<User> followedUsers;
	
	  //FollowingUser
	  // Owning side
	  //ManyToMany Relation	
	@ManyToMany(mappedBy="followedUsers")
	protected List<User> followingUsers;
	
	//
	@OneToMany(mappedBy="user")
	protected List<Comment> comments;
	
// General Methods

	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public User(Integer id, String password, String firstname, String lastname,
			String email,String username, String type) {
		super();
		Id = id;
		Password = password;
		Firstname = firstname;
		Lastname = lastname;
		Email = email;
	    Username = username;
	    Type = type;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
// General Method
	public List<Spot> getSpots() {
		return spots;
	}
	public void setSpots(List<Spot> spots) {
		this.spots = spots;
	}
	public List<Information> getInformations() {
		return informations;
	}
	public void setInformations(List<Information> informations) {
		this.informations = informations;
	}
	public List<User> getFollowedUsers() {
		return followedUsers;
	}
	public void setFollowedUsers(List<User> followedUsers) {
		this.followedUsers = followedUsers;
	}
	public List<User> getFollowingUsers() {
		return followingUsers;
	}
	public void setFollowingUsers(List<User> followingUsers) {
		this.followingUsers = followingUsers;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}




}
