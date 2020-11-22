/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ProductDAO;
import entity.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACE
 */
public class ProductController{
    private Product product;
    private ProductDAO doa;

    public ProductController() {
    }
    
    public void create(String name, String category, double price, String brand, String barcode, int piece, String descr){
        this.product=new Product(name, category, price, brand, barcode, piece, descr);
        this.getDoa().create(product);
    }
    
    public List<Product> read(){        
        return this.getDoa().read();
    }
    
    public void update(int id, String name, String category, double price, String brand, String barcode, int piece, String descr){
        product=new Product(id, name, category, price, brand, barcode, piece, descr);
        this.getDoa().update(product);
    }
    
    public void delete(int v){
        this.getDoa().delete(v);
    }

    public ProductDAO getDoa() {
        if(this.doa==null){
            this.doa=new ProductDAO();
        }
        return doa;
    }

    public void setDoa(ProductDAO doa) {
        this.doa = doa;
    }
    
}
