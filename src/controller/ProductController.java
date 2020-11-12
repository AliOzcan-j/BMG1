/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import backend.IFile;
import entity.Product;
import backend.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACE
 */
public class ProductController implements IFile{
    private FileIO fileIO;
    private Product product;

    public ProductController() {
        this.fileIO=new FileIO("Ürünler.txt");
    }
    
    @Override
    public void create(List<String> s) {
        try {
            fileIO.fileWrite(s, "Ürünler.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<String> read() {
        List<String> s=new ArrayList<>();
        try {
            s=fileIO.fileRead("Ürünler.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return s;
    }

    @Override
    public void delete(int id) {
        try {
            fileIO.fileDelete("Ürünler.txt", id);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<String> kodla(Product p) throws IOException {
        List<String> s = new ArrayList<>();
        List<String> t = new ArrayList<>();

        for (int j = 0; j < 40; j++) {
            s.add("");
        }

        s.add(p.getpID(), "ID:" + Integer.toString(p.getpID()) + "." + "Ürün adı: " + p.getName()
                + "|" + " Kategori: " + p.getCategory() + "|"
                + " Fiyat: " + Double.toString(p.getPrice()) + "| Marka: " + p.getBrand()
                + "| Barkod: " + p.getBarcode() + "| Miktar: " + p.getPiece() + "| "
                + "Açıklama: " + p.getDesc() + "|");

        for (int j = 0; j < 40; j++) {
            if (!"".equals(s.get(j))) {
                t.add(s.get(j));
            }
        }
        return t;
    }
    
}
