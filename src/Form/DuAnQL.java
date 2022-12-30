package Form;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    Set<String> phongBanPhuTrach = new HashSet<>();
    List<String> phongBan;
    DuAn duAnSelected;
    public DuAnQL(){
        setContentPane(mainPanel);
        setSize(1000, 500);
        init();
        DuAnTable duAnTable = new DuAnTable();
        tableDuAn.setModel(duAnTable);
        tableDuAn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                duAnSelected = duAnList.get(tableDuAn.getSelectedRow());
                comboBox1.setSelectedItem(tableDuAn.getValueAt(tableDuAn.getSelectedRow(), 4));
                txtMaDA.setText(duAnSelected.getMaDuAn());
                txtTenDA.setText(duAnSelected.getTenDuAn());
                txtChuDauTu.setText(duAnSelected.getChuDauTu());
                txtDuTinhChiPhi.setText(String.valueOf(duAnSelected.getDuTinhChiPhi()));
                txtChiPhiPhatSinh.setText(String.valueOf(duAnSelected.getChiPhiPhatSinh()));
                txtGhiChu.setText(duAnSelected.getGhiChu());
                init();
                DuAnTable duAnTable = new DuAnTable();
                tableDuAn.setModel(duAnTable);
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
        btnDong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMaDA.setText("");
                txtTenDA.setText("");
                txtChuDauTu.setText("");
                txtDuTinhChiPhi.setText("");
                txtChiPhiPhatSinh.setText("");
                txtGhiChu.setText("");
                init();
                DuAnTable duAnTable = new DuAnTable();
                tableDuAn.setModel(duAnTable);
            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DuAn duAn1 = new DuAn(txtMaDA.getText(), txtTenDA.getText(), txtChuDauTu.getText(), Integer.parseInt(txtDuTinhChiPhi.getText()), (String) comboBox1.getSelectedItem(), Integer.parseInt(txtChiPhiPhatSinh.getText()), txtGhiChu.getText());
                replaceDuAn(duAn1, tableDuAn.getSelectedRow());
                init();
                DuAnTable duAnTable = new DuAnTable();
                tableDuAn.setModel(duAnTable);
            }
        });
        setVisible(true);
    }
    public void replaceDuAn(DuAn duAn, int n) {
        List<DuAn> duAns = new ArrayList<>();
        BufferedReader reader = null;
        try {
            DuAn x = null;
            reader = new BufferedReader(new FileReader("D:\\HK5\\LapTrinhJava\\QLNVCongTy\\src\\Data\\DuAn.txt"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] a = line.split("\\|");
                x = new DuAn(a[0], a[1], a[2], Integer.parseInt(a[3]), a[4], Integer.parseInt(a[5]), a[6]);
                duAns.add(x);
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
        duAns.set(n, duAn);
        BufferedWriter writer = null;
        try{
            File file = new File("D:\\HK5\\LapTrinhJava\\QLNVCongTy\\src\\Data\\DuAn.txt");
            //writer = new FileWriter(file, true);
            writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < duAns.size(); i++) {
                String w;
                if(i==0){
                    w = duAns.get(i).getMaDuAn() + "|" + duAns.get(i).getTenDuAn() + "|" + duAns.get(i).getChuDauTu() + "|" + duAns.get(i).getDuTinhChiPhi() + "|" + duAns.get(i).getPhongBanPhuTrach() + "|" + duAns.get(i).getChiPhiPhatSinh() + "|" + duAns.get(i).getGhiChu();
                }
                else{
                    w = "\n" + duAns.get(i).getMaDuAn() + "|" + duAns.get(i).getTenDuAn() + "|" + duAns.get(i).getChuDauTu() + "|" + duAns.get(i).getDuTinhChiPhi() + "|" + duAns.get(i).getPhongBanPhuTrach() + "|" + duAns.get(i).getChiPhiPhatSinh() + "|" + duAns.get(i).getGhiChu();
                }
                writer.write(w);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
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
                phongBanPhuTrach.add(a[4]);
            }
            phongBan = new ArrayList<>(phongBanPhuTrach);
            for (String a:phongBan) {
                comboBox1.addItem(a);
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
