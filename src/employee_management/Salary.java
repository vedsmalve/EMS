package employee_management;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Salary extends JFrame implements ActionListener{
    
    Font f,f1;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    Choice ch1,ch2,ch3;
    JButton bt1,bt2;
    JPanel p1,p2,p3;
    
    Salary(){
        super("Salary");
        setSize(950,700);
        setLocation(100,100);
        setResizable(false);
        
        f= new Font("Arial",Font.BOLD,18);
        f1 = new Font("Arial",Font.BOLD,25);
        
        l1 = new JLabel("Select Employee ID");
        l2 = new JLabel("Name");
        l3 = new JLabel("Email");
        l4 = new JLabel("HRA");
        l5 = new JLabel("DA");
        l6 = new JLabel("MID");
        l7 = new JLabel("PF");
        l8 = new JLabel("Basic Salary");
        l9 = new JLabel("Select Month");
        l10 = new JLabel("Select Year");
        l12 = new JLabel("Employee Salary");
        
        l12.setHorizontalAlignment(JLabel.CENTER);
        
        ch1 = new Choice();
        try
        {
            ConnectionClass obj = new ConnectionClass();
            String q = "select Eid from employee";
            ResultSet rest = obj.stm.executeQuery(q);
            while(rest.next())
            {
                ch1.add(rest.getString("Eid"));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        ch2 = new Choice();
        ch2.add("January");
        ch2.add("February");
        ch2.add("March");
        ch2.add("April");
        ch2.add("May");
        ch2.add("June");
        ch2.add("July");
        ch2.add("August");
        ch2.add("September");
        ch2.add("October");
        ch2.add("November");
        ch2.add("December");
        
        ch3.add("2018");
        ch3.add("2019");
        ch3.add("2020");
        ch3.add("2021");
        ch3.add("2022");
        ch3.add("2023");
        
        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f);
        l7.setFont(f);
        l8.setFont(f);
        l9.setFont(f);
        l10.setFont(f);
        l11.setFont(f);
        l12.setFont(f);
        
        ch1.setFont(f);
        ch2.setFont(f);
        ch3.setFont(f);
        
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        
        t1.setFont(f);
        t2.setFont(f);
        t3.setFont(f);
        t4.setFont(f);
        t5.setFont(f);
        t6.setFont(f);
        t7.setFont(f);
        
        t1.setEditable(false);
        t2.setEditable(false);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("employee_management/Icon/salary.jpg"));
        Image image=img.getImage().getScaledInstance(400,600,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(image);
        l11=new JLabel(img1);
        
        bt1 = new JButton("Submit");
        bt2 = new JButton("Close");
        
        bt1.setFont(f);
        bt2.setFont(f);
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt2.setBackground(Color.BLACK);
        bt2.setForeground(Color.WHITE);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(11,2,10,10));
        p1.add(l1);
        p1.add(ch1);
        p1.add(l2);
        p1.add(t1);
        p1.add(l3);
        p1.add(t2);
        p1.add(l4);
        p1.add(t3);
        p1.add(l5);
        p1.add(t4);
        p1.add(l6);
        p1.add(t5);
        p1.add(l7);
        p1.add(t6);
        p1.add(l8);
        p1.add(t7);
        p1.add(l9);
        p1.add(ch2);
        p1.add(l10);
        p1.add(ch3);
        p1.add(bt1);
        p1.add(bt2);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,1,10,10));
        p2.add(l11);
        
        p3 = new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));
        p3.add(l12);
        
        setLayout(new BorderLayout(30,30));
        
        add(p1,"Center");
        add(p2,"West");
        add(p3,"North");
        
        
        ch1.addMouseListener(new Mouseadapter()
        {
                    @Override
                    public void mouseClicked(MouseEvent arg0)
                    {
                        try
                        {
                            ConnectionClass obj2 = new ConnectionClass();
                            String eid2 = ch1.getSelectedItem();
                            String q3 = "select * from employee where Eid='"+eid2+"'";
                            ResultSet rest1 = obj2.stm.executeQuery(q3);
                            while(rest1.next())
                            {
                                t1.setText(rest1.getString("name"));
                                t2.setText(rest1.getString("email"));
                            }
                        }
                        catch(Exception exx)
                        {
                            exx.printStackTrace();
                        }
                    }
        });
        
       
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            String Eid = ch1.getSelectedItem();
            String name = t1.getText();
            String email = t2.getText();
            float hra = Float.parseFloat(t3.getText());
            float da = Float.parseFloat(t4.getText());
            float mid = Float.parseFloat(t5.getText());
            float pf = Float.parseFloat(t6.getText());
            float basic = Float.parseFloat(t7.getText());
            String month = ch2.getSelectedItem()+" "+ch3.getSelectedItem();
            
            
            try
            {
                ConnectionClass obj1 = new ConnectionClass();
                String q1 = "insert into salary values('"+0+"','"+Eid+"','"+name+"','"+hra+"','"+da+"','"+mid+"','"+pf+"','"+basic+"','"+month+"')";
                int aa = obj1.stm.executeUpdate(q1);
                if(aa==1)
                {
                    JOptionPane.showMessageDialog(null, "Your Data Successfully Inserted.");
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please fill all the detials Carefullly!!!");
                    this.setVisible(false);
                    this.setVisible(true);
                    
                }
            }
            catch(Exception exx)
            {
                exx.printStackTrace();
            }
        }        }
    }
    
    public static void main(String[] args)
    {
        new Salary().setVisible(true);
    }
    
}
