package org.sergei.policies.service;

import org.sergei.policies.dto.PolicySubObject;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sergei Visotsky
 */
public interface RiskTypePremiumCalculator {
    /**
     * Method to calculate premium depending on the coefficients
     *
     * @param policySubObjects all policy sub-objects
     * @return calculated premium fire
     */
    BigDecimal calculatePremiumFire(List<PolicySubObject> policySubObjects);

    /**
     * Calculate premium water
     *
     * @param policySubObjects all policy sub-objects
     * @return calculated premium water
     */
    BigDecimal calculatePremiumWater(List<PolicySubObject> policySubObjects);
}
