/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import backend.*;
import controller.*;
import entity.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ACE
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FileIO fio=new FileIO();
        Product prdct=new Product();
        ProductController pdc=new ProductController();
        List<String> s=new ArrayList<>();
        
        prdct.setpID(1);
        prdct.setName("gündüz kremi");
        prdct.setCategory("krem");
        prdct.setPrice(999.9);
        prdct.setBrand("nefes");
        prdct.setBarcode("87461030");
        prdct.setPiece(34);
        prdct.setDesc("Lorem Ipsum lol");
        
        s=pdc.kodla(prdct);
        
        pdc.create(s);
        int i=0;
        while (i < s.size() && s.get(i) != null){
            System.out.println(s.get(i));
            i++;
        }
    }
    
}
