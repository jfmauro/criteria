package com.mauro.criteriahandling;

/**
 * Created by root on 19/11/16.
 */
public class Criteria {
    private String name;
    private String value;

    public Criteria(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
