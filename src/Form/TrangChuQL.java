package Form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrangChuQL extends JFrame{
    private JButton btnQuanLyNhanVien;
    private JButton btnQuanLyNhiemVu;
    private JButton btnQuanLyDuAn;
    private JButton btnQuanLyTienLuong;
    private JButton btnDangXuat;
    private JButton btnThoat;
    private JPanel mainPanel;

    public TrangChuQL()  {
        setContentPane(mainPanel);
        setSize(500, 400);
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
        btnQuanLyDuAn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DuAnQL().setVisible(true);
                dispose();
            }
        });
        btnQuanLyNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NhanVienManager nhanVienManager = new NhanVienManager();
                nhanVienManager.setVisible(true);
                dispose();
            }
        });
        btnQuanLyNhiemVu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NhiemVuQL nhiemVuQL = new NhiemVuQL();
                nhiemVuQL.setVisible(true);
                dispose();
            }
        });
        btnQuanLyTienLuong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TienLuongQL().setVisible(true);
                dispose();
            }
        });

    }
}
