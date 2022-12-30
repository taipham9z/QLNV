package Form;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Class.NhiemVu;
public class NhiemVuQL extends JFrame {

    private JPanel mainPanel;
    private JButton btnThem;
    private JButton btnXoa;
    private JButton btnSua;
    private JButton btnReset;
    private JButton btnDong;
    private JTable tableNhiemVu;
    private JComboBox<String> comboBoxChucVu;
    private JComboBox<String> comboBoxPhongBan;
    private JTextArea textArea1;
    List<String> chucVu;
    Set<String> chucVuSet;
    List<String> phongBan;
    Set<String> phongBanSet;
    List<String> noiDung;

    List<NhiemVu> nhiemVuList;
    NhiemVu nhiemVuSelected;
    public NhiemVuQL(){
        setContentPane(mainPanel);
        setSize(1000, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Quản lý nhiệm vụ");
        init();
        NhiemVuTable nhiemVuTable = new NhiemVuTable();
        tableNhiemVu.setModel(nhiemVuTable);
        tableNhiemVu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nhiemVuSelected = nhiemVuList.get(tableNhiemVu.getSelectedRow());
                comboBoxChucVu.setSelectedItem(tableNhiemVu.getValueAt(tableNhiemVu.getSelectedRow(), 0));
                comboBoxPhongBan.setSelectedItem(tableNhiemVu.getValueAt(tableNhiemVu.getSelectedRow(), 1));
                textArea1.setText(nhiemVuSelected.getNoiDung());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        btnDong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TrangChuQL().setVisible(true);
                dispose();

            }
        });
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init();
                NhiemVuTable nhiemVuTable = new NhiemVuTable();
                tableNhiemVu.setModel(nhiemVuTable);
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteNhiemVu(tableNhiemVu.getSelectedRow());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                textArea1.setText("");
                init();
                NhiemVuTable nhiemVuTable = new NhiemVuTable();
                tableNhiemVu.setModel(nhiemVuTable);
            }
        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNhiemVu();
            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NhiemVu nhiemVu = new NhiemVu((String) comboBoxChucVu.getSelectedItem(), (String) comboBoxPhongBan.getSelectedItem(), textArea1.getText());
                replaceNhiemVu(nhiemVu, tableNhiemVu.getSelectedRow());
            }
        });
    }
    public void addNhiemVu(){
        BufferedWriter writer;
        File file = new File("D:\\HK5\\LapTrinhJava\\QLNVCongTy\\src\\Data\\NhiemVu.txt");
        try {
            writer = new BufferedWriter(new FileWriter(file, true));
            String input = "\n" + (String) comboBoxChucVu.getSelectedItem() + "|" + (String) comboBoxPhongBan.getSelectedItem() + "|" + textArea1.getText();
            writer.write(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        init();
        NhiemVuTable nhiemVuTable = new NhiemVuTable();
        tableNhiemVu.setModel(nhiemVuTable);
    }
    public void deleteNhiemVu(int n) throws IOException {
        nhiemVuList.remove(n);
        BufferedWriter writer = null;
        try{
            File file = new File("D:\\HK5\\LapTrinhJava\\QLNVCongTy\\src\\Data\\NhiemVu.txt");
            writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < nhiemVuList.size(); i++) {
                String w;
                if(i==0){
                    w = nhiemVuList.get(i).getChucVu() + "|" + nhiemVuList.get(i).getPhongBan() + "|" + nhiemVuList.get(i).getNoiDung();
                }
                else{
                    w = "\n" + nhiemVuList.get(i).getChucVu() + "|" + nhiemVuList.get(i).getPhongBan() + "|" + nhiemVuList.get(i).getNoiDung();
                }
                writer.write(w);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            writer.close();
        }
        init();
        NhiemVuTable nhiemVuTable = new NhiemVuTable();
        tableNhiemVu.setModel(nhiemVuTable);
    }
    public void replaceNhiemVu(NhiemVu nhiemVu, int n) {
        List<NhiemVu> nhiemVus = new ArrayList<>();
        BufferedReader reader = null;
        try {
            NhiemVu x = null;
            reader = new BufferedReader(new FileReader("D:\\HK5\\LapTrinhJava\\QLNVCongTy\\src\\Data\\NhiemVu.txt"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] a = line.split("\\|");
                x = new NhiemVu(a[0], a[1], a[2]);
                nhiemVus.add(x);
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
        nhiemVus.set(n, nhiemVu);
        BufferedWriter writer = null;
        try{
            File file = new File("D:\\HK5\\LapTrinhJava\\QLNVCongTy\\src\\Data\\NhiemVu.txt");
            //writer = new FileWriter(file, true);
            writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < nhiemVus.size(); i++) {
                String w;
                if(i==0){
                    w = nhiemVus.get(i).getChucVu() + "|" + nhiemVus.get(i).getPhongBan() + "|" + nhiemVus.get(i).getNoiDung();
                }
                else{
                    w = "\n" + nhiemVus.get(i).getChucVu() + "|" + nhiemVus.get(i).getPhongBan() + "|" + nhiemVus.get(i).getNoiDung();
                }
                writer.write(w);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        init();
        NhiemVuTable nhiemVuTable = new NhiemVuTable();
        tableNhiemVu.setModel(nhiemVuTable);
    }
    public void init()  {
        chucVu = new ArrayList<>();
        phongBan = new ArrayList<>();
        noiDung = new ArrayList<>();
        nhiemVuList = new ArrayList<>();
        File file = new File("D:\\HK5\\LapTrinhJava\\QLNVCongTy\\src\\Data\\NhiemVu.txt");
        File file1 = new File("D:\\HK5\\LapTrinhJava\\QLNVCongTy\\src\\Data\\ChucVu.txt");
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = reader.readLine())!=null){
                String[] split = line.split("\\|");
                noiDung.add(split[2]);
                NhiemVu nhiemVu = new NhiemVu(split[0], split[1], split[2]);
                nhiemVuList.add(nhiemVu);
            }
            reader = new BufferedReader(new FileReader(file1));
            String line1 = "";
            while((line1 = reader.readLine()) != null){
                String[] split1 = line1.split("\\|");
                chucVu.add(split1[0]);
                phongBan.add(split1[1]);
            }
            chucVuSet = new HashSet<String>(chucVu);
            chucVu = new ArrayList<>(chucVuSet);
            for (String a : chucVu) {
                comboBoxChucVu.addItem(a);
            }
            phongBanSet = new HashSet<String>(phongBan);
            phongBan = new ArrayList<>(phongBanSet);
            for (String a : phongBan) {
                comboBoxPhongBan.addItem(a);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
    public class NhiemVuTable extends AbstractTableModel {
        String[] COLUMNS = {"Chức vụ", "Phòng ban", "Nội dung"};
        @Override
        public int getRowCount() {
            return nhiemVuList.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
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
        public Class<?> getColumnClass(int columnIndex) {
            if(getValueAt(0, columnIndex) != null){
                return getValueAt(0, columnIndex).getClass();
            }else{
                return Object.class;
            }
        }
    }

}
