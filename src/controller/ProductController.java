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
public class ProductController {

    private Product product;
    private ProductDAO dao;

    public ProductController() {
    }

    public void create(String name, String category, double price, String brand, String barcode, int piece, String descr) {
        this.product = new Product(name, category, price, brand, barcode, piece, descr);
        this.getDao().create(product);
    }

    public List<Product> read() {
        return this.getDao().read();
    }

    public void update(int id, String name, String category, String barcode, double price ) {
        this.product = new Product(id, name, category, barcode, price);
        this.getDao().update(product);
    }

    public void delete(int v) {
        this.getDao().delete(v);
    }
//eğer açık kalan bağlantı varsa tekrardan yeni bir bağlantı açmak yerine eldeki bağlantı kullanılmasını sağlamak amacıyla koşula bağlandı
    public ProductDAO getDao() {
        if (this.dao == null) {
            this.dao = new ProductDAO();
        }
        return dao;
    }

    public void setDao(ProductDAO dao) {
        this.dao = dao;
    }

}
