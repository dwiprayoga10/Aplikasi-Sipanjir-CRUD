package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.JOptionPane;

import java.io.File;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;
import util.KoneksiDB;


public class Laporan_View extends javax.swing.JFrame {
    private KoneksiDB koneksi;
    private String username;
    private String role; // Tambahkan variabel role untuk menentukan peran pengguna

    public Laporan_View(String username, boolean isAdmin) {
        initComponents();
        Date date = new Date();
        tanggal.setDate(date);
        this.username = username;
        this.role = isAdmin ? "admin" : "umum";

        // Sesuaikan visibilitas komponen berdasarkan role
        if (!isAdmin) {
            
            btn_hapus.setVisible(false); // Tombol hapus tidak terlihat untuk role umum
        } else {
            btn_hapus.setVisible(true); // Pastikan tombol hapus terlihat untuk role admin
        }

        tampilkanData();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = dim.width;
        int screenHeight = dim.height;
        int frameWidth = this.getSize().width;
        int frameHeight = this.getSize().height;
        int xPos = (screenWidth - frameWidth) / 2;
        int yPos = (screenHeight - frameHeight) / 2;
        this.setLocation(xPos, yPos);
    }

  

    private void tampilkanData() {
        DefaultTableModel model = (DefaultTableModel) tbl_laporan.getModel();
        model.setRowCount(0); // Mengosongkan tabel sebelum menambahkan data baru

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sipanjir", "root", "");
            String sql = "SELECT no, nama, tanggal, lokasi, ketinggian, jml_korban, keterangan FROM laporan ORDER BY no";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("no"),
                    rs.getString("nama"),
                    rs.getDate("tanggal"), // Gunakan getDate untuk kolom tanggal
                    rs.getString("lokasi"),
                    rs.getInt("ketinggian"), // Sesuaikan dengan tipe data kolom 'ketinggian'
                    rs.getString("jml_korban"),
                    rs.getString("keterangan")
                };
                model.addRow(row); // Menambahkan baris ke tabel
            }

            rs.close();
            stmt.close();
            conn.close();
            resetAutoIncrement();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengambil data dari database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void hapusData(int no) {
        if (!isAdmin()) {
            JOptionPane.showMessageDialog(this, "Anda tidak memiliki izin untuk menghapus data.", "Akses Ditolak", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sipanjir", "root", "");
            String sql = "DELETE FROM laporan WHERE no = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, no);
            stmt.executeUpdate();
            stmt.close();
            conn.close();

            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
            tampilkanData(); // Refresh tabel data setelah penghapusan
            resetAutoIncrement();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetAutoIncrement() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sipanjir", "root", "");
            Statement stmt = conn.createStatement();
            // Mengatur nilai auto increment kembali ke 1
            stmt.executeUpdate("ALTER TABLE laporan AUTO_INCREMENT = 1");
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isAdmin() {
        return "admin".equals(role); // Implementasi sederhana untuk mengecek apakah pengguna adalah admin
    }

    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lbl_dashboard = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_laporan = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_pantau = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_kontak = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_ussers = new javax.swing.JLabel();
        lbl_logout = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_laporan = new javax.swing.JTable();
        btn_tambah = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tf_nama = new javax.swing.JTextField();
        tf_lokasi = new javax.swing.JTextField();
        tf_ketinggian = new javax.swing.JTextField();
        tf_jmlkorban = new javax.swing.JTextField();
        btn_chose_file = new javax.swing.JButton();
        lbl_gambar = new javax.swing.JLabel();
        tf_keterangan = new javax.swing.JTextField();
        tanggal = new com.toedter.calendar.JDateChooser();
        btn_hapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(8, 131, 149));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbl_dashboard.setFont(new java.awt.Font("Poppins ExtraBold", 1, 12)); // NOI18N
        lbl_dashboard.setForeground(new java.awt.Color(255, 255, 255));
        lbl_dashboard.setText("Dahboard");
        lbl_dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_dashboardMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/laporan view.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbl_laporan.setFont(new java.awt.Font("Poppins ExtraBold", 1, 12)); // NOI18N
        lbl_laporan.setForeground(new java.awt.Color(255, 255, 255));
        lbl_laporan.setText("Laporan");
        lbl_laporan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_laporanMouseClicked(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edukasi.png"))); // NOI18N
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbl_pantau.setFont(new java.awt.Font("Poppins ExtraBold", 1, 12)); // NOI18N
        lbl_pantau.setForeground(new java.awt.Color(255, 255, 255));
        lbl_pantau.setText("Pantau Banjir");
        lbl_pantau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_pantau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_pantauMouseClicked(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kontak.png"))); // NOI18N
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbl_kontak.setFont(new java.awt.Font("Poppins ExtraBold", 1, 12)); // NOI18N
        lbl_kontak.setForeground(new java.awt.Color(255, 255, 255));
        lbl_kontak.setText("Kontak Darurat");
        lbl_kontak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_kontak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_kontakMouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user-guide view.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbl_ussers.setFont(new java.awt.Font("Poppins ExtraBold", 1, 12)); // NOI18N
        lbl_ussers.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ussers.setText("Ussers");
        lbl_ussers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_ussers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ussersMouseClicked(evt);
            }
        });

        lbl_logout.setFont(new java.awt.Font("Poppins ExtraBold", 1, 12)); // NOI18N
        lbl_logout.setForeground(new java.awt.Color(255, 255, 255));
        lbl_logout.setText("Logout");
        lbl_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_logoutMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Poppins ExtraBold", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buat Laporan");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lfofojg.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_ussers))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lbl_logout))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_kontak))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_pantau))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_laporan))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lbl_dashboard)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(35, 35, 35)))
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_dashboard)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(lbl_pantau))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(lbl_kontak))
                .addGap(110, 110, 110)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_ussers, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(lbl_laporan))
                .addGap(18, 18, 18)
                .addComponent(lbl_logout)
                .addGap(56, 56, 56))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Poppins ExtraLight", 1, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(8, 131, 149));
        jLabel6.setText("Bukti");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        tbl_laporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Nama", "Tanggal", "Lokasi", "Ketinggian", "Jml Korban", "Bukti"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_laporan);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 239, 570, 230));

        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        jPanel4.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Poppins ExtraBold", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(8, 131, 149));
        jLabel7.setText("Buat Laporan");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel18.setFont(new java.awt.Font("Poppins ExtraLight", 1, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(8, 131, 149));
        jLabel18.setText("Nama");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel19.setFont(new java.awt.Font("Poppins ExtraLight", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(8, 131, 149));
        jLabel19.setText("Tanggal");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel20.setFont(new java.awt.Font("Poppins ExtraLight", 1, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(8, 131, 149));
        jLabel20.setText("Lokasi");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel21.setFont(new java.awt.Font("Poppins ExtraLight", 1, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(8, 131, 149));
        jLabel21.setText("Ketinggian");
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 20));

        jLabel22.setFont(new java.awt.Font("Poppins ExtraLight", 1, 10)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(8, 131, 149));
        jLabel22.setText("Jml Korban");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));
        jPanel4.add(tf_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 160, -1));
        jPanel4.add(tf_lokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 160, -1));

        tf_ketinggian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ketinggianActionPerformed(evt);
            }
        });
        jPanel4.add(tf_ketinggian, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 160, -1));

        tf_jmlkorban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_jmlkorbanActionPerformed(evt);
            }
        });
        jPanel4.add(tf_jmlkorban, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 160, -1));

        btn_chose_file.setText("Upload File");
        btn_chose_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chose_fileActionPerformed(evt);
            }
        });
        jPanel4.add(btn_chose_file, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 43, -1, 30));
        jPanel4.add(lbl_gambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 160, 80));
        jPanel4.add(tf_keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 160, -1));

        tanggal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tanggalMouseClicked(evt);
            }
        });
        jPanel4.add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 160, -1));

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel4.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 570, 470));

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dashboardMouseClicked
        this.dispose();
        Dashboard_View dashboard = new Dashboard_View("umum", true);
        dashboard.setVisible(true);
    }//GEN-LAST:event_lbl_dashboardMouseClicked

    private void lbl_pantauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_pantauMouseClicked
        this.dispose();
        PantauBanjir_View pantau = new PantauBanjir_View();
        pantau.setVisible(true);
    }//GEN-LAST:event_lbl_pantauMouseClicked

    private void lbl_kontakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_kontakMouseClicked
       
    }//GEN-LAST:event_lbl_kontakMouseClicked

    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked
        
    }//GEN-LAST:event_lbl_logoutMouseClicked

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        String nama = tf_nama.getText();
        Date tanggalValue = tanggal.getDate();
        String lokasi = tf_lokasi.getText();
        String ketinggian = tf_ketinggian.getText();
        String jmlKorban = tf_jmlkorban.getText();
        String keterangan = tf_keterangan.getText();

        // Validasi data
        if (nama.isEmpty() || tanggalValue == null || lokasi.isEmpty() || ketinggian.isEmpty() || jmlKorban.isEmpty() || keterangan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Insert into database
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sipanjir", "root", "");
            String sql = "INSERT INTO laporan (nama, tanggal, lokasi, ketinggian, jml_korban, keterangan) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nama);
            stmt.setDate(2, new java.sql.Date(tanggalValue.getTime()));
            stmt.setString(3, lokasi);
            stmt.setString(4, ketinggian);
            stmt.setString(5, jmlKorban);
            stmt.setString(6, keterangan);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Berhasil");
            }
            tampilkanData();
             

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_tambahActionPerformed

    private void tf_ketinggianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ketinggianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ketinggianActionPerformed

    private void tf_jmlkorbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_jmlkorbanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_jmlkorbanActionPerformed

    private void btn_chose_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chose_fileActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // Menampilkan path file di jTextField1
            tf_keterangan.setText(selectedFile.getName()); // Menampilkan nama file di jTextField1

            // Menampilkan gambar di lbl_gambar
            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
            Image image = imageIcon.getImage().getScaledInstance(lbl_gambar.getWidth(), lbl_gambar.getHeight(), Image.SCALE_SMOOTH);
            lbl_gambar.setIcon(new ImageIcon(image));
        }
    }//GEN-LAST:event_btn_chose_fileActionPerformed

    private void tanggalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tanggalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        if (isAdmin()) {
        int selectedRow = tbl_laporan.getSelectedRow();
        if (selectedRow >= 0) {
            int no = (int) tbl_laporan.getValueAt(selectedRow, 0); // Mengambil nilai no dari baris yang dipilih
            hapusData(no); // Menghapus data berdasarkan no
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Anda tidak memiliki izin untuk menghapus data.", "Akses Ditolak", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
         if (role.equals("admin")) {
        // Handle admin-specific action for 'Users' label click
        

        // Buka User_View
        this.dispose();
        Add_Laporan_View add = new Add_Laporan_View();
        add.setVisible(true);
    } else {
        // Notify non-admin users (though this should not be reachable due to visibility check)
        JOptionPane.showMessageDialog(this, "Permission denied. Admin access required.");
    }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void lbl_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_laporanMouseClicked

    }//GEN-LAST:event_lbl_laporanMouseClicked

    private void lbl_ussersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ussersMouseClicked
        if (role.equals("admin")) {
            // Handle admin-specific action for 'Users' label click

            // Buka User_View
            this.dispose();
            Usser_View userView = new Usser_View("admin");
            userView.setVisible(true);
        } else {
            // Notify non-admin users (though this should not be reachable due to visibility check)
            JOptionPane.showMessageDialog(this, "Permission denied. Admin access required.");
        }
    }//GEN-LAST:event_lbl_ussersMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Laporan_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Laporan_View laporan =new Laporan_View("admin", true);
                
                laporan.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_chose_file;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_gambar;
    private javax.swing.JLabel lbl_kontak;
    private javax.swing.JLabel lbl_laporan;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_pantau;
    private javax.swing.JLabel lbl_ussers;
    private com.toedter.calendar.JDateChooser tanggal;
    private javax.swing.JTable tbl_laporan;
    private javax.swing.JTextField tf_jmlkorban;
    private javax.swing.JTextField tf_keterangan;
    private javax.swing.JTextField tf_ketinggian;
    private javax.swing.JTextField tf_lokasi;
    private javax.swing.JTextField tf_nama;
    // End of variables declaration//GEN-END:variables
}
