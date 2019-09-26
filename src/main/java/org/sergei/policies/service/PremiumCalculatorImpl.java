package org.sergei.policies.service;

import org.sergei.policies.dto.Policy;
import org.sergei.policies.dto.PolicyObject;
import org.sergei.policies.dto.PolicySubObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Visotsky
 */
public class PremiumCalculatorImpl implements PremiumCalculator {

    public Double calculate(Policy policy) {
        List<PolicyObject> policyObjects = policy.getPolicyObjects();
        List<PolicySubObject> policySubObjects = new ArrayList<>();

        policyObjects.forEach(policyObject -> {
            List<PolicySubObject> subObjects = policyObject.getSubObjects();
            policySubObjects.addAll(subObjects);
        });

        return null;
    }
}
