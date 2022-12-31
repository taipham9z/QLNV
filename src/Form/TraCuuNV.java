package Form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import Class.NhanVien;
import Class.NhanVienDAO;
public class TraCuuNV extends JFrame{
    private JPanel panel1;
    private JTextField txtMaNV;
    private JTextField txtTenNV;
    private JButton btnTraCuu;
    private BufferedReader bufferedReader;
    private NhanVienDAO nhanVienDAO;
    public TraCuuNV(){
        setContentPane(panel1);
        setSize(500, 160);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Tra cứu nhân viên");
        init();
        btnTraCuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maNV = txtMaNV.getText();
                String tenNV = txtTenNV.getText();
                for(int i=0;i<nhanVienDAO.getNhanVienList().size();i++){
                    if(maNV.equals(nhanVienDAO.getNhanVienList().get(i).getMaNV()) && tenNV.equals(nhanVienDAO.getNhanVienList().get(i).getTenNV())){
                        JOptionPane.showMessageDialog(TraCuuNV.this, nhanVienDAO.getNhanVienList().get(i).toString1());
                    }
                }
            }
        });
    }
    public static final String DATA_FILE_PATH_NHAN_VIEN = "src\\Data\\NhanVien.txt";
    File file = new File(DATA_FILE_PATH_NHAN_VIEN);
    String absolutePath = file.getAbsolutePath();
    public void loadDataFromFile() throws IOException {
        try {
            NhanVien x = null;
            bufferedReader = new BufferedReader(new FileReader(absolutePath));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] a = line.split("\\|");
                x = new NhanVien(a[0], a[1], a[2], a[3], a[4], a[5], a[6], Integer.parseInt(a[7]), Integer.parseInt(a[8]), Integer.parseInt(a[9]), Integer.parseInt(a[10]), Integer.parseInt(a[11]));
                nhanVienDAO.getNhanVienList().add(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
    }
    public void init() {
        nhanVienDAO = new NhanVienDAO();
        try {
            loadDataFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
