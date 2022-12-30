package Form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class DangKy extends JFrame {

    private JPanel mainPanel;
    private JTextField txtTaiKhoan;
    private JTextField txtHoTen;
    private JTextField txtSDT;
    private JTextField txtEmail;
    private JRadioButton quanlyRadioButton;
    private JRadioButton nhanvienRadioButton;
    private JButton btnDangKy;
    private JButton btnQuayLai;
    private JPasswordField txtMatKhau;
    private JPasswordField txtXacNhanMatKhau;

    public DangKy(){
        setContentPane(mainPanel);
        setSize(300, 400);
        setTitle("Đăng ký");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(nhanvienRadioButton);
        buttonGroup.add(quanlyRadioButton);

        btnQuayLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DangNhapMain dangNhapMain = new DangNhapMain();
                dangNhapMain.setVisible(true);
                dispose();
            }
        });
        btnDangKy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtTaiKhoan.getText().equals("")){
                    JOptionPane.showMessageDialog(DangKy.this, "Tài khoản không bỏ trống");
                    return;
                }
                if(txtMatKhau.getPassword() == null){
                    JOptionPane.showMessageDialog(DangKy.this, "Mật khẩu không bỏ trống");
                    return;
                }
                if(txtHoTen.getText().equals("")){
                    JOptionPane.showMessageDialog(DangKy.this, "Họ tên không bỏ trống");
                    return;
                }
                if(txtSDT.getText().equals("")){
                    JOptionPane.showMessageDialog(DangKy.this, "Số điện thoại không bỏ trống");
                    return;
                }
                if(txtEmail.getText().equals("")){
                    JOptionPane.showMessageDialog(DangKy.this, "Email không bỏ trống");
                    return;
                }
                BufferedWriter writer = null;
                String taikhoan = txtTaiKhoan.getText();
                String matkhau = String.valueOf(txtMatKhau.getPassword());
                if(quanlyRadioButton.isSelected()){
                    File file = new File("D:\\HK5\\LapTrinhJava\\QLNVCongTy\\src\\Data\\TaiKhoanQuanTri.txt");
                    try {
                        writer = new BufferedWriter(new FileWriter(file, true));
                        writer.write("\n" +taikhoan + "|" +matkhau);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }finally {
                        try {
                            writer.close();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }else{
                    File file = new File("D:\\HK5\\LapTrinhJava\\QLNVCongTy\\src\\Data\\TaiKhoanNhanVien.txt");
                    try {
                        writer = new BufferedWriter(new FileWriter(file, true));
                        writer.write("\n" +taikhoan + "|" +matkhau);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }finally {
                        try {
                            writer.close();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
    }

}
