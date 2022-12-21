package com.example.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dto.StockResponse;
import com.example.demo.model.Stock;

/**
 * Mapper for response {@link StockResponse} DTO which is representation of {@link Stock} entities
 */
@Component
public class ResponseMapper {

    /**
     * Maps {@link Stock} entity to it's response DTO
     *
     * @param stock Stock to map
     * @return Mapped response entity
     */
    public StockResponse mapResponse(Stock stock) {
        return map(stock);
    }

    /**
     * Maps a list {@link Stock} entities to response DTOs
     *
     * @param stocks List of stocks to map
     * @return Mapped list of response entities
     */
    public List<StockResponse> mapResponseList(List<Stock> stocks) {
        return stocks.stream().map(this::map).collect(Collectors.toList());
    }

    private StockResponse map(Stock stock) {
        final StockResponse stockResponse = new StockResponse();

        stockResponse.setStockPrice(stock.getCurrentPrice());
        stockResponse.setId(stock.getId().toString());
        stockResponse.setStockName(stock.getName());
        stockResponse.setLastUpdate(stock.getLastUpdate());

        return stockResponse;
    }
}
