package Form;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.List;

import Class.NhanVien;
import Class.NhanVienDAO;
public class NhanVienManager extends JFrame {

    private JTable tableNhanVien;
    private JTextField txtMaNV;
    private JTextField txtTenNV;
    private JButton btnTrangChu;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JTextField txtChucVu;
    private JTextField txtPhongBan;
    private JTextField txtSDT;
    private JTextField txtDiaChi;
    private JTextField txtGioVaoLam;
    private JTextField txtGioTanLam;
    private JTextField txtLuongCoBan;
    private JTextField txtTienThuong;
    private JPanel mainPanel;
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btnReset;
    private JButton btnTraCuuMaNV;
    private JTextField txtSoNgayNghi;
    private JButton btnTraCuuTheoTen;
    BufferedReader bufferedReader;
    static NhanVienDAO nhanVienDAO;
    private NhanVien nhanVienSelected;
    public NhanVienManager(){
        setContentPane(mainPanel);
        setSize(1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Quản lý nhân viên");
        init();
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(femaleRadioButton);
        buttonGroup.add(maleRadioButton);
        NhanVienTable nhanVienTable = new NhanVienTable();
        tableNhanVien.setModel(nhanVienTable);
        tableNhanVien.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nhanVienSelected = nhanVienDAO.getNhanVienList().get(tableNhanVien.getSelectedRow());
                txtMaNV.setText(nhanVienSelected.getMaNV());
                txtTenNV.setText(nhanVienSelected.getTenNV());
                if(nhanVienSelected.getGioiTinh().equals("Nam")){
                    maleRadioButton.setSelected(true);
                }
                else{
                    femaleRadioButton.setSelected(true);
                }
                txtChucVu.setText(nhanVienSelected.getChucVu());
                txtPhongBan.setText(nhanVienSelected.getPhongBan());
                txtSDT.setText(nhanVienSelected.getsDT());
                txtDiaChi.setText(nhanVienSelected.getDiachi());
                txtGioVaoLam.setText(String.valueOf(nhanVienSelected.getGioVaoLam()));
                txtGioTanLam.setText(String.valueOf(nhanVienSelected.getGioTanLam()));
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
        btnTraCuuMaNV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtMaNV.getText().equals("")){
                    NhanVien a = new NhanVien();
                    String maNV = txtMaNV.getText();
                    for(int i=0;i<nhanVienDAO.getNhanVienList().size();i++){
                        if(maNV.equals(nhanVienDAO.getNhanVienList().get(i).getMaNV())){
                            a = nhanVienDAO.getNhanVienList().get(i);
                            break;
                        }
                    }
                    txtMaNV.setText(a.getMaNV());
                    txtTenNV.setText(a.getTenNV());
                    if(a.getGioiTinh().equals("Nam")){
                        maleRadioButton.setSelected(true);
                    }else{
                        femaleRadioButton.setSelected(true);
                    }
                    txtChucVu.setText(a.getChucVu());
                    txtPhongBan.setText(a.getPhongBan());
                    txtSDT.setText(a.getsDT());
                    txtDiaChi.setText(a.getDiachi());
                    txtGioVaoLam.setText(String.valueOf(a.getGioTanLam()));
                    txtGioTanLam.setText(String.valueOf(a.getGioVaoLam()));
                    txtSoNgayNghi.setText(String.valueOf(a.getSoNgayNghi()));
                    txtLuongCoBan.setText(String.valueOf(a.getLuongCoBan()));
                    txtTienThuong.setText(String.valueOf(a.getTienThuong()));
                }

            }
        });
        btnTraCuuTheoTen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtTenNV.getText().equals("")){
                    NhanVien a = new NhanVien();
                    String tenNV = txtTenNV.getText();
                    for(int i=0;i<nhanVienDAO.getNhanVienList().size();i++){
                        if(tenNV.equals(nhanVienDAO.getNhanVienList().get(i).getTenNV())){
                            a = nhanVienDAO.getNhanVienList().get(i);
                        }
                    }
                    txtMaNV.setText(a.getMaNV());
                    txtTenNV.setText(a.getTenNV());
                    if(a.getGioiTinh().equals("Nam")){
                        maleRadioButton.setSelected(true);
                    }else{
                        femaleRadioButton.setSelected(true);
                    }
                    txtChucVu.setText(a.getChucVu());
                    txtPhongBan.setText(a.getPhongBan());
                    txtSDT.setText(a.getsDT());
                    txtDiaChi.setText(a.getDiachi());
                    txtGioVaoLam.setText(String.valueOf(a.getGioTanLam()));
                    txtGioTanLam.setText(String.valueOf(a.getGioVaoLam()));
                    txtSoNgayNghi.setText(String.valueOf(a.getSoNgayNghi()));
                    txtLuongCoBan.setText(String.valueOf(a.getLuongCoBan()));
                    txtTienThuong.setText(String.valueOf(a.getTienThuong()));
                }
            }
        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtMaNV.getText().equals("")){
                    JOptionPane.showMessageDialog(NhanVienManager.this, "Mã nhân viên không bỏ trống");
                    return;
                }
                String maNV = txtMaNV.getText();
                if(txtTenNV.getText().equals("")){
                    JOptionPane.showMessageDialog(NhanVienManager.this, "Tên nhân viên không bỏ trống");
                    return;
                }
                String tenNV = txtTenNV.getText();
                String gioiTinh = "";
                if(maleRadioButton.isSelected()){
                    gioiTinh = "Nam";
                }
                else{
                    gioiTinh = "Nữ";
                }
                if(txtChucVu.getText().equals("")){
                    JOptionPane.showMessageDialog(NhanVienManager.this, "Chức vụ không bỏ trống");
                    return;
                }
                String chucVu = txtChucVu.getText();
                if(txtPhongBan.getText().equals("")){
                    JOptionPane.showMessageDialog(NhanVienManager.this, "Phòng ban không bỏ trống");
                    return;
                }
                String phongBan = txtPhongBan.getText();
                if(txtSDT.getText().equals("")){
                    JOptionPane.showMessageDialog(NhanVienManager.this, "SDT không bỏ trống");
                    return;
                }
                String sdt = txtSDT.getText();
                if(txtDiaChi.getText().equals("")){
                    JOptionPane.showMessageDialog(NhanVienManager.this, "Địa chỉ không bỏ trống");
                    return;
                }
                String diaChi = txtDiaChi.getText();
                if(txtGioVaoLam.getText().equals("")){
                    JOptionPane.showMessageDialog(NhanVienManager.this, "Giờ vào làm không bỏ trống");
                    return;
                }
                int gioVaoLam = Integer.parseInt(txtGioVaoLam.getText());
                if(txtGioTanLam.getText().equals("")){
                    JOptionPane.showMessageDialog(NhanVienManager.this, "Giờ tan làm không bỏ trống");
                    return;
                }
                int gioTanLam = Integer.parseInt(txtGioTanLam.getText());
                if(txtSoNgayNghi.getText().equals("")){
                    JOptionPane.showMessageDialog(NhanVienManager.this, "Số ngày nghỉ không bỏ trống");
                    return;
                }
                int soNgayNghi = Integer.parseInt(txtSoNgayNghi.getText());
                if(txtLuongCoBan.getText().equals("")){
                    JOptionPane.showMessageDialog(NhanVienManager.this, "Lương cơ bản không bỏ trống");
                    return;
                }
                int luongCoBan = Integer.parseInt(txtLuongCoBan.getText());
                if(txtTienThuong.getText().equals("")){
                    JOptionPane.showMessageDialog(NhanVienManager.this, "Tiền thưởng không bỏ trống");
                    return;
                }
                int tienThuong= Integer.parseInt(txtTienThuong.getText());
                NhanVien nhanVien = new NhanVien(maNV, tenNV, gioiTinh, chucVu, phongBan, sdt, diaChi, gioVaoLam, gioTanLam, soNgayNghi, luongCoBan, tienThuong);
                try {
                    nhanVienDAO.writeFile(nhanVien);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                init();
                NhanVienTable nhanVienTable = new NhanVienTable();
                tableNhanVien.setModel(nhanVienTable);
                txtMaNV.setText("");
                txtTenNV.setText("");
                txtChucVu.setText("");
                maleRadioButton.setSelected(false);
                femaleRadioButton.setSelected(false);
                txtPhongBan.setText("");
                txtSDT.setText("");
                txtDiaChi.setText("");
                txtGioTanLam.setText("");
                txtGioVaoLam.setText("");
                txtSoNgayNghi.setText("");
                txtLuongCoBan.setText("");
                txtTienThuong.setText("");
            }
        });

        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(txtMaNV.getText().equals("")){
                        JOptionPane.showMessageDialog(NhanVienManager.this, "Mã nhân viên không bỏ trống");
                        return;
                    }
                    String maNV = txtMaNV.getText();
                    if(txtTenNV.getText().equals("")){
                        JOptionPane.showMessageDialog(NhanVienManager.this, "Tên nhân viên không bỏ trống");
                        return;
                    }
                    String tenNV = txtTenNV.getText();
                    String gioiTinh = "";
                    if(maleRadioButton.isSelected()){
                        gioiTinh = "Nam";
                    }
                    else{
                        gioiTinh = "Nữ";
                    }
                    if(txtChucVu.getText().equals("")){
                        JOptionPane.showMessageDialog(NhanVienManager.this, "Chức vụ không bỏ trống");
                        return;
                    }
                    String chucVu = txtChucVu.getText();
                    if(txtPhongBan.getText().equals("")){
                        JOptionPane.showMessageDialog(NhanVienManager.this, "Phòng ban không bỏ trống");
                        return;
                    }
                    String phongBan = txtPhongBan.getText();
                    if(txtSDT.getText().equals("")){
                        JOptionPane.showMessageDialog(NhanVienManager.this, "SDT không bỏ trống");
                        return;
                    }
                    String sdt = txtSDT.getText();
                    if(txtDiaChi.getText().equals("")){
                        JOptionPane.showMessageDialog(NhanVienManager.this, "Địa chỉ không bỏ trống");
                        return;
                    }
                    String diaChi = txtDiaChi.getText();
                    if(txtGioVaoLam.getText().equals("")){
                        JOptionPane.showMessageDialog(NhanVienManager.this, "Giờ vào làm không bỏ trống");
                        return;
                    }
                    int gioVaoLam = Integer.parseInt(txtGioVaoLam.getText());
                    if(txtGioTanLam.getText().equals("")){
                        JOptionPane.showMessageDialog(NhanVienManager.this, "Giờ tan làm không bỏ trống");
                        return;
                    }
                    int gioTanLam = Integer.parseInt(txtGioTanLam.getText());
                    if(txtSoNgayNghi.getText().equals("")){
                        JOptionPane.showMessageDialog(NhanVienManager.this, "Số ngày nghỉ không bỏ trống");
                        return;
                    }
                    int soNgayNghi = Integer.parseInt(txtSoNgayNghi.getText());
                    if(txtLuongCoBan.getText().equals("")){
                        JOptionPane.showMessageDialog(NhanVienManager.this, "Lương cơ bản không bỏ trống");
                        return;
                    }
                    int luongCoBan = Integer.parseInt(txtLuongCoBan.getText());
                    if(txtTienThuong.getText().equals("")){
                        JOptionPane.showMessageDialog(NhanVienManager.this, "Tiền thưởng không bỏ trống");
                        return;
                    }
                    int tienThuong= Integer.parseInt(txtTienThuong.getText());
                    nhanVienSelected = new NhanVien(maNV, tenNV, gioiTinh, chucVu, phongBan, sdt, diaChi, gioVaoLam, gioTanLam, soNgayNghi, luongCoBan, tienThuong);
                    nhanVienDAO.replaceNhanVien(nhanVienSelected, tableNhanVien.getSelectedRow());
                    init();
                    NhanVienTable nhanVienTable = new NhanVienTable();
                    tableNhanVien.setModel(nhanVienTable);
                    txtMaNV.setText("");
                    txtTenNV.setText("");
                    maleRadioButton.setSelected(false);
                    femaleRadioButton.setSelected(false);
                    txtChucVu.setText("");
                    txtPhongBan.setText("");
                    txtSDT.setText("");
                    txtDiaChi.setText("");
                    txtGioTanLam.setText("");
                    txtGioVaoLam.setText("");
                    txtSoNgayNghi.setText("");
                    txtLuongCoBan.setText("");
                    txtTienThuong.setText("");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    nhanVienDAO.deleteNhanVien(tableNhanVien.getSelectedRow());
                    init();
                    NhanVienTable nhanVienTable = new NhanVienTable();
                    tableNhanVien.setModel(nhanVienTable);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init();
                NhanVienTable nhanVienTable = new NhanVienTable();
                tableNhanVien.setModel(nhanVienTable);
                txtMaNV.setText("");
                txtTenNV.setText("");
                maleRadioButton.setSelected(false);
                femaleRadioButton.setSelected(false);
                txtChucVu.setText("");
                txtPhongBan.setText("");
                txtSDT.setText("");
                txtDiaChi.setText("");
                txtGioTanLam.setText("");
                txtGioVaoLam.setText("");
                txtSoNgayNghi.setText("");
                txtLuongCoBan.setText("");
                txtTienThuong.setText("");
            }
        });
        //xuatBang();
        btnTrangChu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrangChuQL trangChu = new TrangChuQL();
                trangChu.setVisible(true);
                dispose();
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
    public static class NhanVienTable extends AbstractTableModel {
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


}
