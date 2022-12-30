package Form;

import javax.swing.*;
import java.awt.event.*;

import Class.TaiKhoan;
public class DangNhapMain extends JFrame{
    private JPanel mainPanel;
    private JRadioButton quanLyRadioButton;
    private JRadioButton nhanVienRadioButton;

    private ButtonGroup buttonGroup;
    private JPasswordField txtMatKhau;
    private JTextField txtTaiKhoan;

    private JButton btnDangNhap;

    private JButton btnDangKy;

    private static DangNhapMain dangNhapMain = new DangNhapMain();
    public DangNhapMain(){
        setContentPane(mainPanel);
        setSize(432, 256);
        setTitle("Đăng nhập/Đăng ký");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Đăng ký
        btnDangKy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DangKy dangKy = new DangKy();
                dangKy.setVisible(true);
                dispose();
            }
        });
        //Chọn quản lý hoặc nhân viên
        buttonGroup = new ButtonGroup();
        buttonGroup.add(quanLyRadioButton);
        buttonGroup.add(nhanVienRadioButton);
        //Đăng nhập
        btnDangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setTenDangNhap(txtTaiKhoan.getText());
                taiKhoan.setMatKhau(String.valueOf(txtMatKhau.getPassword()));
                if(quanLyRadioButton.isSelected()){
                    int check = taiKhoan.readFileTaiKhoanQuanTri();
                    if(check != 1){
                        JOptionPane.showMessageDialog(DangNhapMain.this, "Sai tên đăng nhập hoặc mật khẩu");
                    }
                    else{
                        TrangChuQL trangChu = new TrangChuQL();
                        trangChu.setVisible(true);
                        dispose();
                    }
                }
                if(nhanVienRadioButton.isSelected()){
                    int check1 = taiKhoan.readFileTaiKhoanNhanVien();
                    if(check1 != 1){
                        JOptionPane.showMessageDialog(DangNhapMain.this, "Sai tên đăng nhập hoặc mật khẩu");
                    }
                    else{
                        TrangChuNV trangChuNV = new TrangChuNV();
                        trangChuNV.setVisible(true);
                        dispose();
                    }
                }

            }

        });
    }
    public static void main(String[] args) {
        dangNhapMain.setVisible(true);

    }

}
