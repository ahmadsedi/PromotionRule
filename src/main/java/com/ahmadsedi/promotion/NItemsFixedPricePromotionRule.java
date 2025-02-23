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
    Integer number;
    Character unit;
    Integer value;

    public NItemsFixedPricePromotionRule(Integer number, Character unit, Integer value) {
        this.number = number;
        this.unit = unit;
        this.value = value;
    }

    public int consume(Map<Character, Integer> items) {
        if(items.size()==0){
            return 0;
        }
        Integer count = items.get(unit);
        if(count!=null && count >= number) {
            int newCount = count % number;
            if (newCount == 0) {
                items.remove(unit);
            } else {
                items.put(unit, count % number);
            }
            return (count / number) * value;
        }else{
            return 0;
        }
    }
}
