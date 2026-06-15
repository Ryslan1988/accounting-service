package by.javaguru.jdmik12.accountingservice.model.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ServiceType {
    ACCOUNTING("ACCOUNTING"),

    RESOURCES("RESOURCES"),

    SECURITY("SECURITY"),

    PROFILER("PROFILER"),

    NOTIFICATION("NOTIFICATION");

    private final String value;

    ServiceType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static ServiceType fromValue(String value) {
        for (ServiceType b : ServiceType.values()) {
            if (b.value.equalsIgnoreCase(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected ServiceType value '" + value + "'");
    }
}
