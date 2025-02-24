package com.ahmadsedi.promotion;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 6/12/25
 * Time: 11:04 AM
 *
 * The {@code SimplePromotionRule} represents a simple implementation of PromotionRule interface. This implmenentation
 * only counts the scenario elements and returns it as the result.
 */

public class NilPromotionRule implements PromotionRule {

    @Override
    public int consume(String itemName, Integer number, Integer itemPrice) {
        return 0;
    }

    @Override
    public boolean test(String character) {
        return false;
    }
}
