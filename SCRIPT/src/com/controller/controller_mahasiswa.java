package com.controller;

import com.view.view_mahasiswa;
import java.sql.SQLException;

public interface controller_mahasiswa {
    public void Simpan(view_mahasiswa mhs) throws SQLException;        
    public void Ubah(view_mahasiswa mhs) throws SQLException; 
    public void Hapus(view_mahasiswa mhs) throws SQLException; 
    public void Tampil(view_mahasiswa mhs, int mulai) throws SQLException; 
    public void Baru(view_mahasiswa mhs) throws SQLException;                                
    public void Klik_Tabel(view_mahasiswa mhs) throws SQLException;
}
