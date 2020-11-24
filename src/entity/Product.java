/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ACE
 */
public class Product {

    private int pid;
    private String name;
    private String category;
    private double price;
    private String brand;
    private String barcode;
    private int piece;
    private String descr;

    public Product() {
    }

    public Product(String name, String category, double price, String brand, String barcode, int piece, String descr) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.brand = brand;
        this.barcode = barcode;
        this.piece = piece;
        this.descr = descr;
    }

    public Product(int pid, String name, String category, double price, String brand, String barcode, int piece, String descr) {
        this.pid = pid;
        this.name = name;
        this.category = category;
        this.price = price;
        this.brand = brand;
        this.barcode = barcode;
        this.piece = piece;
        this.descr = descr;
    }

    public int getpID() {
        return pid;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String desc) {
        this.descr = desc;
    }

}
