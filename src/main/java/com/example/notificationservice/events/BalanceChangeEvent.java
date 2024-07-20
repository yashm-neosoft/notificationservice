package com.example.notificationservice.events;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BalanceChangeEvent {
    private Long accountId;
    private String accountType;
    private double newBalance;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    // Default constructor
    
    public BalanceChangeEvent() {
    }

    @JsonCreator
    public BalanceChangeEvent(
        @JsonProperty("accountId") Long accountId,
        @JsonProperty("accountType") String accountType,
        @JsonProperty("newBalance") Double newBalance) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.newBalance = newBalance;
    }
}

