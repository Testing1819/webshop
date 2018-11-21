package domain.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<Integer,Product> products = new HashMap<>();
    private Map<Integer,Integer> amounts = new HashMap<>();

    public Collection<CartItem> getItems() {
        ArrayList<CartItem> cartItems = new ArrayList<>();

        for (Integer productId : amounts.keySet()) {
            Product product = products.get(productId);
            int amount = amounts.get(productId);
            CartItem item = new CartItem(product.getName(), product.getDescription(), product.getPrice(), amount);
            cartItems.add(item);
        }

        return cartItems;
    }

    public void add (Product product, Integer amount) {
        amounts.put(product.getId(), amounts.getOrDefault(product.getId(), 0) + amount);
        products.put(product.getId(), product);
    }

}
