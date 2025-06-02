package Com.Sandy.Models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, CartItem> cartItems = new HashMap<>();

   

    public void addItem(CartItem item) {
        if (cartItems.containsKey(item.getMenuId())) {
            CartItem existing = cartItems.get(item.getMenuId());
            existing.setQuantity(existing.getQuantity() + item.getQuantity());
        } else {
            cartItems.put(item.getMenuId(), item);
        }
    }

    public void updateItem(int menuId, int quantity) {
        if (cartItems.containsKey(menuId)) {
            if (quantity <= 0) {
                cartItems.remove(menuId);
            } else {
                cartItems.get(menuId).setQuantity(quantity);
            }
        }
    }

    public void removeItem(int menuId) {
        cartItems.remove(menuId);
    }

    public void clear() {
        cartItems.clear();
    }

    public Map<Integer, CartItem> getItems() {
        return cartItems;
    }

    public float getTotal() {
        float total = 0;
        for (CartItem item : cartItems.values()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }
}
