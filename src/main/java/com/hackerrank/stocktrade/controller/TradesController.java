package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.services.TradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/trades")
public class TradesController {
    private final TradeService tradeService;

    TradesController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @PostMapping
    ResponseEntity<String> newTrade(@RequestBody Trade newTrade) {
        Trade result = tradeService.add(newTrade);
        URI location = URI.create(String.format("/trade/%s", result.getId()));
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    ResponseEntity<Trade> trade(@PathVariable Long id) {
        Optional<Trade> trade = tradeService.get(id);
        if(trade.isPresent()) {
            return ResponseEntity.ok(trade.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    ResponseEntity<List<Trade>> trades() {
        return ResponseEntity.ok(tradeService.getAll());
    }

    @GetMapping("/users/{userID}")
    ResponseEntity<List<Trade>> userTrades(@PathVariable Long userID) {
        List<Trade> trades = tradeService.getByUserId(userID);
        if(trades.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trades);
    }

    @GetMapping("/stocks/{stockSymbol}")
    ResponseEntity<List<Trade>> stockSymbolAndTypeDateRangeTrades(@PathVariable String stockSymbol, @RequestParam String type,
            @RequestParam String start, @RequestParam String end) {
        List<Trade> trades = tradeService.getByStockSymbolAndTradeTypeDateRange(stockSymbol, type, start, end);
        return ResponseEntity.ok(trades);
    }
}
