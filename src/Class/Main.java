package Class;

import Form.DangNhapMain;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GlobalFont.setGlobalFont(new Font("Arial", Font.PLAIN, 14));
        DangNhapMain dangNhapMain = new DangNhapMain();
        dangNhapMain.setVisible(true);
    }
}
