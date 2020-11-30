/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utility.DBConnection;
import entity.NonArge;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ACE
 */
public class NonArgeDAO extends DBConnection {//arge dışı harcama ve gelirlerin veri tabanındaki işlemlerini gerçekleştirecek sınıf

    public void create(NonArge na) {
        try {
            PreparedStatement ps = this.connect().prepareStatement("insert into nonarge(category, income, expense) values(?,?,?)");
            ps.setString(1, na.getCategory());
            ps.setDouble(2, na.getIncome());
            ps.setDouble(3, na.getExpense());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<NonArge> read() {
        List<NonArge> naList = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from nonarge");

            while (rs.next()) {
                NonArge tmp = new NonArge(rs.getString("category"), rs.getDouble("income"), rs.getDouble("expense"));
                naList.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return naList;
    }

    public void update(NonArge na, double inc, double exp) {
        try {
            PreparedStatement ps = this.connect().prepareStatement("update nonarge set income=?, expense=? where (income=" + inc + " and expense=" + exp + ") and category='" + na.getCategory() + "'");
            ps.setDouble(1, na.getIncome());
            ps.setDouble(2, na.getExpense());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(String category, double amount) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from nonarge where ((income=" + amount + " or expense=" + amount + ") and category='" + category + "')=true");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
