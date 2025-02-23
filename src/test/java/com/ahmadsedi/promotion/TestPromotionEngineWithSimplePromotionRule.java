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

public class TestPromotionEngineWithSimplePromotionRule {

    static PromotionEngine promotionEngine ;

    @BeforeAll
    public static void setup(){
        List<Sku> skus = new ArrayList<>();
        skus.add(new Sku('A', 50));
        skus.add(new Sku('B', 30));
        skus.add(new Sku('C', 20));
        skus.add(new Sku('D', 15));

        List<PromotionRule> promotionRules = new ArrayList<>();
        promotionRules.add(new SimplePromotionRule());

        promotionEngine = new PromotionEngine(skus, promotionRules);
    }

    @Test
    public void process_normal_normal(){

        Map<Character, Integer> scenario = new HashMap<>();
        scenario.put('A', 1);
        scenario.put('B', 1);
        scenario.put('C', 1);
        Assertions.assertEquals(103, promotionEngine.process(scenario));
    }

}
