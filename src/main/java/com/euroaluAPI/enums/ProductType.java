package com.euroaluAPI.enums;

public enum ProductType {
    TIEU_BIEU(1),
    NOI_BAT(2),
    MOI(3);

    private final int value;

    ProductType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ProductType fromValue(int value) {
        for (ProductType type : ProductType.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}