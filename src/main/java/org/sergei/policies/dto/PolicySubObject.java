package org.sergei.policies.dto;

/**
 * @author Sergei Visotsky
 */
public class PolicySubObject {
    private String subObjectName;
    private Double sumInsured;
    private RiskType riskType;

    public PolicySubObject() {
    }

    private PolicySubObject(Builder builder) {
        subObjectName = builder.subObjectName;
        sumInsured = builder.sumInsured;
        riskType = builder.riskType;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getSubObjectName() {
        return subObjectName;
    }

    public Double getSumInsured() {
        return sumInsured;
    }

    public RiskType getRiskType() {
        return riskType;
    }

    public static final class Builder {
        private String subObjectName;
        private Double sumInsured;
        private RiskType riskType;

        private Builder() {
        }

        public Builder withSubObjectName(String val) {
            subObjectName = val;
            return this;
        }

        public Builder withSumInsured(Double val) {
            sumInsured = val;
            return this;
        }

        public Builder withRiskType(RiskType val) {
            riskType = val;
            return this;
        }

        public PolicySubObject build() {
            return new PolicySubObject(this);
        }
    }
}
