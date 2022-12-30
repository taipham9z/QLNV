package Form;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Class.NhanVien;
public class TienLuongQL extends JFrame{

    private JTextField txtMaNV;
    private JTextField txtNhanVien;
    private JTextField txtLuongCoBan;
    private JTextField txtSoNgayNghi;
    private JTextField txtTienThuong;
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnReset;
    private JButton btnDong;
    private JButton btnTrangChu;
    private JTable tableTienLuong;
    private JPanel mainPanel;
    BufferedReader bufferedReader;
    static List<NhanVien> nhanVienList = new ArrayList<>();
    NhanVien nhanVienSelected;
    public TienLuongQL(){
        setContentPane(mainPanel);
        setSize(600, 400);
        txtMaNV.setEditable(false);
        txtNhanVien.setEditable(false);
        init();
        TienLuongTable tienLuongTable = new TienLuongTable();
        tableTienLuong.setModel(tienLuongTable);
        tableTienLuong.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nhanVienSelected = nhanVienList.get(tableTienLuong.getSelectedRow());
                txtMaNV.setText(nhanVienSelected.getMaNV());
                txtNhanVien.setText(nhanVienSelected.getTenNV());
                txtSoNgayNghi.setText(String.valueOf(nhanVienSelected.getSoNgayNghi()));
                txtLuongCoBan.setText(String.valueOf(nhanVienSelected.getLuongCoBan()));
                txtTienThuong.setText(String.valueOf(nhanVienSelected.getTienThuong()));
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        btnTrangChu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrangChuQL trangChu = new TrangChuQL();
                trangChu.setVisible(true);
                dispose();
            }
        });
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init();
                TienLuongTable tienLuongTable = new TienLuongTable();
                tableTienLuong.setModel(tienLuongTable);
                txtMaNV.setText("");
                txtSoNgayNghi.setText("");
                txtLuongCoBan.setText("");
                txtTienThuong.setText("");
            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nhanVienSelected = nhanVienList.get(tableTienLuong.getSelectedRow());
                nhanVienSelected.setLuongCoBan(Integer.parseInt(txtLuongCoBan.getText()));
                nhanVienSelected.setSoNgayNghi(Integer.parseInt(txtSoNgayNghi.getText()));
                nhanVienSelected.setTienThuong(Integer.parseInt(txtTienThuong.getText()));
                try {
                    replaceNhanVien(nhanVienSelected, tableTienLuong.getSelectedRow());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                init();
                TienLuongTable tienLuongTable = new TienLuongTable();
                tableTienLuong.setModel(tienLuongTable);
                txtMaNV.setText("");
                txtNhanVien.setText("");
                txtLuongCoBan.setText("");
                txtSoNgayNghi.setText("");
                txtTienThuong.setText("");

            }
        });
        btnDong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public void replaceNhanVien(NhanVien nhanVien, int n) throws IOException {
        BufferedReader reader = null;
        nhanVienList = new ArrayList<>();
        try {
            NhanVien x = null;
            reader = new BufferedReader(new FileReader("D:\\HK5\\LapTrinhJava\\QLNVCongTy\\src\\Data\\NhanVien.txt"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] a = line.split("\\|");
                x = new NhanVien(a[0], a[1], a[2], a[3], a[4], a[5], a[6], Integer.parseInt(a[7]), Integer.parseInt(a[8]), Integer.parseInt(a[9]), Integer.parseInt(a[10]), Integer.parseInt(a[11]));
                nhanVienList.add(x);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        nhanVienList.set(n, nhanVien);
        BufferedWriter writer = null;
        try{
            File file = new File("D:\\HK5\\LapTrinhJava\\QLNVCongTy\\src\\Data\\NhanVien.txt");
            //writer = new FileWriter(file, true);
            writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < nhanVienList.size(); i++) {
                String w;
                if(i==0){
                    w = nhanVienList.get(i).getMaNV() + "|" + nhanVienList.get(i).getTenNV() + "|" + nhanVienList.get(i).getGioiTinh() + "|" + nhanVienList.get(i).getChucVu() + "|" + nhanVienList.get(i).getPhongBan() + "|" + nhanVienList.get(i).getsDT() + "|" + nhanVienList.get(i).getDiachi() + "|" + nhanVienList.get(i).getGioVaoLam() + "|" + nhanVienList.get(i).getGioTanLam() + "|" + nhanVienList.get(i).getSoNgayNghi() + "|" + nhanVienList.get(i).getLuongCoBan() + "|" +nhanVienList.get(i).getTienThuong();
                }
                else{
                    w =  "\n" + nhanVienList.get(i).getMaNV() + "|" + nhanVienList.get(i).getTenNV() + "|" + nhanVienList.get(i).getGioiTinh() + "|" + nhanVienList.get(i).getChucVu() + "|" + nhanVienList.get(i).getPhongBan() + "|" + nhanVienList.get(i).getsDT() + "|" + nhanVienList.get(i).getDiachi() + "|" + nhanVienList.get(i).getGioVaoLam() + "|" + nhanVienList.get(i).getGioTanLam() + "|" + nhanVienList.get(i).getSoNgayNghi() + "|" + nhanVienList.get(i).getLuongCoBan() + "|" +nhanVienList.get(i).getTienThuong();
                }
                writer.write(w);
            }
            writer.flush();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            writer.close();
        }
    }
    public void loadDataFromFile() throws IOException{
        try {
            NhanVien x = null;
            bufferedReader = new BufferedReader(new FileReader("D:\\HK5\\LapTrinhJava\\QLNVCongTy\\src\\Data\\NhanVien.txt"));
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
    public static class TienLuongTable extends AbstractTableModel {
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

}
