package com.ahmadsedi.promotion;

import java.util.List;
import java.util.Map;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 6/12/25
 * Time: 11:35 AM
 *
 * The {@code SumItemsFixedPricePromotionRule} represents a rule of promotion: buy SKU 1 & SKU 2 for a fixed price
 * ( C + D = 30 )
 */

public class SumItemsFixedPricePromotionRule implements PromotionRule {
    List<Character> units;
    Integer value;

    public SumItemsFixedPricePromotionRule(List<Character> units, Integer value) {
        this.units = units;
        this.value = value;
    }

    public int consume(Map<Character, Integer> items) {
        Integer minOccurrence = Integer.MAX_VALUE;
        for (Character unit : units) {
            Integer occurrence = items.get(unit);
            if (occurrence == null) {
                minOccurrence=0;
                break;
            } else if (occurrence < minOccurrence) {
                minOccurrence = occurrence;
            }
        }
        if (minOccurrence > 0) {
            for (Character unit : units) {
                items.put(unit, items.get(unit) - minOccurrence);
            }
        }
        return minOccurrence * value;
    }
}

