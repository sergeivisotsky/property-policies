package org.sergei.policies.service;

import org.sergei.policies.dto.Policy;

/**
 * @author Sergei Visotsky
 */
public interface PremiumCalculator {
    Double calculate(Policy policy);
}
