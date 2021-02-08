package Problem;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

public class karyawan_Control {

    //pengertian method
    /*Parameter adalah Data yang dapat ditambahkan dari luar Method, contoh : ketika kita membuat 
    sebuah Method untuk mengubah nama pada kelas Orang, 
    Oleh karena itu kita kita membutuhkan sebuah Parameter baru untuk menggantikan nama tersebut*/
    
    
    
    String[] header = {"ID KARYAWAN", "NAMA", "NIP", "JABATAN", "JENIS KELAMIN", "AGAMA", "STATUS", "ALAMAT"};
    private ArrayList<Karyawan> list = new ArrayList();//tempat untuk menyimpan data barang

    //Menampilkan data pada table 
    public void read(JTable tb) {
        DefaultTableModel dtm = new DefaultTableModel(null, header);// mengkontruksikan objek defaulttablemodel dengan jumlah baris dan kolomnya null

        for (int i = 0; i < list.size(); i++) {
            Object[] oj = new Object[8];
            oj[0] = list.get(i).getIdkaryawan();
            oj[1] = list.get(i).getNama();
            oj[2] = list.get(i).getNip();
            oj[3] = list.get(i).getJabatan();
            oj[4] = list.get(i).getJeniskelamin();
            oj[5] = list.get(i).getAgama();
            oj[6] = list.get(i).getStatus();
            oj[7] = list.get(i).getAlamat();
            dtm.addRow(oj); //fungsinya untuk menambahkan baris dari data yang dimasukan pada variabel oj.

        }

        tb.setModel(dtm); //fungsinya ketika di run akan mengubah tambilan table
    }

    // menambahkan data
    public void create(Karyawan kr) {
        list.add(kr);
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");

    }

    //mengubah data
    public void update(Karyawan kr) {
        for (int i = 0; i < list.size(); i++) {
            if (kr.getIdkaryawan() == list.get(i).getIdkaryawan()) {
                list.set(i, kr);
            }

        }
        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah!");

    }

    //menghapus Data
    public void delete(int Idkaryawan) {
        for (int i = 0; i < list.size(); i++) {
            if (Idkaryawan == list.get(i).getIdkaryawan()) {
                list.remove(i);

            }

        }
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
    }

    //pencarian data
    public void search(JTable tb, int Idkaryawan) {
        DefaultTableModel dtm = new DefaultTableModel(null, header);

        for (int i = 0; i < list.size(); i++) {
            if (Idkaryawan == list.get(i).getIdkaryawan()) {
                Object[] oj = new Object[8];
                oj[0] = list.get(i).getIdkaryawan();
                oj[1] = list.get(i).getNama();
                oj[2] = list.get(i).getNip();
                oj[3] = list.get(i).getJabatan();
                oj[4] = list.get(i).getJeniskelamin();
                oj[5] = list.get(i).getAgama();
                oj[6] = list.get(i).getStatus();
                oj[7] = list.get(i).getAgama();
                dtm.addRow(oj);
            }

        }
        tb.setModel(dtm);
    }

}
