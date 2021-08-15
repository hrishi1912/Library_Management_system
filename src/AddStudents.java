import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class AddStudents extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField t1,t2,t3;
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2;

    public static void main(String[] args) {
        new AddStudents().setVisible(true);
    }

    public void random() {
        Random rd = new Random();
        t1.setText("" + rd.nextInt(10000 + 1));
    }

    public AddStudents() {
        super("Add Student");
        setBounds(400,200,600,405);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Student Id");
        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(120, 20, 102, 22);
        contentPane.add(l1);

        t1 = new JTextField();
        t1.setEditable(false);
        t1.setForeground(new Color(47, 79, 79));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(230, 20, 156, 20);
        contentPane.add(t1);
        t1.setColumns(10);



        JLabel l3 = new JLabel("Full Name");
        l3.setForeground(new Color(25, 25, 112));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(120, 70, 102, 22);
        contentPane.add(l3);

        t3 = new JTextField();
        t3.setForeground(new Color(47, 79, 79));
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t3.setColumns(10);
        t3.setBounds(230, 74, 156, 20);
        contentPane.add(t3);

        JLabel l7 = new JLabel("Course");
        l7.setForeground(new Color(25, 25, 112));
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        l7.setBounds(120, 120, 102, 22);
        contentPane.add(l7);

        comboBox_3 = new JComboBox();
        comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "B.E", "B.Tech", "M.Tech", "MBA", "BBA", "BCA", "B.Sc", "M.Sc", "B.Com", "M.Com" }));
        comboBox_3.setForeground(new Color(47, 79, 79));
        comboBox_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_3.setBounds(230, 124, 154, 20);
        contentPane.add(comboBox_3);


        JLabel l4 = new JLabel("Branch");
        l4.setForeground(new Color(25, 25, 112));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(120, 170, 102, 22);
        contentPane.add(l4);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Electronics", "Instrumentation", "IT", "Civil", "Electronics & Telecommunication", "Mechanics", "Other" }));
        comboBox.setForeground(new Color(47, 79, 79));
        comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox.setBounds(230, 174, 154, 20);
        contentPane.add(comboBox);

        JLabel l5 = new JLabel("Year");
        l5.setForeground(new Color(25, 25, 112));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(120, 222, 102, 22);
        contentPane.add(l5);

        comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "First", "Second", "Third", "Four" }));
        comboBox_1.setForeground(new Color(47, 79, 79));
        comboBox_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_1.setBounds(230, 224, 154, 20);
        contentPane.add(comboBox_1);

        JLabel l6 = new JLabel("Semester");
        l6.setForeground(new Color(25, 25, 112));
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(120, 275, 102, 22);
        contentPane.add(l6);

        comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th" }));
        comboBox_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_2.setForeground(new Color(47, 79, 79));
        comboBox_2.setBounds(230, 277, 154, 20);
        contentPane.add(comboBox_2);



        b1 = new JButton("ADD");
        b1.addActionListener(this);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b1.setBounds(120, 321, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b2.setBounds(290, 321, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);


        JPanel panel = new JPanel();

        contentPane.setBackground(Color.WHITE);
        panel.setBackground(Color.WHITE);

        contentPane.add(panel);
        random();

        JLabel l9 = new JLabel("");
        ImageIcon i27  = new ImageIcon(ClassLoader.getSystemResource("icons/bg4.jpg"));
        Image i28 = i27.getImage().getScaledInstance(1000, 750,Image.SCALE_DEFAULT);
        ImageIcon i29 = new ImageIcon(i28);
        l9 = new JLabel(i29);
        l9.setBounds(0, 0, 1000, 750);
        contentPane.add(l9);

    }

    @Override
    public void actionPerformed(ActionEvent ae){
        try{

            if(ae.getSource() == b1){
                try{
                    conn con = new conn();
                    String sql = "insert into Student(StudentId, Full_Name, Course, Branch, Year, Semester) values(?, ?, ?, ?, ?, ?)";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, t1.getText());
                    st.setString(2, t3.getText());
                    st.setString(3, (String) comboBox_3.getSelectedItem());
                    st.setString(4, (String) comboBox.getSelectedItem());
                    st.setString(5, (String) comboBox_1.getSelectedItem());
                    st.setString(6, (String) comboBox_2.getSelectedItem());

                    int i = st.executeUpdate();
                    if (i > 0){
                        JOptionPane.showMessageDialog(null, "Successfully Added");
                        this.setVisible(false);
                        new HomePage().setVisible(true);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Error");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            if(ae.getSource() == b2){
                this.setVisible(false);
                new HomePage().setVisible(true);
            }
        }catch(Exception e){

        }
    }
}

