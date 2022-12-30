package Form;
import Class.NhiemVu;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class NhiemVuNV extends JFrame {

    private JPanel mainpanel;
    private JTable table1;
    private JButton btnDong;
    private JButton btnTrangChu;
    private JButton btnReset;
    BufferedReader bufferedReader;
    List<NhiemVu> nhiemVuList = new ArrayList<>();
    public NhiemVuNV (){
        setContentPane(mainpanel);
        setSize(1000,500);
        init();
        NhiemVuNVTable nhiemVuNVTable = new NhiemVuNVTable();
        table1.setModel(nhiemVuNVTable);
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init();
                NhiemVuNVTable nhiemVuNVTable = new NhiemVuNVTable();
                table1.setModel(nhiemVuNVTable);
            }
        });
        btnDong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnTrangChu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrangChuNV trangChuNV = new TrangChuNV();
                trangChuNV.setVisible(true);
                dispose();
            }
        });


    }
    public class NhiemVuNVTable extends AbstractTableModel {
        private String[] COLUMNS = {"Chức vụ","Phòng ban","Nội dung"};

        @Override
        public int getRowCount() {
            return nhiemVuList.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex){
                case 0 -> nhiemVuList.get(rowIndex).getChucVu();
                case 1 -> nhiemVuList.get(rowIndex).getPhongBan();
                case 2 -> nhiemVuList.get(rowIndex).getNoiDung();
                default ->  "-";
            };
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if(getValueAt(0, columnIndex) != null){
                return getValueAt(0, columnIndex).getClass();
            }else{
                return Object.class;
            }
        }

    }
    public void loadDataFromFile() throws IOException {
        try {
            NhiemVu x = null;
            bufferedReader = new BufferedReader(new FileReader("D:\\HK5\\LapTrinhJava\\QLNVCongTy\\src\\Data\\NhiemVu.txt"));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] a = line.split("\\|");
                x = new NhiemVu(a[0], a[1], a[2]);
                nhiemVuList.add(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
    }
    public void init() {
        nhiemVuList = new ArrayList<>();
        try {
            loadDataFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}