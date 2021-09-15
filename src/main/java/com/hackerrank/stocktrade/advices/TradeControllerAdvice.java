package com.hackerrank.stocktrade.advices;

import com.hackerrank.stocktrade.exceptions.SymbolDoesNotExistException;
import com.hackerrank.stocktrade.exceptions.TradeAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TradeControllerAdvice {
    @ResponseBody
    @ExceptionHandler(TradeAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String userNotFoundHandler(TradeAlreadyExistsException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(SymbolDoesNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String symbolNotFoundHandler(SymbolDoesNotExistException ex){
        return ex.getMessage();
    }
}
