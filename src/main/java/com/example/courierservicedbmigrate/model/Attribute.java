package com.example.courierservicedbmigrate.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attribute {
    @JsonProperty("barcode")
    private String barcode;

    public String getBarcode() {
        return barcode;
    }

    public Attribute(String barcode) {
        this.barcode = barcode;
    }
}
