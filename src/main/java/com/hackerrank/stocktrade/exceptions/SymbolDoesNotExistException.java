package com.hackerrank.stocktrade.exceptions;

public class SymbolDoesNotExistException extends RuntimeException {
    public SymbolDoesNotExistException(String symbol) {
        super(String.format("Symbol: %s does not exist!", symbol));
    }
}
