/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.Laporan_View;  // Ganti 'view' dengan nama paket sesungguhnya jika berbeda

import util.KoneksiDB;

/**
 *
 * @author Dwi Prayoga
 */
public class Dashboard_View extends javax.swing.JFrame {
    private String role; // Variable to store current user role
    private KoneksiDB koneksi;
     private String username;
    
     
    public Dashboard_View(String username, boolean isAdmin) {
        initComponents();
         tampilkanData();
        this.setLocationRelativeTo(null);
        this.username = username; // Inisialisasi username

        this.role = isAdmin ? "admin" : "umum";

        if (!isAdmin) {
            jLabel5.setVisible(false);
            lbl_ussers.setVisible(false);
            lbl_laporan.setVisible(false);
            jLabel3.setVisible(false);
        }
    
    }
    private void tampilkanData() {
        DefaultTableModel model = (DefaultTableModel) tbl_tampil.getModel();
        model.setRowCount(0); // Mengosongkan tabel sebelum menambahkan data baru

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sipanjir", "root", "");
            String sql = "SELECT no, nama, lokasi, tanggal, ketinggian FROM laporan ORDER BY no";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("no"),
                    rs.getString("nama"),
                    rs.getString("lokasi"),
                     // Gunakan getDate untuk kolom tanggal
                    rs.getInt("ketinggian"), // Sesuaikan dengan tipe data kolom 'ketinggian'
                    rs.getDate("tanggal"),
                    
                };
                model.addRow(row); // Menambahkan baris ke tabel
            }

            rs.close();
            stmt.close();
            conn.close();
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengambil data dari database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }


    

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
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
        jLabel1 = new javax.swing.JLabel();
        lbl_add = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btn_edukasi = new javax.swing.JButton();
        btn_laporbanjir = new javax.swing.JButton();
        btn_pantaubanjir = new javax.swing.JButton();
        btn_Kontakdarurat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tampil = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(8, 131, 149));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N

        lbl_add.setFont(new java.awt.Font("Poppins ExtraBold", 1, 12)); // NOI18N
        lbl_add.setForeground(new java.awt.Color(255, 255, 255));
        lbl_add.setText("Buat Laporan");
        lbl_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_addMouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lfofojg.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_ussers))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lbl_logout))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_kontak))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_pantau))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_laporan))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_add)
                            .addComponent(lbl_dashboard))))
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(lbl_dashboard))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_add)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(lbl_pantau))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(lbl_kontak))
                .addGap(110, 110, 110)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_ussers, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(lbl_laporan))
                .addGap(39, 39, 39)
                .addComponent(lbl_logout)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, -1));

        btn_edukasi.setText("Edukasi");
        btn_edukasi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_edukasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edukasiActionPerformed(evt);
            }
        });
        jPanel3.add(btn_edukasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 110, 70));

        btn_laporbanjir.setText("Lapor Banjir");
        btn_laporbanjir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_laporbanjir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laporbanjirActionPerformed(evt);
            }
        });
        jPanel3.add(btn_laporbanjir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 110, 70));

        btn_pantaubanjir.setText("Pantau Banjir");
        btn_pantaubanjir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pantaubanjir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pantaubanjirActionPerformed(evt);
            }
        });
        jPanel3.add(btn_pantaubanjir, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 110, 70));

        btn_Kontakdarurat.setText("Kontak Darurat");
        btn_Kontakdarurat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Kontakdarurat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KontakdaruratActionPerformed(evt);
            }
        });
        jPanel3.add(btn_Kontakdarurat, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 110, 70));

        tbl_tampil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Pelapor", "Lokasi", "Kedalaman (cm)", "Waktu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_tampil);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 540, 200));

        jLabel7.setFont(new java.awt.Font("Poppins ExtraBold", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(8, 131, 149));
        jLabel7.setText("Dashboard ");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Poppins ExtraBold", 1, 14)); // NOI18N
        jLabel2.setText("Waspada!!!");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel6.setText("Telah Terjadi Banjir dengan Ketinggian bervariasi di Kota Semarang");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dashboardMouseClicked
       
    }//GEN-LAST:event_lbl_dashboardMouseClicked

    private void lbl_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_laporanMouseClicked
                                               
             if (role.equals("admin")) {
        
        
        this.dispose();
        Laporan_View laporan = new Laporan_View("admin", true);
        laporan.setVisible(true);
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
         this.dispose();
        Kontak_View kontak = new Kontak_View();
        kontak.setVisible(true);
    }//GEN-LAST:event_lbl_kontakMouseClicked

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

    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked
        this.dispose();
        Login_Form login = new Login_Form();
        login.setVisible(true);
    }//GEN-LAST:event_lbl_logoutMouseClicked

    private void lbl_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_addMouseClicked
        this.dispose();
        Add_Laporan_View addlaporan = new Add_Laporan_View();
        addlaporan.setVisible(true);
    }//GEN-LAST:event_lbl_addMouseClicked

    private void btn_laporbanjirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporbanjirActionPerformed
        this.dispose();
        Add_Laporan_View  addlaporan = new Add_Laporan_View();
        addlaporan.setVisible(true);
    }//GEN-LAST:event_btn_laporbanjirActionPerformed

    private void btn_KontakdaruratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KontakdaruratActionPerformed
        this.dispose();
        Kontak_View  kontak = new Kontak_View();
        kontak.setVisible(true);
    }//GEN-LAST:event_btn_KontakdaruratActionPerformed

    private void btn_edukasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edukasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_edukasiActionPerformed

    private void btn_pantaubanjirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pantaubanjirActionPerformed
        this.dispose();
        PantauBanjir_View  pantau = new PantauBanjir_View();
        pantau.setVisible(true);
    }//GEN-LAST:event_btn_pantaubanjirActionPerformed

    /**
     * @param args the command line arguments
     * 
     */
     public static void main(String args[]) {
        // Example main method for initialization
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Example: assume username is "admin" and isAdmin is true for admin role
                Dashboard_View dashboard = new Dashboard_View("admin", true);
                dashboard.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Kontakdarurat;
    private javax.swing.JButton btn_edukasi;
    private javax.swing.JButton btn_laporbanjir;
    private javax.swing.JButton btn_pantaubanjir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_add;
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_kontak;
    private javax.swing.JLabel lbl_laporan;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_pantau;
    private javax.swing.JLabel lbl_ussers;
    private javax.swing.JTable tbl_tampil;
    // End of variables declaration//GEN-END:variables
}

