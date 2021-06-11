package com.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class koneksi {
    private static Connection koneksi;
    
    public static Connection getKoneksi()
    {
        if(koneksi== null)
        {
            try {
                String url = "jdbc:mysql://localhost/mahasiswa";
                String username= "root";     // default username
                String password= "";         // jika ada password bisa anda masukkan
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        return koneksi;
    }
    
}