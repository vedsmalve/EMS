package employee_management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;



public class LoginPage  extends JFrame implements ActionListner
{
    JFrame f;
    JLabel 11,12;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    
    LoginPage ()
    {
        f=new Jframe("Login");
        
        f.setBckground(Color.WHITE);
        f.setLayout(null);
        
        l1=new JLabel("UserName");
        l1.setBounds(40,20,100,30);
        f.add(l1);
        
         
        l2=new JLabel("Password");
        l1.setBounds(40,70,100,30);
        f.add(l2);
        
        t1=newJTextfield();
        t1.setBounds(150,20,150,30);
        f.add(t1);
        
        t1=newJPasswordField();
        t1.setBounds(150,20,150,30);
        f.add(t1);
        
        ImageIcon i1= new ImageIcon (ClassLoader.getSystemResource("employee_management/Icon/lock.png"));
        Image i2=i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=newJLabel(i3);
        l3.setBounds(350,20,150,150);
        f.add(l3);
        
        b1=new JButton("Login");
        b1.setBackground(color.BLACK);
        b1.setBounds(40,140,120,30);
        b1.addActionListner(this);
        b1.setForeground(color.WHITE);
        f.add(b1);
        
        
        b2=new JButton("Close");
        b2.setBackground(color.BLACK);
        b2.setBounds(180,140,120,30);
        b2.addActionListner(this);
        b2.setForeground(color.WHITE);
        f.add(b2);
        
        f.getContentPane();
        
        f.setVisible(true);
        f.setSize(500,240);
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
                String g="select * from logindata where username='"+name+"'  and password='"+pass+"'";
                ResultSet rs=obj.stm.executeQuery(q);
                if(rs.next())
                {
//                    new HomePage().setVisible(true);
                    this.setVisible(false);
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
