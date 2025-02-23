package com.ahmadsedi.promotion;

import java.util.Map;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 6/12/25
 * Time: 11:04 AM
 *
 * PromotionRule is a basic interface to be used to define any
 * promotion rule in the future.
 *
 * @see SimplePromotionRule
 */

public interface PromotionRule {
    /**
     * Consumes a scenario and returns the promotion value of that scenario.
     *
     * @param scenario a promotion scenario
     * @return a value of promotion
     */
    int consume(Map<Character, Integer> scenario);
}
