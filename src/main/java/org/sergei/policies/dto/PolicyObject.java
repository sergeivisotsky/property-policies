package org.sergei.policies.dto;

import java.util.List;

/**
 * @author Sergei Visotsky
 */
public class PolicyObject {

    private String objectName;
    private List<PolicySubObject> subObjects;

    public PolicyObject() {
    }

    public String getObjectName() {
        return objectName;
    }

    public List<PolicySubObject> getSubObjects() {
        return subObjects;
    }

    private PolicyObject(Builder builder) {
        objectName = builder.objectName;
        subObjects = builder.subObjects;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String objectName;
        private List<PolicySubObject> subObjects;

        private Builder() {
        }

        public Builder withObjectName(String val) {
            objectName = val;
            return this;
        }

        public Builder withSubObjects(List<PolicySubObject> val) {
            subObjects = val;
            return this;
        }

        public PolicyObject build() {
            return new PolicyObject(this);
        }
    }
}
