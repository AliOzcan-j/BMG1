/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.NonArgeDAO;
import entity.NonArge;
import java.util.List;

/**
 *
 * @author ACE
 */
public class NonArgeController {

    private NonArge nonArge;
    private NonArgeDAO dao;

    public NonArgeController() {
    }

    public void create(String category, double income, double expense) {
        this.nonArge = new NonArge(category, income, expense);
        this.getDao().create(this.nonArge);
    }

    public List<NonArge> read() {
        return this.getDao().read();
    }

    public void update(String category, double income, double expense, double olincome, double olexpense) {
        this.nonArge = new NonArge(category, income, expense);
        this.getDao().update(nonArge, olincome, olexpense);
    }

    public void delete(String category, double amount) {
        this.getDao().delete(category, amount);
    }

    public NonArgeDAO getDao() {
        if (this.dao == null) {
            this.dao = new NonArgeDAO();
        }
        return dao;
    }

    public void setDao(NonArgeDAO dao) {
        this.dao = dao;
    }

}
