package domain.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Product extends DatabaseModel {
	protected Integer productId;
	protected String title;
	protected String description;
	protected double price;
	protected String type;
	protected String genre;
	protected String artist;
	
	public Product() {
		
	}
	
	public Product(int productId, String title, String artist, String type, String genre, String description, double d) {
		setId(productId);
		setTitle(title);
		setDescription(description);
		setPrice(d);
		setType(type);
		setGenre(genre);
		setArtist(artist);
	}
	public Product(String title, String artist, String type, String genre, String description, double d) {
		setTitle(title);
		setDescription(description);
		setPrice(d);
	}

	public int getId() {
		return productId;
	}
	public void setId(int productId) {
		this.productId = productId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		if (title.isEmpty()) {
			throw new DomainException("No title given");
		}
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		if (artist.isEmpty()) {
			throw new DomainException("No artist given");
		}
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		if (genre.isEmpty()) {
			throw new DomainException("No genre given");
		}
		this.genre = genre;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		if (type.isEmpty()) {
			throw new DomainException("No type given");
		}
		this.type = type;
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
		return getTitle() + ": " + getDescription() + " - " + getPrice();
	}
	
}
