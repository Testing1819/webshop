package domain.model;

public class CartItem extends Product {

    private Integer amount = 0;

    public CartItem(String name, String description, double price, int amount) {
        super(0, name, description, price);
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

}
