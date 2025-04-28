package com.example.courierservicedbmigrate.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attribute {
    @JsonProperty("barcode")
    private String barcode;
    @JsonProperty
    private Long taskId;

    public Attribute(String barcode, Long taskId) {
        this.barcode = barcode;
        this.taskId = taskId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public String getBarcode() {
        return barcode;
    }

    public Attribute(String barcode) {
        this.barcode = barcode;
    }
}
