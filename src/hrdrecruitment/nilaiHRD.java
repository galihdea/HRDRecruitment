/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrdrecruitment;
import java.sql.*;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import javax.swing.table.*;

/**
 *
 * @author Galih Dea
 */
public class nilaiHRD extends javax.swing.JFrame {

    /**
     * Creates new form nilaiHRD
     */
    
    
    public nilaiHRD() {
        initComponents();
        int baris = 0;
        try{
            //DefaultTableModel tbl = new DefaultTableModel();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrd","root","");
            Statement stmt = con.createStatement();
            String que = "select * from karyawan WHERE divisi='"+PilihDivisi.divisyon+"'";
            ResultSet rs = stmt.executeQuery(que);
            while(rs.next()){
                //tabelKaryawan.setValueAt();
                baris++;
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        try{
            DefaultTableModel tbl = (DefaultTableModel)tabelNilai.getModel();
            tbl.setRowCount(baris);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrd","root","");
            Statement stmt = con.createStatement();
            String que = "select * from karyawan WHERE divisi='"+PilihDivisi.divisyon+"'";
            ResultSet rs = stmt.executeQuery(que);
            String[] po = new String[]{"1", "2", "3", "4", "5"};
            JComboBox a = new JComboBox(po);
            int i = 0;
            while(rs.next()){
                //tabelKaryawan.setValueAt();
                int j = i+1;
                System.out.println(rs.getString(2)+","+rs.getString(3)+","+rs.getInt(4)+","+rs.getString(5)+","+rs.getString(6));
                tbl.setValueAt((Object)j,i,0);
                tbl.setValueAt((Object)rs.getString(2),i,1);
                tbl.setValueAt((Object)rs.getString(3),i,2);
                tbl.setValueAt((Object)rs.getString(6),i,3);
                i++;
            }
            tabelNilai.setModel(tbl);
            int z;
            for(z=4;z<21;z++){
                tabelNilai.getColumnModel().getColumn(z).setCellEditor(new DefaultCellEditor(a));
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelNilai = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelGap = new javax.swing.JTable();
        proses = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelRank = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        simpan = new javax.swing.JButton();
        notifikasi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Penilaian Karyawan");

        tabelNilai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "NIK", "Nama", "Jabatan", "Konsentrasi", "Fleksibilitas", "Antisipasi", "Penalaran", "Kreatifitas", "Potensi IQ", "Energi Psikis", "Ketelitian", "Pengendalian", "Motivasi", "Kehati-hatian", "Kesopanan", "Kepedulian", "Ketaatan", "Ego", "Proaktif", "Super Ego"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelNilai.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tabelNilai);

        tabelGap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "NIK", "Nama", "Jabatan", "NCi", "NSi", "Ni", "NCsk", "NSsk", "Nsk", "NCp", "NSp", "Np", "Ha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelGap.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(tabelGap);

        proses.setText("Proses");
        proses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prosesActionPerformed(evt);
            }
        });

        kembali.setText("Kembali");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        tabelRank.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "NIK", "Nama", "Jabatan", "Skor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabelRank);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Keterangan Penilaian Karyawan\n\nBagian Intelektual\nCore Factor\t\t: Konsentrasi, Fleksibilitas, dan Antisipasi\nSecondary Factor\t: Penalaran, Kreatifitas, dan Potensi IQ\n\nBagian Sikap\nCore Factor\t\t: Energi Psikis, Ketelitian, dan Pengendalian\nSecondary Factor\t: Motivasi dan Kehati-hatian\n\nBagian Perilaku\nCore Factor\t\t: Kesopanan, Kepedulian, dan Ketaatan\nSecondary Factor\t: Ego, Proaktif, dan Super Ego");
        jTextArea1.setCaretPosition(0);
        jScrollPane4.setViewportView(jTextArea1);

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        notifikasi.setText("   ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(353, 353, 353))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(notifikasi)
                        .addGap(146, 146, 146)
                        .addComponent(simpan))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(proses)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(kembali)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                                .addComponent(jScrollPane4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(proses)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kembali)
                    .addComponent(simpan)
                    .addComponent(notifikasi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
        menuHRD menu = new menuHRD();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kembaliActionPerformed

    private void prosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prosesActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tbl = (DefaultTableModel)tabelGap.getModel();
        int i,j;
        int jumlahBaris = tabelNilai.getRowCount();
        tbl.setRowCount(jumlahBaris);
        int jumlahKolom = 17;
        int[][] data = new int[jumlahBaris][jumlahKolom];
        for(i=0;i<jumlahBaris;i++){
            //String nik = (String)tabelNilai.getModel().getValueAt(i,1);
            for(j=0;j<jumlahKolom;j++){
                data[i][j] = Integer.parseInt((String)tabelNilai.getModel().getValueAt(i, j+4));
            }
            /*try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrd","root","");
                String queryUpdate = "UPDATE karyawan SET konsentrasi=? , fleksibilitas=? , antisipasi=? , penalaran=? , kreatifitas=? , potensi_iq=? , energi_psikis=? , ketelitian=? , pengendalian=? , motivasi=? , kehati_hatian=? , kesopanan=? , kepedulian=? , ketaatan=? , ego=? , proaktif=? , super_ego=? WHERE nik=?";
                PreparedStatement preparedStmt = con.prepareStatement(queryUpdate);
                preparedStmt.setInt(1,data[i][0]);
                preparedStmt.setInt(2,data[i][1]);
                preparedStmt.setInt(3,data[i][2]);
                preparedStmt.setInt(4,data[i][3]);
                preparedStmt.setInt(5,data[i][4]);
                preparedStmt.setInt(6,data[i][5]);
                preparedStmt.setInt(7,data[i][6]);
                preparedStmt.setInt(8,data[i][7]);
                preparedStmt.setInt(9,data[i][8]);
                preparedStmt.setInt(10,data[i][9]);
                preparedStmt.setInt(11,data[i][10]);
                preparedStmt.setInt(12,data[i][11]);
                preparedStmt.setInt(13,data[i][12]);
                preparedStmt.setInt(14,data[i][13]);
                preparedStmt.setInt(15,data[i][14]);
                preparedStmt.setInt(16,data[i][15]);
                preparedStmt.setInt(17,data[i][16]);
                preparedStmt.setString(18,nik);
                preparedStmt.execute();
                con.close();
            }
            catch(Exception e){
                System.out.println(e);
            }*/
        }
        double[] NCi = new double[jumlahBaris];
        double[] NSi = new double[jumlahBaris];
        double[] Ni = new double[jumlahBaris];
        double[] NCsk = new double[jumlahBaris];
        double[] NSsk = new double[jumlahBaris];
        double[] Nsk = new double[jumlahBaris];
        double[] NCp = new double[jumlahBaris];
        double[] NSp = new double[jumlahBaris];
        double[] Npe = new double[jumlahBaris];
        double[] Ha = new double[jumlahBaris];
        for(i=0;i<jumlahBaris;i++){
            j = i+1;
            String nik = (String)tabelNilai.getModel().getValueAt(i,1);
            String nama = (String)tabelNilai.getModel().getValueAt(i,2);
            String jab = (String)tabelNilai.getModel().getValueAt(i,3);
            NCi[i] = (double)(data[i][0]+data[i][1]+data[i][2])/3;
            NSi[i] = (double)(data[i][3]+data[i][4]+data[i][5])/3;
            Ni[i] = (0.6*NCi[i])+(0.4*NSi[i]);
            NCsk[i] = (double)(data[i][6]+data[i][7]+data[i][8])/3;
            NSsk[i] = (double)(data[i][9]+data[i][10])/2;
            Nsk[i] = (0.6*NCsk[i])+(0.4*NSsk[i]);
            NCp[i] = (double)(data[i][11]+data[i][12]+data[i][13])/3;
            NSp[i] = (double)(data[i][14]+data[i][15]+data[i][16])/3;
            Npe[i] = (0.6*NCp[i])+(0.4*NSp[i]);
            Ha[i] = (0.35*Ni[i])+(0.35*Nsk[i])+(0.3*Npe[i]);
            tabelGap.setValueAt((Object)j, i, 0);
            tabelGap.setValueAt((Object)nik, i, 1);
            tabelGap.setValueAt((Object)nama, i, 2);
            tabelGap.setValueAt((Object)jab, i, 3);
            tabelGap.setValueAt((Object)NCi[i], i, 4);
            tabelGap.setValueAt((Object)NSi[i], i, 5);
            tabelGap.setValueAt((Object)Ni[i], i, 6);
            tabelGap.setValueAt((Object)NCsk[i], i, 7);
            tabelGap.setValueAt((Object)NSsk[i], i, 8);
            tabelGap.setValueAt((Object)Nsk[i], i, 9);
            tabelGap.setValueAt((Object)NCp[i], i, 10);
            tabelGap.setValueAt((Object)NSp[i], i, 11);
            tabelGap.setValueAt((Object)Npe[i], i, 12);
            tabelGap.setValueAt((Object)Ha[i], i, 13);
        }
        DefaultTableModel tbel = (DefaultTableModel)tabelRank.getModel();
        tbel.setRowCount(jumlahBaris);
        String tempnik,tempnama,tempjab;
        double temprank;
        String[] nikurut = new String[jumlahBaris];
        String[] namaurut = new String[jumlahBaris];
        String[] jaburut = new String[jumlahBaris];
        double[] rank = new double[jumlahBaris];
        for(i=0;i<jumlahBaris;i++){
            nikurut[i] = (String)tabelNilai.getModel().getValueAt(i,1);
            namaurut[i] = (String)tabelNilai.getModel().getValueAt(i,2);
            jaburut[i] = (String)tabelNilai.getModel().getValueAt(i,3);
            rank[i] = Ha[i];
        }
        for(i=0;i<jumlahBaris-1;i++){
            int idxmax = i;
            for(j=i;j<jumlahBaris;j++){
                if(rank[j]>rank[idxmax]){
                    idxmax = j;
                }
            }
            temprank = rank[i];
            rank[i] = rank[idxmax];
            rank[idxmax] = temprank;
            tempnik = nikurut[i];
            nikurut[i] = nikurut[idxmax];
            nikurut[idxmax] = tempnik;
            tempnama = namaurut[i];
            namaurut[i] = namaurut[idxmax];
            namaurut[idxmax] = tempnama;
            tempjab = jaburut[i];
            jaburut[i] = jaburut[idxmax];
            jaburut[idxmax] = tempjab;
        }
        for(i=0;i<jumlahBaris;i++){
            int y = i+1;
            tabelRank.setValueAt((Object)y, i, 0);
            tabelRank.setValueAt((Object)nikurut[i], i, 1);
            tabelRank.setValueAt((Object)namaurut[i], i, 2);
            tabelRank.setValueAt((Object)jaburut[i], i, 3);
            tabelRank.setValueAt((Object)rank[i], i, 4);
        }
    }//GEN-LAST:event_prosesActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        int jumlahBaris = tabelNilai.getRowCount();
        int jumlahKolom = 17;
        int[][] data = new int[jumlahBaris][jumlahKolom];
        int i,j;
        for(i=0;i<jumlahBaris;i++){
            String nik = (String)tabelNilai.getModel().getValueAt(i,1);
            for(j=0;j<jumlahKolom;j++){
                data[i][j] = Integer.parseInt((String)tabelNilai.getModel().getValueAt(i, j+4));
            }
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrd","root","");
                String queryUpdate = "UPDATE karyawan SET konsentrasi=? , fleksibilitas=? , antisipasi=? , penalaran=? , kreatifitas=? , potensi_iq=? , energi_psikis=? , ketelitian=? , pengendalian=? , motivasi=? , kehati_hatian=? , kesopanan=? , kepedulian=? , ketaatan=? , ego=? , proaktif=? , super_ego=? WHERE nik=?";
                PreparedStatement preparedStmt = con.prepareStatement(queryUpdate);
                preparedStmt.setInt(1,data[i][0]);
                preparedStmt.setInt(2,data[i][1]);
                preparedStmt.setInt(3,data[i][2]);
                preparedStmt.setInt(4,data[i][3]);
                preparedStmt.setInt(5,data[i][4]);
                preparedStmt.setInt(6,data[i][5]);
                preparedStmt.setInt(7,data[i][6]);
                preparedStmt.setInt(8,data[i][7]);
                preparedStmt.setInt(9,data[i][8]);
                preparedStmt.setInt(10,data[i][9]);
                preparedStmt.setInt(11,data[i][10]);
                preparedStmt.setInt(12,data[i][11]);
                preparedStmt.setInt(13,data[i][12]);
                preparedStmt.setInt(14,data[i][13]);
                preparedStmt.setInt(15,data[i][14]);
                preparedStmt.setInt(16,data[i][15]);
                preparedStmt.setInt(17,data[i][16]);
                preparedStmt.setString(18,nik);
                preparedStmt.execute();
                con.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        notifikasi.setText("Data penilaian berhasil disimpan");
    }//GEN-LAST:event_simpanActionPerformed

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
            java.util.logging.Logger.getLogger(nilaiHRD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nilaiHRD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nilaiHRD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nilaiHRD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nilaiHRD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton kembali;
    private javax.swing.JLabel notifikasi;
    private javax.swing.JButton proses;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabelGap;
    private javax.swing.JTable tabelNilai;
    private javax.swing.JTable tabelRank;
    // End of variables declaration//GEN-END:variables
}