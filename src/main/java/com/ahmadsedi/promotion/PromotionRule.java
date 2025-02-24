package com.ahmadsedi.promotion;

import java.util.function.Predicate;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 6/12/25
 * Time: 11:04 AM
 *
 * PromotionRule is a basic interface to be used to define any
 * promotion rule in the future.
 *
 * @see NilPromotionRule
 */

public interface PromotionRule extends Predicate<String> {
    /**
     * Consumes a scenario and returns the promotion value of that scenario.
     *
     * @param itemName a item's name
     * @param number a number of item
     * @param itemPrice represent a price for one single item
     * @return a value of promotion
     */
    int consume(String itemName, Integer number, Integer itemPrice);

}
