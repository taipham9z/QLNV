package Class;

public class DuAn {
    private String maDuAn;
    private String tenDuAn;
    private String chuDauTu;
    private String phongBanPhuTrach;
    private String ghiChu;
    private int duTinhChiPhi;
    private int chiPhiPhatSinh;

    public DuAn() {
    }

    public DuAn(String maDuAn, String tenDuAn, String chuDauTu, int duTinhChiPhi, String phongBanPhuTrach , int chiPhiPhatSinh, String ghiChu) {
        this.maDuAn = maDuAn;
        this.tenDuAn = tenDuAn;
        this.chuDauTu = chuDauTu;
        this.phongBanPhuTrach = phongBanPhuTrach;
        this.ghiChu = ghiChu;
        this.duTinhChiPhi = duTinhChiPhi;
        this.chiPhiPhatSinh = chiPhiPhatSinh;
    }

    public String getMaDuAn() {
        return maDuAn;
    }

    public void setMaDuAn(String maDuAn) {
        this.maDuAn = maDuAn;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public String getChuDauTu() {
        return chuDauTu;
    }

    public void setChuDauTu(String chuDauTu) {
        this.chuDauTu = chuDauTu;
    }

    public String getPhongBanPhuTrach() {
        return phongBanPhuTrach;
    }

    public void setPhongBanPhuTrach(String phongBanPhuTrach) {
        this.phongBanPhuTrach = phongBanPhuTrach;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getDuTinhChiPhi() {
        return duTinhChiPhi;
    }

    public void setDuTinhChiPhi(int duTinhChiPhi) {
        this.duTinhChiPhi = duTinhChiPhi;
    }

    public int getChiPhiPhatSinh() {
        return chiPhiPhatSinh;
    }

    public void setChiPhiPhatSinh(int chiPhiPhatSinh) {
        this.chiPhiPhatSinh = chiPhiPhatSinh;
    }

}
