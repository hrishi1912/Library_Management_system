
import java.awt.*;
        import javax.swing.*;
        import java.awt.event.*;
        import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
//import javax.swing.border.EmptyBorder;

public class LibraryManagementSystem extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1;
private JPanel panel;

    public LibraryManagementSystem() {

        setBounds(400,200,600,405);
        setLayout(null);


         panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        //setBackground(new Color(169, 169, 169));
        setContentPane(panel);
        panel.setBackground( Color.white);
        panel.setLayout(null);


        JLabel l5 = new JLabel("Library Management System ");
        l5.setBounds(160, 20, 400, 36);
        l5.setFont(new Font("Acme", Font.CENTER_BASELINE, 20));
        panel.add(l5);



        l1= new JLabel("");
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/lib_background.png"));
        Image i3 = i1.getImage().getScaledInstance(750, 400,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);

        b1 = new JButton("Next");
        b1.addActionListener(this);
        b1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(212, 178, 128), new Color(5, 5, 5)));
        b1.setForeground(Color.BLACK);
        b1.setBounds(149, 200, 113, 39);
        panel.add(b1);
        b1.setBounds(220,250,120,40);
        l1.setBounds(0, 0, 750, 390);

        l1.add(b1);
        add(l1);
        b1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        new login().setVisible(true);
        this.setVisible(false);


    }

    public static void main(String[] args) {
        LibraryManagementSystem window = new LibraryManagementSystem();
        window.setVisible(true);
    }
}

