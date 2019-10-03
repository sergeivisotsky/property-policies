package org.sergei.policies;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.sergei.policies.dto.PolicySubObject;
import org.sergei.policies.dto.RiskType;
import org.sergei.policies.service.RiskTypePremiumCalculator;
import org.sergei.policies.service.RiskTypePremiumCalculatorImpl;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Sergei Visotsky
 */
public class RiskTypePremiumCalculatorTest {

    private final RiskTypePremiumCalculator riskTypePremiumCalculator;

    public RiskTypePremiumCalculatorTest() {
        this.riskTypePremiumCalculator = new RiskTypePremiumCalculatorImpl();
    }

    /**
     * Test for {@link RiskTypePremiumCalculator#calculatePremiumFire(List)}
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
        BigDecimal expectedPremiumFire = BigDecimal.valueOf(276.2093);
        BigDecimal actualPremiumFire = riskTypePremiumCalculator.calculatePremiumFire(policySubObjects);
        assertEquals(expectedPremiumFire, actualPremiumFire);
    }

    /**
     * Test for {@link RiskTypePremiumCalculator#calculatePremiumWater(List)}
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
        BigDecimal expectedPremiumWater = BigDecimal.valueOf(601.6095);
        BigDecimal actualPremiumWater = riskTypePremiumCalculator.calculatePremiumWater(policySubObjects);
        assertEquals(expectedPremiumWater, actualPremiumWater);
    }
}
