package Form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrangChuNV extends JFrame{
    private JButton btnDanhSachNhanVien;
    private JButton btnNhiemVu;
    private JButton btnTienLuong;
    private JButton btnDuAn;
    private JButton btnDangXuat;
    private JButton btnThoat;
    private JPanel mainPanel;

    public TrangChuNV(){
        setContentPane(mainPanel);
        setSize(500, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Trang chủ của nhân viên");
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnDangXuat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DangNhapMain dangNhapMain = new DangNhapMain();
                dangNhapMain.setVisible(true);
                dispose();
            }
        });
        btnDanhSachNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NhanVienView nhanVienView = new NhanVienView();
                nhanVienView.setVisible(true);
                dispose();
            }
        });
        btnNhiemVu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NhiemVuNV nhiemVuNV = new NhiemVuNV();
                nhiemVuNV.setVisible(true);
                dispose();
            }
        });
        btnTienLuong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TienLuongNV tienLuongNV = new TienLuongNV();
                tienLuongNV.setVisible(true);
                dispose();
            }
        });
        btnDuAn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DuAnNV duAnNV = new DuAnNV();
                duAnNV.setVisible(true);
                dispose();
            }
        });
    }
}
