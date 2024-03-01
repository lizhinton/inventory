package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventoryTable")
public class inventory {
	//variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String productName;
	int quantity;
	double price;
	
	//constructors
	public inventory(){
		super();
	}
	
	public inventory(String n, int q, double p) {
		super();
		productName = n;
		quantity = q;
		price = p;
	}
	
	//getters
	public int getId(){
		return id;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	//setters
	public void setId(int i) {
		id = i;
	}
	
	public void setProductName(String n) {
		productName = n;
	}
	
	public void setQuantity(int q) {
		quantity = q;
	}
	
	public void setPrice(double p) {
		price = p;
	}
	
	//methods
}
