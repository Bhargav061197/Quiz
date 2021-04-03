package com.udaan.machine.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Type {
    A("a"),

    B("b"),

    C("c");

    String type;

    Type(String type) {
        this.type = type;
    }

    @JsonCreator
    public static Type fromString(String value) {
        Type type = null;
        try {
            type = Type.valueOf(value.toUpperCase());
        } catch (Exception e) {
            System.out.println(e);
        }
        return type;
    }

    @JsonValue
    public String getType() {
        return this.type != null ? this.toString().toLowerCase() : null;
    }
}
