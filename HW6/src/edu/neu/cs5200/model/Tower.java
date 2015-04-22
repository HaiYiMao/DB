package edu.neu.cs5200.model;

import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

import edu.neu.cs5200.model.Site;
import edu.neu.cs5200.model.Equipment;

@Entity
@Table(name="tower")
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Tower {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @XmlAttribute
	private int id;
	
	@Column(name="name")
    @XmlAttribute
	private String name;
	
	@Column(name="height")
	@XmlAttribute
	private int height;
	
	@Column(name="sides")
	@XmlAttribute
	private int sides;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "siteId")
	@XmlTransient
	private Site site;
	
	
	@OneToMany(mappedBy = "tower", cascade=CascadeType.ALL, orphanRemoval=true)
	@XmlElement(name="equipment")
	private List<Equipment> equipments;
	
	public Tower() {
		super();
	}
	public Tower(int id, String name, int height, int sides) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.sides = sides;
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
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getSides() {
		return sides;
	}
	public void setSides(int sides) {
		this.sides = sides;
	}
	public List<Equipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
}