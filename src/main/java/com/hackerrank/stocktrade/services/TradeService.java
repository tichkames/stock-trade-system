package com.hackerrank.stocktrade.services;

import com.hackerrank.stocktrade.model.Trade;

import java.util.List;
import java.util.Optional;

public interface TradeService {
    void deleteAll();
    Trade add(Trade trade);
    Optional<Trade> get(Long id);
    List<Trade> getAll();
    List<Trade> getByUserId(Long userId);
    List<Trade> getByStockSymbolAndTradeTypeDateRange(String symbol, String type, String startDate, String endDate);
}
