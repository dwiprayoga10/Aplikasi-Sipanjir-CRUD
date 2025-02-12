/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
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

public class Add_Laporan_View extends javax.swing.JFrame {

    private String role;
    
    public Add_Laporan_View() {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = dim.width;
        int screenHeight = dim.height;
        int frameWidth = this.getSize().width;
        int frameHeight = this.getSize().height;
        int xPos = (screenWidth - frameWidth) / 2;
        int yPos = (screenHeight - frameHeight) / 2;
        this.setLocation(xPos, yPos);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lbl_dashboard = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_laporan = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_pantau = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_kontak = new javax.swing.JLabel();
        lbl_logout = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tf_jmlkorban = new javax.swing.JTextField();
        tf_ketinggian = new javax.swing.JTextField();
        tf_lokasi = new javax.swing.JTextField();
        tanggal = new com.toedter.calendar.JDateChooser();
        tf_nama = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btn_chose_file = new javax.swing.JButton();
        lbl_gambar = new javax.swing.JLabel();
        tf_keterangan = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N

        lbl_laporan.setFont(new java.awt.Font("Poppins ExtraBold", 1, 12)); // NOI18N
        lbl_laporan.setForeground(new java.awt.Color(255, 255, 255));
        lbl_laporan.setText("Buat Laporan");
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

        lbl_logout.setFont(new java.awt.Font("Poppins ExtraBold", 1, 12)); // NOI18N
        lbl_logout.setForeground(new java.awt.Color(255, 255, 255));
        lbl_logout.setText("Logout");
        lbl_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_logoutMouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lfofojg.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_kontak))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_pantau))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_laporan)
                                .addComponent(lbl_dashboard)))))
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(87, 87, 87)
                    .addComponent(lbl_logout)
                    .addContainerGap(153, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_dashboard)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lbl_laporan))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(lbl_pantau))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(lbl_kontak))
                .addGap(0, 291, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(439, 439, 439)
                    .addComponent(lbl_logout)
                    .addContainerGap(98, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 610, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Poppins ExtraBold", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(8, 131, 149));
        jLabel7.setText("Buat Laporan");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel18.setFont(new java.awt.Font("Poppins ExtraLight", 1, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(8, 131, 149));
        jLabel18.setText("Nama");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel19.setFont(new java.awt.Font("Poppins ExtraLight", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(8, 131, 149));
        jLabel19.setText("Tanggal");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel20.setFont(new java.awt.Font("Poppins ExtraLight", 1, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(8, 131, 149));
        jLabel20.setText("Lokasi");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel21.setFont(new java.awt.Font("Poppins ExtraLight", 1, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(8, 131, 149));
        jLabel21.setText("Ketinggian");
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel22.setFont(new java.awt.Font("Poppins ExtraLight", 1, 10)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(8, 131, 149));
        jLabel22.setText("Jml Korban");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tf_jmlkorban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_jmlkorbanActionPerformed(evt);
            }
        });

        tf_ketinggian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ketinggianActionPerformed(evt);
            }
        });

        tanggal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tanggalMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Poppins ExtraLight", 1, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(8, 131, 149));
        jLabel6.setText("Bukti");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_chose_file.setText("Upload File");
        btn_chose_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chose_fileActionPerformed(evt);
            }
        });

        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(39, 39, 39)
                        .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel6)
                        .addGap(26, 26, 26)
                        .addComponent(btn_chose_file))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_lokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_ketinggian, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addComponent(lbl_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(13, 13, 13)
                        .addComponent(tf_jmlkorban, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_keterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel7)
                .addGap(69, 69, 69)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_chose_file, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel20)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(tf_lokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(tf_ketinggian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(tf_jmlkorban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_keterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_tambah)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 570, 420));

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dashboardMouseClicked
        this.dispose();
        Dashboard_View dashboard = new Dashboard_View("admin", true);
        dashboard.setVisible(true);
        
    
    }//GEN-LAST:event_lbl_dashboardMouseClicked

    private void lbl_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_laporanMouseClicked
        if (role.equals("admin")) {
            // Handle admin-specific action for 'Users' label click

            // Buka User_View
            this.dispose();
            Laporan_View add = new Laporan_View("admin", true);
            add.setVisible(true);
        } else {
            // Notify non-admin users (though this should not be reachable due to visibility check)
            JOptionPane.showMessageDialog(this, "Permission denied. Admin access required.");
        }
    }//GEN-LAST:event_lbl_laporanMouseClicked

    private void lbl_pantauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_pantauMouseClicked
        this.dispose();
        PantauBanjir_View pantau = new PantauBanjir_View();
        pantau.setVisible(true);
    }//GEN-LAST:event_lbl_pantauMouseClicked

    private void lbl_kontakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_kontakMouseClicked

    }//GEN-LAST:event_lbl_kontakMouseClicked

    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked

    }//GEN-LAST:event_lbl_logoutMouseClicked

    private void tf_jmlkorbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_jmlkorbanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_jmlkorbanActionPerformed

    private void tf_ketinggianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ketinggianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ketinggianActionPerformed

    private void tanggalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tanggalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalMouseClicked

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
                JOptionPane.showMessageDialog(this, "Laporan Sudah Kami Terima");
            }
            

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

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
            java.util.logging.Logger.getLogger(Add_Laporan_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Laporan_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Laporan_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Laporan_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Laporan_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_chose_file;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_gambar;
    private javax.swing.JLabel lbl_kontak;
    private javax.swing.JLabel lbl_laporan;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_pantau;
    private com.toedter.calendar.JDateChooser tanggal;
    private javax.swing.JTextField tf_jmlkorban;
    private javax.swing.JTextField tf_keterangan;
    private javax.swing.JTextField tf_ketinggian;
    private javax.swing.JTextField tf_lokasi;
    private javax.swing.JTextField tf_nama;
    // End of variables declaration//GEN-END:variables
}
