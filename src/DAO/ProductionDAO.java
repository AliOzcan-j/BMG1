/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utility.DBConnection;
import entity.Production;
import java.sql.*;

/**
 *
 * @author ACE
 */
public class ProductionDAO extends DBConnection {

    public void create(Production p) {
        int i = 0;
        String[] unqcode = p.getUnqcode();
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update product set piece=piece+" + p.getQuant() + "where pname='" + p.getpName() + "'");
            
            while (i < p.getUnqcode().length) {
                st.executeUpdate("update ingredient set amount=amount-" + p.getAmount()[i] + "where unqcode='" + p.getUnqcode()[i]+"'");
                i++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
