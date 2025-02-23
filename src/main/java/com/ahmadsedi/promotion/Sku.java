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

public class Sku {
    Character unit;
    Integer price;

    public Sku(Character unit, Integer price) {
        this.unit = unit;
        this.price = price;
    }

    public Character getUnit() {
        return unit;
    }

    public void setUnit(Character unit) {
        this.unit = unit;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
