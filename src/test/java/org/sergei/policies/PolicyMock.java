package org.sergei.policies;

import com.google.common.collect.ImmutableList;
import org.sergei.policies.dto.*;

import java.util.List;

/**
 * Helper test class to construct complex policy object
 *
 * @author Sergei Visotsky
 */
class PolicyMock {

    /**
     * So that it was unable to create class instances
     */
    private PolicyMock() {
    }

    /**
     * Construct the whole policy for test purposes only
     *
     * @return Constructed {@link Policy}
     */
    static Policy constructPolicyStub() {
        List<PolicyObject> policyObjects = constructPolicyObjects();

        return Policy.newBuilder()
                .withPolicyNumber("LV19-07-100000-1")
                .withPolicyStatus(PolicyStatus.APPROVED)
                .withPremium(1400.22)
                .withPolicyObjects(policyObjects)
                .build();
    }

    /**
     * Construct policy object of all subObjects
     *
     * @return {@link List} of all policy objects {@link PolicyObject}
     */
    private static List<PolicyObject> constructPolicyObjects() {
        List<PolicySubObject> flatPolicySubObjects = constructFlatPolicySubObjects();
        List<PolicySubObject> carPolicySubObjects = constructCarPolicySubObjects();

        PolicyObject carPolicyObject = PolicyObject.newBuilder()
                .withObjectName("Car")
                .withSubObjects(carPolicySubObjects)
                .build();
        PolicyObject flatPolicyObject = PolicyObject.newBuilder()
                .withObjectName("A flat")
                .withSubObjects(flatPolicySubObjects)
                .build();
        return ImmutableList.of(flatPolicyObject, carPolicyObject);
    }

    /**
     * Construct flat policy sub objects
     *
     * @return @return {@link List} of all policy objects {@link PolicySubObject}
     */
    private static List<PolicySubObject> constructFlatPolicySubObjects() {
        PolicySubObject flatSubObjectOne = PolicySubObject.newBuilder()
                .withRiskType(RiskType.FIRE)
                .withSubObjectName("TV")
                .withSumInsured(120.00)
                .build();
        PolicySubObject flatSubObjectTwo = PolicySubObject.newBuilder()
                .withRiskType(RiskType.WATER)
                .withSubObjectName("CAR")
                .withSumInsured(12009.10)
                .build();
        return ImmutableList.of(flatSubObjectOne, flatSubObjectTwo);
    }

    /**
     * Construct car policy sub objects
     *
     * @return @return {@link List} of all policy objects {@link PolicySubObject}
     */
    private static List<PolicySubObject> constructCarPolicySubObjects() {
        PolicySubObject carSubObjectOne = PolicySubObject.newBuilder()
                .withRiskType(RiskType.WATER)
                .withSubObjectName("WINDOW")
                .withSumInsured(1450.00)
                .build();
        PolicySubObject carSubObjectTwo = PolicySubObject.newBuilder()
                .withRiskType(RiskType.FIRE)
                .withSubObjectName("HOUSE")
                .withSumInsured(124567.1980)
                .build();
        return ImmutableList.of(carSubObjectOne, carSubObjectTwo);
    }
}
