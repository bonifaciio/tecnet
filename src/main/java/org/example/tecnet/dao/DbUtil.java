package org.example.tecnet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
    private static String url, user, pass;
    static {
        try (var in = DbUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
            var p = new Properties();
            p.load(in);
            url = p.getProperty("db.url");
            user = p.getProperty("db.user");
            pass = p.getProperty("db.pass");
        } catch (Exception e) {
            throw new RuntimeException("No se pudo cargar db.properties", e);
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}