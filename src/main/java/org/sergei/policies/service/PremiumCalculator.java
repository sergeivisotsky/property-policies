package org.sergei.policies.service;

import org.sergei.policies.dto.PolicySubObject;
import org.sergei.policies.dto.Policy;

import java.util.List;

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
    double calculate(Policy policy);

    /**
     * Method to calculate premium depending on the coefficients
     *
     * @param policySubObjects all policy sub-objects
     * @return calculated premium fire
     */
    double calculatePremiumFire(List<PolicySubObject> policySubObjects);

    /**
     * Calculate premium water
     *
     * @param policySubObjects all policy sub-objects
     * @return calculated premium water
     */
    double calculatePremiumWater(List<PolicySubObject> policySubObjects);

}
