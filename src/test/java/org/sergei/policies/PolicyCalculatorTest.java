package org.sergei.policies;

import org.junit.Before;
import org.junit.Test;
import org.sergei.policies.dto.Policy;
import org.sergei.policies.service.PremiumCalculator;
import org.sergei.policies.service.PremiumCalculatorImpl;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * @author Sergei Visotsky
 */
public class PolicyCalculatorTest {

    private PremiumCalculator premiumCalculator;

    @Before
    public void setUp() {
        this.premiumCalculator = new PremiumCalculatorImpl();
    }

    /**
     * Test for {@link PremiumCalculator#calculate(Policy)}
     */
    @Test
    public void calculateTest() {
        Policy policy = PolicyConstructor.constructPolicyStub();
        BigDecimal expectedPremium = BigDecimal.valueOf(9093.405454);
        BigDecimal actualPremium = premiumCalculator.calculate(policy);
        assertEquals(expectedPremium, actualPremium);
    }
}
