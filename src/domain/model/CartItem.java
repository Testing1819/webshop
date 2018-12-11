package domain.model;

public class CartItem extends Product {

    private Integer amount = 0;

    public CartItem(String title, String artist, String type, String genre, String description, double d, int amount) {
        super(0, title, artist, type, genre, description, d);
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

}
