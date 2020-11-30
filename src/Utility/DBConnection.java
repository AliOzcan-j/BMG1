/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.sql.*;

/**
 *
 * @author ACE
 */
//Bu sınıf yalnızca veri tabanına bağlantı açacak, kendi başına iş yapmayacağı için abstract olarak tanımlandı
public abstract class DBConnection {

    public DBConnection() {
    }

    public Connection connect() {
        Connection c = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/compaut", "postgres", "1234");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
}
