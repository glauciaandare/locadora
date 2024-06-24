package com.locadora.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection con = null;

    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                String url = "jdbc:postgresql://localhost:5432/postgres";
                String user = "postgres";
                String password = "2030";
                con = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to PostgreSQL database");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível conectar ao banco de dados, verifique " +
                    "os dados de conexão\n" + e);
        }

        return con;
    }
}

