package edu.neu.cs5200.model;

import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.*;


@Entity
@NamedQuery(name="Site.findAllSites", query="SELECT s FROM Site s")
@Table(name="site")
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Site {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@XmlAttribute
	private int id;
	
	@Column(name="name")
	@XmlAttribute
	private String name;
	
	@Column(name="latitude")
	@XmlAttribute
	private int latitude;
	
	@Column(name="longitude")
	@XmlAttribute
	private int longitude;
	
	@OneToMany(mappedBy="site")
	@XmlElement(name="tower")
	private List<Tower> towers;
	public Site() {
		super();
	}
	public Site(int id, String name, int latitude, int longitude) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public List<Tower> getTowers() {
		return towers;
	}
	public void setTowers(List<Tower> towers) {
		this.towers = towers;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
}
