package Class;

import java.util.ArrayList;
import java.util.List;

public class NhiemVu {
    private String chucVu;
    private String phongBan;
    private String noiDung;

    public NhiemVu() {
    }

    public NhiemVu(String chucVu, String phongBan, String noiDung) {
        this.chucVu = chucVu;
        this.phongBan = phongBan;
        this.noiDung = noiDung;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public String toString() {
        return chucVu + "|" + phongBan + "|" + noiDung;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
