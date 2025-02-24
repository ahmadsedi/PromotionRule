package com.ahmadsedi.promotion;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 6/12/25
 * Time: 11:42 AM
 *
 * The {@code Sku} represents a row of the starting setup table, to be used in calculation of promotion value in the
 * case of no-matched promotion rule.
 *
 */

public class Item {
    String name;
    Integer price;

    public Item(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
