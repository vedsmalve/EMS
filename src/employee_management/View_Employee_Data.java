package employee_management;

import com.sun.source.tree.UsesTree;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.rtf.RTFEditorKit;
import java.awt.event.*;
import java.sql.*;
public class View_Employee_Data implements ActionListener
{
    JFrame f;
    JLabel id8,id,aid,aidi, id1,id2,aid2,id3 , id4,aid3, aid4,id5,aid5,id6,aid6,id7,aid7,id9;
    String emp_id,name,father,address,phone,email,education,post,age,dob,aadhar;
    JButton b1,b2;
    ImageIcon Icon ;

    View_Employee_Data(String Eid)
    {   try
    {
        ConnectionClass obj = new ConnectionClass();
        String s ="select * from employee where Eid='"+Eid+"'";
        ResultSet rs = obj.stm.executeQuery(s);

        while(rs.next())
        {
            name=rs.getString("name");
            father=rs.getString("Fname");
            age=rs.getString("age");
            dob=rs.getString("dob");
            address=rs.getString("address");
            phone=rs.getString("phone");
            email=rs.getString("email");
            education=rs.getString("Education");
            post=rs.getString("Job_Post");
            aadhar=rs.getString("aadhar");
            emp_id=rs.getString("Eid");
        }


    }
    catch (Exception ex)
    {
        ex.printStackTrace();

    }

        f = new JFrame("Display Employee Details");
        f.setVisible(true);
        f.setSize(595,642);
        f.setLocation(450,200);
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        id9=new JLabel();
        id9.setBounds(0,0,595,642);
        id9.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icon/laptop.jpg"));
        id9.setIcon(img);

        id = new JLabel("Employee Id:");
        id.setBounds(150,70,120,30);
        id.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id);

        aid = new JLabel(emp_id);
        id.setBounds(330,120,200,30);
        id.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid);

        id1 = new JLabel("Name:");
        id1.setBounds(150,120,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id1);

        aidi= new JLabel(name);
        aidi.setBounds(330,120,100,30);
        aidi.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aidi);

        id2= new JLabel("Fathers_Name:");
        id2.setBounds(150,170,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id2);

        aid2= new JLabel(father);
        aid2.setBounds(330 ,170,200,30);
        aid2.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid2);

        id3= new JLabel("Address:");
        id3.setBounds(150,220,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id3);

        aid3= new JLabel(address);
        aid3.setBounds(330 ,170,200,30);
        aid3.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid3);

        id4= new JLabel("Mobile_no");
        id4.setBounds(150,270,100,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id4);

        aid4= new JLabel(phone);
        aid4.setBounds(330,320,100,30);
        aid4.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid4);

        id5= new JLabel("Email_id");
        id5.setBounds(150,320,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id5);

        aid5= new JLabel(email);
        aid5.setBounds(150,320,100,30);
        aid5.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid5);


        id6= new JLabel("Education");
        id6.setBounds(330,370,300,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id6);

        aid6= new JLabel(education);
        aid6.setBounds(330,420,100,30);
        aid6.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid6);

        id7= new JLabel("job post");
        id7.setBounds(150,420,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id7);

        aid7= new JLabel(post);
        aid7.setBounds(330,420,300,30);
        aid7.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid7);

        b1= new JButton("print");
        b1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
        b1.setBounds(160,520,100,30);
        b1.addActionListener(this);
        id9.add(b1);


        b2= new JButton("Cancle");
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        b2.setBounds(350,520,100,30);
        b2.addActionListener(this);
        id9.add(b2);

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            JOptionPane.showMessageDialog(null,"printed succesfully");
            f.setVisible(false);
            new Homepage();

        }
        if (e.getSource()==b2)
        {
            f.setVisible(false);
            new View_Employee();
        }
    }


}
