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
    }

    public static void main(String[] args) {
        TrangChuNV trangChuNV = new TrangChuNV();
        trangChuNV.setVisible(true);
    }
}
