package org.example;

import java.util.Objects;

public class Product {
    private String name;
    private String id;
    private String price;
    private String type;
    private String productionDate;

    public Product(String name, String id, String price, String type, String productionDate) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.type = type;
        this.productionDate = productionDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name) && id.equals(product.id) && price.equals(product.price) && type.equals(product.type) && productionDate.equals(product.productionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, price, type, productionDate);
    }
}
