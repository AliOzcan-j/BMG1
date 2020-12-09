/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import controller.*;
import entity.*;
import java.io.IOException;
import java.util.AbstractList;
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
        ProductController pc=new ProductController(); //arayüzden gelen verileri controller paketindeki sınıflar işleyecek ve veri tabanı erişim sınıfı olan DAO ya iletecek
        IngredientController ic=new IngredientController();
        ArgeController prc=new ArgeController();
        NonArgeController nc=new NonArgeController();
        ProductionController ptc=new ProductionController();
        
        /*pc.create("gündüz kremi", "krem", 999.9, "nefes", "941384", 22, "ööeöoahtpöpöspönöspösöppapapentonağpet");
        pc.update(2,"aaserum", "serum", 2999.9, "nefes", "8745487230", 55, "Lorem Ipsum the cat jump down doo");
        List<Product> l=new ArrayList<>();
        l=pc.read();
        int i=0;
        while(i<l.size()){
            System.out.println(l.get(i).getpID()+" "+l.get(i).getName()+" "+l.get(i).getCategory()+" "+l.get(i).getPrice()+" "+l.get(i).getBrand()+" "+l.get(i).getBarcode()+" "+l.get(i).getPiece()+" "+l.get(i).getDescr());
            i++;
        }
        pc.delete(1);*/
        
        /*ic.create("A05F59", 26, 5000.16);
        ic.create("F5FA80", 22, 3020.121);
        ic.create("E2F8AE", 16, 1600.50);
        ic.create("E8F22A", 60, 8000.3);
        ic.update("F5FA80", 66, 12233,"E8F22A");
        ic.delete("E8F22A");
        List<Ingredient> il=new ArrayList<>();
        il=ic.read();
        int i=0;
        while(i<il.size()){
            System.out.println(il.get(i).getUnqCode()+" "+il.get(i).getPieces()+" "+il.get(i).getAmount());
            i++;
        }*/
        
        /*prc.create("drog","satış",5000.12,0.0);
        prc.update("bmg1", "kira", 1234, 0, 0, 2900.40);
        List<Arge> pl=new ArrayList<>();
        pl=prc.read();
        int i=0;
        while(i<pl.size()){
            System.out.println(pl.get(i).getProjectName()+" "+pl.get(i).getCategory()+" "+pl.get(i).getIncome()+" "+pl.get(i).getExpense());
            i++;
        }
        prc.delete("drog", "satış", 5000.12);*/
        
        /*nc.create("kira", 0, 8452.40);
        nc.create("vergi", 0, 1282.88);
        nc.create("sgk", 0, 911.20);
        nc.create("sgk", 0, 897.88);
        nc.create("bağış", 10222.50, 0);
        nc.create("melek yatırımcı", 80000.50, 0);
        nc.update("vergi", 0, 100, 0, 1282.88);
        nc.delete("sgk", 911.2);
        List<NonArge> nl=new ArrayList<>();
        nl=nc.read();
        int i=0;
        while(i<nl.size()){
            System.out.println(nl.get(i).getCategory()+" "+nl.get(i).getIncome()+" "+nl.get(i).getExpense());
            i++;
        }*/
        String[] cd={"3t32","A05F59","E2F8AE"};
        double[] v={200,500,600};
        ptc.create(cd, v, "gündüz kremi", 60);
    }
    
}
