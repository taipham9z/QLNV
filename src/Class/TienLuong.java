package Class;

import java.util.Scanner;

public class TienLuong {
    private long luongCoBan;
    private int soNgayNghi;
    private long tienThuong;

    public TienLuong() {
    }

    public TienLuong(long luongCoBan, int soNgayNghi, long tienThuong) {
        this.luongCoBan = luongCoBan;
        this.soNgayNghi = soNgayNghi;
        this.tienThuong = tienThuong;
    }

    public long getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(long luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public int getSoNgayNghi() {
        return soNgayNghi;
    }

    public void setSoNgayNghi(int soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }

    public long getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(long tienThuong) {
        this.tienThuong = tienThuong;
    }
}
