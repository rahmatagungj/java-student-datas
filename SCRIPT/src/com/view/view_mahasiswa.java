package com.view;

import com.model.model_mahasiswa;
import java.awt.Component;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public final class view_mahasiswa extends javax.swing.JFrame {
    public DefaultTableModel tblmodel;
    String header[] ={"No","NIM", "Nama Lengkap", "Jenis kelamin", "Jurusan"};    
    public int halaman_ke = 1, dari_halaman, total_data_db, data_perhalaman, data_ke;
    public String urutan = "ASC", kategori = "NIM", cari = " is not null ";
    
    public view_mahasiswa() {
        initComponents();
        tblmodel = new DefaultTableModel(null, header);
        tabel_data_mhs.setModel(tblmodel);
        tabel_data_mhs.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        halaman_ke = 1;
        model.Tampil(this, halaman_ke); 
        entri_data(false);
    }

    public void entri_data(boolean tampil){
        input_nim.setEditable(tampil);
        input_nama.setEditable(tampil);
        input_lk.setEnabled(tampil);
        input_pr.setEnabled(tampil);
        input_jurusan.setEnabled(tampil);
    }
    
    public void form_input(boolean tampil){
        setLebarKolom();
        form_data.setVisible(tampil);//form input
        btn_tambah.setEnabled(tampil);//tambah
        btn_ubah.setEnabled(tampil);//ubah
        btn_hapus.setEnabled(tampil);//hapus
        btn_refresh.setEnabled(tampil);//refresh
        input_halaman.setEnabled(tampil);//perhalaman
        input_kategori.setEnabled(tampil);//kategori
        btn_urutan.setEnabled(tampil);//urutan
        input_cari.setEnabled(tampil);//input cari
        btn_cari.setEnabled(tampil);//cari
        tabel_data_mhs.setEnabled(tampil);            
        tabel_data_mhs.setSelectionMode(0);
        form_data.setTitle("");
        
        btn_awal.setEnabled(tampil);
        btn_sebelum.setEnabled(tampil);
        btn_setelah.setEnabled(tampil);
        btn_akhir.setEnabled(tampil);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jk_mhs = new javax.swing.ButtonGroup();
        form_data = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        input_nim = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        input_nama = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        input_lk = new javax.swing.JRadioButton();
        input_pr = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        input_jurusan = new javax.swing.JComboBox<>();
        btn_simpan = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        input_kategori = new javax.swing.JComboBox<>();
        btn_tambah = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btn_cari = new javax.swing.JButton();
        btn_urutan = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        input_cari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_data_mhs = new javax.swing.JTable();
        btn_hapus = new javax.swing.JButton();
        input_halaman = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_awal = new javax.swing.JButton();
        btn_sebelum = new javax.swing.JButton();
        btn_setelah = new javax.swing.JButton();
        btn_akhir = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Mahasiswa");
        setMinimumSize(new java.awt.Dimension(820, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        form_data.setVisible(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel2.setText("NAMA LENGKAP");

        input_nim.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel6.setText("NIM");

        input_nama.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel7.setText("JENIS KELAMIN");

        jk_mhs.add(input_lk);
        input_lk.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        input_lk.setSelected(true);
        input_lk.setText("Perempuan");

        jk_mhs.add(input_pr);
        input_pr.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        input_pr.setText("Laki-laki");
        input_pr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_prActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel8.setText("JURUSAN");

        input_jurusan.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        input_jurusan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PTIK", "PGSD", "PGPAUD", "PJKR", "RPL" }));
        input_jurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_jurusanActionPerformed(evt);
            }
        });

        btn_simpan.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_batal.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout form_dataLayout = new javax.swing.GroupLayout(form_data.getContentPane());
        form_data.getContentPane().setLayout(form_dataLayout);
        form_dataLayout.setHorizontalGroup(
            form_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form_dataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(form_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(form_dataLayout.createSequentialGroup()
                        .addGroup(form_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(form_dataLayout.createSequentialGroup()
                                .addComponent(input_lk, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(input_pr, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(form_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(input_nim)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                                .addComponent(input_nama)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(input_jurusan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, form_dataLayout.createSequentialGroup()
                        .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        form_dataLayout.setVerticalGroup(
            form_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form_dataLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(input_nim, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(input_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(form_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(input_lk)
                    .addComponent(input_pr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(input_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(form_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(form_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 280, 360));

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Dokumen Tidak Ditemukan");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 630, 70));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        input_kategori.setBackground(new java.awt.Color(255, 102, 0));
        input_kategori.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        input_kategori.setForeground(new java.awt.Color(255, 255, 255));
        input_kategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NIM", "Nama Lengkap", "Jenis Kelamin", "Jurusan" }));
        input_kategori.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        input_kategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_kategoriActionPerformed(evt);
            }
        });

        btn_tambah.setBackground(new java.awt.Color(51, 102, 255));
        btn_tambah.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("Tambah");
        btn_tambah.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_ubah.setBackground(new java.awt.Color(51, 102, 255));
        btn_ubah.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        btn_ubah.setForeground(new java.awt.Color(255, 255, 255));
        btn_ubah.setText("Ubah");
        btn_ubah.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel12.setText("Kategori : ");

        btn_cari.setBackground(new java.awt.Color(51, 102, 255));
        btn_cari.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        btn_cari.setForeground(new java.awt.Color(255, 255, 255));
        btn_cari.setText("Cari");
        btn_cari.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        btn_urutan.setBackground(new java.awt.Color(255, 102, 0));
        btn_urutan.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        btn_urutan.setForeground(new java.awt.Color(255, 255, 255));
        btn_urutan.setText("AZ");
        btn_urutan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_urutan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_urutanActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel13.setText("Tampil");

        input_cari.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        input_cari.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jScrollPane1.setEnabled(false);

        tabel_data_mhs.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        tabel_data_mhs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_data_mhs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabel_data_mhs.setDragEnabled(true);
        tabel_data_mhs.setRowHeight(25);
        tabel_data_mhs.getTableHeader().setReorderingAllowed(false);
        tabel_data_mhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_data_mhsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabel_data_mhsMousePressed(evt);
            }
        });
        tabel_data_mhs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabel_data_mhsKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabel_data_mhsKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_data_mhs);

        btn_hapus.setBackground(new java.awt.Color(51, 102, 255));
        btn_hapus.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setText("Hapus");
        btn_hapus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        input_halaman.setBackground(new java.awt.Color(255, 102, 0));
        input_halaman.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        input_halaman.setForeground(new java.awt.Color(255, 255, 255));
        input_halaman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "50", "100" }));
        input_halaman.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        input_halaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_halamanActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel14.setText("Data");

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Halaman 1 dan 2");

        btn_awal.setBackground(new java.awt.Color(51, 102, 255));
        btn_awal.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        btn_awal.setForeground(new java.awt.Color(255, 255, 255));
        btn_awal.setText("AWAL");
        btn_awal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_awal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_awalActionPerformed(evt);
            }
        });

        btn_sebelum.setBackground(new java.awt.Color(51, 102, 255));
        btn_sebelum.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        btn_sebelum.setForeground(new java.awt.Color(255, 255, 255));
        btn_sebelum.setText("<");
        btn_sebelum.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_sebelum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sebelumActionPerformed(evt);
            }
        });

        btn_setelah.setBackground(new java.awt.Color(51, 102, 255));
        btn_setelah.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        btn_setelah.setForeground(new java.awt.Color(255, 255, 255));
        btn_setelah.setText(">");
        btn_setelah.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_setelah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_setelahActionPerformed(evt);
            }
        });

        btn_akhir.setBackground(new java.awt.Color(51, 102, 255));
        btn_akhir.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        btn_akhir.setForeground(new java.awt.Color(255, 255, 255));
        btn_akhir.setText("AKHIR");
        btn_akhir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_akhir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_akhirActionPerformed(evt);
            }
        });

        btn_refresh.setBackground(new java.awt.Color(51, 102, 255));
        btn_refresh.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        btn_refresh.setForeground(new java.awt.Color(255, 255, 255));
        btn_refresh.setText("Refresh");
        btn_refresh.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_awal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_sebelum, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_setelah, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_akhir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(input_halaman, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(input_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_urutan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(input_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(btn_cari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_ubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input_halaman, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_urutan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_akhir)
                    .addComponent(btn_setelah)
                    .addComponent(btn_sebelum)
                    .addComponent(btn_awal))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 800, 380));

        jLabel1.setBackground(new java.awt.Color(255, 0, 51));
        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA MAHASISWA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 10, 780, 50));

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Selamat Datang,");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Rahmat Agung Julians");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(649, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 830, 70));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        entri_data(true);
        form_input(false);
        form_data.setVisible(true);
        form_data.setTitle("Ubah Data Mahasiswa");
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        if(form_data.getTitle().equals("Tambah Data Mahasiswa")){
            model.Simpan(this);
        }else{
            model.Ubah(this);
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        entri_data(true);
        form_input(false);
        form_data.setTitle("Tambah Data Mahasiswa");
        form_data.setVisible(true);
        model.Baru(this);  
        
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        model.Hapus(this);        
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void tabel_data_mhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_data_mhsMouseClicked
        if(form_data.getTitle().equals("")){
            model.Klik_Tabel(this);
        }                
    }//GEN-LAST:event_tabel_data_mhsMouseClicked

    private void tabel_data_mhsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabel_data_mhsKeyPressed
        
    }//GEN-LAST:event_tabel_data_mhsKeyPressed

    private void tabel_data_mhsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabel_data_mhsKeyReleased
        model.Klik_Tabel(this);         
    }//GEN-LAST:event_tabel_data_mhsKeyReleased

    private void nim_mhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nim_mhsActionPerformed
        
    }//GEN-LAST:event_nim_mhsActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        form_input(true);
        model.Tampil(this, halaman_ke);
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_urutanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_urutanActionPerformed
        if(btn_urutan.getText().equals("AZ")){
            urutan = "DESC";
            btn_urutan.setText("ZA");
        }else{
            urutan = "ASC";
            btn_urutan.setText("AZ");
        }
        cari = " LIKE '%"+input_cari.getText()+"%'  ";
        if(input_cari.equals("")){
            cari = " is not null ";
        }
        model.Tampil(this, halaman_ke);
    }//GEN-LAST:event_btn_urutanActionPerformed

    private void btn_sebelumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sebelumActionPerformed
        halaman_ke--;      
        model.Tampil(this, halaman_ke); 
    }//GEN-LAST:event_btn_sebelumActionPerformed

    private void btn_awalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_awalActionPerformed
        halaman_ke = 1;
        model.Tampil(this, halaman_ke);        
    }//GEN-LAST:event_btn_awalActionPerformed

    private void btn_akhirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_akhirActionPerformed
        halaman_ke = dari_halaman;
        model.Tampil(this, halaman_ke);       
    }//GEN-LAST:event_btn_akhirActionPerformed

    private void btn_setelahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_setelahActionPerformed
        halaman_ke++;      
        model.Tampil(this, halaman_ke);
    }//GEN-LAST:event_btn_setelahActionPerformed

    private void input_halamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_halamanActionPerformed
        model.Tampil(this, 1);         
    }//GEN-LAST:event_input_halamanActionPerformed

    private void input_kategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_kategoriActionPerformed
        kategori = null;
        kategori = input_kategori.getSelectedItem().toString();
        kategori = kategori.toLowerCase().replace(" ", "_");
        input_cari.setText("");
        //cari = " LIKE '%"+input_cari.getText()+"%'  ";
        //if(input_cari.equals("")){
            //cari = " is not null ";
        //}
        //model.Tampil(this, halaman_ke);
    }//GEN-LAST:event_input_kategoriActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        cari = " LIKE '%"+input_cari.getText()+"%'  ";
        halaman_ke = 1;
        model.Tampil(this, halaman_ke); 
    }//GEN-LAST:event_btn_cariActionPerformed

    private void tabel_data_mhsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_data_mhsMousePressed
        
    }//GEN-LAST:event_tabel_data_mhsMousePressed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        input_halaman.setSelectedIndex(0); 
        input_kategori.setSelectedIndex(0);
        btn_urutan.setText("AZ");
        input_cari.setText("");
        cari = " is not null ";
        halaman_ke = 1;
        model.Tampil(this, halaman_ke); 
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void input_jurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_jurusanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_jurusanActionPerformed

    private void input_prActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_prActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_prActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new view_mahasiswa().setVisible(true);
        });
    }
    
    model_mahasiswa model = new model_mahasiswa();
    
    public void setColomnWidth(int kolom){
        DefaultTableColumnModel column = (DefaultTableColumnModel) tabel_data_mhs.getColumnModel();
        TableColumn kolomtabel = column.getColumn(kolom);
        int lebar = 0;
        int margin = 70;
        int a;

        TableCellRenderer renderer = kolomtabel.getHeaderRenderer();
        if (renderer ==null){
            renderer = tabel_data_mhs.getTableHeader().getDefaultRenderer();
        }
        Component komponen = renderer.getTableCellRendererComponent(tabel_data_mhs,  kolomtabel.getHeaderValue(), false, false, 0, 0);
        lebar = komponen.getPreferredSize().width;
        for (a = 0; a< tabel_data_mhs.getRowCount(); a++){
            renderer = tabel_data_mhs.getCellRenderer(a, kolom);
            komponen = renderer.getTableCellRendererComponent(tabel_data_mhs, tabel_data_mhs.getValueAt(a, kolom), false, false, a, kolom);
            int lebarKolom = komponen.getPreferredSize().width;
            lebar = Math.max(lebar, lebarKolom);
        }
        lebar = lebar + margin;
        kolomtabel.setPreferredWidth(lebar);

        kolomtabel = tabel_data_mhs.getColumnModel().getColumn(0); 
        kolomtabel.setPreferredWidth(lebar/3);
    }
    
    public boolean isCellEditable(int row, int column) {
            return false;
        }
    
    public void setLebarKolom(){
        int a;
        for(a =0; a< tabel_data_mhs.getColumnCount(); a++){
            setColomnWidth(a);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_akhir;
    public javax.swing.JButton btn_awal;
    private javax.swing.JButton btn_batal;
    public javax.swing.JButton btn_cari;
    public javax.swing.JButton btn_hapus;
    public javax.swing.JButton btn_refresh;
    public javax.swing.JButton btn_sebelum;
    public javax.swing.JButton btn_setelah;
    private javax.swing.JButton btn_simpan;
    public javax.swing.JButton btn_tambah;
    public javax.swing.JButton btn_ubah;
    public javax.swing.JButton btn_urutan;
    public javax.swing.JInternalFrame form_data;
    public javax.swing.JTextField input_cari;
    public javax.swing.JComboBox<String> input_halaman;
    public javax.swing.JComboBox<String> input_jurusan;
    public javax.swing.JComboBox<String> input_kategori;
    public javax.swing.JRadioButton input_lk;
    public javax.swing.JTextField input_nama;
    public javax.swing.JTextField input_nim;
    public javax.swing.JRadioButton input_pr;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup jk_mhs;
    public javax.swing.JTable tabel_data_mhs;
    // End of variables declaration//GEN-END:variables
}
