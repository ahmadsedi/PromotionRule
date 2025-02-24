package com.ahmadsedi.promotion;

import java.util.List;
import java.util.Map;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 6/12/25
 * Time: 10:47 AM
 * <p>
 * The {@code PromotionEngine} is the main class in promotion calculation task. It accepts a list of PromotionRule and
 * then provide a process method to calculate promotion value based on a scenario.
 */

public class PromotionEngine {

    private Map<String, Item> itemMap;
    private List<PromotionRule> promotionRules;

    public PromotionEngine(Map<String, Item> itemMap, List<PromotionRule> promotionRules) {
        this.itemMap = itemMap;
        this.promotionRules = promotionRules;
    }

    /**
     * Returns the promotion value of a scenario based on the promotionsRules.
     *
     * @param basket is a map of Character/Integer which represents a scenario
     * @return the value of promotion
     */
    public int process(Map<String, Integer> basket) {
        int rulesAppliedSum = basket.keySet().stream().filter(c -> promotionRules.stream().anyMatch(rule -> rule.test(c))).mapToInt(c -> promotionRules.stream().mapToInt(r -> r.consume(c, basket.get(c), itemMap.get(c).getPrice())).sum()).sum();
        int rulesNotAppliedSum = basket.keySet().stream().filter(c -> promotionRules.stream().noneMatch(rule -> rule.test(c))).mapToInt(c -> itemMap.get(c).getPrice() * basket.get(c)).sum();
        return rulesAppliedSum + rulesNotAppliedSum;
    }


}
