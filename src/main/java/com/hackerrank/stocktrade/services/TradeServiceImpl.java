package com.hackerrank.stocktrade.services;

import com.hackerrank.stocktrade.exceptions.SymbolDoesNotExistException;
import com.hackerrank.stocktrade.exceptions.TradeAlreadyExistsException;
import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.repositories.TradeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    @Override
    public void deleteAll() {
        log.info("Deleting all trades!");
        tradeRepository.deleteAll();
    }

    @Override
    public Trade add(final Trade trade) {
        Optional<Trade> existing = tradeRepository.findById(trade.getId());
        if (existing.isPresent()) {
            log.error(String.format("Duplicate trade with id: %s", trade));
            throw new TradeAlreadyExistsException(trade.getId());
        }
        log.info(String.format("Saving trade: %s", trade));
        return tradeRepository.save(trade);
    }

    @Override
    public Optional<Trade> get(final Long id) {
        log.info(String.format("Fetching trade for id: %s", id));
        return tradeRepository.findById(id);
    }

    @Override
    public List<Trade> getAll() {
        log.info("Fetching all trades!");
        final List<Trade> sorted = tradeRepository.findAll()
                .stream()
                .sorted(Comparator.comparingLong(Trade::getId))
                .collect(Collectors.toList());
        return sorted;
    }

    @Override
    public List<Trade> getByUserId(final Long userId) {
        log.info(String.format("Fetching all trades for user id: %s", userId));
        return tradeRepository.findTradeByUserId(userId)
                .stream()
                .sorted(Comparator.comparingLong(Trade::getId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Trade> getByStockSymbolAndTradeTypeDateRange(final String symbol, final String type, final String startDate, final String endDate) {
        log.info(String.format("Fetching all trades for stock symbol %s and trade type %s with start date %s and end date %s",
                symbol, type, startDate, endDate));
        List<Trade> tradeForSymbol = tradeRepository.findTradeBySymbol(symbol);
        if(tradeForSymbol.isEmpty()) {
            throw new SymbolDoesNotExistException(symbol);
        }
        return tradeRepository.findByStockSymbolAndTradeTypeDateRange(symbol, type, startDate, endDate)
                .stream()
                .sorted(Comparator.comparingLong(Trade::getId))
                .collect(Collectors.toList());
    }
}
