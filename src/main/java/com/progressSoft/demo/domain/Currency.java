package com.progressSoft.demo.domain;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.boot.internal.StandardEntityNotFoundDelegate;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.time.LocalDateTime;

@Entity
@Validated
public class Currency extends StandardEntityNotFoundDelegate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime DealTimestamp;
    @NotNull
    @Length(min = 3,max = 3,message = "name of currency not correct")
   private String fromCurrencyISO;
    @NotNull
    @Length(min = 3,max = 3,message = "name of currency not correct")
   private String toCurrencyISO;

    @DecimalMax("100000000000.0") @DecimalMin("0.0")
    private  Double amount;


    public Currency(Long id, LocalDateTime dealTimestamp, String fromCurrencyISO, String toCurrencyISO, Double amount) {
        this.id = id;
        DealTimestamp = dealTimestamp;
        this.fromCurrencyISO = fromCurrencyISO;
        this.toCurrencyISO = toCurrencyISO;
        this.amount = amount;
    }

    public Currency() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDealTimestamp() {
        return DealTimestamp;
    }

    public String getFromCurrencyISO() {
        return fromCurrencyISO;
    }

    public String getToCurrencyISO() {
        return toCurrencyISO;
    }

    public Double getAmount() {
        return amount;
    }

    public void setFromCurrencyISO(String fromCurrencyISO) {
        this.fromCurrencyISO = fromCurrencyISO;
    }

    public void setToCurrencyISO(String toCurrencyISO) {
        this.toCurrencyISO = toCurrencyISO;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
