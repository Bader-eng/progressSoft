package com.progressSoft.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyDTO {
    @JsonProperty("fCurrencyISOCode")
    private Long id;
    private String fromCurrencyISO;
    private String toCurrencyISO;
    private  Double amount;

    public CurrencyDTO() {

    }


    public String getFromCurrencyISO() {
        return fromCurrencyISO;
    }

    public void setFromCurrencyISO(String fromCurrencyISO) {
        this.fromCurrencyISO = fromCurrencyISO;
    }

    public String getToCurrencyISO() {
        return toCurrencyISO;
    }

    public void setToCurrencyISO(String toCurrencyISO) {
        this.toCurrencyISO = toCurrencyISO;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
