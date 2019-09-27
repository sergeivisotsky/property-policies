package org.sergei.policies;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.sergei.policies.dto.Policy;
import org.sergei.policies.dto.PolicySubObject;
import org.sergei.policies.dto.RiskType;
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

    /**
     * Test for {@link PremiumCalculator#calculate(Policy)}
     */
    @Test
    public void calculateTest() {
        Policy policy = PolicyConstructor.constructPolicyStub();
        double premium = premiumCalculator.calculate(policy);
        assertEquals(9093.405454, premium, 0);
    }

    /**
     * Test for {@link PremiumCalculator#calculatePremiumFire(List)}
     */
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

    /**
     * Test for {@link PremiumCalculator#calculatePremiumWater(List)}
     */
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
