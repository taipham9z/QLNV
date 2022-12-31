package Class;

import Form.NhanVienManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NhanVienDAO {
    List<NhanVien> nhanVienList = new ArrayList<>();
    List<NhanVien> nhanViens;
    NhanVien nhanVien;

    public boolean suaNV(int index, NhanVien nhanVien) {
        return nhanVienList.set(index, nhanVien) != null;
    }

    public boolean xoaNV(int index) {
        return nhanVienList.remove(index) != null;
    }

    public boolean themNV(NhanVien nhanVien) {
        return nhanVienList.add(nhanVien);
    }

    public void showListNhanVien() {
        for (NhanVien nhanVien : nhanVienList) {
            System.out.println(nhanVien.toString());
        }
    }
    public static final String DATA_FILE_PATH_NHAN_VIEN = "src\\Data\\NhanVien.txt";
    File file = new File(DATA_FILE_PATH_NHAN_VIEN);
    String absolutePathNhanVien = file.getAbsolutePath();
    public List<NhanVien> getNhanVienList() {
        return nhanVienList;
    }
    public void replaceNhanVien(NhanVien nhanVien, int n) throws IOException {
        BufferedReader reader = null;
        nhanViens = new ArrayList<>();
        try {
            NhanVien x = null;
            reader = new BufferedReader(new FileReader(absolutePathNhanVien));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] a = line.split("\\|");
                x = new NhanVien(a[0], a[1], a[2], a[3], a[4], a[5], a[6], Integer.parseInt(a[7]), Integer.parseInt(a[8]), Integer.parseInt(a[9]), Integer.parseInt(a[10]), Integer.parseInt(a[11]));
                nhanViens.add(x);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        nhanViens.set(n, nhanVien);
        BufferedWriter writer = null;
        try{
            File file = new File(absolutePathNhanVien);
            //writer = new FileWriter(file, true);
            writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < nhanViens.size(); i++) {
                String w;
                if(i==0){
                    w = nhanViens.get(i).getMaNV() + "|" + nhanViens.get(i).getTenNV() + "|" + nhanViens.get(i).getGioiTinh() + "|" + nhanViens.get(i).getChucVu() + "|" + nhanViens.get(i).getPhongBan() + "|" + nhanViens.get(i).getsDT() + "|" + nhanViens.get(i).getDiachi() + "|" + nhanViens.get(i).getGioVaoLam() + "|" + nhanViens.get(i).getGioTanLam() + "|" + nhanViens.get(i).getSoNgayNghi() + "|" + nhanViens.get(i).getLuongCoBan() + "|" +nhanViens.get(i).getTienThuong();
                }
                else{
                    w =  "\n" + nhanViens.get(i).getMaNV() + "|" + nhanViens.get(i).getTenNV() + "|" + nhanViens.get(i).getGioiTinh() + "|" + nhanViens.get(i).getChucVu() + "|" + nhanViens.get(i).getPhongBan() + "|" + nhanViens.get(i).getsDT() + "|" + nhanViens.get(i).getDiachi() + "|" + nhanViens.get(i).getGioVaoLam() + "|" + nhanViens.get(i).getGioTanLam() + "|" + nhanViens.get(i).getSoNgayNghi() + "|" + nhanViens.get(i).getLuongCoBan() + "|" +nhanViens.get(i).getTienThuong();
                }
                writer.write(w);
            }
            writer.flush();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            writer.close();
        }
    }
    public void deleteNhanVien(int n) throws IOException {
        BufferedReader reader = null;
        nhanViens = new ArrayList<>();
        try {
            NhanVien x = null;
            reader = new BufferedReader(new FileReader(absolutePathNhanVien));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] a = line.split("\\|");
                x = new NhanVien(a[0], a[1], a[2], a[3], a[4], a[5], a[6], Integer.parseInt(a[7]), Integer.parseInt(a[8]), Integer.parseInt(a[9]), Integer.parseInt(a[10]), Integer.parseInt(a[11]));
                nhanViens.add(x);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        nhanViens.remove(n);
        BufferedWriter writer = null;
        try{
            File file = new File(absolutePathNhanVien);
            //writer = new FileWriter(file, true);
            writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < nhanViens.size(); i++) {
                if(i==0){
                    String w = nhanViens.get(i).getMaNV() + "|" + nhanViens.get(i).getTenNV() + "|" + nhanViens.get(i).getGioiTinh() + "|" + nhanViens.get(i).getChucVu() + "|" + nhanViens.get(i).getPhongBan() + "|" + nhanViens.get(i).getsDT() + "|" + nhanViens.get(i).getDiachi() + "|" + nhanViens.get(i).getGioVaoLam() + "|" + nhanViens.get(i).getGioTanLam() + "|" + nhanViens.get(i).getSoNgayNghi() + "|" + nhanViens.get(i).getLuongCoBan() + "|" +nhanViens.get(i).getTienThuong();
                    writer.write(w);
                }
                else{
                    String w = "\n"+nhanViens.get(i).getMaNV() + "|" + nhanViens.get(i).getTenNV() + "|" + nhanViens.get(i).getGioiTinh() + "|" + nhanViens.get(i).getChucVu() + "|" + nhanViens.get(i).getPhongBan() + "|" + nhanViens.get(i).getsDT() + "|" + nhanViens.get(i).getDiachi() + "|" + nhanViens.get(i).getGioVaoLam() + "|" + nhanViens.get(i).getGioTanLam() + "|" + nhanViens.get(i).getSoNgayNghi() + "|" + nhanViens.get(i).getLuongCoBan() + "|" +nhanViens.get(i).getTienThuong();
                    writer.write(w);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            writer.close();
        }
    }
    public void writeFile(NhanVien nhanVien) throws IOException {
        BufferedWriter writer = null;
        BufferedReader reader = null;
        try {
            File file = new File(absolutePathNhanVien);
            //writer = new FileWriter(file, true);
            writer = new BufferedWriter(new FileWriter(file, true));
            reader = new BufferedReader(new FileReader(file));
            if(reader.readLine() != null){
                writer.write(nhanVien.toString());
            }
            else {
                String w = nhanVien.getMaNV() + "|" + nhanVien.getTenNV() + "|" + nhanVien.getGioiTinh() + "|" + nhanVien.getChucVu() + "|" + nhanVien.getPhongBan() + "|" + nhanVien.getsDT() + "|" + nhanVien.getDiachi() + "|" + nhanVien.getGioVaoLam() + "|" + nhanVien.getGioTanLam() + "|" + nhanVien.getSoNgayNghi() + "|" +nhanVien.getLuongCoBan() + "|" +nhanVien.getTienThuong();
                writer.write(w);
            }
        } catch (Exception ex) {
            System.out.println("Tạo file test_text.txt có vấn đề: " + ex.getMessage());
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.getLocalizedMessage();
            } finally {
                writer.close();
            }
        }

    }
}
