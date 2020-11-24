/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ArgeDAO;
import entity.Arge;
import java.util.List;

/**
 *
 * @author ACE
 */
public class ArgeController {

    private Arge arge;
    private ArgeDAO dao;

    public ArgeController() {
    }

    public void create(String projectName, String category, double income, double expense) {
        this.arge = new Arge(projectName, category, income, expense);
        this.getDao().create(arge);
    }

    public List<Arge> read() {
        return this.getDao().read();
    }

    public void update(String projectName, String category, double income, double expense, double olincome, double olexpense) {
        this.arge = new Arge(projectName, category, income, expense);
        this.getDao().update(arge, olincome, olexpense);
    }

    public void delete(String projectName, String category, double amount) {
        this.getDao().delete(projectName, category, amount);
    }

    public ArgeDAO getDao() {
        if (this.dao == null) {
            this.dao = new ArgeDAO();
        }
        return dao;
    }

    public void setDao(ArgeDAO dao) {
        this.dao = dao;
    }

}
