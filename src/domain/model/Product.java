package domain.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Product extends DatabaseModel {
	protected Integer productId;
	protected String name;
	protected String description;
	protected double price;
	
	public Product() {
		
	}
	
	public Product(int productId, String name, String description, double d) {
		setId(productId);
		setName(name);
		setDescription(description);
		setPrice(d);
	}
	public Product(String name, String description, double d) {
		setName(name);
		setDescription(description);
		setPrice(d);
	}

	public int getId() {
		return productId;
	}
	public void setId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name.isEmpty()) {
			throw new DomainException("No name given");
		}
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		if (description.isEmpty()) {
			throw new DomainException("No description given");
		}
		
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if (price<0) {
			throw new DomainException("Give a valid price");
		}
		this.price = price;
	}
	public void setPrice(String price) {
		if (price.isEmpty()) {
			throw new DomainException("No price given");
		}
		setPrice(Double.valueOf(price));
	}
	
	@Override
	public String toString(){
		return getName() + ": " + getDescription() + " - " + getPrice();
	}
	
}
