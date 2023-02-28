package employee_management;

import java.sql.*;
public class ConnectionClass {
    Connection con;
    Statement stm;
    ConnectionClass (){
        try
        {
                        Class.forName("com.mariadb.jdbc.Driver");
                        con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/employee_management","root","root");
                        stm=con.createStatement();
                        }
            catch(Exception ex){
            ex.printStackTrace();
        }
    }
public static void main(String[] args){
        new ConnectionClass();
}
}
