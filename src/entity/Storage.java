/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import backend.*;

/**
 *
 * @author ACE
 */
public class Storage {
    private Product product;
    private Ingredient ingredient;
    private String stockCode;

    public Storage() {
    }
    
    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }
    
}
