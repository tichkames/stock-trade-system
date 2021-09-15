package com.hackerrank.stocktrade.repositories;

import com.hackerrank.stocktrade.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
    @Query(value = "select * FROM trade WHERE user_id = :userId", nativeQuery = true)
    List<Trade> findTradeByUserId(@Param("userId") Long userId);

    List<Trade> findTradeBySymbol(String symbol);

    @Query(value = "select * FROM trade WHERE symbol = :symbol and type = :type and cast (timestamp as date) between :startDate and :endDate", nativeQuery = true)
    List<Trade> findByStockSymbolAndTradeTypeDateRange(@Param("symbol") String symbol, @Param("type") String type,
            @Param("startDate") String startDate, @Param("endDate") String endDate);
}
