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

public class TestPromotionEngineWithNItemsFixedPricePromotionRule {

    static PromotionEngine promotionEngine ;

    @BeforeAll
    public static void setup(){
        List<Sku> skus = new ArrayList<>();
        skus.add(new Sku('A', 50));
        skus.add(new Sku('B', 30));
        skus.add(new Sku('C', 20));
        skus.add(new Sku('D', 15));

        List<PromotionRule> promotionRules = new ArrayList<>();
        promotionRules.add(new NItemsFixedPricePromotionRule(3, 'A', 130));

        promotionEngine = new PromotionEngine(skus, promotionRules);
    }

    @Test
    public void process_matched_normal(){

        Map<Character, Integer> scenario = new HashMap<>();
        scenario.put('A', 3);
        Assertions.assertEquals(130, promotionEngine.process(scenario));
    }

    @Test
    public void process_empty_zero(){
        Map<Character, Integer> scenario = new HashMap<>();
        Assertions.assertEquals(0, promotionEngine.process(scenario));
    }

    @Test
    public void process_notmatched_30(){
        Map<Character, Integer> scenario = new HashMap<>();
        scenario.put('B', 1);
        Assertions.assertEquals(30, promotionEngine.process(scenario));
    }
}
