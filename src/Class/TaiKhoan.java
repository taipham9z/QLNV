package Class;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Objects;

public class TaiKhoan {
    private String tenDangNhap;
    private String matKhau;
    public static final String DATA_FILE_PATH_QUAN_TRI = "src\\Data\\TaiKhoanQuanTri.txt";
    File file = new File(DATA_FILE_PATH_QUAN_TRI);
    String absolutePath = file.getAbsolutePath();
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

    public int readFileTaiKhoanQuanTri(){
        BufferedReader reader = null;
        int check = 0, i;
            try{
                reader = new BufferedReader(new FileReader(absolutePath));
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
    public static final String DATA_FILE_PATH_NHAN_VIEN = "src\\Data\\TaiKhoanNhanVien.txt";
    File file1= new File(DATA_FILE_PATH_NHAN_VIEN);
    String absolutePath1 = file1.getAbsolutePath();
    public int readFileTaiKhoanNhanVien(){
        BufferedReader reader = null;
        int check = 0, i;
        try{
            reader = new BufferedReader(new FileReader(absolutePath1));
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
