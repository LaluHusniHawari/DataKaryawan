/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem;

import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class form_new extends javax.swing.JFrame {

    karyawan_Control kc = new karyawan_Control();
    public boolean TAG = true;

    /**
     *
     */
    public form_new() {
        initComponents();
        read();
    }

    //untuk menghapus data yang diinputkan
    private void clear() {
        tfidkaryawan.setEnabled(true);
        tfidkaryawan.setText("");
        tfnama.setText("");
        tfnip.setText("");
        taalamat.setText("");
        read();

    }

    //untuk menghapus data yang diinputkan pada Combo Box
    private void reset() {
        cbjabatan.setSelectedIndex(0);
        cbjeniskelamin.setSelectedIndex(0);
        cbagama.setSelectedIndex(0);
        cbstatus.setSelectedIndex(0);
    }

    //menampilkan data pada tabel
    private void read() {
        kc.read(tblkaryawan);
    }

    private boolean validasi() {
        return !(tfidkaryawan.getText().isEmpty()
                || tfnama.getText().isEmpty()
                || tfnip.getText().isEmpty()
                || cbjabatan.getSelectedItem().toString().isEmpty()
                || cbagama.getSelectedItem().toString().isEmpty()
                || cbjeniskelamin.getSelectedItem().toString().isEmpty()
                || cbstatus.getSelectedItem().toString().isEmpty()
                || taalamat.getText().isEmpty());
    }

    private void save() {
        if (validasi()) {
            if (TAG) {
                create(); //true

            } else {
                update(); // false
            }

        }

    }

    //menambahkan data
    private void create() {
        Karyawan k = new Karyawan();
        k.setIdkaryawan(Integer.valueOf(tfidkaryawan.getText()));
        k.setNama(tfnama.getText());
        k.setNip(tfnip.getText());
        k.setJabatan(cbjabatan.getSelectedItem().toString());
        k.setJeniskelamin(cbjeniskelamin.getSelectedItem().toString());
        k.setAgama(cbagama.getSelectedItem().toString());
        k.setStatus(cbstatus.getSelectedItem().toString());
        k.setAlamat(taalamat.getText());
        kc.create(k);
        clear();

        TAG = true;

    }

    private void update() {
        Karyawan k = new Karyawan();
        k.setIdkaryawan(Integer.valueOf(tfidkaryawan.getText()));
        k.setNama(tfnama.getText());
        k.setNip(tfnip.getText());
        k.setJabatan(cbjabatan.getSelectedItem().toString());
        k.setJeniskelamin(cbjeniskelamin.getSelectedItem().toString());
        k.setAgama(cbagama.getSelectedItem().toString());
        k.setStatus(cbstatus.getSelectedItem().toString());
        k.setAlamat(taalamat.getText());
        kc.update(k);

        clear();

        TAG = true;
    }

    private void loadData() {
        int select = tblkaryawan.getSelectedRow();

        if (select == -1) {
            JOptionPane.showMessageDialog(rootPane, "Data Belum Diisi");

        } else {
            int pilih = JOptionPane.NO_OPTION;
            pilih = JOptionPane.showConfirmDialog(rootPane, "Yakin Ingin Update?",
                    "Informasi", JOptionPane.YES_NO_OPTION, 2);

            if (pilih == JOptionPane.YES_OPTION) {
                int row = tblkaryawan.getSelectedRow();
                tfidkaryawan.setText(tblkaryawan.getValueAt(row, 0).toString());
                tfnama.setText(tblkaryawan.getValueAt(row, 1).toString());
                tfnip.setText(tblkaryawan.getValueAt(row, 2).toString());
                cbjabatan.setSelectedItem(tblkaryawan.getValueAt(row, 3).toString());
                cbjeniskelamin.setSelectedItem(tblkaryawan.getValueAt(row, 4).toString());
                cbagama.setSelectedItem(tblkaryawan.getValueAt(row, 5).toString());
                cbstatus.setSelectedItem(tblkaryawan.getValueAt(row, 6).toString());
                taalamat.setText(tblkaryawan.getValueAt(row, 7).toString());
                tfidkaryawan.setEnabled(false);

                TAG = false;

            }
        }
    }

    private void delete() {
        int select = tblkaryawan.getSelectedRowCount();

        if (select == -1) {
            JOptionPane.showMessageDialog(rootPane, "Data Belum Dipilih!");

        } else {
            int pilih = JOptionPane.NO_OPTION;
            pilih = JOptionPane.showConfirmDialog(rootPane, "Yakin Ingin Hapus?",
                    "Informasi", JOptionPane.YES_NO_OPTION, 2);

            if (pilih == JOptionPane.YES_OPTION) {
                int row = tblkaryawan.getSelectedRow();

                int id = Integer.valueOf(tblkaryawan.getValueAt(row, 0).toString());
                kc.delete(id);

                clear();

            }

        }
    }

    private void search() {
        if (tfpencarian.getText().isEmpty()) {
            clear();

        } else {
            kc.search(tblkaryawan, Integer.valueOf(tfpencarian.getText()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfidkaryawan = new javax.swing.JTextField();
        tfnama = new javax.swing.JTextField();
        tfnip = new javax.swing.JTextField();
        cbjabatan = new javax.swing.JComboBox<>();
        cbjeniskelamin = new javax.swing.JComboBox<>();
        cbagama = new javax.swing.JComboBox<>();
        cbstatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        taalamat = new javax.swing.JTextArea();
        btnsimpan = new javax.swing.JButton();
        btnubah = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tfpencarian = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblkaryawan = new javax.swing.JTable();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 103, Short.MAX_VALUE)
        );

        jLabel1.setText("ID");

        jLabel2.setText("NAMA");

        jLabel3.setText("NIM");

        jLabel4.setText("JABATAN");

        jLabel5.setText("JENIS KELAMIN");

        jLabel6.setText("AGAMA");

        jLabel7.setText("STATUS");

        jLabel8.setText("ALAMAT");

        cbjabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PIlih --", "DIREKTUR", "MANEJER", "STAF", "ADMIN", "PENGADAAN" }));

        cbjeniskelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PIlih --", "LAKI-LAKI", "PEREMPUAN" }));

        cbagama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PIlih --", "ISLAM", "HINDU", "BUDHA", "KRISTEN" }));

        cbstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PIlih --", "PEGAWAI TETAP", "MAGANG" }));

        taalamat.setColumns(20);
        taalamat.setRows(5);
        jScrollPane1.setViewportView(taalamat);

        btnsimpan.setText("SIMPAN");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnubah.setText("UBAH");
        btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahActionPerformed(evt);
            }
        });

        btnhapus.setText("HAPUS");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        jLabel9.setText("PENCARIAN");

        tfpencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfpencarianActionPerformed(evt);
            }
        });

        tblkaryawan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblkaryawan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfidkaryawan)
                                    .addComponent(tfnama, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(tfnip, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(cbjabatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbagama, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbjeniskelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(btnsimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnubah)
                                .addGap(32, 32, 32)
                                .addComponent(btnhapus))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(40, 40, 40)
                .addComponent(tfpencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfidkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(cbjeniskelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(cbagama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfnip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(cbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(cbjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnhapus)
                                .addComponent(btnubah)
                                .addComponent(btnsimpan))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(38, 38, 38)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfpencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        save();
        reset();
        
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
        // TODO add your handling code here:
        loadData();
    }//GEN-LAST:event_btnubahActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void tfpencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfpencarianActionPerformed
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_tfpencarianActionPerformed

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
            java.util.logging.Logger.getLogger(form_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_new().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnubah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbagama;
    private javax.swing.JComboBox<String> cbjabatan;
    private javax.swing.JComboBox<String> cbjeniskelamin;
    private javax.swing.JComboBox<String> cbstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea taalamat;
    private javax.swing.JTable tblkaryawan;
    private javax.swing.JTextField tfidkaryawan;
    private javax.swing.JTextField tfnama;
    private javax.swing.JTextField tfnip;
    private javax.swing.JTextField tfpencarian;
    // End of variables declaration//GEN-END:variables
}
