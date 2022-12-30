package Form;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Class.DuAn;

public class DuAnNV extends JFrame {

    private JPanel mainpanel;
    private JButton btnTrangChu;
    private JButton btnDong;
    private JButton btnReset;
    private JTable table1;
    BufferedReader bufferedReader;
    List<DuAn> duAnList = new ArrayList<>();

    public DuAnNV() {
        setContentPane(mainpanel);
        setSize(600, 400);
        init();
        DuAnNVTable duAnNVTable = new DuAnNVTable();
        table1.setModel(duAnNVTable);
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init();
                DuAnNV.DuAnNVTable nhiemVuNVTable = new DuAnNV.DuAnNVTable();
                table1.setModel(nhiemVuNVTable);
            }
        });
        btnDong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnTrangChu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrangChuNV trangChuNV = new TrangChuNV();
                trangChuNV.setVisible(true);
                dispose();
            }
        });

    }

    public class DuAnNVTable extends AbstractTableModel {
        private String[] COLUMNS = {"Mã dự án", "Tên dự án", "Chủ đầu tư", "Phòng ban phụ trách", "Ghi chú", "Chi phí dự tính", "Chi phí phát sinh"};

        @Override
        public int getRowCount() {
            return duAnList.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex) {
                case 0 -> duAnList.get(rowIndex).getMaDuAn();
                case 1 -> duAnList.get(rowIndex).getTenDuAn();
                case 2 -> duAnList.get(rowIndex).getChuDauTu();
                case 3 -> duAnList.get(rowIndex).getPhongBanPhuTrach();
                case 4 -> duAnList.get(rowIndex).getGhiChu();
                case 5 -> duAnList.get(rowIndex).getDuTinhChiPhi();
                case 6 -> duAnList.get(rowIndex).getChiPhiPhatSinh();
                default -> "-";
            };
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (getValueAt(0, columnIndex) != null) {
                return getValueAt(0, columnIndex).getClass();
            } else {
                return Object.class;
            }
        }

    }

    public void loadDataFromFile() throws IOException {
        try {
            DuAn x = null;
            bufferedReader = new BufferedReader(new FileReader("D:\\HK5\\LapTrinhJava\\QLNVCongTy\\src\\Data\\DuAn.txt"));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] a = line.split("\\|");
                x = new DuAn(a[0], a[1], a[2], Integer.parseInt(a[3]), a[4], Integer.parseInt(a[5]), a[6]);
                duAnList.add(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
    }

    public void init() {
        duAnList = new ArrayList<>();
        try {
            loadDataFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
