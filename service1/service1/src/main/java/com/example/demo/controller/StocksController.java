package com.example.demo.controller;

import com.example.demo.dto.EditStock;
import com.example.demo.dto.StockResponse;
import com.example.demo.mapper.ResponseMapper;
import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * API controller for operation with {@link Stock}s
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("service1/api/stocks")
@AllArgsConstructor
@Slf4j
public class StocksController {

    private StockService stockService;
    private ResponseMapper responseMapper;

    @GetMapping
    @ApiOperation("Returns all stocks from repository")
    @ApiResponses({
            @ApiResponse(code = 500, message = "Unexpected server error")
    })
    public List<StockResponse> getStocks() {
        LocalDateTime localDateTime = LocalDateTime.now();
		log.info("Service 1 API is called and Get All Stocks" + localDateTime);
        return responseMapper.mapResponseList(stockService.getAllStocks());
    }

    @GetMapping("/{stockId}")
    @ApiOperation("Returns stock by it's unique id")
    @ApiResponses({
            @ApiResponse(code = 500, message = "Unexpected server error"),
            @ApiResponse(code = 404, message = "No such stock")
    })
    public StockResponse getStock(@PathVariable @NotNull UUID stockId) {
        LocalDateTime localDateTime = LocalDateTime.now();
		log.info("Service 1 API is called and find ID" + localDateTime);
        return responseMapper.mapResponse(stockService.getStockById(stockId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Creates a new stock with provided data")
    @ApiResponses({
            @ApiResponse(code = 500, message = "Unexpected server error"),
    })
    public void createStock(@RequestBody @Valid @NotNull EditStock stock) {
        LocalDateTime localDateTime = LocalDateTime.now();
		log.info("Service 1 API is called and Create Stocks" + localDateTime);
        stockService.createStock(stock);
    }

    @PutMapping("/{stockId}")
    @ApiOperation("Updates a stock with new price")
    @ApiResponses({
            @ApiResponse(code = 500, message = "Unexpected server error"),
    })
    public void updateStock(@PathVariable @NotNull UUID stockId, @RequestBody @Valid @NotNull EditStock updatedStock) {
        LocalDateTime localDateTime = LocalDateTime.now();
		log.info("Service 1 API is called and Update Stocks" + localDateTime);
        stockService.updateStockPrice(stockId, updatedStock);
    }
}
