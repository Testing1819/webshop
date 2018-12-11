package domain.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;

public class Order extends DatabaseModel {
    protected Integer orderId;
    protected String username;
    protected String date = LocalDate.now().toString();
    protected String title;
    protected String artist;
    protected double price;
    protected int amount;


    public Order() {

    }

    public Order(int productId, String username, String title, String artist, double d, int amount) {
        setId(productId);
        setUsername(username);
        setTitle(title);
        setArtist(artist);
        setPrice(d);
        setAmount(amount);
    }

    public Order(int productId, String username, String date, String title, String artist, double d, int amount) {
        setId(productId);
        setUsername(username);
        setDate(date);
        setTitle(title);
        setArtist(artist);
        setPrice(d);
        setAmount(amount);
    }
    public Order(String username,  String title, String artist, String type, String genre, String description, double d) {
        setUsername(username);
        setDate(date);
        setTitle(title);
        setArtist(artist);
        setPrice(d);
        setAmount(amount);
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return orderId;
    }
    public void setId(int productId) {
        this.orderId = productId;
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

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        if (date.isEmpty()) {
            throw new DomainException("No date given");
        }
        this.date = date;
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

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        if (amount<0) {
            throw new DomainException("Give a valid amount");
        }
        this.amount = amount;
    }

    @Override
    public String toString(){
        return getTitle() + ": " + " - " + getPrice();
    }

}
