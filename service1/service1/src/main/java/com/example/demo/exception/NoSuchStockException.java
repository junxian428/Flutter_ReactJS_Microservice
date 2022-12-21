package com.example.demo.exception;


public class NoSuchStockException extends StockException {
    public NoSuchStockException() {
        super(ErrorType.NO_STOCK_FOUND);
    }
}
