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
public class NonArge {

    private String category;
    private double income;
    private double expense;
    private String month;

    public NonArge() {
    }

    public NonArge(String category, double income, double expense, String month) {
        this.category = category;
        this.income = income;
        this.expense = expense;
        this.month = month;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "NonArge{" + "category=" + category + ", income=" + income + ", expense=" + expense + ", month=" + month + '}';
    }

}
