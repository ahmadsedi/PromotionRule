package com.ahmadsedi.promotion;

import java.util.List;
import java.util.Map;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 6/12/25
 * Time: 10:47 AM
 *
 * The {@code PromotionEngine} is the main class in promotion calculation task. It accepts a list of PromotionRule and
 * then provide a process method to calculate promotion value based on a scenario.
 *
 */

public class PromotionEngine {

    List<Sku> skus;
    List<PromotionRule> promotionRules;

    public PromotionEngine(List<Sku> skus, List<PromotionRule> promotionRules) {
        this.skus = skus;
        this.promotionRules = promotionRules;
    }

    /**
     * Returns the promotion value of a scenario based on the promotionsRules.
     *
     * @param scenario is a map of Character/Integer which represents a scenario
     * @return the value of promotion
     */
    public int process(Map<Character, Integer> scenario){
        int total = 0;
        for(PromotionRule promotionRule:promotionRules){
            total = total + promotionRule.consume(scenario);
        }
        for(Sku sku:skus){
            Integer number = scenario.get(sku.getUnit());
            if(number!=null){
                total= total + (number*sku.getPrice());
            }
        }
        return total;
    }


}
