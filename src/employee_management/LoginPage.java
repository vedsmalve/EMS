package employee_management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Locale;

public class LoginPage  extends JFrame implements ActionListener
{
    JFrame f;
    JLabel a1,a2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    
    LoginPage ()
    {
        f=new JFrame("Login");
        
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        a1=new JLabel("UserName");
        
        a1.setBounds(40,20,100,30);
        f.add(a1);
        
        a2=new JLabel("Password");
        a2.setBounds(40,70,100,30);
        f.add(a2);
        
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        f.add(t1);
        
        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        f.add(t2);
        
        
        ImageIcon i1= new ImageIcon (ClassLoader.getSystemResource("employee_management/Icon/lock.png"));
        Image i2=i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(350,20,150,150);
        f.add(l3);
        
        b1=new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setBounds(40,140,120,30);
        b1.addActionListener(this);
        b1.setForeground(Color.WHITE);
        f.add(b1);
        
        
        b2=new JButton("Close");
        b2.setBackground(Color.BLACK);
        b2.setBounds(180,140,120,30);
        b2.addActionListener(this);
        b2.setForeground(Color.WHITE);
        f.add(b2);
        
        f.getContentPane();
        
        f.setVisible(true);
        f.setSize(540,240);
        f.setLocation(400,300);
        
    }
    
    public void actionPerformed(ActionEvent ee)
    {
        if(ee.getSource()==b1)
        {
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String name=t1.getText();
                String pass=t2.getText();
                String q="select * from logindata where username='"+name+"'  and password='"+pass+"'";
                ResultSet rs=obj.stm.executeQuery(q);
                if(rs.next())
                {
//                    new HomePage().setVisible(true);
                      f.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You have entered wrong username and password !");
                    f.setVisible(false);
                    f.setVisible(true);
                }
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
                    
            
        }
        if(ee.getSource()==b2)
        {
           this.f.setVisible(false); 
        }
    }
    public static void main(String[]args)
    {
        new LoginPage();
    
    }   
}
