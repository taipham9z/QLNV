package Class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Objects;

public class TaiKhoan {
    private String tenDangNhap;
    private String matKhau;

    public TaiKhoan() {

    }

    public TaiKhoan(String tenDangNhap, String matKhau) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    String fileNameQuanTri = "D:\\HK5\\LapTrinhJava\\QLNVCongTy\\src\\Data\\TaiKhoanQuanTri.txt";

    public int readFileTaiKhoanQuanTri(){
        BufferedReader reader = null;
        int check = 0, i;
            try{
                reader = new BufferedReader(new FileReader(fileNameQuanTri));
                String line = "";
                while ((line = reader.readLine()) != null){
                    check = 0;
                    String[] split = line.split("\\|");
                    if(tenDangNhap.equals(split[0]) && matKhau.equals(split[1])){
                        check = 1;
                        return check;
                    }
                }
                return check;
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return 1;
    }
    String fileNameNhanVien = "D:\\HK5\\LapTrinhJava\\QLNVCongTy\\src\\Data\\TaiKhoanNhanVien.txt";
    public int readFileTaiKhoanNhanVien(){
        BufferedReader reader = null;
        int check = 0, i;
        try{
            reader = new BufferedReader(new FileReader(fileNameNhanVien));
            String line = "";
            while ((line = reader.readLine()) != null){
                check = 0;
                String[] split = line.split("\\|");
                if(tenDangNhap.equals(split[0]) && matKhau.equals(split[1])){
                    check = 1;
                    return check;
                }
            }
            return check;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return 1;
    }

}
