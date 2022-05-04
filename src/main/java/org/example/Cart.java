package org.example;

import java.util.*;

public class Cart {
    private final List<ItemInfo> itemInfoList;
    private float totalDiscount;
    private final Map<String, Float> productDiscount;
    /**
     * default constructor
     **/
    public Cart() {
        itemInfoList = new ArrayList<>();
        productDiscount = new HashMap<>();
        productDiscount.put("1", 0.1f);
    }
    private ItemInfo asAnewItem(Product product, boolean flag) {
        float discount;
        if (productDiscount.containsKey(product.getId())) {
            discount = productDiscount.get(product.getId());
        } else {
            discount = 1;
        }
        ItemInfo itemInfo = new ItemInfo(product, 1, discount);
        if (flag) {
            itemInfoList.add(itemInfo);
        }
        return itemInfo;
    }
    /**
     * add a new product to card
     * if the quantity of the product over the 99 return the false
     * if success to add return true
     **/
    public Boolean add(Product product) {
        ItemInfo itemInfo = itemInfoList
                .stream()
                .filter(it -> it.getProduct().equals(product))
                .findFirst()
                .orElse(null);
        // there is no product in cart
        if (itemInfo == null) {
            asAnewItem(product, true);
            //items.add(asAnewItem(product,true));
        } else {
            if (itemInfo.getQuantity() + 1 >= 99) {
                return false;
            }
            itemInfo.setQuantity(itemInfo.getQuantity() + 1);
        }
        return true;
    }
    public Boolean add(Product product, int count) {
        ItemInfo itemInfo = itemInfoList
                .stream()
                .filter(it -> it.getProduct().equals(product))
                .findFirst()
                .orElse(null);
        // there is no product in cart
        if (itemInfo == null) {
            asAnewItem(product, true);
            //items.add(asAnewItem(product,true));
        } else {
            if (itemInfo.getQuantity() + count >= 99) {
                return false;
            }
            itemInfo.setQuantity(itemInfo.getQuantity() + count);
        }
        return true;
    }
    public void decreaseProduct() {
        //TODO will complete this method on next week
    }
}
