package org.sergei.policies.service;

import org.sergei.policies.dto.Policy;
import org.sergei.policies.dto.PolicyObject;
import org.sergei.policies.dto.PolicySubObject;
import org.sergei.policies.dto.RiskType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Visotsky
 */
public class PremiumCalculatorImpl implements PremiumCalculator {

    private static final Logger log = LoggerFactory.getLogger(PremiumCalculatorImpl.class);

    private final RiskTypePremiumCalculator riskTypePremiumCalculator;

    public PremiumCalculatorImpl() {
        this.riskTypePremiumCalculator = new RiskTypePremiumCalculatorImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal calculate(Policy policy) {

        List<PolicyObject> policyObjects = policy.getPolicyObjects();
        List<PolicySubObject> policySubObjects = new ArrayList<>();

        policyObjects.forEach(policyObject -> {
            List<PolicySubObject> subObjects = policyObject.getSubObjects();
            policySubObjects.addAll(subObjects);
        });
        BigDecimal premiumFire = null;
        BigDecimal premiumWater = null;
        for (PolicySubObject policySubObject : policySubObjects) {
            if (policySubObject.getRiskType().equals(RiskType.FIRE)) {
                log.debug("Premium fire handled");
                premiumFire = riskTypePremiumCalculator.calculatePremiumFire(policySubObjects);
            } else if (policySubObject.getRiskType().equals(RiskType.WATER)) {
                log.debug("Premium fire handled");
                premiumWater = riskTypePremiumCalculator.calculatePremiumWater(policySubObjects);
            }
        }
        if (premiumFire != null && premiumWater != null) {
            return premiumFire.add(premiumWater);
        } else {
            log.error("Premium fire or premium water is null");
            return BigDecimal.ZERO;
        }
    }
}
