package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KoneksiDB {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_sipanjir";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private Connection conn;

    public KoneksiDB() {
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.err.println("Kesalahan koneksi database: " + e.getMessage());
        }
    }

    // Metode untuk mendapatkan koneksi ke database
    public Connection getConnection() {
        return conn;
    }

    public void insertUser(String nama, String nohp, String username, String password, String role) {
        String sql = "INSERT INTO users (nama, no_hp, username, password, role) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nama);
            stmt.setString(2, nohp);
            stmt.setString(3, username);
            stmt.setString(4, password);
            stmt.setString(5, role);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Insert user berhasil.");
            } else {
                System.out.println("Insert user gagal.");
            }
        } catch (SQLException e) {
            System.err.println("Error saat insert user: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Koneksi ditutup.");
            }
        } catch (SQLException e) {
            System.err.println("Error saat menutup koneksi: " + e.getMessage());
        }
        
        
    }
}
