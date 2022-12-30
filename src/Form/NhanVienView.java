package Form;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import Class.NhanVien;
import Class.NhanVienDAO;
public class NhanVienView extends JFrame {

    private JButton btnTrangChu;
    private JButton btnTraCuu;
    private JButton btnDong;
    private JTable tableNhanVienView;
    private JPanel mainPanel;
    private NhanVienDAO nhanVienDAO;
    private BufferedReader bufferedReader;

    public NhanVienView(){
        setContentPane(mainPanel);
        setSize(1000, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Nhân viên");
        init();
        NhanVienViewTable nhanVienViewTable = new NhanVienViewTable();
        tableNhanVienView.setModel(nhanVienViewTable);

        btnTrangChu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrangChuNV trangChuNV = new TrangChuNV();
                trangChuNV.setVisible(true);
                dispose();
            }
        });
        btnDong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnTraCuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TraCuuNV traCuuNV = new TraCuuNV();
                traCuuNV.setVisible(true);
                init();
                NhanVienViewTable nhanVienViewTable = new NhanVienViewTable();
                tableNhanVienView.setModel(nhanVienViewTable);
            }
        });

    }
    public class NhanVienViewTable extends AbstractTableModel{
        private String[] COLUMNS = {"Mã nhân viên", "Tên nhân viên", "Giới tính", "Chức vụ", "Phòng ban", "SĐT", "Địa chỉ", "Giờ vào làm", "Giờ tan làm", "Số ngày nghỉ", "Lương cơ bản", "Tiền thưởng"};
        private List<NhanVien> nhanVienList = nhanVienDAO.getNhanVienList();
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
                case 2 -> nhanVienList.get(rowIndex).getGioiTinh();
                case 3 -> nhanVienList.get(rowIndex).getChucVu();
                case 4 -> nhanVienList.get(rowIndex).getPhongBan();
                case 5 -> nhanVienList.get(rowIndex).getsDT();
                case 6 -> nhanVienList.get(rowIndex).getDiachi();
                case 7 -> nhanVienList.get(rowIndex).getGioVaoLam();
                case 8 -> nhanVienList.get(rowIndex).getGioTanLam();
                case 9 -> nhanVienList.get(rowIndex).getSoNgayNghi();
                case 10 -> nhanVienList.get(rowIndex).getLuongCoBan();
                case 11 -> nhanVienList.get(rowIndex).getTienThuong();
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
    public void loadDataFromFile() throws IOException {
        try {
            NhanVien x = null;
            bufferedReader = new BufferedReader(new FileReader("D:\\HK5\\LapTrinhJava\\QLNVCongTy\\src\\Data\\NhanVien.txt"));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] a = line.split("\\|");
                x = new NhanVien(a[0], a[1], a[2], a[3], a[4], a[5], a[6], Integer.parseInt(a[7]), Integer.parseInt(a[8]), Integer.parseInt(a[9]), Integer.parseInt(a[10]), Integer.parseInt(a[11]));
                nhanVienDAO.getNhanVienList().add(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
    }
    public void init() {
        nhanVienDAO = new NhanVienDAO();
        try {
            loadDataFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
