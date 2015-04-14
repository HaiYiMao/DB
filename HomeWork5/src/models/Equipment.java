package models;

import javax.persistence.*;



@Entity

public class Equipment {
    @Id
	private Integer id;
    private String name;
    private String brand;
    private String description;
    private String price;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="towerId")
    private Tower tower;
	public Equipment(Integer id, String name, String brand, String description,
			String price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.price = price;
		
	}
	
	public Equipment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Tower getTower() {
		return tower;
	}
	public void setTower(Tower tower) {
		this.tower = tower;
	}
 
	
}
