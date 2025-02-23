package com.ahmadsedi.promotion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 6/12/25
 * Time: 11:36 AM
 */

public class TestPromotionEngineWithSumItemsFixedPricePromotionRule {

    static PromotionEngine promotionEngine ;

    @BeforeAll
    public static void setup(){
        List<Sku> skus = new ArrayList<>();
        skus.add(new Sku('A', 50));
        skus.add(new Sku('B', 30));
        skus.add(new Sku('C', 20));
        skus.add(new Sku('D', 15));

        List<PromotionRule> promotionRules = new ArrayList<>();
        promotionRules.add(new SumItemsFixedPricePromotionRule(Arrays.asList('C', 'D'), 30));

        promotionEngine = new PromotionEngine(skus, promotionRules);
    }

    @Test
    public void process_empty_zero(){
        Map<Character, Integer> scenario = new HashMap<>();
        Assertions.assertEquals(0, promotionEngine.process(scenario));
    }

    @Test
    public void process_matched_30(){
        Map<Character, Integer> scenario = new HashMap<>();
        scenario.put('C', 1);
        scenario.put('D', 1);
        Assertions.assertEquals(30, promotionEngine.process(scenario));
    }

    @Test
    public void process_mixed_30(){
        Map<Character, Integer> scenario = new HashMap<>();
        scenario.put('C', 2);
        scenario.put('D', 1);
        Assertions.assertEquals(50, promotionEngine.process(scenario));
    }
}
