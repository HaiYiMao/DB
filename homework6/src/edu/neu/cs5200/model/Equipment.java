package edu.neu.cs5200.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

import edu.neu.cs5200.model.Tower;

@Entity
@Table(name="equipment")
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Equipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @XmlAttribute
	private int id;
	
	@Column(name="name")
    @XmlAttribute
	private String name;
	
	@Column(name="brand")
	@XmlAttribute
	private String brand;
	
	@Column(name="description")
	@XmlAttribute
	private String description;
	
	@Column(name="price")
	@XmlAttribute
	private int price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "towerId")
	@XmlTransient
	private Tower tower;
	public Equipment() {
		super();
	}
	public Equipment(int id, String name, String brand, String description,
			int price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.price = price;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}

