package com.ahmadsedi.promotion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 6/12/25
 * Time: 10:56 AM
 */

public class NilPromotionRuleTest {

    static PromotionEngine promotionEngine ;

    @BeforeAll
    public static void setup(){
        Map<String, Item> itemMap = new HashMap<>();
        itemMap.put("A", new Item("A", 50));
        itemMap.put("B", new Item("B", 30));
        itemMap.put("C", new Item("C", 20));
        itemMap.put("D", new Item("D", 15));

        List<PromotionRule> promotionRules = new ArrayList<>();
        promotionRules.add(new NilPromotionRule());

        promotionEngine = new PromotionEngine(itemMap, promotionRules);
    }

    @Test
    public void process_givenABasket_returnSummary(){
        Map<String, Integer> basket = new HashMap<>();
        basket.put("A", 1);
        basket.put("B", 1);
        basket.put("C", 1);
        Assertions.assertEquals(100, promotionEngine.process(basket));
    }

}
