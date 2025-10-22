package com.matrix;  // ✅ keep this line since your file is inside com/matrix

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:sqlserver://Jayashree\\SQLEXPRESS:1433;databaseName=matrixdb;encrypt=false";
        String username = "sa";
        String password = "Ishwarya_2722!";

        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("✅ Connected successfully to SQL Server!");
        conn.close();
    }
}
