package org.example.modual;

public class Item {
    private Product product;
    private int quantity;
    private float discount;

    public Item(Product product, int quantity, float discount) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
