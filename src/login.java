import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1 ,b2 ,b3 ;


    public login() {
super("Library Management System");


        setBounds(400,200,600,405);


        contentPane  = new JPanel();
       contentPane.setBorder(new EmptyBorder(5,5,5,5));

        setContentPane(contentPane);
        contentPane.setLayout(null);



        JLabel l = new JLabel("Login user");
        l.setForeground(Color.black);
        l.setFont(new Font("Georgie", Font.PLAIN, 25));
        l.setBounds(200, 10, 330, 56);
        contentPane.add(l);


        JLabel l1 = new JLabel("Username : ");
        l1.setBounds(124, 95, 95, 24);
        ImageIcon i21  = new ImageIcon(ClassLoader.getSystemResource("icons/username.PNG"));
        Image i22 = i21.getImage().getScaledInstance(30, 31,Image.SCALE_DEFAULT);
        ImageIcon i23 = new ImageIcon(i22);
        l1 = new JLabel(i23);
        l1.setBounds(135, 50, 100, 110);
        contentPane.add(l1);


        textField = new JTextField();
        textField.setBounds(210, 98, 157, 20);
        contentPane.add(textField);


        JLabel l2 = new JLabel("Password : ");
        l2.setBounds(124, 140, 95, 24);
        ImageIcon i24  = new ImageIcon(ClassLoader.getSystemResource("icons/password.PNG"));
        Image i25 = i24.getImage().getScaledInstance(31, 30,Image.SCALE_DEFAULT);
        ImageIcon i26 = new ImageIcon(i25);
        l2 = new JLabel(i26);
        l2.setBounds(145, 110, 80, 85);
        contentPane.add(l2);



        passwordField = new JPasswordField();
        passwordField.setBounds(210, 144, 157, 20);
        contentPane.add(passwordField);


        b1 = new JButton("Login");
        b1.addActionListener(this);

        b1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(212, 178, 128), new Color(5, 5, 5)));
        b1.setForeground(Color.BLACK);
        b1.setBounds(149, 200, 113, 39);
        contentPane.add(b1);

        b2 = new JButton("SignUp");
        b2.addActionListener(this);

        b2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(212, 178, 128), new Color(5, 5, 5)));
        b2.setForeground(Color.BLACK);
        b2.setBounds(289, 200, 113, 39);
        contentPane.add(b2);

        b3 = new JButton("Forgot Password");
        b3.addActionListener(this);

        b3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(212, 178, 128), new Color(5, 5, 5)));
        b3.setForeground(Color.BLACK);
        b3.setBounds(199, 280, 179, 39);
        contentPane.add(b3);

        JLabel l5 = new JLabel("Trouble in Login?");
        l5.setFont(new Font(" MS", Font.PLAIN, 15));
        l5.setForeground(new Color(14, 2, 2));
        l5.setBounds(70, 288, 130, 20);
        contentPane.add(l5);


        JLabel l8 = new JLabel("");
        l8.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login-user.png"));
        Image i2 = i1.getImage().getScaledInstance(80, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l8 = new JLabel(i3);
        l8.setBounds(300, 3, 80, 70);
        contentPane.add(l8);

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
        if(ae.getSource() == b1){
            Boolean status = false;
            try {
                conn con = new conn();
                String sql = "select * from Account where Username=? and Password=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, passwordField.getText());

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    this.setVisible(false);
                    new loading().setVisible(true);
                } else
                    JOptionPane.showMessageDialog(null, "Invalid Login...!.");

            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if(ae.getSource() == b2){
            setVisible(false);
            signup su = new signup();
            su.setVisible(true);
        }
        if(ae.getSource() == b3){
            setVisible(false);
            forgot forgot = new forgot();
            forgot.setVisible(true);
        }
    }

    public static void main(String[] args) {

        new login().setVisible(true);
    }

}









