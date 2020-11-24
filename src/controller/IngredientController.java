/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.IngredientDAO;
import entity.Ingredient;
import java.util.List;

/**
 *
 * @author ACE
 */
public class IngredientController {

    private Ingredient ingredient;
    private IngredientDAO dao;

    public IngredientController() {
    }

    public void create(String unqCode, int pieces, double amount) {
        this.ingredient = new Ingredient(unqCode, pieces, amount);
        this.getDao().create(ingredient);
    }

    public List<Ingredient> read() {
        return this.getDao().read();
    }

    public void update(String unqCode, int pieces, double amount, String cd) {
        this.ingredient = new Ingredient(unqCode, pieces, amount);
        this.getDao().update(ingredient, cd);
    }

    public void delete(String unqCode) {
        this.getDao().delete(unqCode);
    }

    public IngredientDAO getDao() {
        if (this.dao == null) {
            this.dao = new IngredientDAO();
        }
        return dao;
    }

    public void setDao(IngredientDAO dao) {
        this.dao = dao;
    }

}
