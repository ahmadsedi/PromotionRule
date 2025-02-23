package com.ahmadsedi.promotion;

import java.util.Map;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 6/12/25
 * Time: 11:04 AM
 * 1622
 *
 * The {@code SimplePromotionRule} represents a simple implementation of PromotionRule interface. This implmenentation
 * only counts the scenario elements and returns it as the result.
 */

public class SimplePromotionRule implements PromotionRule{
    @Override
    public int consume(Map<Character, Integer> scenario) {
        int total = 0;
        for(Character chars:scenario.keySet()){
            total++;
        }
        return total;
    }
}
