package com.example.courierservicedbmigrate.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FinalMessage {
    @JsonProperty("EN")
    String en;
    @JsonProperty("RU")
    String ru;
    @JsonProperty("KK")
    String kk;

    public FinalMessage(String message) {
        this.en = message;
        this.ru = message;
        this.kk = message;
    }

    public String getEn() {
        return en;
    }

    public String getRu() {
        return ru;
    }

    public String getKk() {
        return kk;
    }
}
