package com.ahmadsedi.promotion;

import java.util.Map;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 6/12/25
 * Time: 11:24 AM
 *
 * The {@code NItemsFixedPricePromotionRule} represents a rule of promotion: buy 'n' items of a SKU for a fixed price
 * (3 A's for 130)
 */

public class NItemsFixedPricePromotionRule implements PromotionRule{
    private final Integer number;
    private final String name;
    private final Integer value;

    public NItemsFixedPricePromotionRule(Integer number, String name, Integer value) {
        this.number = number;
        this.name = name;
        this.value = value;
    }

    @Override
    public int consume(String itemName, Integer number, Integer itemPrice) {
        return (number/this.number)*value+(number%this.number)*itemPrice;
    }

    @Override
    public boolean test(String name) {
        return this.name.equals(name);
    }
}
