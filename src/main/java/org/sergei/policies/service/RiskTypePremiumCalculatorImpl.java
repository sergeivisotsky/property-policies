package org.sergei.policies.service;

import org.sergei.policies.dto.PolicySubObject;
import org.sergei.policies.utils.PropertyProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;

/**
 * @author Sergei Visotsky
 */
public class RiskTypePremiumCalculatorImpl implements RiskTypePremiumCalculator {

    private static final Logger log = LoggerFactory.getLogger(PremiumCalculatorImpl.class);

    private Double coefficientFire;
    private Double coefficientWater;

    @PostConstruct
    public void setUp() {
        Properties props = PropertyProvider.getPropertyFile();
        coefficientFire = Double.valueOf(props.getProperty("coefficient.fire"));
        coefficientWater = Double.valueOf(props.getProperty("coefficient.water"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal calculatePremiumFire(List<PolicySubObject> policySubObjects) {
        BigDecimal premiumFire = null;
        for (PolicySubObject policySubObject : policySubObjects) {
            Double sumInsured = policySubObject.getSumInsured();
            if (sumInsured != null) {
                if (sumInsured > 100) {
                    coefficientFire = 0.023;
                }
                premiumFire = BigDecimal.valueOf(sumInsured)
                        .multiply(BigDecimal.valueOf(coefficientFire));
                log.debug("Premium fire calculated: {} with coefficientFire: {}", premiumFire, coefficientFire);
            } else {
                throw new RuntimeException("Sum insured cannot be null");
            }
        }
        return premiumFire;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal calculatePremiumWater(List<PolicySubObject> policySubObjects) {
        BigDecimal premiumWater = null;
        for (PolicySubObject policySubObject : policySubObjects) {
            Double sumInsured = policySubObject.getSumInsured();
            if (sumInsured != null) {
                if (sumInsured >= 10) {
                    coefficientWater = 0.05;
                }
                premiumWater = BigDecimal.valueOf(sumInsured)
                        .multiply(BigDecimal.valueOf(coefficientWater));
                log.debug("Premium water calculated: {} with coefficientWater: {}", premiumWater, coefficientWater);
            } else {
                throw new RuntimeException("Sum insured cannot be null");
            }
        }
        return premiumWater;
    }
}
