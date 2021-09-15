package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {
    @Autowired
    TradeService tradeService;

    @DeleteMapping
    ResponseEntity<?> deleteTrade() {
        tradeService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
