import java.awt.*;
import javax.swing.*;
import javax.swing.text.rtf.RTFEditorKit;
import java.awt.event.*;
import java.sql.*;

public class View_Employee{
    JFrame f;
    JTextField t;
    JLabel l1 , l2;
    JButton b,b2;

    void View_Employe(){

        f= new JFrame("VIEW EMPLOYEE");
        f.setBackground(Color.green);
        f.setLayout(null);

        l1=new JLabel();
        l1.setBounds(0,0,500,270);
        l1.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icon/7.jpg"));
        Image i1= img.getImage().getScaledInstance(900,600,Image.SCALE_DEFAULT);
        ImageIcon ici = new ImageIcon(img1);
        l1.setIcon(ic1);

        l2= new JLabel("Employee Id");
        l2.setVisible(true);
        l2.setBounds(40,60,250,30);
        l2.setForeground(color.White);
        Font F1 = new Font("Arial",Font.BOLD,30);
        l2.setFont(F1);
        l1.add(l2);
        f.add(l1);

        t = new JTextField();
        t.setBounds(240,60,220,30);
        l1.add(t);

        b= new JButton("Search");
        b.setBounds(140,150,100,30);
        b.addActionListener(this);
        l1.add(b);


        b2= new JButton("cancle");
        b2.setBackground(Color.RED);
        b2.setBackground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(260,150,100,30);
        l1.add(b2);

        f.setSize(500,270);
        f.setLocation(450,250);
        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()==b)
        {
            f.setLocation(false);
            new View_Employee_Data(t.getText());


        }
        if (e.getSource()==b2)
        {
            f.setVisible(false);
            new Homepage();
        }
    }
}
