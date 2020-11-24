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
public class Ingredient {

    private String unqCode;
    private int pieces;
    private double amount;

    public Ingredient() {
    }

    public Ingredient(String unqCode, int pieces, double amount) {
        this.unqCode = unqCode;
        this.pieces = pieces;
        this.amount = amount;
    }

    public Ingredient(int pieces, double amount) {
        this.pieces = pieces;
        this.amount = amount;
    }

    public String getUnqCode() {
        return unqCode;
    }

    public void setUnqCode(String unqCode) {
        this.unqCode = unqCode;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
