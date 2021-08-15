import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class AddBooks extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6;
    private JButton b1,b2;
    JComboBox comboBox;

    public static void main(String[] args) {

        new AddBooks().setVisible(true);
    }

    public void random() {
        Random rd = new Random();
        t1.setText("" + rd.nextInt(1000 + 1));
    }

    public AddBooks() {
        super("Add Book ");

        setBounds(400,200,600,405);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l5 = new JLabel("Book ID");
        l5.setForeground(new Color(47, 79, 79));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(73, 49, 90, 22);
        contentPane.add(l5);

        t1 = new JTextField();
        t1.setForeground(new Color(47, 79, 79));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(169, 51, 198, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        JLabel l1 = new JLabel("Name");
        l1.setForeground(new Color(47, 79, 79));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(73, 84, 90, 22);
        contentPane.add(l1);

        t2 = new JTextField();
        t2.setForeground(new Color(47, 79, 79));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setColumns(10);
        t2.setBounds(169, 87, 198, 20);
        contentPane.add(t2);


        JLabel l2 = new JLabel("Author");
        l2.setForeground(new Color(47, 79, 79));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(73, 128, 90, 22);
        contentPane.add(l2);

        t3 = new JTextField();
        t3.setForeground(new Color(47, 79, 79));
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t3.setColumns(10);
        t3.setBounds(169, 130, 198, 20);
        contentPane.add(t3);


        JLabel l3 = new JLabel("Publisher");
        l3.setForeground(new Color(47, 79, 79));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(73, 170, 90, 22);
        contentPane.add(l3);

        t5 = new JTextField();
        t5.setForeground(new Color(47, 79, 79));
        t5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t5.setColumns(10);
        t5.setBounds(169, 170, 198, 20);
        contentPane.add(t5);


        JLabel l4 = new JLabel("Edition");
        l4.setForeground(new Color(47, 79, 79));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(73, 210, 90, 22);
        contentPane.add(l4);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        comboBox.setBounds(173, 210, 194, 20);
        contentPane.add(comboBox);


        JLabel l6 = new JLabel("Price");
        l6.setForeground(new Color(47, 79, 79));
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(75, 249, 90, 22);
        contentPane.add(l6);

        t6 = new JTextField();
        t6.setForeground(new Color(47, 79, 79));
        t6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t6.setColumns(10);
        t6.setBounds(169, 252, 198, 20);
        contentPane.add(t6);



        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b1.setBounds(102, 300, 100, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b2.setBounds(212, 300, 108, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        contentPane.add(b2);



        contentPane.setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);
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
            conn con = new conn();
            if(ae.getSource() == b1){
                String sql = "insert into Book(book_id, Name,Author,  Publisher, Edition, Price) values(?, ?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);
                // st.setInt(1, Integer.parseInt(textField.getText()));
                st.setString(1, t1.getText());
                st.setString(2, t2.getText());
                st.setString(3, t3.getText());
                st.setString(4, t5.getText());
                st.setString(5, (String) comboBox.getSelectedItem());
                st.setString(6, t6.getText());

                int rs = st.executeUpdate();
                if (rs > 0)
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                else
                    JOptionPane.showMessageDialog(null, "Error");
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t5.setText("");
                t6.setText("");
                st.close();
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new HomePage().setVisible(true);

            }
            con.c.close();
        }catch(Exception e){

        }
    }

}
