package org.sergei.policies.service;

import org.sergei.policies.dto.Policy;
import org.sergei.policies.dto.PolicyObject;
import org.sergei.policies.dto.PolicySubObject;
import org.sergei.policies.dto.RiskType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Visotsky
 */
public class PremiumCalculatorImpl implements PremiumCalculator {

    private static final Logger log = LoggerFactory.getLogger(PremiumCalculatorImpl.class);

    private Double coefficientFire = 0.013;
    private Double coefficientWater = 0.1;

    /**
     * {@link PremiumCalculator#calculate(Policy)}
     *
     * @return calculated premium value
     */
    @Override
    public double calculate(Policy policy) {

        List<PolicyObject> policyObjects = policy.getPolicyObjects();
        List<PolicySubObject> policySubObjects = new ArrayList<>();

        policyObjects.forEach(policyObject -> {
            List<PolicySubObject> subObjects = policyObject.getSubObjects();
            policySubObjects.addAll(subObjects);
        });
        double premiumFire = 0.0;
        double premiumWater = 0.0;
        for (PolicySubObject policySubObject : policySubObjects) {
            if (policySubObject.getRiskType().equals(RiskType.FIRE)) {
                premiumFire = calculatePremiumFire(policySubObjects);
            } else if (policySubObject.getRiskType().equals(RiskType.WATER)) {
                premiumWater = calculatePremiumWater(policySubObjects);
            }
        }
        return premiumFire + premiumWater;
    }

    /**
     * {@link PremiumCalculator#calculatePremiumFire(List)}
     *
     * @param policySubObjects all policy sub-objects
     * @return calculated premium fire
     */
    @Override
    public double calculatePremiumFire(List<PolicySubObject> policySubObjects) {
        double premiumFire = 0.0;
        for (PolicySubObject policySubObject : policySubObjects) {
            Double sumInsured = policySubObject.getSumInsured();
            if (sumInsured != null) {
                if (sumInsured > 100) {
                    coefficientFire = 0.023;
                }
                premiumFire = sumInsured * coefficientFire;
            } else {
                log.info("Sum insured cannot be null");
                throw new RuntimeException("Sum insured cannot be null");
            }
        }
        return premiumFire;
    }

    /**
     * {@link PremiumCalculator#calculatePremiumWater(List)}
     *
     * @param policySubObjects all policy sub-objects
     * @return calculated premium water
     */
    @Override
    public double calculatePremiumWater(List<PolicySubObject> policySubObjects) {
        double premiumWater = 0.0;
        for (PolicySubObject policySubObject : policySubObjects) {
            Double sumInsured = policySubObject.getSumInsured();
            if (sumInsured != null) {
                if (sumInsured >= 10) {
                    coefficientWater = 0.05;
                }
                premiumWater = sumInsured * coefficientWater;
            } else {
                log.info("Sum insured cannot be null");
                throw new RuntimeException("Sum insured cannot be null");
            }
        }
        return premiumWater;
    }
}
