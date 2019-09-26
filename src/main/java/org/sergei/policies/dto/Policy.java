package org.sergei.policies.dto;

import java.util.List;

/**
 * @author Sergei Visotsky
 */
public class Policy {
    private String policyNumber;
    private PolicyStatus policyStatus;
    private Double premium;
    private List<PolicyObject> policyObjects;

    public Policy() {
    }

    private Policy(Builder builder) {
        policyNumber = builder.policyNumber;
        policyStatus = builder.policyStatus;
        premium = builder.premium;
        policyObjects = builder.policyObjects;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public PolicyStatus getPolicyStatus() {
        return policyStatus;
    }

    public Double getPremium() {
        return premium;
    }

    public List<PolicyObject> getPolicyObjects() {
        return policyObjects;
    }

    public static final class Builder {
        private String policyNumber;
        private PolicyStatus policyStatus;
        private Double premium;
        private List<PolicyObject> policyObjects;

        private Builder() {
        }

        public Builder withPolicyNumber(String val) {
            policyNumber = val;
            return this;
        }

        public Builder withPolicyStatus(PolicyStatus val) {
            policyStatus = val;
            return this;
        }

        public Builder withPremium(Double val) {
            premium = val;
            return this;
        }

        public Builder withPolicyObjects(List<PolicyObject> val) {
            policyObjects = val;
            return this;
        }

        public Policy build() {
            return new Policy(this);
        }
    }
}
