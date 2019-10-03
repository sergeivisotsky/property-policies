package org.sergei.policies.service;

import org.sergei.policies.dto.Policy;

import java.math.BigDecimal;

/**
 * @author Sergei Visotsky
 */
public interface PremiumCalculator {

    /**
     * Calculate premium
     *
     * @param policy with all the sub objects
     * @return calculated premium value
     */
    BigDecimal calculate(Policy policy);
}
