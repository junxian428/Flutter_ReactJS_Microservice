package com.example.demo.service;

import java.math.BigDecimal;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.demo.dto.EditStock;
import com.example.demo.model.Stock;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Generator of {@link Stock} objects on Spring's Application Context start
 */
@Component
@AllArgsConstructor
@Slf4j
public class StockGenerator {

    private StockService stockService;

    /**
     * Generate example {@link Stock} objects
     */
    @EventListener(ApplicationReadyEvent.class)
    public void generateStocks() {
        EditStock stock = new EditStock();

        stock.setStockPrice(BigDecimal.valueOf(1122));
        stock.setStockName("Payconic");

        stockService.createStock(stock);

        stock.setStockPrice(BigDecimal.valueOf(2244.55));
        stock.setStockName("Shop");

        stockService.createStock(stock);

        stock.setStockPrice(BigDecimal.valueOf(1234.97));
        stock.setStockName("Mall");

        stockService.createStock(stock);

        log.info("Generated test stock objects");
    }
}
