package Class;

import java.util.Scanner;

public class TienLuong {
    private long luongCoBan;
    private long tienThuong;

    public TienLuong(long luongCoBan, long tienThuong) {
        this.luongCoBan = luongCoBan;
        this.tienThuong = tienThuong;
    }

    public TienLuong() {
    }

    public long getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(long luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public long getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(long tienThuong) {
        this.tienThuong = tienThuong;
    }
    @Override
    public String toString() {
        return " | " + luongCoBan + " | " + tienThuong;
    }
}
