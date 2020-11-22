/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import Utility.DBConnection;
import controller.*;
import entity.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        Product prdct=new Product();
        ProductController pc=new ProductController();
        
        //pc.create("gündüz kremi", "krem", 999.9, "nefes", "94561384", 22, "ööeöoahtpöpöspönöspösöppapapentonağpet");
        //pc.update(2,"aaserum", "serum", 2999.9, "nefes", "8745487230", 55, "Lorem Ipsum the cat jump down doo lol");
        List<Product> l=new ArrayList<>();
        l=pc.read();
        int i=0;
        while(i<l.size()){
            System.out.println(l.get(i).getpID()+" "+l.get(i).getName()+" "+l.get(i).getCategory()+" "+l.get(i).getPrice()+" "+l.get(i).getBrand()+" "+l.get(i).getBarcode()+" "+l.get(i).getPiece()+" "+l.get(i).getDescr());
            i++;
        }
        //pc.delete(1);
        
    }
    
}
