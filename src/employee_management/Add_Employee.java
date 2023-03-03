package employee_management;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Add_Employee implements ActionListener
{
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id13;
    JFrame f;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    JButton b,b1;
    
    Add_Employee()
    {
        f=new JFrame("Add Employee");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        
        
        id=new JLabel();
        id.setBounds(0,0,900,600);
        id.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("employee_management/Icon/10.jpg"));
        Image i1=img.getImage().getScaledInstance(900,600, Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);
        id.setIcon(img1);
        f.add(id);
        
        id1=new JLabel("New Employee Details");
        id1.setBounds(280,30,500,50);
        id1.setFont(new Font("Airal",Font.BOLD,30));
        id1.setForeground(Color.black);
        id.add(id1);
        
        id2=new JLabel("Name");
        id2.setBounds(50,150,150,30);
        id2.setFont(new Font("Airal",Font.BOLD,20));
        id.add(id2);
        
        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        id.add(t1);
        
         id3=new JLabel("Father's Name");
        id3.setBounds(450,150,200,30);
        id3.setFont(new Font("Airal",Font.BOLD,20));
        id.add(id3);
        
        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        id.add(t2);
        
        id4=new JLabel("Age");
        id4.setBounds(50,200,100,30);
        id4.setFont(new Font("Airal",Font.BOLD,20));
        id.add(id4);
        
        t3=new JTextField();
        t3.setBounds(200,200,150,30);
        id.add(t3);
        
        
        
        id5=new JLabel("Date Of Birth");
        id5.setBounds(450,200,200,30);
        id5.setFont(new Font("Airal",Font.BOLD,20));
        id.add(id5);
        
        
        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        id.add(t4);
        
        
        id6=new JLabel("Address");
        id6.setBounds(50,250,100,30);
        id6.setFont(new Font("Airal",Font.BOLD,20));
        id.add(id6);
        
        t5=new JTextField();
        t5.setBounds(200,250,150,30);
        id.add(t5);
        
        
        id7=new JLabel("Phone");
        id7.setBounds(450,250,100,30);
        id7.setFont(new Font("Airal",Font.BOLD,20));
        id.add(id7);
        
        t6=new JTextField();
        t6.setBounds(600,250,150,30);
        id.add(t6);
        
        id8=new JLabel("Email Id");
        id8.setBounds(50,300,100,30);
        id8.setFont(new Font("Airal",Font.BOLD,20));
        id.add(id8);
        
        
        t7=new JTextField();
        t7.setBounds(200,300,150,30);
        id.add(t7);
        
        
        id9=new JLabel("Education");
        id9.setBounds(450,300,100,30);
        id9.setFont(new Font("Airal",Font.BOLD,20));
        id.add(id9);
        
        t8=new JTextField();
        t8.setBounds(600,300,150,30);
        id.add(t8);
        
        id10=new JLabel("Job Post");
        id10.setBounds(50,350,100,30);
        id10.setFont(new Font("Airal",Font.BOLD,20));
        id.add(id10);
        
        t9=new JTextField();
        t9.setBounds(200,350,150,30);
        id.add(t9);
        
        
        id11=new JLabel("Aadhar No");
        id11.setBounds(450,350,100,30);
        id11.setFont(new Font("Airal",Font.BOLD,20));
        id.add(id11);
        
        t10=new JTextField();
        t10.setBounds(600,350,150,30);
        id.add(t10);
        
        id12=new JLabel("Employee Id");
        id12.setBounds(50,400,150,30);
        id12.setFont(new Font("Airal",Font.BOLD,20));
        id.add(id12);
        
        t11=new JTextField();
        t11.setBounds(200,400,150,30);
        id.add(t11);
        
        
        b = new JButton("Submit");
        b.setBackground(Color.red);
        b.setForeground(Color.white);
        b.setBounds(250,500,150,40);
        
        id.add(b);
        
        b1 = new JButton("Cancel");
        b1.setBackground(Color.RED);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,500,150,40);
        
        id.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        
        
        f.setVisible(true);
        f.setSize(900,600);
        f.setLocation(300,100);
        
        
        
   }
    public void actionPerformed(ActionEvent e)
   {
        String name=t.getText();
        String fname=t2.getText();
        String age=t3.getText();
        String dob=t4.getText();
        String address=t5.getText();
        String phone=t6.getText();
        String email=t7.getText();
        String education=t8.getText();
        String post=t9.getText();
        String aadhar=t10.getText();
        String eid=t11.getText();
       
        if(e.getSource()==b)
      {
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String s ="insert into employee values("+name+","+fname+","+age+","+dob+","+address+","+phone+","+email+","+education+","+post+","+aadhar+","+eid+")";
                obj.stm.executeUpdate(s);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                f.setVisible(false);
                new HomePage();
            }
            catch (Exception ex)
            {
                System.out.println("The error is:"+ex);
           }
       }
        if(e.getSource()==b1)
        {
           f.setVisible(false);
            new HomePage();
        }
            
        
        
        
        
    }
    public static void main(String[] args)
   {
        new  Add_Employee();
    }
}





