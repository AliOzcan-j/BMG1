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
public class Accounting {
    private double income;
    private double expense;
    private double pIncome;
    private double pExpense;
    private String projectName;

    public Accounting() {
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

    public double getpIncome() {
        return pIncome;
    }

    public void setpIncome(double pIncome) {
        this.pIncome = pIncome;
    }

    public double getpExpense() {
        return pExpense;
    }

    public void setpExpense(double pExpense) {
        this.pExpense = pExpense;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    
}
