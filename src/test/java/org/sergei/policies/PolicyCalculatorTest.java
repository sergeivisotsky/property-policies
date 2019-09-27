package org.sergei.policies;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.sergei.policies.dto.*;
import org.sergei.policies.service.PremiumCalculator;
import org.sergei.policies.service.PremiumCalculatorImpl;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Sergei Visotsky
 */
public class PolicyCalculatorTest {

    private PremiumCalculator premiumCalculator;

    public PolicyCalculatorTest() {
        premiumCalculator = new PremiumCalculatorImpl();
    }

    @Test
    public void calculateTest() {
        Policy policy = PolicyConstructor.constructPolicyStub();
        double premium = premiumCalculator.calculate(policy);
        System.out.println(premium);
    }

    @Test
    public void calculatePremiumFireTest() {
        PolicySubObject subObjectOne = PolicySubObject.newBuilder()
                .withRiskType(RiskType.FIRE)
                .withSubObjectName("TV")
                .withSumInsured(120.00)
                .build();
        PolicySubObject subObjectTwo = PolicySubObject.newBuilder()
                .withRiskType(RiskType.FIRE)
                .withSubObjectName("CAR")
                .withSumInsured(12009.10)
                .build();
        List<PolicySubObject> policySubObjects = ImmutableList.of(subObjectOne, subObjectTwo);
        double premiumFire = premiumCalculator.calculatePremiumFire(policySubObjects);
        assertEquals(276.2093, premiumFire, 0);
    }

    @Test
    public void calculatePremiumWaterTest() {
        PolicySubObject subObjectOne = PolicySubObject.newBuilder()
                .withRiskType(RiskType.WATER)
                .withSubObjectName("FRIDGE")
                .withSumInsured(300.00)
                .build();
        PolicySubObject subObjectTwo = PolicySubObject.newBuilder()
                .withRiskType(RiskType.WATER)
                .withSubObjectName("HOUSE")
                .withSumInsured(12032.190)
                .build();
        List<PolicySubObject> policySubObjects = ImmutableList.of(subObjectOne, subObjectTwo);
        double premiumWater = premiumCalculator.calculatePremiumWater(policySubObjects);
        assertEquals(601.6095, premiumWater, 0);
    }
}
