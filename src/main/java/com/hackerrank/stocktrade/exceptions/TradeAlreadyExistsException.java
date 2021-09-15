package com.hackerrank.stocktrade.exceptions;

public class TradeAlreadyExistsException extends RuntimeException {
    public TradeAlreadyExistsException(Long id) {
        super(String.format("Trade with id: %s already exists!", id));
    }
}
