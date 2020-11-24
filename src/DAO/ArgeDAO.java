/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utility.DBConnection;
import entity.Arge;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author ACE
 */
public class ArgeDAO extends DBConnection {

    public void create(Arge p) {
        try {
            PreparedStatement ps = this.connect().prepareStatement("insert into arge(projectname, category, income, expense) values(?,?,?,?)");
            ps.setString(1, p.getProjectName());
            ps.setString(2, p.getCategory());
            ps.setDouble(3, p.getIncome());
            ps.setDouble(4, p.getExpense());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Arge> read() {
        List<Arge> pList = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from arge");

            while (rs.next()) {
                Arge tmp = new Arge(rs.getString("projectname"), rs.getString("category"), rs.getDouble("income"), rs.getDouble("expense"));
                pList.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pList;
    }

    public void update(Arge p, double inc, double exp) {
        try {
            PreparedStatement ps = this.connect().prepareStatement("update arge set income=?, expense=? where (income=" + inc + "and expense=" + exp + ") and projectname='" + p.getProjectName() + "'");
            ps.setDouble(1, p.getIncome());
            ps.setDouble(2, p.getExpense());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(String projectName, String category, double amount) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from arge where ((income=" + amount + " or expense=" + amount + ") and (projectname='" + projectName + "' and category='" + category + "'))=true");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
