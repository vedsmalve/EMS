package employee_management;

import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class View_Attendence_Single extends JFrame
{
     JTable t;
     String x[]={"Employee ID","Name","Email","First Half","Second Half","date"};
     String Y[] []=new String [20] [6];
     int i=0 , j=0;
     Font f,f1;
     int count=0;
     
    
    View_Attendence_Single(String eid)
    {
             super("Particular Employee attendence records");
             setSize(1480,400);
             setLocation(0,10);
             
             f=new Font("Ms UI Gothic",Font.BOLD,17);
             
             try
             {
                 ConnectionClass obj=new ConnectionClass();
                 String q="select * from attendence where EID='"+eid+"'";
                 ResultSet rest=obj.stm.executeQuery(q);
                 while(rest.next())
                 {
                      count++;
                      Y[i][j++]=rest.getString("Eid");
                      Y[i][j++]=rest.getString("name");
                      Y[i][j++]=rest.getString("Email");
                      Y[i][j++]=rest.getString("first_half");
                      Y[i][j++]=rest.getString("second_half");
                      Y[i][j++]=rest.getString("day_date");
                      i++;
                      j=0;
                 }
                  if(count==0)
                  {
                       JOptionPane.showMessageDialog(null,"NO Record Found.");
                  }
                  else
                  {
                      t=new JTable(Y,x);
                      t.setBackground(Color.BLACK);
                      t.setBackground(Color.WHITE);
                      t.setFont(f);
                      setSize(1480,400);
                      setLocation(0,10);
                      JScrollPane js=new JScrollPane(t);
                      add(js);
                  }
             }
             catch(Exception ex)
             {
                 ex.printStackTrace();
             }
    }
}
