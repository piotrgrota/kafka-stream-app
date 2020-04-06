package com.stream.sample.producerdemo.rest;

import lombok.Data;
import lombok.Getter;

@Data
public class Transaction {

    public Transaction() {
    }

    public Transaction(String name, Double amount) {
        this.name = name;
        this.amount = amount;
    }

    @Getter
    private String name ;

    @Getter
    private Double amount;

}
