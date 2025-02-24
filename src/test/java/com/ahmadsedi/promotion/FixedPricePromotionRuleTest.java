package com.ahmadsedi.promotion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 6/12/25
 * Time: 11:28 AM
 */

public class FixedPricePromotionRuleTest {

    static PromotionEngine promotionEngine ;

    @BeforeAll
    public static void setup(){
        Map<String, Item> merchandises = new HashMap<>();
        merchandises.put("A", new Item("A", 50));
        merchandises.put("B", new Item("B", 30));
        merchandises.put("C", new Item("C", 20));
        merchandises.put("D", new Item("D", 15));

        List<PromotionRule> promotionRules = new ArrayList<>();
        promotionRules.add(new NItemsFixedPricePromotionRule(3, "A", 130));

        promotionEngine = new PromotionEngine(merchandises, promotionRules);
    }

    @Test
    public void process_givenItemCompliedWithRule_returnAppliedRuleValue(){
        Map<String, Integer> basket = new HashMap<>();
        basket.put("A", 3);
        Assertions.assertEquals(130, promotionEngine.process(basket));
    }

    @Test
    public void process_givenEmptyBasket_returnZero(){
        Map<String, Integer> basket = new HashMap<>();
        Assertions.assertEquals(0, promotionEngine.process(basket));
    }

    @Test
    public void process_givenBasketNotCompliedWithRule_returnSummary(){
        Map<String, Integer> basket = new HashMap<>();
        basket.put("B", 1);
        Assertions.assertEquals(30, promotionEngine.process(basket));
    }
}
