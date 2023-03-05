package employee_management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Employee_Attendence extends JFrame implements ActionListener
{
    JLabel l1,l2 ,l3 ,l4,l5;
    Choice c1,c2,c3;
    JButton bt1,bt2;
    JTextField tf1,tf2;
    Font f;
    JPanel p;
    
    Employee_Attendence()
    {
         super("Employee Attendence");
         setSize(450,300);
         setLocation(300,200);
         setResizable(false);
         f= new Font("senserif",Font.BOLD,15);
         
         l1 = new JLabel("Select Employee ID");
         l2 = new JLabel("First Half");
         l3 = new JLabel("Second Half");
         l4 = new JLabel("Name");
         l5 = new JLabel("Email");
         
         l1.setFont(f);
         l2.setFont(f);
         l3.setFont(f);
         l4.setFont(f);
         l5.setFont(f);
         
         tf1 = new JTextField();
         tf2 = new JTextField();
         
         tf1.setFont(f);
         tf2.setFont(f);
         
         tf1.setEditable(false);
         tf2.setEditable(false);
         
         c2= new Choice();
         c2.add("Present");
         c2.add("Absent");
         
         c3= new Choice();
         c3.add("present");
         c3.add("Absent");
         
         c2.setFont(f);
         c3.setFont(f);
         
         bt1 = new JButton("Submit");
         bt2 = new JButton("Close");
         
         bt1.setBackground(Color.BLACK);
         bt1.setForeground(Color.WHITE);
         
          bt2.setBackground(Color.BLACK);
          bt2.setForeground(Color.WHITE);
          
         bt1.setFont(f);
         bt2.setFont(f);
         
         bt1.addActionListener(this);
         bt2.addActionListener(this);
         
          c1 = new Choice();
          
          try
          {
             ConnectionClass obj = new ConnectionClass();
             String q = "Select *From Employee ";
             ResultSet rest = obj.stm.executeQuery(q);
             while(rest.next())
             {
                 c1.add(rest.getString("Eid"));              
             }
             
          }
          catch(Exception ex)
          {
               ex.printStackTrace();
          }
          
        p = new JPanel();
        p.setLayout(new GridLayout(6,2,10,10));

        p.add(l1);
        p.add(c1);
        p.add(l4);
        p.add(tf1);
        p.add(l5);
        p.add(tf2);
        p.add(l2);
        p.add(c2);
        p.add(l3);
        p.add(c3);
        p.add(bt1);
        p.add(bt2);

        add(p);
        
        c1.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                try
                {
                    ConnectionClass obj2 = new ConnectionClass();
                    String eid = c1.getSelectedItem();
                    String q2 = "Select * from employee where Eid='"+eid+"'";
                    ResultSet rest1 = obj2.stm.executeQuery(q2);
                    while(rest1.next())
                    {
                        tf1.setText(rest1.getString("name"));
                        tf2.setText(rest1.getString("email"));
                    }
                }
                catch(Exception exx)
                {
                    exx.printStackTrace();
                }
            }
        });


    }
    
    public void actionPerformed(ActionEvent ev)
    {
         if (ev.getSource()==bt1)
         {
                String ch_eid= c1.getSelectedItem();
                String ch_first_half = c2.getSelectedItem();
                String ch_second_half = c3.getSelectedItem();
                String name = tf1.getText();
                String email = tf2.getText();
                String dt = new java.util.Date().toString();
                
                try
                {
                    ConnectionClass obj1 = new ConnectionClass();
                    String q1 ="insert into attendence values('"+ch_eid+"','"+name+"','"+email+"','"+ch_first_half+"','"+ch_second_half+"','"+dt+"')";
                    obj1.stm.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null,"data inserted");
                    setVisible(false);
                }
                catch (Exception ex1)
                {
                     ex1.printStackTrace();
                }
         }
         if (ev.getSource()==bt2)
         {
                JOptionPane.showMessageDialog(null,"Are you sure to close??");
                setVisible(false);

         }
    }
    public static void main(String args[])
    {
         new Employee_Attendence().setVisible(true);
    }
}
