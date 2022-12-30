package Form;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Class.DuAn;
public class DuAnQL extends JFrame{
    private JTextField txtMaDA;
    private JTextField txtTenDA;
    private JTextField txtChuDauTu;
    private JTextField txtDuTinhChiPhi;
    private JTextField txtChiPhiPhatSinh;
    private JTextField txtGhiChu;
    private JComboBox<String> comboBox1;
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btnReset;
    private JButton btnDong;
    private JTable tableDuAn;
    private JPanel mainPanel;
    private BufferedReader bufferedReader;
    static List<DuAn> duAnList = new ArrayList<>();
    public DuAnQL(){
        setContentPane(mainPanel);
        setSize(1000, 500);
        init();
        DuAnTable duAnTable = new DuAnTable();
        tableDuAn.setModel(duAnTable);
        setVisible(true);
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
    public void init(){
        try {
            loadDataFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static class DuAnTable extends AbstractTableModel{
        private String[] COLUMNS = {"Mã dự án", "Tên dự án", "Chủ đầu tư", "Dự tính chi phí", "Phòng ban phụ trách", "Chi phí phát sinh", "Ghi chú"};
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
            return switch (columnIndex){
                case 0 -> duAnList.get(rowIndex).getMaDuAn();
                case 1 -> duAnList.get(rowIndex).getTenDuAn();
                case 2 -> duAnList.get(rowIndex).getChuDauTu();
                case 3 -> duAnList.get(rowIndex).getDuTinhChiPhi();
                case 4 -> duAnList.get(rowIndex).getPhongBanPhuTrach();
                case 5 -> duAnList.get(rowIndex).getChiPhiPhatSinh();
                case 6 -> duAnList.get(rowIndex).getGhiChu();
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
    public static void main(String[] args) {
        DuAnQL duAnQL = new DuAnQL();

    }
}
