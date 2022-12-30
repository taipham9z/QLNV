package Form;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Class.NhanVien;

public class TienLuongNV extends JFrame {
    private JTable tableTimKiem;
    private JTable tableDanhSach;
    private JTextField txtMaNV;
    private JTextField txtTenNV;
    private JButton btnTraCuuMaNV;
    private JButton btnTraCuuTenNV;
    private JButton btnTrangChu;
    private JPanel mainPanel;
    private JButton btnReset;

    List<NhanVien> nhanVienList = new ArrayList<>();
    BufferedReader bufferedReader;
    List<NhanVien> nhanVienTimKiem = new ArrayList<>();
    public TienLuongNV(){
        setContentPane(mainPanel);
        setSize(700, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Tiền lương");
        init();
        TienLuongTable tienLuongTable = new TienLuongTable();
        tableDanhSach.setModel(tienLuongTable);
        btnTrangChu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrangChuNV trangChuNV = new TrangChuNV();
                trangChuNV.setVisible(true);
                dispose();
            }
        });
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nhanVienTimKiem = new ArrayList<>();
                TienLuongTimKiemTable tienLuongTimKiemTable = new TienLuongTimKiemTable();
                tableTimKiem.setModel(tienLuongTimKiemTable);
                txtMaNV.setText("");
                txtTenNV.setText("");
            }
        });
        btnTraCuuMaNV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nhanVienTimKiem = new ArrayList<>();
                NhanVien a = new NhanVien();
                String maNV = txtMaNV.getText();
                for(int i=0;i<nhanVienList.size();i++){
                    if(maNV.equals(nhanVienList.get(i).getMaNV())){
                        a = nhanVienList.get(i);
                        nhanVienTimKiem.add(a);
                    }
                }
                TienLuongTimKiemTable tienLuongTimKiemTable = new TienLuongTimKiemTable();
                tableTimKiem.setModel(tienLuongTimKiemTable);
            }
        });
        btnTraCuuTenNV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nhanVienTimKiem = new ArrayList<>();
                NhanVien a = new NhanVien();
                String maNV = txtTenNV.getText();
                for(int i=0;i<nhanVienList.size();i++){
                    if(maNV.equals(nhanVienList.get(i).getTenNV())){
                        a = nhanVienList.get(i);
                        nhanVienTimKiem.add(a);
                    }
                }
                TienLuongTimKiemTable tienLuongTimKiemTable = new TienLuongTimKiemTable();
                tableTimKiem.setModel(tienLuongTimKiemTable);
            }
        });
    }
    public static final String DATA_FILE_PATH_NHAN_VIEN = "NhanVien.txt";
    File file = new File(DATA_FILE_PATH_NHAN_VIEN);

    String absolutePath = file.getAbsolutePath();
    public void loadDataFromFile() throws IOException{
        try {
            NhanVien x = null;
            bufferedReader = new BufferedReader(new FileReader(absolutePath));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] a = line.split("\\|");
                x = new NhanVien(a[0], a[1], a[2], a[3], a[4], a[5], a[6], Integer.parseInt(a[7]), Integer.parseInt(a[8]), Integer.parseInt(a[9]), Integer.parseInt(a[10]), Integer.parseInt(a[11]));
                nhanVienList.add(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
    }
    public void init() {
        nhanVienList = new ArrayList<>();
        try {
            loadDataFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public class TienLuongTable extends AbstractTableModel {
        String[] COLUMNS = {"Mã nhân viên", "Tên nhân viên", "Lương cơ bản","Số ngày nghỉ", "Tiền thưởng"};
        @Override
        public int getRowCount() {
            return nhanVienList.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex){
                case 0 -> nhanVienList.get(rowIndex).getMaNV();
                case 1 -> nhanVienList.get(rowIndex).getTenNV();
                case 2 -> nhanVienList.get(rowIndex).getLuongCoBan();
                case 3 -> nhanVienList.get(rowIndex).getSoNgayNghi();
                case 4 -> nhanVienList.get(rowIndex).getTienThuong();
                default ->  "-";
            };
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if(getValueAt(0, columnIndex) != null){
                return getValueAt(0, columnIndex).getClass();
            }else{
                return Object.class;
            }
        }

    }
    public class TienLuongTimKiemTable extends AbstractTableModel {
        String[] COLUMNS = {"Mã nhân viên", "Tên nhân viên", "Lương cơ bản","Số ngày nghỉ", "Tiền thưởng"};
        @Override
        public int getRowCount() {
            return nhanVienTimKiem.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex){
                case 0 -> nhanVienTimKiem.get(rowIndex).getMaNV();
                case 1 -> nhanVienTimKiem.get(rowIndex).getTenNV();
                case 2 -> nhanVienTimKiem.get(rowIndex).getLuongCoBan();
                case 3 -> nhanVienTimKiem.get(rowIndex).getSoNgayNghi();
                case 4 -> nhanVienTimKiem.get(rowIndex).getTienThuong();
                default ->  "-";
            };
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if(getValueAt(0, columnIndex) != null){
                return getValueAt(0, columnIndex).getClass();
            }else{
                return Object.class;
            }
        }

    }
}
