/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ProductionDAO;
import entity.Production;

/**
 *
 * @author ACE
 */
public class ProductionController {

    private Production production;
    private ProductionDAO dao;

    public ProductionController() {
    }

    public void create(String[] unqcode, double[] amount, String pName, int quant) {
        this.production = new Production(unqcode, amount, pName, quant);
        this.getDao().create(production);
    }

    public ProductionDAO getDao() {
        if (this.dao == null) {
            this.dao = new ProductionDAO();
        }
        return dao;
    }

    public void setDao(ProductionDAO dao) {
        this.dao = dao;
    }

}
