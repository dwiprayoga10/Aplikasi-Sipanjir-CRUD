/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.table.TableModel;
import util.KoneksiDB;

/**
 *
 * @author Dwi Prayoga
 */
public class Usser_View extends javax.swing.JFrame {

    private Connection conn;
    private Statement stmt;
    private String currentUsername; // Tambahkan ini untuk melacak username pengguna saat ini
    private String username;
    private String role; // Variable to store current user role
    private KoneksiDB koneksi;
     

    public Usser_View(String username) {
        
        this.currentUsername = username; // Inisialisasi dengan username pengguna saat ini
        initComponents();
        connect(); // Menghubungkan ke database
        if (!isAdmin()) {
            JOptionPane.showMessageDialog(this, "Akses Ditolak: Anda tidak memiliki izin untuk mengakses tampilan ini.");
            dispose();
        } else {
            showData();
        }
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int centerX = (int) screenSize.getWidth() / 2;
    int centerY = (int) screenSize.getHeight() / 2;
    setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
    setVisible(true); // Memastikan jendela terlihat setelah ditempatkan di tengah
    }
    private boolean isAdmin() {
    boolean isAdmin = false;
    try {
        String sql = "SELECT role FROM users WHERE username = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, currentUsername);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String role = rs.getString("role");
            isAdmin = "admin".equalsIgnoreCase(role);
        }
        rs.close();
        pstmt.close();
    } catch (SQLException e) {
        System.out.println("Gagal memeriksa peran pengguna: " + e.getMessage());
    }
    return isAdmin;
}


    private void resetAutoIncrement() {
        try {
            Connection connReset = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sipanjir", "root", "");
            Statement stmtReset = connReset.createStatement();
            stmtReset.executeUpdate("ALTER TABLE users AUTO_INCREMENT = 1");
            stmtReset.close();
            connReset.close();
        } catch (SQLException e) {
            System.out.println("Gagal reset auto increment: " + e.getMessage());
        }
    }

    private void connect() {
    String url = "jdbc:mysql://localhost:3306/db_sipanjir"; // Sesuaikan dengan URL database Anda
    String user = "root"; // Sesuaikan dengan username database Anda
    String password = ""; // Sesuaikan dengan password database Anda

    try {
        conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement();
    } catch (SQLException e) {
        System.out.println("Koneksi ke database gagal: " + e.getMessage());
    }
}


   

    private void showSelectedData(int selectedRow) {
        if (selectedRow != -1) {
            int id = (int) tbl_database.getValueAt(selectedRow, 0);
            String nama = (String) tbl_database.getValueAt(selectedRow, 1);
            String noHp = (String) tbl_database.getValueAt(selectedRow, 2);
            String username = (String) tbl_database.getValueAt(selectedRow, 3);
            String password = (String) tbl_database.getValueAt(selectedRow, 4);
            String role = (String) tbl_database.getValueAt(selectedRow, 5);

            
        }
    }
    
    

    private void showData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama");
        model.addColumn("No Hp");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Role");

        try {
            String sql = "SELECT * FROM users"; // Ganti dengan nama tabel Anda
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("no_hp"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role")
                        
                };
                model.addRow(row);
            }
            resetAutoIncrement();

        } catch (SQLException e) {
            System.out.println("Error saat menampilkan data: " + e.getMessage());
        }

        tbl_database.setModel(model);
    }

    private void hapusData(int id) {
        try {
            String sql = "DELETE FROM users WHERE id = " + id;
            int rowsAffected = stmt.executeUpdate(sql);

            if (rowsAffected > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Data dengan ID tersebut tidak ditemukan!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }

            showData(); // Refresh tabel data setelah penghapusan
            resetAutoIncrement();

        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
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
        lbl_dashboard = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lbl_nama = new javax.swing.JLabel();
        tf_nama = new javax.swing.JTextField();
        lbl_nohp = new javax.swing.JLabel();
        tf_nohp = new javax.swing.JTextField();
        lbl_ussername = new javax.swing.JLabel();
        tf_ussername = new javax.swing.JTextField();
        lbl_password = new javax.swing.JLabel();
        tf_password = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_database = new javax.swing.JTable();
        btn_hapus = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(8, 131, 149));

        lbl_dashboard.setFont(new java.awt.Font("Poppins ExtraBold", 1, 12)); // NOI18N
        lbl_dashboard.setForeground(new java.awt.Color(255, 255, 255));
        lbl_dashboard.setText("Dahboard");
        lbl_dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_dashboardMouseClicked(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        jLabel2.setFont(new java.awt.Font("Poppins ExtraBold", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buat Laporan");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lfofojg.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
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
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(lbl_dashboard))))
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(lbl_dashboard))
                .addGap(16, 16, 16)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(lbl_laporan))
                .addGap(24, 24, 24)
                .addComponent(lbl_logout)
                .addGap(56, 56, 56))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        lbl_nama.setBackground(new java.awt.Color(8, 131, 149));
        lbl_nama.setFont(new java.awt.Font("Poppins ExtraLight", 1, 10)); // NOI18N
        lbl_nama.setForeground(new java.awt.Color(8, 131, 149));
        lbl_nama.setText("Nama");

        lbl_nohp.setBackground(new java.awt.Color(8, 131, 149));
        lbl_nohp.setFont(new java.awt.Font("Poppins ExtraLight", 1, 10)); // NOI18N
        lbl_nohp.setForeground(new java.awt.Color(8, 131, 149));
        lbl_nohp.setText("No Hp");

        lbl_ussername.setBackground(new java.awt.Color(8, 131, 149));
        lbl_ussername.setFont(new java.awt.Font("Poppins ExtraLight", 1, 10)); // NOI18N
        lbl_ussername.setForeground(new java.awt.Color(8, 131, 149));
        lbl_ussername.setText("Ussername");

        lbl_password.setBackground(new java.awt.Color(8, 131, 149));
        lbl_password.setFont(new java.awt.Font("Poppins ExtraLight", 1, 10)); // NOI18N
        lbl_password.setForeground(new java.awt.Color(8, 131, 149));
        lbl_password.setText("Password");

        tbl_database.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "Nama", "No Hp", "Username", "Password", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_database.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_databaseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_database);
        if (tbl_database.getColumnModel().getColumnCount() > 0) {
            tbl_database.getColumnModel().getColumn(0).setResizable(false);
            tbl_database.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        btn_hapus.setText("Hapus");
        btn_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hapusMouseClicked(evt);
            }
        });
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_nohp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nama)
                    .addComponent(lbl_ussername)
                    .addComponent(lbl_password))
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tf_nohp, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_ussername, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_password, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(126, 126, 126))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_hapus)
                        .addGap(117, 117, 117)
                        .addComponent(btn_tambah)
                        .addGap(118, 118, 118)
                        .addComponent(btn_edit)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_nohp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nohp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ussername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ussername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_hapus)
                    .addComponent(btn_edit)
                    .addComponent(btn_tambah))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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
        Login_Form loginView = new Login_Form();
        loginView.setVisible(true);
        this.dispose(); // Menutup form Laporan_View
    }//GEN-LAST:event_lbl_logoutMouseClicked

    private void tbl_databaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_databaseMouseClicked
                    int i = tbl_database.getSelectedRow();
    TableModel model = tbl_database.getModel();

    // Ambil data dari tabel dan tampilkan di field
    tf_nama.setText(model.getValueAt(i, 1).toString());
    tf_nohp.setText(model.getValueAt(i, 2).toString());
    tf_ussername.setText(model.getValueAt(i, 3).toString());
    tf_password.setText(model.getValueAt(i, 4).toString());

    }//GEN-LAST:event_tbl_databaseMouseClicked

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked

    }//GEN-LAST:event_btn_hapusMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        int selectedRow = tbl_database.getSelectedRow();

        if (selectedRow != -1) {
            int id = (int) tbl_database.getValueAt(selectedRow, 0);

            int response = javax.swing.JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", javax.swing.JOptionPane.YES_NO_OPTION);

            if (response == javax.swing.JOptionPane.YES_OPTION) {
                hapusData(id);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Silakan pilih data yang ingin dihapus.", "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
         String nama = tf_nama.getText();
        String no_hp = tf_nohp.getText();
        String username = tf_ussername.getText();
        char[] passwordChars = tf_password.getPassword();
        String password = new String(passwordChars);

        if (nama.isEmpty() || no_hp.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String sql = "INSERT INTO users (nama, no_hp, username, password) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nama);
            pstmt.setString(2, no_hp);
            pstmt.setString(3, username);
            pstmt.setString(4, password);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");

            showData();

            tf_nama.setText("");
            tf_nohp.setText("");
            tf_ussername.setText("");
            tf_password.setText("");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menambah data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
       int selectedRow = tbl_database.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Silakan pilih data yang ingin diedit.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = (int) tbl_database.getValueAt(selectedRow, 0);

        String nama = tf_nama.getText();
        String noHp = tf_nohp.getText();
        String username = tf_ussername.getText();
        char[] passwordChars = tf_password.getPassword();
        String password = new String(passwordChars);

        if (nama.isEmpty() || noHp.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String sql = "UPDATE users SET nama = ?, no_hp = ?, username = ?, password = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nama);
            pstmt.setString(2, noHp);
            pstmt.setString(3, username);
            pstmt.setString(4, password);
            pstmt.setInt(5, id);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
            } else {
                JOptionPane.showMessageDialog(this, "Gagal mengupdate data.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            showData();
            showSelectedData(selectedRow);

            tf_nama.setText("");
            tf_nohp.setText("");
            tf_ussername.setText("");
            tf_password.setText("");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengupdate data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_editActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
        Add_Laporan_View addlaporan = new Add_Laporan_View();
        addlaporan.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
  
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
             public void run() {
                new Usser_View("admin_username").setVisible(true); // Ganti "admin_username" dengan username yang valid
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_kontak;
    private javax.swing.JLabel lbl_laporan;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_nama;
    private javax.swing.JLabel lbl_nohp;
    private javax.swing.JLabel lbl_pantau;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_ussername;
    private javax.swing.JLabel lbl_ussers;
    private javax.swing.JTable tbl_database;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JTextField tf_nohp;
    private javax.swing.JPasswordField tf_password;
    private javax.swing.JTextField tf_ussername;
    // End of variables declaration//GEN-END:variables
}
