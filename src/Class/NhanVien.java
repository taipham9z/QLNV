package Class;

public class NhanVien {
    private String maNV;
    private String tenNV;
    private String gioiTinh;
    private String chucVu;

    private String phongBan;
    private String sDT;
    private String diachi;
    private int gioVaoLam;
    private int gioTanLam;

    private int soNgayNghi;

    private int luongCoBan;
    private int tienThuong;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, String gioiTinh, String chucVu, String phongBan, String sDT, String diachi, int gioVaoLam, int gioTanLam, int soNgayNghi, int luongCoBan, int tienThuong) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.phongBan = phongBan;
        this.sDT = sDT;
        this.diachi = diachi;
        this.gioVaoLam = gioVaoLam;
        this.gioTanLam = gioTanLam;
        this.soNgayNghi = soNgayNghi;
        this.luongCoBan = luongCoBan;
        this.tienThuong = tienThuong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getGioVaoLam() {
        return gioVaoLam;
    }

    public void setGioVaoLam(int gioVaoLam) {
        this.gioVaoLam = gioVaoLam;
    }

    public int getGioTanLam() {
        return gioTanLam;
    }

    public void setGioTanLam(int gioTanLam) {
        this.gioTanLam = gioTanLam;
    }

    public int getSoNgayNghi() {
        return soNgayNghi;
    }

    public void setSoNgayNghi(int soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }

    public int getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(int luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public int getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(int tienThuong) {
        this.tienThuong = tienThuong;
    }

    @Override
    public String toString() {
        return "\n"+maNV + "|" + tenNV + "|" + gioiTinh + "|" + chucVu + "|" + phongBan + "|" + sDT + "|" + diachi + "|" + gioVaoLam + "|" + gioTanLam + "|" + soNgayNghi + "|" + luongCoBan + "|" + tienThuong;
    }
    public String toString1() {
        return "Mã nhân viên='" + maNV + '\'' + ", Tên nhân viên='" + tenNV + '\'' + ", Giới tính='" + gioiTinh + '\'' + ", Chức Vụ='" + chucVu + '\'' + ", Phòng ban='" + phongBan + '\'' + ", SĐT='" + sDT + '\'' + ", Địa chỉ='" + diachi + '\'' + ", Giờ vào làm=" + gioVaoLam + ", Giờ tan làm=" + gioTanLam + ", Số ngày nghỉ=" + soNgayNghi + ", Lương cơ bản=" + luongCoBan + ", Tiền thưởng=" + tienThuong + '}';
    }
}
