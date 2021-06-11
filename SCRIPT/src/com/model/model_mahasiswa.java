package com.model;

import com.controller.controller_mahasiswa;
import com.database.koneksi;
import com.view.view_mahasiswa;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class model_mahasiswa implements controller_mahasiswa{
    Connection con = koneksi.getKoneksi();
    String sql, jk, var_dumy;
    
    @Override
    public void Simpan(view_mahasiswa mhs) {
        pilih_jk(mhs);
        try {
            if (Cek_Data("nim = '"+mhs.input_nim.getText()+"'") > 0){ //CEK NIM TERSEDIA???
                JOptionPane.showMessageDialog(null, "Maaf!!!\nNIM "+mhs.input_nim.getText()+" Sudah Ada", "Informasi ", JOptionPane.INFORMATION_MESSAGE);
                mhs.input_nim.requestFocus();
            }else{
               sql = "INSERT data_mahasiswa VALUES (?,?,?,?,?,?)";
               System.out.println("SQL Simpan = "+sql);
               PreparedStatement prepare = con.prepareStatement(sql);
               prepare.setString(1, null);
               prepare.setString(2, mhs.input_nim.getText());
               prepare.setString(3, mhs.input_nama.getText());
               prepare.setString(4, jk);
               prepare.setString(5, (String) mhs.input_jurusan.getSelectedItem());
               prepare.setString(6, "1");
               prepare.executeUpdate();
               prepare.close();
               
               Tampil(mhs, mhs.halaman_ke);
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Simpan Data\n"+e, "Peringatan", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    @Override
    public void Ubah(view_mahasiswa mhs) {
        pilih_jk(mhs);
        int pilih = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Mengubah Data "+var_dumy+" ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(pilih == 0){
            try {
                if (Cek_Data("nim = '"+mhs.input_nim.getText()+"'") > 0 && !var_dumy.equals(mhs.input_nim.getText())){ //CEK NIM TERSEDIA???
                    JOptionPane.showMessageDialog(null, "Maaf!!!\nNIM "+mhs.input_nim.getText()+" Sudah Ada", "Informasi ", JOptionPane.INFORMATION_MESSAGE);
                    mhs.input_nim.requestFocus();
                }else{
                    sql = "UPDATE data_mahasiswa set nim= ?, nama_lengkap= ?, jenis_kelamin= ?, jurusan= ? where nim ='"+var_dumy+"'";
                    System.out.println("SQL Ubah = "+sql);
                    PreparedStatement prepare = con.prepareStatement(sql);
                    prepare.setString(1, mhs.input_nim.getText());
                    prepare.setString(2, mhs.input_nama.getText());
                    prepare.setString(3, jk);
                    prepare.setString(4, (String) mhs.input_jurusan.getSelectedItem());
                    prepare.executeUpdate();
                    prepare.close();

                    Tampil(mhs, mhs.halaman_ke);
                }
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Ubah Data\n"+e, "Peringatan", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void Hapus(view_mahasiswa mhs) {
        int pilih = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Menghapus Data "+mhs.input_nim.getText()+" ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        
        if(pilih == 0){
            try {
                sql = "DELETE FROM data_mahasiswa WHERE nim ='"+var_dumy+"'";
                System.out.println("SQL Hapus = "+sql);
                PreparedStatement prepare = con.prepareStatement(sql);
                prepare.executeUpdate();
                prepare.close();
                
                Tampil(mhs, mhs.halaman_ke);
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Hapus Data\nError : "+e, "Peringatan", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void initPagination(view_mahasiswa mhs){
        mhs.total_data_db = Cek_Data(mhs.kategori+mhs.cari+" ORDER BY "+mhs.kategori+" "+mhs.urutan); //10 --->>> Total Jumlah Data Pada DB
        //mhs.total_data_db = Cek_Data(mhs.kategori+mhs.cari+" ORDER BY "+mhs.kategori+" "+mhs.urutan+" LIMIT "+mhs.data_ke+","+mhs.data_perhalaman); //10 --->>> Total Jumlah Data Pada DB
        mhs.data_perhalaman = Integer.parseInt(mhs.input_halaman.getSelectedItem().toString()); //3 --->>> Data Dalam Tabel Sesuai Combobox
        mhs.dari_halaman = (mhs.total_data_db/mhs.data_perhalaman); //3+1=4 --->>> Batas Halaman
        if(mhs.total_data_db%mhs.data_perhalaman > 0){
            mhs.dari_halaman = mhs.dari_halaman + 1;
        }
        
        mhs.data_ke = (mhs.halaman_ke-1)*(mhs.data_perhalaman); //1 --->>> Batas Akhir Pemanggilan DB
        
        if(mhs.dari_halaman == 1){
            mhs.btn_sebelum.setEnabled(false);
            mhs.btn_setelah.setEnabled(false);
            mhs.btn_awal.setEnabled(false);
            mhs.btn_akhir.setEnabled(false);
        }else if(mhs.halaman_ke == 1){
            mhs.btn_sebelum.setEnabled(false);
            mhs.btn_setelah.setEnabled(true);
            mhs.btn_awal.setEnabled(false);
            mhs.btn_akhir.setEnabled(true);
        }else if(mhs.halaman_ke > 1 && mhs.halaman_ke != mhs.dari_halaman){
            mhs.btn_sebelum.setEnabled(true);
            mhs.btn_setelah.setEnabled(true);
            mhs.btn_awal.setEnabled(true);
            mhs.btn_akhir.setEnabled(true);
        }else{
            mhs.btn_sebelum.setEnabled(true);
            mhs.btn_setelah.setEnabled(false);
            mhs.btn_awal.setEnabled(true);
            mhs.btn_akhir.setEnabled(false);
        }

        mhs.jLabel11.setText("Halaman "+(mhs.halaman_ke)+" dari "+(mhs.dari_halaman)+" (Total Data "+mhs.total_data_db+")");
    }
    
   
    @Override
    public void Tampil(view_mahasiswa mhs, int mulai) {
        mhs.halaman_ke = mulai;
        mhs.tblmodel.getDataVector().removeAllElements();
        mhs.tblmodel.fireTableDataChanged();
        try {
            Statement stt = con.createStatement();
            initPagination(mhs);
            sql = "SELECT * FROM data_mahasiswa WHERE "+mhs.kategori+mhs.cari+" ORDER BY "+mhs.kategori+" "+mhs.urutan+" LIMIT "+mhs.data_ke+","+mhs.data_perhalaman;
            System.out.println("SQL Tampil = "+sql);
            ResultSet res = stt.executeQuery(sql);
            int no = 1;
            while(res.next()){
                Object[] ob= new Object[8];
                ob[0] = ""+(no++);//no
                ob[1] = res.getString(2);//nim
                ob[2] = res.getString(3);//nama
                ob[3] = res.getString(4);//jk
                ob[4] = res.getString(5);//jurusan
                mhs.tblmodel.addRow(ob);
            }
            mhs.jLabel10.setVisible(false);
            if(no == 1){
                mhs.jLabel10.setVisible(true);
            }
            mhs.setLebarKolom();
            mhs.form_data.setVisible(false);//form input
            mhs.btn_tambah.setEnabled(true);//tambah
            mhs.btn_ubah.setEnabled(false);//ubah
            mhs.btn_hapus.setEnabled(false);//hapus
            mhs.btn_refresh.setEnabled(true);//refresh
            mhs.input_halaman.setEnabled(true);//perhalaman
            mhs.input_kategori.setEnabled(true);//kategori
            mhs.btn_urutan.setEnabled(true);//urutan
            mhs.input_cari.setEnabled(true);//input cari
            mhs.btn_cari.setEnabled(true);//cari
            mhs.tabel_data_mhs.setEnabled(true);            
            mhs.tabel_data_mhs.setSelectionMode(0);
            mhs.form_data.setTitle("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Tampil Data\n"+e, "Peringatan", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public int Cek_Data(String Cari) {
        int no = 0;
        try {
            Statement stt = con.createStatement();
            sql = "SELECT * FROM data_mahasiswa WHERE "+Cari;
            System.out.println("SQL Cek Data = "+sql);
            ResultSet res = stt.executeQuery(sql);
            while(res.next()){
                no = res.getRow();
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Cek Data\n"+e, "Peringatan", JOptionPane.ERROR_MESSAGE);
        }
        return no;
    }

    @Override
    public void Baru(view_mahasiswa mhs) {
        mhs.input_nim.setText("");
        mhs.input_nama.setText("");
        mhs.input_lk.setSelected(true);
        mhs.input_jurusan.setSelectedIndex(0);
        
        mhs.input_nim.requestFocus();
    }

    @Override
    public void Klik_Tabel(view_mahasiswa mhs) {
        mhs.btn_ubah.setEnabled(true);
        mhs.btn_hapus.setEnabled(true);
        
        try {
            int pilih = mhs.tabel_data_mhs.getSelectedRow();
            if (pilih == -1 ) return;
            
            var_dumy = mhs.tblmodel.getValueAt(pilih, 1).toString();
            mhs.input_nim.setText(var_dumy);
            mhs.input_nama.setText(mhs.tblmodel.getValueAt(pilih, 2).toString());
            jk = String.valueOf(mhs.tblmodel.getValueAt(pilih, 3));
                mhs.input_lk.setSelected(true);
                if(mhs.input_pr.getText().equals(jk)) mhs.input_pr.setSelected(true);
            mhs.input_jurusan.setSelectedItem(mhs.tblmodel.getValueAt(pilih, 4).toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Klik Tabel\n"+e, "Peringatan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void pilih_jk(view_mahasiswa mhs){
        if(mhs.input_pr.isSelected()){
            jk = "Laki-laki";
        }else
            jk = "Perempuan";

    }
}
