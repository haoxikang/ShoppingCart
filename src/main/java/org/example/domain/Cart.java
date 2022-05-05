package org.example.domain;

import org.example.modual.Item;
import org.example.modual.Product;
import org.example.exception.ProductExceedsLimitException;
import org.example.exception.ProductExpiredException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private static final int MAX_QUANTITY_PER_PRODUCT = 99;
    private static final int PRICE_OF_10_DISCOUNT = 200;
    private static final String APPLE_ID = "1";

    private final List<Item> items;
    private float totalDiscount;
    private final Map<String, Float> productDiscount;

    public Cart() {
        items = new ArrayList<>();
        productDiscount = new HashMap<>();
        productDiscount.put(APPLE_ID, 0.1f);
    }

    public void addProductToCart(Product product) throws ProductExceedsLimitException, ProductExpiredException {
        if (product.getProductionExpiredDate().isAfter(LocalDate.now())) {
            throw new ProductExpiredException(product.getName() + "is expired");
        }

        Item item = findItemByProducts(product);
        if (item == null) {
            items.add(asAnewItem(product));
        } else {
            checkProductQuantity(item);
            increase(item);
        }
    }

    public void addItemNumberInCart(Item item, int quantity) throws ProductExceedsLimitException {
        if (quantity >= MAX_QUANTITY_PER_PRODUCT) {
            throw new ProductExceedsLimitException(item.getProduct().getName() + "exceeds the maximum number limit of 99");
        }

        item.setQuantity(quantity);
    }


    private Item findItemByProducts(Product product) {
        return items
                .stream()
                .filter(item -> item.getProduct() == product)
                .findFirst()
                .orElse(null);
    }

    private Item asAnewItem(Product product) {
        return new Item(product, 1, checkForDiscount(product));
    }

    private float checkForDiscount(Product product) {
        if (productDiscount.containsKey(product.getId())) {
            return productDiscount.get(product.getId());
        } else {
            return 1;
        }
    }

    private void increase(Item item) {
        item.setQuantity(item.getQuantity() + 1);
    }

    private void checkProductQuantity(Item item) throws ProductExceedsLimitException {
        if (item.getQuantity() >= MAX_QUANTITY_PER_PRODUCT) {
            throw new ProductExceedsLimitException(item.getProduct().getName() + "exceeds the maximum number limit of 99");
        }
    }

}
