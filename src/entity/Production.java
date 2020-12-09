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
public class Production {

    private String[] unqcode;
    private double[] amount;
    private String pName;
    private int quant;

    public Production() {
    }

    public Production(String[] unqcode, double[] amount, String pName, int quant) {
        this.unqcode = unqcode;
        this.amount = amount;
        this.pName = pName;
        this.quant = quant;
    }

    public String[] getUnqcode() {
        return unqcode;
    }

    public void setUnqcode(String[] unqcode) {
        this.unqcode = unqcode;
    }

    public double[] getAmount() {
        return amount;
    }

    public void setAmount(double[] amount) {
        this.amount = amount;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

}
