/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utility.DBConnection;
import entity.Ingredient;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACE
 */
public class IngredientDAO extends DBConnection {

    public void create(Ingredient ing) {
        try {
            PreparedStatement ps = this.connect().prepareStatement("insert into ingredient(unqCode, pieces, amount)" + "values(?,?,?)");
            ps.setString(1, ing.getUnqCode());
            ps.setInt(2, ing.getPieces());
            ps.setDouble(3, ing.getAmount());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Ingredient> read() {
        List<Ingredient> iList = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ingredient");

            while (rs.next()) {
                Ingredient tmp = new Ingredient(rs.getString("unqCode"), rs.getInt("pieces"), rs.getDouble("amount"));
                iList.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return iList;
    }

    public void update(Ingredient ing, String cd) {
        PreparedStatement ps;
        try {
            ps = this.connect().prepareStatement("update ingredient set unqCode=?, pieces=?, amount=? where unqCode=" + "UPPER" + "(" + "'" + ing.getUnqCode() + "'" + ")");
            ps.setString(1, cd);
            ps.setInt(2, ing.getPieces());
            ps.setDouble(3, ing.getAmount());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(String unqCode) {
        int r;
        try {
            Statement st = this.connect().createStatement();
            r = st.executeUpdate("delete from ingredient where unqCode=" + "UPPER" + "('" + unqCode + "')");
            if (r == 1) {
                System.out.println("operation was successful");
            } else {
                System.out.println("Code doesnt exist");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
