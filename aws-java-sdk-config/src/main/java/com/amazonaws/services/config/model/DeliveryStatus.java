/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.config.model;

/**
 * Delivery Status
 */
public enum DeliveryStatus {
    
    Success("Success"),
    Failure("Failure"),
    Not_Applicable("Not_Applicable");

    private String value;

    private DeliveryStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    /**
     * Use this in place of valueOf.
     *
     * @param value
     *            real value
     * @return DeliveryStatus corresponding to the value
     */
    public static DeliveryStatus fromValue(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        
        } else if ("Success".equals(value)) {
            return DeliveryStatus.Success;
        } else if ("Failure".equals(value)) {
            return DeliveryStatus.Failure;
        } else if ("Not_Applicable".equals(value)) {
            return DeliveryStatus.Not_Applicable;
        } else {
            throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
        }
    }
}
    